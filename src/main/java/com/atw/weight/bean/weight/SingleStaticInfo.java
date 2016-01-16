package com.atw.weight.bean.weight;

import java.math.BigDecimal;

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
	private BigDecimal gross;
	private BigDecimal tare;
	private BigDecimal net;
	private BigDecimal bundle;
	private BigDecimal real;
	/**
	 * 平均单价
	 */
	private BigDecimal price;
	private BigDecimal sum;
	/**
	 * 方量
	 */
	private BigDecimal quanter;

	/**
	 * 过磅费
	 */
	private BigDecimal cost;

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

	public BigDecimal getGross() {
		return gross;
	}

	public void setGross(BigDecimal gross) {
		this.gross = gross;
	}

	public BigDecimal getTare() {
		return tare;
	}

	public void setTare(BigDecimal tare) {
		this.tare = tare;
	}

	public BigDecimal getNet() {
		return net;
	}

	public void setNet(BigDecimal net) {
		this.net = net;
	}

	public BigDecimal getBundle() {
		return bundle;
	}

	public void setBundle(BigDecimal bundle) {
		this.bundle = bundle;
	}

	public BigDecimal getReal() {
		return real;
	}

	public void setReal(BigDecimal real) {
		this.real = real;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public BigDecimal getQuanter() {
		return quanter;
	}

	public void setQuanter(BigDecimal quanter) {
		this.quanter = quanter;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

}
