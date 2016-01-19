package com.atw.weight.vo.weight;

import java.util.List;

import com.atw.weight.bean.weight.SingleStaticInfo;

public class WeightSingleStaticListResult {

	private int status;

	private List<SingleStaticInfo> result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<SingleStaticInfo> getResult() {
		return result;
	}

	public void setResult(List<SingleStaticInfo> result) {
		this.result = result;
	}

}
