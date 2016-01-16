package com.atw.weight.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atw.weight.bean.weight.Company;
import com.atw.weight.bean.weight.User;
import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.dao.IWeightDao;
import com.atw.weight.vo.weight.WeightStaticInfo;

@Repository("weightDao")
public class WeightDaoImpl implements IWeightDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public WeightStaticInfo getTestTodayStatic() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(1) AS C, SUM(净重) AS NET FROM ATWWeight15.dbo.称重信息 "
				+ "WHERE CONVERT(varchar(10), 毛重时间, 120) = CONVERT(varchar(10), GETDATE(), 120)";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		WeightStaticInfo weightStaticInfo = new WeightStaticInfo();
		if ((list != null) && (list.size() > 0)) {
			weightStaticInfo.setCount(Integer.valueOf(list.get(0).get("C").toString()));
			weightStaticInfo.setNet(BigDecimal.valueOf(Double.valueOf(list.get(0).get("NET").toString())));
		}
		return weightStaticInfo;
	}

	@Override
	public List<WeightInfo> getTestTodayRecord() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ATWWeight15.dbo.称重信息 "
				+ "WHERE CONVERT(varchar(10), 毛重时间, 120) = CONVERT(varchar(10), GETDATE(), 120)";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List<WeightInfo> listWeightInfo = new ArrayList<WeightInfo>();
		if ((list != null) && (list.size() > 0)) {
			for (int i = 0; i < list.size(); i++) {
				WeightInfo weightInfo = new WeightInfo();
				try {
					weightInfo.setId(
							list.get(i).get("序号") == null ? 0 : Integer.valueOf(list.get(i).get("序号").toString()));
					weightInfo.setGlideNo(list.get(i).get("流水号") == null ? "" : list.get(i).get("流水号").toString());
					weightInfo.setCarNo(list.get(i).get("车号") == null ? "" : list.get(i).get("车号").toString());
					weightInfo.setWeightType("PO");
					weightInfo.setSender(list.get(i).get("发货单位") == null ? "" : list.get(i).get("发货单位").toString());
					weightInfo.setReceiver(list.get(i).get("收货单位") == null ? "" : list.get(i).get("收货单位").toString());
					weightInfo.setGoods(list.get(i).get("货名") == null ? "" : list.get(i).get("货名").toString());
					weightInfo.setSpec(list.get(i).get("规格") == null ? "" : list.get(i).get("规格").toString());
					weightInfo.setGross(
							list.get(i).get("毛重") == null ? 0 : Double.valueOf(list.get(i).get("毛重").toString()));
					weightInfo.setTare(
							list.get(i).get("空重") == null ? 0 : Double.valueOf(list.get(i).get("空重").toString()));
					weightInfo.setNet(
							list.get(i).get("净重") == null ? 0 : Double.valueOf(list.get(i).get("净重").toString()));
					weightInfo.setBundle(
							list.get(i).get("扣重") == null ? 0 : Double.valueOf(list.get(i).get("扣重").toString()));
					weightInfo.setReal(
							list.get(i).get("实重") == null ? 0 : Double.valueOf(list.get(i).get("实重").toString()));
					weightInfo.setPrice(
							list.get(i).get("单价") == null ? 0 : Double.valueOf(list.get(i).get("单价").toString()));
					weightInfo.setSum(
							list.get(i).get("金额") == null ? 0 : Double.valueOf(list.get(i).get("金额").toString()));
					weightInfo.setScale(1.0);
					weightInfo.setQuanter(
							list.get(i).get("净重") == null ? 0 : Double.valueOf(list.get(i).get("净重").toString()));
					weightInfo.setCost(
							list.get(i).get("过磅费") == null ? 0 : Double.valueOf(list.get(i).get("过磅费").toString()));
					weightInfo.setGrossMan(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setTareMan(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setGrossAddr("A");
					weightInfo.setTareAddr("A");
					weightInfo.setGrossTime(list.get(i).get("毛重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("毛重时间").toString()));
					weightInfo.setTareTime(list.get(i).get("空重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("空重时间").toString()));
					weightInfo.setFirstTime(list.get(i).get("空重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("空重时间").toString()));
					weightInfo.setSecondTime(list.get(i).get("毛重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("毛重时间").toString()));
					weightInfo.setUpdateUser(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setUpdateTime(list.get(i).get("毛重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("毛重时间").toString()));
					weightInfo.setMemo(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setPrintCount(1);
					weightInfo.setUpload(false);
					// weightInfo.setBackup1(list.get(i).get("备用1").toString());
					// weightInfo.setBackup2(list.get(i).get("备用2").toString());
					// weightInfo.setBackup3(list.get(i).get("备用3").toString());
					// weightInfo.setBackup4(list.get(i).get("备用4").toString());
					// weightInfo.setBackup5(list.get(i).get("备用5").toString());
					// weightInfo.setBackup6(Double.valueOf(list.get(i).get("备用6").toString()));
					// weightInfo.setBackup7(Double.valueOf(list.get(i).get("备用7").toString()));
					// weightInfo.setBackup8(Double.valueOf(list.get(i).get("备用8").toString()));
					// weightInfo.setBackup9(Double.valueOf(list.get(i).get("备用9").toString()));
					// weightInfo.setBackup10(list.get(i).get("备用10").toString());
					// weightInfo.setBackup11(list.get(i).get("备用11").toString());
					// weightInfo.setBackup12(list.get(i).get("备用12").toString());
					// weightInfo.setBackup13(list.get(i).get("备用13").toString());
					// weightInfo.setBackup14(list.get(i).get("备用14").toString());
					// weightInfo.setBackup15(Double.valueOf(list.get(i).get("备用15").toString()));
					// weightInfo.setBackup16(Double.valueOf(list.get(i).get("备用16").toString()));
					// weightInfo.setBackup17(Double.valueOf(list.get(i).get("备用17").toString()));
					// weightInfo.setBackup18(Double.valueOf(list.get(i).get("备用18").toString()));
				} catch (NumberFormatException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				listWeightInfo.add(weightInfo);
			}
		}
		return listWeightInfo;
	}

	@Override
	public WeightStaticInfo getTestMonthStatic() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(1) AS C, Sum(净重) AS NET FROM ATWWeight15.dbo.称重信息 WHERE Month(毛重时间) = Month(GETDATE())";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		WeightStaticInfo weightStaticInfo = new WeightStaticInfo();
		if ((list != null) && (list.size() > 0)) {
			weightStaticInfo.setCount(Integer.valueOf(list.get(0).get("C").toString()));
			weightStaticInfo.setNet(BigDecimal.valueOf(Double.valueOf(list.get(0).get("NET").toString())));
		}
		return weightStaticInfo;
	}

	@Override
	public List<WeightInfo> getTestMonthRecord() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ATWWeight15.dbo.称重信息 WHERE Month(毛重时间) = Month(GETDATE())";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List<WeightInfo> listWeightInfo = new ArrayList<WeightInfo>();
		if ((list != null) && (list.size() > 0)) {
			for (int i = 0; i < list.size(); i++) {
				WeightInfo weightInfo = new WeightInfo();
				try {
					weightInfo.setId(
							list.get(i).get("序号") == null ? 0 : Integer.valueOf(list.get(i).get("序号").toString()));
					weightInfo.setGlideNo(list.get(i).get("流水号") == null ? "" : list.get(i).get("流水号").toString());
					weightInfo.setCarNo(list.get(i).get("车号") == null ? "" : list.get(i).get("车号").toString());
					weightInfo.setWeightType("PO");
					weightInfo.setSender(list.get(i).get("发货单位") == null ? "" : list.get(i).get("发货单位").toString());
					weightInfo.setReceiver(list.get(i).get("收货单位") == null ? "" : list.get(i).get("收货单位").toString());
					weightInfo.setGoods(list.get(i).get("货名") == null ? "" : list.get(i).get("货名").toString());
					weightInfo.setSpec(list.get(i).get("规格") == null ? "" : list.get(i).get("规格").toString());
					weightInfo.setGross(
							list.get(i).get("毛重") == null ? 0 : Double.valueOf(list.get(i).get("毛重").toString()));
					weightInfo.setTare(
							list.get(i).get("空重") == null ? 0 : Double.valueOf(list.get(i).get("空重").toString()));
					weightInfo.setNet(
							list.get(i).get("净重") == null ? 0 : Double.valueOf(list.get(i).get("净重").toString()));
					weightInfo.setBundle(
							list.get(i).get("扣重") == null ? 0 : Double.valueOf(list.get(i).get("扣重").toString()));
					weightInfo.setReal(
							list.get(i).get("实重") == null ? 0 : Double.valueOf(list.get(i).get("实重").toString()));
					weightInfo.setPrice(
							list.get(i).get("单价") == null ? 0 : Double.valueOf(list.get(i).get("单价").toString()));
					weightInfo.setSum(
							list.get(i).get("金额") == null ? 0 : Double.valueOf(list.get(i).get("金额").toString()));
					weightInfo.setScale(1.0);
					weightInfo.setQuanter(
							list.get(i).get("净重") == null ? 0 : Double.valueOf(list.get(i).get("净重").toString()));
					weightInfo.setCost(
							list.get(i).get("过磅费") == null ? 0 : Double.valueOf(list.get(i).get("过磅费").toString()));
					weightInfo.setGrossMan(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setTareMan(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setGrossAddr("A");
					weightInfo.setTareAddr("A");
					weightInfo.setGrossTime(list.get(i).get("毛重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("毛重时间").toString()));
					weightInfo.setTareTime(list.get(i).get("空重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("空重时间").toString()));
					weightInfo.setFirstTime(list.get(i).get("空重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("空重时间").toString()));
					weightInfo.setSecondTime(list.get(i).get("毛重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("毛重时间").toString()));
					weightInfo.setUpdateUser(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setUpdateTime(list.get(i).get("毛重时间") == null ? new Date()
							: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
									.parse(list.get(i).get("毛重时间").toString()));
					weightInfo.setMemo(list.get(i).get("操作员") == null ? "" : list.get(i).get("操作员").toString());
					weightInfo.setPrintCount(1);
					weightInfo.setUpload(false);
					// weightInfo.setBackup1(list.get(i).get("备用1").toString());
					// weightInfo.setBackup2(list.get(i).get("备用2").toString());
					// weightInfo.setBackup3(list.get(i).get("备用3").toString());
					// weightInfo.setBackup4(list.get(i).get("备用4").toString());
					// weightInfo.setBackup5(list.get(i).get("备用5").toString());
					// weightInfo.setBackup6(Double.valueOf(list.get(i).get("备用6").toString()));
					// weightInfo.setBackup7(Double.valueOf(list.get(i).get("备用7").toString()));
					// weightInfo.setBackup8(Double.valueOf(list.get(i).get("备用8").toString()));
					// weightInfo.setBackup9(Double.valueOf(list.get(i).get("备用9").toString()));
					// weightInfo.setBackup10(list.get(i).get("备用10").toString());
					// weightInfo.setBackup11(list.get(i).get("备用11").toString());
					// weightInfo.setBackup12(list.get(i).get("备用12").toString());
					// weightInfo.setBackup13(list.get(i).get("备用13").toString());
					// weightInfo.setBackup14(list.get(i).get("备用14").toString());
					// weightInfo.setBackup15(Double.valueOf(list.get(i).get("备用15").toString()));
					// weightInfo.setBackup16(Double.valueOf(list.get(i).get("备用16").toString()));
					// weightInfo.setBackup17(Double.valueOf(list.get(i).get("备用17").toString()));
					// weightInfo.setBackup18(Double.valueOf(list.get(i).get("备用18").toString()));
				} catch (NumberFormatException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				listWeightInfo.add(weightInfo);
			}
		}
		return listWeightInfo;
	}

	@Override
	public User getUserByToken(String userToken) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> listUser = jdbcTemplate
				.queryForList("select * from ATWCloudWeight.dbo.tbl_user where token=?", new Object[] { userToken });
		if ((listUser != null) && (listUser.size() > 0)) {
			User user = new User();
			Map<String, Object> mUser = listUser.get(0);
			user.setId(mUser.get("id") == null ? 0 : Integer.valueOf(mUser.get("id").toString()));
			user.setUsername(mUser.get("username") == null ? "" : mUser.get("username").toString());
			user.setPassword(mUser.get("password") == null ? "" : mUser.get("password").toString());
			user.setTel(mUser.get("tel") == null ? "" : mUser.get("tel").toString());
			user.setToken(mUser.get("token") == null ? "" : mUser.get("token").toString());
			user.setCompany(mUser.get("company") == null ? null
					: getCompanyById(Integer.valueOf(mUser.get("company").toString())));
			user.setLeft(mUser.get("left") == null ? 0 : Double.valueOf(mUser.get("left").toString()));
			try {
				user.setExpireTime(mUser.get("expireTime") == null ? new Date()
						: new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(mUser.get("expireTime").toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			user.setExpired(mUser.get("expired") == null ? false : Boolean.valueOf(mUser.get("expired").toString()));
			return user;
		}

		return null;
	}

	@Override
	public Company getCompanyById(int id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> listCompany = jdbcTemplate
				.queryForList("select * from ATWCloudWeight.dbo.tbl_company where id=?", new Object[] { id });
		if ((listCompany != null) && (listCompany.size() > 0)) {
			Map<String, Object> mCompany = listCompany.get(0);
			Company company = new Company();
			company.setId(mCompany.get("id") == null ? 0 : Integer.valueOf(mCompany.get("id").toString()));
			company.setCode(mCompany.get("code") == null ? "" : mCompany.get("code").toString());
			company.setName(mCompany.get("name") == null ? "" : mCompany.get("name").toString());
			company.setDbname(mCompany.get("dbname") == null ? "" : mCompany.get("dbname").toString());
			return company;
		}
		return null;
	}

	@Override
	public boolean saveWeightInfo(User user, WeightInfo weightInfo) {
		// TODO Auto-generated method stub
		String sql = "insert into ATWCloudWeight.dbo." + user.getCompany().getDbname()
				+ "([glideNo],[carNo],[weightType],[sender],[receiver]," + "[goods],[spec],[gross],[tare],[net],"
				+ "[bundle],[real],[price],[sum],[scale]," + "[quanter],[cost],[grossMan],[tareMan],[grossAddr],"
				+ "[tareAddr],[grossTime],[tareTime],[firstTime],[secondTime],"
				+ "[updateUser],[updateTime],[memo],[printCount],[upload],"
				+ "[backup1],[backup2],[backup3],[backup4],[backup5],"
				+ "[backup6],[backup7],[backup8],[backup9],[backup10],"
				+ "[backup11],[backup12],[backup13],[backup14],[backup15]," + "[backup16],[backup17],[backup18]) "
				+ "values (?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?,"
				+ "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?,?,?," + "?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { weightInfo.getGlideNo(), weightInfo.getCarNo(), weightInfo.getWeightType(),
						weightInfo.getSender(), weightInfo.getReceiver(), weightInfo.getGoods(), weightInfo.getSpec(),
						weightInfo.getGross(), weightInfo.getTare(), weightInfo.getNet(), weightInfo.getBundle(),
						weightInfo.getReal(), weightInfo.getPrice(), weightInfo.getSum(), weightInfo.getScale(),
						weightInfo.getQuanter(), weightInfo.getCost(), weightInfo.getGrossMan(),
						weightInfo.getTareMan(), weightInfo.getGrossAddr(), weightInfo.getTareAddr(),
						weightInfo.getGrossTime(), weightInfo.getTareTime(), weightInfo.getFirstTime(),
						weightInfo.getSecondTime(), weightInfo.getUpdateUser(), weightInfo.getUpdateTime(),
						weightInfo.getMemo(), weightInfo.getPrintCount(), weightInfo.isUpload(),
						weightInfo.getBackup1(), weightInfo.getBackup2(), weightInfo.getBackup3(),
						weightInfo.getBackup4(), weightInfo.getBackup5(), weightInfo.getBackup6(),
						weightInfo.getBackup7(), weightInfo.getBackup8(), weightInfo.getBackup9(),
						weightInfo.getBackup10(), weightInfo.getBackup11(), weightInfo.getBackup12(),
						weightInfo.getBackup13(), weightInfo.getBackup14(), weightInfo.getBackup15(),
						weightInfo.getBackup16(), weightInfo.getBackup17(), weightInfo.getBackup18() }) > 0 ? true
								: false;

	}

}
