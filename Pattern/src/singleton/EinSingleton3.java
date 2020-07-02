package singleton;


public class EinSingleton3 {

	// Die eine Instanz 
	private static EinSingleton3 instance;
	
	static {
		instance = new EinSingleton3();
		System.out.println("Erzeuge Instanz");
	}
	
	// Erzeugung nur in der Klasse selbst m�glich
	private EinSingleton3() {
	}
	
	// Liefert die Instanz zur�ck (und erzeugt sie)
	public static EinSingleton3 getInstance() {
		return instance;
		
	}

}
