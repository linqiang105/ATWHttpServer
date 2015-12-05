package com.atw.weight.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.dao.IWeightDao;

@Repository("weightDao")
public class WeightDaoImpl implements IWeightDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveWeightInfo(String dbName, WeightInfo weightInfo) {
		if (dbName == null) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ").append(dbName).append("(glideNo,carNo,weightType,sender,receiver,")
				.append("goods,spec,gross,tare,net,").append("bundle,real,price,sum,scale")
				.append("quanter,cost,grossMan,tareMan,grossAddr,")
				.append("tareAddr,grossTime,tareTime,firstTime,secondTime,")
				.append("updateUser,updateTime,memo,printCount,upload,")
				.append("backup1,backup2,backup3,backup4,backup5,").append("backup6,backup7,backup8,backup9,backup10,")
				.append("backup11,backup12,backup13,backup14,backup15,")
				.append("backup16,backup17,backup18) values(?,?,?,?,?,").append("?,?,?,?,?,").append("?,?,?,?,?,")
				.append("?,?,?,?,?,").append("?,?,?,?,?,").append("?,?,?,?,?,").append("?,?,?,?,?,")
				.append("?,?,?,?,?,").append("?,?,?,?,?,").append("?,?,?)");
		try {
			return jdbcTemplate.update(sb.toString(), new Object[] { weightInfo.getGlideNo(), weightInfo.getCarNo(),
					weightInfo.getWeightType(), weightInfo.getSender(), weightInfo.getShouHuo(), weightInfo.getGoods(),
					weightInfo.getSpec(), weightInfo.getGross(), weightInfo.getTare(), weightInfo.getNet(),
					weightInfo.getBundle(), weightInfo.getReal(), weightInfo.getPrice(), weightInfo.getSum(),
					weightInfo.getScale(), weightInfo.getQuanter(), weightInfo.getCost(), weightInfo.getGrossMan(),
					weightInfo.getTareMan(), weightInfo.getGrossAddr(), weightInfo.getTareAddr(),
					weightInfo.getGrossTime(), weightInfo.getTareTime(), weightInfo.getFirstTime(),
					weightInfo.getSecondTime(), weightInfo.getUpdateUser(), weightInfo.getUpdateTime(),
					weightInfo.getMemo(), weightInfo.getPrintCount(), weightInfo.isUpload(), weightInfo.getBackup1(),
					weightInfo.getBackup2(), weightInfo.getBackup3(), weightInfo.getBackup4(), weightInfo.getBackup5(),
					weightInfo.getBackup6(), weightInfo.getBackup7(), weightInfo.getBackup8(), weightInfo.getBackup9(),
					weightInfo.getBackup10(), weightInfo.getBackup11(), weightInfo.getBackup12(),
					weightInfo.getBackup13(), weightInfo.getBackup14(), weightInfo.getBackup15(),
					weightInfo.getBackup16(), weightInfo.getBackup17(), weightInfo.getBackup18() }) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean hasToken(String token) {
		// TODO Auto-generated method stub
		String sql = "select count(1) from tbl_user where token=?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[] { token });
		return (list != null) && (list.size() > 0);
	}

	@Override
	public String getDbNameByToken(String token) {
		// TODO Auto-generated method stub
		String sql = "select tbl_company.dbName as dbName from tbl_user,tbl_company "
				+ "where (tbl_user.company=tbl_company.id) and (tbl_user.token=?)";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[] { token });
		if ((list != null) && (list.size() > 0)) {
			return list.get(0).get("dbName").toString();
		}
		return null;
	}

}
