package com.atw.weight.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.atw.weight.service.IIncomeExpenseService;

@Controller("pageController")
public class PageController {

	@Resource(name = "incomeExpenseService")
	private IIncomeExpenseService incomeExpenseService;

	@RequestMapping(value = "inOutHistoryPage.do")
	public ModelAndView getInOutHistoryPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		if (incomeExpenseService.hasUserByToken(token).getStatus() == 0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("userToken", token);
			mav.setViewName("inOut/inOutHistory");
			return mav;
		}
		return null;
	}

	@RequestMapping("addInOutPage.do")
	public ModelAndView addInOutPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		if (incomeExpenseService.hasUserByToken(token).getStatus() == 0) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("userToken", token);
			mav.setViewName("inOut/addInOut");
			return mav;
		}
		return null;
	}

	@RequestMapping("testTodayRecordPage.do")
	public String getTestTodayRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightRecord/testTodayRecord";
	}

	@RequestMapping("testMonthRecordPage.do")
	public String getTestMonthRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightRecord/testMonthRecord";
	}

	@RequestMapping("testDaySenderStaticRecordPage.do")
	public String getTestDaySenderStaticRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightStatic/testDaySenderStaticRecord";
	}

	@RequestMapping("testDayReceiverStaticRecordPage.do")
	public String getTestDayReceiverStaticRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightStatic/testDayReceiverStaticRecord";
	}

	@RequestMapping("testDayGoodsStaticRecordPage.do")
	public String getTestDayGoodsStaticRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightStatic/testDayGoodsStaticRecord";
	}

	@RequestMapping("testMonthSenderStaticRecordPage.do")
	public String getTestMonthSenderStaticRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightStatic/testMonthSenderStaticRecord";
	}

	@RequestMapping("testMonthReceiverStaticRecordPage.do")
	public String getTestMonthReceiverStaticRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightStatic/testMonthReceiverStaticRecord";
	}

	@RequestMapping("testMonthGoodsStaticRecordPage.do")
	public String getTestMonthGoodsStaticRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightStatic/testMonthGoodsStaticRecord";
	}

	@RequestMapping("testDateStaticRecordPage.do")
	public String getTestDateStaticRecordPage(HttpServletRequest request, HttpServletResponse response) {
		return "weightStatic/testDateStaticRecord";
	}
}
