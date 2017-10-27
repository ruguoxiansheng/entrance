package com.my.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyFooishHandler implements ApplicationContextAware, InitializingBean{

    private ApplicationContext applicationContext;
    
	private List<String> allFooish = new ArrayList<>();

	@Override
	public void afterPropertiesSet() throws Exception {
		scanFooishClass();
        scanFooishMethod();
        System.out.println(allFooish);
		
	}

	/**
	 * 查找 用 Fooish 注解的 方法
	 */
	private void scanFooishMethod() throws Exception{
		final Map<String, Object> permissionMap = applicationContext.getBeansWithAnnotation(Fooish.class);
		System.out.println("this is permissionMap" + permissionMap.toString());
        for (final Object permissionObject : permissionMap.values()) {
            final Class<? extends Object> permissionClass = permissionObject.getClass();
            final Fooish annotation = permissionClass.getAnnotation(Fooish.class);
            if(annotation != null) {
                allFooish.addAll(Arrays.asList(annotation.tags()));
            }
        }


		
	}

	private void scanFooishClass() throws Exception{
		final Map<String, Object> controllerMap = applicationContext.getBeansWithAnnotation(Fooish.class);
        for (final Object controllerObject : controllerMap.values()) {
            final Class<? extends Object> controllerClass = controllerObject.getClass();
            for (Method method : controllerClass.getDeclaredMethods()) {
                Fooish fooish = method.getAnnotation(Fooish.class);
              if (fooish != null) {
                    allFooish.addAll(Arrays.asList(fooish.tags()));
                }
            }
        }

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		 this.applicationContext = applicationContext;
		
	}

}
