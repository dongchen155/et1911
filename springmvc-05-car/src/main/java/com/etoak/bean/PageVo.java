package com.etoak.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo <T>{
	private int pageNum;
	private int pageSize;
	private List<T> rows;
	private long total;
	private int pageCount;
	private boolean first;
	private boolean last;

}
