package com.atw.weight.service;

import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.vo.CommonResult;

public interface IWeightService {

	/**
	 * 没验证通过就不能进行查询、统计工作
	 * 
	 * @param token
	 * @return
	 */
	public boolean canWork(String token);

	/**
	 * 取Token对应的数据库名称
	 * 
	 * @return
	 */
	public String getDbName(String token);

	/**
	 * 保存称重信息
	 * 
	 * @return
	 */
	public CommonResult saveWeightInfo(String token, WeightInfo weightInfo);
}
