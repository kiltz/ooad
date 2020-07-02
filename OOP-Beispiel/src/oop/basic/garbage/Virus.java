package oop.basic.garbage;

import java.util.ArrayList;
import java.util.List;

public class Virus {

	private static long anzahl;
	private long nr;
	private static List<Virus> vieren = new ArrayList<>();
	
	
	public Virus() {
		anzahl++;
		nr = anzahl;
	}
	
	public static void main(String[] args) {
		while (true) {
			vieren.add(new Virus());
		}

	}

	@Override
	protected void finalize() throws Throwable {
		System.out.print(anzahl+"/"+nr+"; ");
	}
}
