package oop.basic.kapselung;

public class Kreis {

	// Zusicherung >= 0
	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if (radius >= 0) {
			this.radius = radius;
		} else {
			// Mecker!
		}
	}
	
	
	
}
