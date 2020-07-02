package oop.beispiel;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Zeichen eines Punktes Ein wenig dicker, damit er besser gesehen wird
 */

public class Punkt extends Element implements Drawable {

	public Punkt(int x, int y) {
		this.setStartPunkt(x, y);
	}

	public void draw(Graphics zeichenflaeche) {
		// Farbe setzen
		zeichenflaeche.setColor(new Color(this.rot, this.gruen, this.blau));
		// zeichnen
		zeichenflaeche.fillRect(this.x, this.y, 4, 4);

	}
}
