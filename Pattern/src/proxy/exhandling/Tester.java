package proxy.exhandling;

import java.lang.reflect.Proxy;

import org.junit.BeforeClass;
import org.junit.Test;

public class Tester {
	private static Service service;

	
	@BeforeClass
	public static void init() {
		
		Service target = new ServiceImpl(); 
		NullPointerHandler meinHandler = new NullPointerHandler(target);

		service = (Service) Proxy.newProxyInstance(
				Service.class.getClassLoader(), 
					new Class[] { Service.class },
					meinHandler);
	}

	@Test
	public void testeKeinNullPointer() {
		System.out.println(service.ping("test"));
	}
	@Test
	public void testeNullPointer() {
		System.out.println(service.ping(null));
	}
}

