package com.bizzan.er.normal.entity;

import java.math.BigDecimal;

/**
 * 剧本价格元素
 * @author shaox
 *
 */
public class DramaItem {
	
	/**
	 * 时间点
	 */
	private long dramaTime;
	
	/**
	 * 目标价格
	 */
	private BigDecimal targetPrice;
	
	/**
	 * 目标价格与实际价格允许的误差
	 * 即设置targetPrice为100，thresholdPercent为10%时，最终价格是90或者100都可以
	 * 此值与type配合使用可制造相对真实的K线场景
	 */
	private BigDecimal thresholdPercent;

	/**
	 * 到达此目标价格的行走路径
	 * 0：直线增长或降低
	 * 1：指数曲线增长或降低
	 * 2：对数曲线增长或降低
	 * 3：上圆曲线
	 * 4：下圆曲线
	 */
	private int type;
	
	public BigDecimal getThresholdPercent() {
		return thresholdPercent;
	}
	public void setThresholdPercent(BigDecimal thresholdPercent) {
		this.thresholdPercent = thresholdPercent;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public long getDramaTime() {
		return dramaTime;
	}
	public void setDramaTime(long dramaTime) {
		this.dramaTime = dramaTime;
	}
	public BigDecimal getTargetPrice() {
		return targetPrice;
	}
	public void setTargetPrice(BigDecimal targetPrice) {
		this.targetPrice = targetPrice;
	}
}
