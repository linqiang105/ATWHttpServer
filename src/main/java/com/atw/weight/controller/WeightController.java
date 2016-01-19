package com.atw.weight.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.service.IWeightService;
import com.atw.weight.vo.CommonResult;
import com.atw.weight.vo.weight.CarNoListResult;
import com.atw.weight.vo.weight.WeightInfoListResult;
import com.atw.weight.vo.weight.WeightSingleStaticListResult;
import com.atw.weight.vo.weight.WeightStaticInfo;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Controller("weightController")
@RequestMapping("weight")
public class WeightController {

	private static Logger log = LoggerFactory.getLogger(WeightController.class);

	@Resource(name = "weightService")
	private IWeightService weightService;

	@RequestMapping("carNo.do")
	@ResponseBody
	public CarNoListResult getCarNo(HttpServletRequest request, HttpServletResponse response) {
		log.info("取车号列表条目");
		CarNoListResult carNoListResult = weightService.getCarNos();
		carNoListResult.setStatus(0);
		return carNoListResult;
	}

	@RequestMapping("getTestTodayRecord.do")
	@ResponseBody
	public WeightInfoListResult getTestTodayRecord(HttpServletRequest request, HttpServletResponse response) {
		log.info("取测试本日数据列表");
		WeightInfoListResult weightInfoListResult = weightService.getTestTodayRecord();
		weightInfoListResult.setStatus(0);
		return weightInfoListResult;
	}

	@RequestMapping("getTestTodayStatic.do")
	@ResponseBody
	public WeightStaticInfo getTestTodayStatic(HttpServletRequest request, HttpServletResponse response) {
		log.info("取测试本日数据");
		WeightStaticInfo weightStaticInfo = weightService.getTestTodayStatic();
		return weightStaticInfo;
	}

	@RequestMapping("getTestMonthRecord.do")
	@ResponseBody
	public WeightInfoListResult getTestMonthRecord(HttpServletRequest request, HttpServletResponse response) {
		log.info("取测试本月数据列表");
		WeightInfoListResult weightInfoListResult = weightService.getTestMonthRecord();
		weightInfoListResult.setStatus(0);
		return weightInfoListResult;
	}

	@RequestMapping("getTestMonthStatic.do")
	@ResponseBody
	public WeightStaticInfo getTestMonthStatic(HttpServletRequest request, HttpServletResponse response) {
		log.info("取测试本月数据");
		WeightStaticInfo weightStaticInfo = weightService.getTestMonthStatic();
		return weightStaticInfo;
	}

	/**
	 * 取测试统计数据
	 * 
	 * @param timeType，0---本日，1---本月，2---本年
	 * @param condition，carNo,sender,receiver,goods,date
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getTestStaticInfo.do")//, method = RequestMethod.POST)
	@ResponseBody
	public WeightSingleStaticListResult getTestStaticInfo(@RequestParam("timeType") int timeType,
			@RequestParam("condition") String condition, HttpServletRequest request, HttpServletResponse response) {
		log.info("取测试统计数据");
		WeightSingleStaticListResult weightSingleStaticListResult = weightService.getTestSingleStaticList(timeType,
				condition);
		weightSingleStaticListResult.setStatus(0);
		return weightSingleStaticListResult;
	}

	@RequestMapping(value = "saveWeightInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult saveWeightInfo(@RequestParam("userToken") String userToken,
			@RequestParam("weightInfo") String weightInfo, HttpServletRequest request, HttpServletResponse response) {
		log.info("保存客户端上传数据");
		log.info("用户ID：" + userToken);
		log.info("称重信息：" + weightInfo);

		CommonResult commonResult = new CommonResult();
		commonResult.setStatus(1);

		commonResult = weightService.hasAuthority(userToken);

		if (commonResult.getStatus() == 0) {
			weightInfo = new String(Base64.decode(weightInfo));
			WeightInfo wi = new WeightInfo();
			try {
				wi = JSON.parseObject(weightInfo, WeightInfo.class);
				log.info(wi.toString());
			} catch (Exception e) {
				commonResult.setMessage("解析JSON字符串失败");
				log.info(e.getMessage());
			}
			commonResult = weightService.saveWeightInfo(userToken, wi);
			log.info("数据上传成功");
		}
		return commonResult;
	}
}
