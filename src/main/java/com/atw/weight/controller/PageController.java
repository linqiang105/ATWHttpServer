package com.atw.weight.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atw.weight.service.IIncomeExpenseService;

@Controller("pageController")
public class PageController {

	@Resource(name = "incomeExpenseService")
	private IIncomeExpenseService incomeExpenseService;

	@RequestMapping("inOutHistoryPage.do")
	public String getInOutHistoryPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		if (incomeExpenseService.hasUserByToken(token).getStatus() == 0) {
			return "inOutHistory";
		}
		return null;
	}

	@RequestMapping("addInOutPage.do")
	public String addInOutPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		if (incomeExpenseService.hasUserByToken(token).getStatus() == 0) {
			return "addInOut";
		}
		return null;
	}

	@RequestMapping("testTodayRecordPage.do")
	public String getTestTodayRecordPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		if (incomeExpenseService.hasUserByToken(token).getStatus() == 0) {
			return "testTodayRecord";
		}
		return null;
	}

	@RequestMapping("testMonthRecordPage.do")
	public String getTestMonthRecordPage(@RequestParam("userToken") String token, HttpServletRequest request,
			HttpServletResponse response) {
		if (incomeExpenseService.hasUserByToken(token).getStatus() == 0) {
			return "testMonthRecord";
		}
		return null;
	}
}
