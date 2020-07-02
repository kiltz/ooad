package oop.beispiel;

/**
 * Die Anwendung für die Ablaufsteuerung
 */

public class Anwendung {

	public static void main(String[] args) {
		// erzeuge das Bild
		Bild bild = new Bild(400, 400);
		// erzeuge 1. Punkt
		Punkt p1 = new Punkt(48, 48);
		// setze Farbe des Punktes
		p1.setFarbe(255, 0, 0);
		// füge Punkt dem Bild hinzu
		bild.add(p1);

		// 2. Punkt
		Punkt p2 = new Punkt(248, 248);
		p2.setFarbe(0, 255, 0);
		bild.add(p2);

		// 1. Strich
		Strich s1 = new Strich(50, 55, 50, 250);
		// setze Farbe des Striches
		s1.setFarbe(255, 0, 0);
		// füge Strich dem Bild hinzu
		bild.add(s1);

		// 2. Strich
		Strich s2 = new Strich(50, 250, 245, 250);
		// setze Farbe des Striches
		s2.setFarbe(0, 255, 0);
		// füge Strich dem Bild hinzu
		bild.add(s2);

		// 1. Kreis
		Kreis k1 = new Kreis(200, 200, 50);
		// setze Farbe des Striches
		k1.setFarbe(255, 0, 0);
		// füge Strich dem Bild hinzu
		bild.add(k1);

		// 2. Kreis
		Kreis k2 = new Kreis(100, 100, 50);
		// setze Farbe des Striches
		k2.setFarbe(0, 255, 0);
		// füge Strich dem Bild hinzu
		bild.add(k2);

		// bild malen
		bild.repaint();

	}

}