package singleton;

/**
 * "In Java ist diese Implementierung dem Lazy Creation Ansatz vorzuziehen. Die Initialisierung findet durch das späte 
 * Initialisieren der Klasse erst statt, wenn die Klasse Singleton referenziert wird. Da der Zugriff nur via 
 * getInstance() erfolgt, ist dies auch der spätest mögliche Zeitpunkt und entspricht somit der 
 * Lazy Evaluation ohne den Synchronisierungs-Overhead."
 * (Wikipedia)
 * 
 * @author fk
 * 
 */
public class EinSingleton2 {

	// Die eine Instanz
	private static EinSingleton2 instance = new EinSingleton2();

	// Erzeugung nur in der Klasse selbst möglich
	private EinSingleton2() {
	}

	// Liefert die Instanz zurück (und erzeugt sie)
	public static EinSingleton2 getInstance() {
		return instance;

	}

}
