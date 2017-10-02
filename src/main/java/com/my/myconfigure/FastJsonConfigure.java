package com.my.myconfigure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class FastJsonConfigure extends WebMvcConfigurerAdapter {

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// 调用父类的配置
		super.configureMessageConverters(converters);

		// 创建fastJson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();

		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteMapNullValue);
		// 解决中文乱码问题
		List<MediaType> fastMediaType = new ArrayList<>();
		fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);

		fastConverter.setSupportedMediaTypes(fastMediaType);

		fastConverter.setFastJsonConfig(fastJsonConfig);

		converters.add(fastConverter);
	}
}
