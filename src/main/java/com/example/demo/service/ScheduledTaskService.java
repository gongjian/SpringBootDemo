package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5*1000, initialDelay = 1*1000)
	public void reportCurrentTime() {
		System.out.println("每隔5秒执行一次 " + formatter.format(new Date()));
	}

	// 使用cron属性可按照指定时间执行，本例指的是每天20点07分执行
	@Scheduled(cron = "0 01 20 ? * *")
	public void fixTimeExecution() {
		System.out.println("在指定时间 " + formatter.format(new Date()) + " 执行");
	}

}
