package com.kabouros.gath.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;

/**
 * @author JIANG
 */
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	/**
	 * @param recordRequestTime  是否记录请求响应时间
	 * @return
	 */
    @Bean
    public UndertowServletWebServerFactory embeddedServletContainerFactory(@Value("${server.undertow.record-request-time}") boolean recordRequestTime) {
    	UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers((Undertow.Builder builder) -> {
            builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, recordRequestTime);
        });
        return factory;
    }
}
