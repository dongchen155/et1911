package com.etoak.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ArrayUtils;

import com.alibaba.druid.util.StringUtils;
import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.mapper.CarMapper;
import com.etoak.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarServiceImpl implements CarService {
		@Autowired
		CarMapper carMapper;
		
	@Override
	public int addCar(Car car) {
		// TODO Auto-generated method stub
		return  carMapper.addCar(car);
	}
	@Override
	public PageVo<CarVo>queryList(int pageNum,int pageSize,CarVo carVo,String[] priceList){
		List<Map<String,Integer>> priceMapList =this.handlePrice(priceList);
		carVo.setPriceMapList(priceMapList);
		this.handleVehicleAge(carVo);
		PageHelper.startPage(pageNum, pageSize);
		List<CarVo> carList = carMapper.queryList(carVo);
		PageInfo<CarVo> pageInfo = new PageInfo(carList);
		return new PageVo<CarVo>(pageInfo.getPageNum(), 
				pageInfo.getPageSize(), 
				carList, 
				pageInfo.getTotal(),
				pageInfo.getPages(),
				pageInfo.isIsFirstPage(), 
				pageInfo.isIsLastPage());
		
		
	}

	private void handleVehicleAge(CarVo carVo) {
		String vehicleAge =carVo.getVehicleAge();
		if(!StringUtils.isEmpty(vehicleAge)) {
			String[] vehicleAgeArray=vehicleAge.split("-");
			if(!"0".equals(vehicleAgeArray[0])) {
				carVo.setEndYear(Integer.parseInt(vehicleAgeArray[0]));
			}
			if(!"0".equals(vehicleAgeArray[1])) {
				carVo.setStartYear(Integer.parseInt(vehicleAgeArray[1]));
			}
		}
		
	}
	private List<Map<String, Integer>> handlePrice(String[] priceList) {
List<Map<String,Integer>> priceMapList = new ArrayList<>();
		
		if(!ArrayUtils.isEmpty(priceList)){
			for(String priceStr : priceList){
				String[] prices = priceStr.split("-");
				Map<String,Integer> priceMap = new HashMap<>();
				priceMap.put("start",Integer.parseInt(prices[0]));
				priceMap.put("end",Integer.parseInt(prices[1]));
				priceMapList.add(priceMap);
			}
		}
		
		return priceMapList;
	}
	@Override
	public List<String> getAllBrand(){
		return carMapper.getAllBrand();
	}
	@Override
	
	public List<String> getSeriesByBrand(@Param("brand")String brand){
		return carMapper.getSeriesByBrand(brand);
	}
	

}
