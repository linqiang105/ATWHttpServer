package com.atw.weight.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.dao.IWeightDao;
import com.atw.weight.service.IWeightService;
import com.atw.weight.vo.CommonResult;

@Service("weightService")
public class WeightServiceImpl implements IWeightService {

	@Resource(name = "weightDao")
	private IWeightDao weightDao;

	@Override
	public boolean canWork(String token) {
		// TODO Auto-generated method stub
		return weightDao.hasToken(token);
	}

	@Override
	public String getDbName(String token) {
		// TODO Auto-generated method stub
		return weightDao.getDbNameByToken(token);
	}

	@Override
	public CommonResult saveWeightInfo(String token, WeightInfo weightInfo) {
		CommonResult commonResult = new CommonResult();
		if (canWork(token)) {
			if (weightDao.saveWeightInfo(getDbName(token), weightInfo)) {
				commonResult.setStatus(0);
			} else {
				commonResult.setStatus(1);
				commonResult.setMessage("插入数据库失败 ");
			}

		} else {
			commonResult.setStatus(1);
			commonResult.setMessage("Token验证失败");
		}

		return commonResult;
	}

}
