package com.atw.weight.bean.weight;

/**
 * 单个查询条件实体类
 * 
 * @author haibara
 *
 */
public class SingleStaticInfo {

	private String condition;
	/**
	 * 车次
	 */
	private int count;
	private String gross;
	private String tare;
	private String net;
	private String bundle;
	private String real;
	/**
	 * 平均单价
	 */
	private String price;
	private String sum;
	/**
	 * 方量
	 */
	private String quanter;

	/**
	 * 过磅费
	 */
	private String cost;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getTare() {
		return tare;
	}

	public void setTare(String tare) {
		this.tare = tare;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public String getBundle() {
		return bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public String getReal() {
		return real;
	}

	public void setReal(String real) {
		this.real = real;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getQuanter() {
		return quanter;
	}

	public void setQuanter(String quanter) {
		this.quanter = quanter;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

}
