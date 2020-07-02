package oop.basic.erbe.aufgabe;

public class EinSingleton {
	private static EinSingleton instance;
	
	private EinSingleton() {
		
	}
	
	public static EinSingleton getInstance() {
		if (instance == null ) {
			instance = new EinSingleton();
		}
		return instance;
	}
}

