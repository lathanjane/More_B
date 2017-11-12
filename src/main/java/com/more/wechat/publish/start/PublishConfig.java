package com.more.wechat.publish.start;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @ClassName: SofaConfig
 * @Description: sofa配置引入
 * @author: lathan.zhang
 * @date: 2017-7-1 上午10:57:24
 */
@Configuration
@ComponentScan(basePackages = { "com.more.wechat.publish.survey" })
@ImportResource(value = { "classpath:startConfig/*.xml" })
public class PublishConfig {

}
