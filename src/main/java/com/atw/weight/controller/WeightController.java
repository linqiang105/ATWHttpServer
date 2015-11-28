package com.atw.weight.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atw.weight.service.IWeightService;
import com.atw.weight.vo.weight.CarNoListResult;

@Controller("weightController")
@RequestMapping("weight")
public class WeightController {
	
	private static Logger log = LoggerFactory.getLogger(WeightController.class);

	@Resource(name="weightService")
	private IWeightService weightService;
	
	@RequestMapping("carNo.do")
	@ResponseBody
	public CarNoListResult getCarNo(HttpServletRequest request, HttpServletResponse response) {
		log.info("取车号列表条目");
		CarNoListResult carNoListResult = weightService.getCarNos();
		carNoListResult.setStatus(0);
		return carNoListResult;
	}
	
}
