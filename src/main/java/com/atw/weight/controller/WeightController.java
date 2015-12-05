package com.atw.weight.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.atw.weight.bean.weight.WeightInfo;
import com.atw.weight.service.IWeightService;
import com.atw.weight.vo.CommonResult;

@Controller("weightController")
@RequestMapping("weight")
public class WeightController {

	private static Logger log = LoggerFactory.getLogger(WeightController.class);

	@Resource(name = "weightService")
	private IWeightService weightService;

	@RequestMapping("saveWeightInfo.do")
	@ResponseBody
	public CommonResult saveWeightInfo(HttpServletRequest request, HttpServletResponse response) {
		log.info("保存称重记录");
		String strWeight = request.getParameter("weightInfo。");
		String wechatToken = request.getParameter("token");
		CommonResult commonResult = new CommonResult();
		commonResult.setStatus(1);
		try {
			WeightInfo weightInfo = JSONObject.parseObject(strWeight, WeightInfo.class);
			weightService.saveWeightInfo(wechatToken, weightInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commonResult;
	}

}
