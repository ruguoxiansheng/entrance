package mydefineComponent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceProxy implements InvocationHandler {
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("ObjectProxy execute:" + method.getName());
		return method.invoke(proxy, args);
	}
	
	public static <T> T newInstance(Class<T> innerInterface) {
		ClassLoader classLoader = innerInterface.getClassLoader();
		Class[] interfaces = new Class[] { innerInterface };
		InterfaceProxy proxy = new InterfaceProxy();
		return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
	}
}
