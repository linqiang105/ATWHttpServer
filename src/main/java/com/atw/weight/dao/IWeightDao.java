package com.atw.weight.dao;

import java.util.List;

import com.atw.weight.bean.weight.Company;
import com.atw.weight.bean.weight.SingleStaticInfo;
import com.atw.weight.bean.weight.User;
import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.vo.weight.WeightStaticInfo;

public interface IWeightDao {

	/**
	 * 返回测试今日车次，净重
	 * 
	 * @return
	 */
	public WeightStaticInfo getTestTodayStatic();

	/**
	 * 返回测试今日过磅数据
	 * 
	 * @return
	 */
	public List<WeightInfo> getTestTodayRecord();

	/**
	 * 返回测试本月车次，净重
	 * 
	 * @return
	 */
	public WeightStaticInfo getTestMonthStatic();

	/**
	 * 返回测试本月过磅数据
	 * 
	 * @return
	 */
	public List<WeightInfo> getTestMonthRecord();

	/**
	 * 返回测试统计数据
	 * 
	 * @param timeType
	 * @param condition
	 * @return
	 */
	public List<SingleStaticInfo> getTestSingleStaticInfo(int timeType, String condition);

	/**
	 * 根据用户令牌取用户信息
	 * 
	 * @param userToken
	 * @return
	 */
	public User getUserByToken(String userToken);

	public Company getCompanyById(int id);

	public boolean saveWeightInfo(User user, WeightInfo weightInfo);

}
