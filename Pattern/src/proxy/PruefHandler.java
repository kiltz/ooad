package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PruefHandler implements InvocationHandler {

	private PersonenService ziel;

	public PruefHandler() {
		ziel = new PersonenServiceImpl();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object ret = null;
//		if (method.getName().equals("suche")) {
//			ret = ziel.suche((String) args[0]);
//		}
		if (pruefParameter(args)) {
			Method methode = ziel.getClass().getMethod(method.getName(),
					args[0].getClass());
			ret = methode.invoke(ziel, args);
		} else {
			throw new IllegalArgumentException();
		}
		return ret;
	}

	private boolean pruefParameter(Object[] args) {
		if (args[0].equals("böse")) {
			return false;
		}
		return true;
	}

}
