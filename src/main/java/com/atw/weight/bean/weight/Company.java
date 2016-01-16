package com.atw.weight.bean.weight;

/**
 * 用户所属公司
 * 
 * @author haibara
 *
 */
public class Company {

	private int id;

	/**
	 * 企业代码
	 */
	private String code;

	/**
	 * 企业名称
	 */
	private String name;

	/**
	 * 所在数据库
	 */
	private String dbname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

}
