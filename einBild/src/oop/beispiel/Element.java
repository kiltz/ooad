package oop.beispiel;

/**
 * Abstrakte Klasse für die Gemeinsamkeiten der Bildelemente
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
		// Gültigkeitsbereich müßte noch geprüft werden...
		this.rot = rot;
		this.gruen = gruen;
		this.blau = blau;
	}

	void setStartPunkt(int x, int y) {
		this.x = x;
		this.y = y;
	}
}