package com.atw.weight.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.atw.weight.bean.weight.BackupInfo;
import com.atw.weight.bean.weight.CarNo;
import com.atw.weight.bean.weight.Goods;
import com.atw.weight.bean.weight.Receiver;
import com.atw.weight.bean.weight.Sender;
import com.atw.weight.bean.weight.Spec;
import com.atw.weight.bean.weight.User;
import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.dao.IWeightDao;
import com.atw.weight.service.IWeightService;
import com.atw.weight.vo.CommonResult;
import com.atw.weight.vo.weight.AllWeightInfoResult;
import com.atw.weight.vo.weight.BackupInfoListResult;
import com.atw.weight.vo.weight.CarNoListResult;
import com.atw.weight.vo.weight.GoodsListResult;
import com.atw.weight.vo.weight.ReceiverListResult;
import com.atw.weight.vo.weight.SenderListResult;
import com.atw.weight.vo.weight.SpecListResult;
import com.atw.weight.vo.weight.WeightInfoListResult;
import com.atw.weight.vo.weight.WeightStaticInfo;

@Service("weightService")
public class WeightServiceImpl implements IWeightService {

	private static Logger log = LoggerFactory.getLogger(WeightServiceImpl.class);

	@Resource(name = "weightDao")
	private IWeightDao weightDao;

	public CarNoListResult getCarNos() {
		// TODO Auto-generated method stub
		return null;
	}

	public SenderListResult getSenders() {
		// TODO Auto-generated method stub
		return null;
	}

	public ReceiverListResult getReceivers() {
		// TODO Auto-generated method stub
		return null;
	}

	public GoodsListResult getGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public SpecListResult getSpecs() {
		// TODO Auto-generated method stub
		return null;
	}

	public BackupInfoListResult getBackupInfos(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveCarNo(CarNo carNo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveSender(Sender sender) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveReceiver(Receiver receiver) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveGoods(Goods goods) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveSpec(Spec spec) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveBackupInfo(int index, BackupInfo backupInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	public WeightInfoListResult getWeightInfos(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public AllWeightInfoResult getWeightInfo(String glideNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommonResult saveWeightInfo(String userToken, WeightInfo weightInfo) {
		// TODO Auto-generated method stub
		CommonResult commonResult = new CommonResult();
		
		User user = weightDao.getUserByToken(userToken);
		if (weightDao.saveWeightInfo(user,weightInfo)) {
			commonResult.setStatus(0);
		} else {
			commonResult.setStatus(1);
			commonResult.setMessage("保存数据到数据库失败");
		}
		return commonResult;
	}

	@Override
	public CommonResult hasAuthority(String userToken) {
		// TODO Auto-generated method stub
		User user = weightDao.getUserByToken(userToken);
		CommonResult commonResult = new CommonResult();
		if (user == null) {
			commonResult.setStatus(1);
			commonResult.setMessage("你无权上传数据");
			log.info("你无权上传数据");
		} else if (user.isExpired()) {
			commonResult.setStatus(1);
			commonResult.setMessage("用户已过期，请续费！");
			log.info("用户已过期，请续费！");
		} else {
			commonResult.setStatus(0);
		}
		return commonResult;
	}

	@Override
	public WeightInfoListResult getTestTodayRecord() {
		// TODO Auto-generated method stub
		WeightInfoListResult weightInfoListResult = new WeightInfoListResult();
		List<WeightInfo> listWeightInfo = weightDao.getTestTodayRecord();
		weightInfoListResult.setResult(listWeightInfo);
		weightInfoListResult.setCount(listWeightInfo.size());
		return weightInfoListResult;
	}

	@Override
	public WeightInfoListResult getTestMonthRecord() {
		// TODO Auto-generated method stub
		WeightInfoListResult weightInfoListResult = new WeightInfoListResult();
		List<WeightInfo> listWeightInfo = weightDao.getTestMonthRecord();
		weightInfoListResult.setResult(listWeightInfo);
		weightInfoListResult.setCount(listWeightInfo.size());
		return weightInfoListResult;
	}

	@Override
	public WeightStaticInfo getTestTodayStatic() {
		// TODO Auto-generated method stub
		return weightDao.getTestTodayStatic();
	}

	@Override
	public WeightStaticInfo getTestMonthStatic() {
		// TODO Auto-generated method stub
		return weightDao.getTestMonthStatic();
	}

}
