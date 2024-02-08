package com.bizzan.er.normal.robot;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.web.client.RestTemplate;

import com.bizzan.er.normal.entity.RobotParams;
import com.bizzan.er.normal.service.CustomRobotKlineService;
import com.bizzan.er.normal.service.RobotParamService;

public interface ExchangeRobot{
	
	/**
	 * 获取外部价格
	 * @return
	 */
	public BigDecimal getOuterPrice();
	
	/**
	 * 获取机器人参数
	 * @return
	 */
	public RobotParams getRobotParams();
	
	/**
	 * 设置机器人参数
	 * @param params
	 */
	public void setRobotParams(RobotParams params);
	
	public void setPlateSymbol(String symbol);
	
	/**
	 * 更新机器人参数
	 * @param params
	 */
	public void updateRobotParams(RobotParams params);
	
	public void startRobot();
	
	public void stopRobot();
	
	public void setRobotParamSevice(RobotParamService service);
	
	public void setRestTemplate(RestTemplate rest);
	
	public Instant getLastSendOrderTime();
	
	public void setCustomRobotKlineService(CustomRobotKlineService service); // 控盘机器人专用
	
	public boolean reloadCustomRobotKline(); // 重载k线数据，控盘机器人专用

	public void interrupt();

	public boolean isRunning();
}
