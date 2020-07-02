package singleton;


public class EinSingleton {

	// Die eine Instanz 
	private static EinSingleton instance;
	
	// Erzeugung nur in der Klasse selbst möglich
	private EinSingleton() {
	}
	
	// Liefert die Instanz zurück (und erzeugt sie)
	public synchronized static EinSingleton getInstance() {
		if (instance == null) {
			instance = new EinSingleton();
		}
		return instance;
		
	}

}
