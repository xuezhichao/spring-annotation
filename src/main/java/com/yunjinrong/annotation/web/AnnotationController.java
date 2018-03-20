package com.yunjinrong.annotation.web;

import javax.xml.ws.RespectBinding;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yunjinrong.annotation.config.MyAnnotation;

@RestController
public class AnnotationController {

	
	@MyAnnotation
	@RequestMapping("add1")
	public String addData1(String deviceId) {
		System.out.println("123");
		return "success";
	}
	
	@RequestMapping("add2")
	public String addData2(String deviceId) {
		return "success";
	}
	
	@RequestMapping("add3")
	public String addData3(String deviceId) {
		return "success";
	}
	
}
