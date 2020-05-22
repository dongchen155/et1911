package com.etoak.service;

import java.util.List;

import com.etoak.bean.Dict;

public interface DictService {

	/**
	 * 根据groupId查询字典列表
	 * 
	 * @param groupId
	 * @return
	 */
	List<Dict> queryList(String groupId);

}
