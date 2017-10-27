package mydefineComponent;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MethodInterceptorImpl implements MethodInterceptor{

	@Override
	public Object intercept(Object o, Method method, Object[] objects,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("MethodInterceptorImpl:" + method.getName());
		return methodProxy.invokeSuper(o, objects);
	}
	
	

}
