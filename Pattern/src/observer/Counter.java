package observer;

import java.util.Observable;

/**
 * Ein einfaches "änderbares" Modell. 
 * 
 */
public class Counter extends Observable {
	//	Die Daten
	private int anzahl;
	
	public Counter(int anzahl) {
		this.anzahl = anzahl; 
	}
	
	public int getAnzahl() {
		return anzahl; 
	}
	
	public void increment() {
		anzahl++;
		// markiere Counter als verändert 
		setChanged();
		// Benachrichtige aller Observer (hier mit Nachricht)
		notifyObservers("Increment");
	}
	
	public void decrement() {
		anzahl--;
		// markiere Counter als verändert 
		setChanged();
		// Benachrichtige aller Observer (hier ohne Nachricht)
		notifyObservers();
	}
	
}