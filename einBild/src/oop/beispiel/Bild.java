package oop.beispiel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * Aufgabe der Klasse Bild ist es, die Leinwand für die Elemente bereitzustellen
 * (extends jFrame) und das Bild darzustellen (draw).
 * 
 * PAL: Problem anderer Leute. Sprich: Müsst ihr nicht im Detail verstehen.
 */

// PAL: bitte ignorieren!
@SuppressWarnings("serial")
public class Bild extends JFrame {

	int breite = 200;
	int hoehe = 200;
	// Die "Leinwand"
	Graphics zeichenflaeche;
	// die Sammlung der Elemente
	List<Element> elemente = new ArrayList<Element>();

	// Erzeugung mit Standard-Werten
	public Bild() {
		init();
	}

	// Erzeugung mit neuer Höhe und Breite
	// Bild bild = new Bild(400,400);
	public Bild(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;
		init();
	}

	// Element dem Bild zuordnen
	// bild.add( p1 );
	public void add(Element neu) {
		elemente.add(neu);
	}

	// Für jedes Element "draw()" aufrufen
	public void draw() {
		// Hole Element aus der Liste
		for (Element e : elemente) {
			// Wenn das Element Zeichenbar ist
			if (e instanceof Drawable) {
				// Betrachte es als Zeichenbar
				Drawable d = (Drawable) e;
				// Rufe seine Methode auf
				d.draw(zeichenflaeche);
			}
		}
	}

	// ruft draw() auf, Rest ist PAL
	public void paint(Graphics g) {
		super.paint(g);
		zeichenflaeche = g;
		draw();
	}

	// interne Methode zum Aufbau des Dialogs (Inhalt: PAL)
	private void init() {
		// Programm beenden, wenn das Fenster geschlossen wird
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Größe setzen
		setSize(breite, hoehe);
		// Hintergrundfarbe
		getContentPane().setBackground(new Color(255, 255, 255));
		// und anzeigen
		setVisible(true);
	}
}