package oop.beispiel;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Ausgabe eines Kreises
 */

public class Kreis extends Element implements Drawable {

	private int radius = 0;

	/**
	 * Erzeugt einen Kreis.
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Kreis(int x, int y, int radius) {
		this.setStartPunkt(x, y);
		this.radius = radius;
	}

	public void draw(Graphics zeichenflaeche) {
		// Farbe setzen
		zeichenflaeche.setColor(new Color(this.rot, this.gruen, this.blau));
		// zeichnen
		zeichenflaeche.drawArc(this.x, this.y, this.radius * 2, this.radius * 2, 0, 360);

	}

}
