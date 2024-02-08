package com.bizzan.er.normal.robot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.bizzan.er.normal.entity.RobotParams;
import com.bizzan.er.normal.service.RobotParamService;

public class ExchangeRobotFactory {
	
	private ConcurrentHashMap<String, IExchangeRobot> robotMap; // btcusdt -> robot
	
	public ExchangeRobotFactory() {
		robotMap = new ConcurrentHashMap<String, IExchangeRobot>();
	}
	
	public Map<String, IExchangeRobot> getRobotList(){
		return robotMap;
	}
	
	public void addExchangeRobot(String coinName, IExchangeRobot robot) {
		if(!this.containsExchangeRobot(coinName)) {
			this.robotMap.put(coinName, robot);
		}
	}
	
	public boolean containsExchangeRobot(String coinName) {
		return robotMap != null && robotMap.containsKey(coinName);
	}
	
	public IExchangeRobot getExchangeRobot(String coinName) {
		return robotMap.get(coinName);
	}
	
	/**
	 * 获取机器人参数
	 * @param coinName
	 * @return
	 */
	public RobotParams getRobotParams(String coinName) {
		IExchangeRobot robot = robotMap.get(coinName);
		if(robot != null) {
			return robot.getRobotParams();
		}else {
			return null;
		}
	}
	
	/**
	 * 设置机器人参数
	 * @param coinName
	 * @param params
	 */
	public void setRobotParams(String coinName, RobotParams params) {
		IExchangeRobot robot = robotMap.get(coinName);
		if(robot != null) {
			robot.setRobotParams(params);
		}
	}
}
