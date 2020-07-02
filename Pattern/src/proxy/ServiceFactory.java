package proxy;

import java.lang.reflect.Proxy;

public class ServiceFactory {

	private static PersonenService personenService;
	
	public static PersonenService getPersonenService() {
		if (personenService == null)
		{
			PruefHandler handler = new PruefHandler();

			personenService = (PersonenService) Proxy.newProxyInstance(
					PersonenService.class.getClassLoader(), 
					new Class[] { PersonenService.class },
			        handler);
		}
	    return personenService;
    }

}
