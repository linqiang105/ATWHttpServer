package com.atw.weight.vo.storage;

import java.util.List;

import com.atw.weight.bean.storage.StorageInfo;

public class StorageInfoListResult {

	private int count;
	private List<StorageInfo> result;
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

	public List<StorageInfo> getResult() {
		return result;
	}

	public void setResult(List<StorageInfo> result) {
		this.result = result;
	}

}
