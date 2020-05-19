package com.etoak.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HelloController implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收参数
		String name =request.getParameter("name");
		System.out.println("param name-"+name);
		//调用service,向request传值
		request.setAttribute("result", "hello"+name);
		
		//返回页面
			request.getRequestDispatcher("hello.jsp").forward(request, response);
			
	}

}
