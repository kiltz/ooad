package oop.beispiel;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Erweiterung des Punktes durch die Endkoordinaten
 */

public class Strich extends Element implements Drawable {
	int x2 = 0;
	int y2 = 0;

	public Strich(int x, int y, int x2, int y2) {
		this.setStartPunkt(x, y);
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics zeichenflaeche) {

		// Farbe setzen
		zeichenflaeche.setColor(new Color(this.rot, this.gruen, this.blau));
		// zeichnen
		zeichenflaeche.drawLine(this.x, this.y, this.x2, this.y2);
	}

}
