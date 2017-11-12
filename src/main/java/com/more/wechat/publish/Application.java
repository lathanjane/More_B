package com.more.wechat.publish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.more.wechat.publish.start.PublishConfig;

@SpringBootApplication
@ComponentScan(basePackageClasses = { PublishConfig.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
