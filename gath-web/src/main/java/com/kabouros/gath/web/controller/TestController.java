package com.kabouros.gath.web.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@GetMapping("/test")
	public String test(HttpServletRequest httpRequest) throws InterruptedException{
		TimeUnit.SECONDS.sleep(10);
		return "测试";
	}

}
