package com.etoak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.etoak.action.UserAction;
import com.etoak.bean.User;
import com.etoak.config.UserConfig;

public class JavaConfigTest {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(UserConfig.class);
		UserAction userAction =ac.getBean(UserAction.class);
		User us=userAction.getById(200);
		System.out.println(us.getId()+"-"+us.getName());
		
	}

}
