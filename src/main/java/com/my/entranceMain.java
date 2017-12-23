package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

//// 用这个注解，必须要有@ComponentScan来规定扫描的根路径
//@EnableAutoConfiguration
//// 定义扫描的路径
//@ComponentScan(value = "com.my")
//@Configuration
@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class entranceMain {

	public static void main(String[] args) {
		SpringApplication.run(entranceMain.class, args);

	}
	
}
