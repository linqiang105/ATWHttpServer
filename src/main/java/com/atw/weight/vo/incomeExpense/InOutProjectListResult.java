package com.atw.weight.vo.incomeExpense;

import java.util.List;

import com.atw.weight.bean.incomeExpense.Project;

public class InOutProjectListResult {

	private int count;
	private List<Project> result;

	private int status;
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Project> getResult() {
		return result;
	}

	public void setResult(List<Project> result) {
		this.result = result;
	}

}
