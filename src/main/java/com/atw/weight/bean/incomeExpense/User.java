package com.atw.weight.bean.incomeExpense;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.atw.weight.config.JsonDateSerializer;

/**
 * 登录用户
 * 
 * @author haibara
 *
 */
public class User {

	private int id;
	private String username;
	private String password;
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
