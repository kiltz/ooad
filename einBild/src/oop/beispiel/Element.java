package oop.beispiel;

/**
 * Abstrakte Klasse f�r die Gemeinsamkeiten der Bildelemente
 */

public abstract class Element {
	// Farbe
	int rot = 0;
	int gruen = 0;
	int blau = 0;
	// Position
	int x = 0;
	int y = 0;

	public void setFarbe(int rot, int gruen, int blau) {
		// G�ltigkeitsbereich m��te noch gepr�ft werden...
		this.rot = rot;
		this.gruen = gruen;
		this.blau = blau;
	}

	void setStartPunkt(int x, int y) {
		this.x = x;
		this.y = y;
	}
}