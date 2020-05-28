package com.etoak.mapper;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.User;

public interface UserMapper {
	
	User getById(int id);
	User getByNameAndPassword(@Param("name")String name,@Param("password") String password);
}
