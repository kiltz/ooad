package proxy.exhandling;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NullPointerHandler implements InvocationHandler {

	private Object target;

	public NullPointerHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object ret = null;
		try {
			ret = method.invoke(target, args);
		} catch (Exception e) {
			System.out.println(e.getClass());
			if (e.getCause() != null) {
				System.out.println("\t"+e.getCause().getClass());
			}
		}
		
		return ret;
	}

}
