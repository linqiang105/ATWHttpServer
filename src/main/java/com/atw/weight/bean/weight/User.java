package com.atw.weight.bean.weight;

import java.util.Date;

/**
 * 系统注册用户
 * 
 * @author haibara
 *
 */
public class User {

	private int id;

	/**
	 * 用户名称
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 联系电话
	 */
	private String tel;

	/**
	 * 用户令牌
	 */
	private String token;

	/**
	 * 所在企业
	 */
	private Company company;

	/**
	 * 用户余额
	 */
	private Double left;

	/**
	 * 过期时间
	 */
	private Date expireTime;

	/**
	 * 过期否
	 */
	private boolean expired;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Double getLeft() {
		return left;
	}

	public void setLeft(Double left) {
		this.left = left;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

}
