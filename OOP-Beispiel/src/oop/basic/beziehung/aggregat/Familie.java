package oop.basic.beziehung.aggregat;

public class Familie {
	private Katze[] katzen = new Katze[2];
	private int index = 0;
	
	public void zulaufen(Katze k) {
		katzen[index++] = k;
		
	}
}
