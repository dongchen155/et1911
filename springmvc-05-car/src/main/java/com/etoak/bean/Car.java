package com.etoak.bean;

import lombok.Data;

/**
 * t_springmvc_car对应的实体类
 */
@Data
public class Car {
	private Integer id;
	// 品牌
	private String brand;
	// 车系
	private String series;
	// 价格
	private Integer price;
	// 上牌时间
	private String licensingTime;
	// 级别
	private String level;
	// 变速箱
	private String gearbox;
	// 排量
	private String outputVolume;
	// 里程
	private Integer mileage;
	// 归属地
	private String location;
	// 图片地址
	private String pic;
	// 概述
	private String summary;
	// 创建时间
	private String createTime;

}
