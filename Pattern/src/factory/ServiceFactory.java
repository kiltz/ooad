package factory;

public class ServiceFactory {

	public static Service createService() {
		// Besser über eine Konfig entscheiden lassen ;-)
		if (Math.random() < 0.5) {	
			return new InMemoryServiceImpl();
		} else {
			return new DummyServiceImpl();
		}

	}

}
