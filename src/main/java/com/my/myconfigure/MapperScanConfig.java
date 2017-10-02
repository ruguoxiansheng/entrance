package com.my.myconfigure;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

//<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
//<property name="basePackage" value="springMVCmybatis" /> 
//<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" /> 
//
//</bean>

@Configuration
@AutoConfigureAfter(MybatisDbConfigure.class)
public class MapperScanConfig {

	public MapperScannerConfigurer myGetMapperScannerConfigurer() {
		MapperScannerConfigurer myMapperScannerConfigurer = new MapperScannerConfigurer();

		myMapperScannerConfigurer.setBasePackage("com.my.dao");
		myMapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		return myMapperScannerConfigurer;
	}

}
