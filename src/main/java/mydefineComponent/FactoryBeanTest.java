package mydefineComponent;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;

public class FactoryBeanTest<T> implements InitializingBean, FactoryBean<T> {
	
	private String innerClassName;
	
	public void setInnerClassName(String innerClassName) {
		this.innerClassName = innerClassName;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getObject() throws Exception {
		Class innerClass = Class.forName(innerClassName);
		if (innerClass.isInterface()) {
			return (T) InterfaceProxy.newInstance(innerClass);
		} else {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(innerClass);
			enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
			enhancer.setCallback(new MethodInterceptorImpl());
			return (T) enhancer.create();
		}
	}
	

	@Override
	public Class<?> getObjectType() {
		try {
			return Class.forName(innerClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
