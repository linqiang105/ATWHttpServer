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
			mav.setViewName("inOutHistory");
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
			mav.setViewName("addInOut");
			return mav;
		}
		return null;
	}

	@RequestMapping("testTodayRecordPage.do")
	public String getTestTodayRecordPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		return "testTodayRecord";
	}

	@RequestMapping("testMonthRecordPage.do")
	public String getTestMonthRecordPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		return "testMonthRecord";
	}
}
