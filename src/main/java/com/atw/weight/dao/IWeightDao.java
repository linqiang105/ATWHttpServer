package com.atw.weight.dao;

import com.atw.weight.bean.weight.WeightInfo;

public interface IWeightDao {

	/**
	 * 保存过磅数据
	 * 
	 * @param dbName
	 * @param weightInfo
	 * @return
	 */
	public boolean saveWeightInfo(String dbName, WeightInfo weightInfo);

	/**
	 * 验证Token是否存在
	 * 
	 * @param token
	 * @return
	 */
	public boolean hasToken(String token);

	/**
	 * 每个Token对应一张数据表
	 * 
	 * @param token
	 * @return
	 */
	public String getDbNameByToken(String token);
}
