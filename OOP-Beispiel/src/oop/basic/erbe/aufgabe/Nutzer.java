package oop.basic.erbe.aufgabe;

public class Nutzer {

	public void testeSingleton() {
		EinSingleton s = EinSingleton.getInstance();

		EinSingleton s1 = EinSingleton.getInstance();
		
		if (s == s1) {
			System.out.println("Die beiden sind gleich!");
		}
		
	}
	
	public static void main(String[] args) {
		Nutzer n = new Nutzer();
		n.testeSingleton();
	}
}
