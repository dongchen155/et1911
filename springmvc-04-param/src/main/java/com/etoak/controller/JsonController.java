package com.etoak.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {
	@PostMapping(value="/jsonToMap",produces = "application/json;charset=UTF-8")
	public Object jsonToMap(@RequestBody Map<String,Object> jsonMap) {
		System.out.println(jsonMap);
		return "success";
	}

}
