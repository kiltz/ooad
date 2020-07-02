package proxy;

public class Nutzer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PersonenService service = ServiceFactory.getPersonenService();
		service.neu("gut");
		service.suche("böse");


	}

}
