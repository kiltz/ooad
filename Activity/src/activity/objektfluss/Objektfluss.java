package activity.objektfluss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Nach "UML2" von Galileo Computing
 * 
 * @author fk
 * 
 */

public class Objektfluss {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Objektfluss o = new Objektfluss();
		Eingabe e = o.eingabeLesen();
		o.eingabeAusgeben(e);

	}
	
	public Eingabe eingabeLesen() {
		Eingabe e = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Eingabe: ");
			e = new Eingabe(br.readLine());
		} catch (Exception ex){
			System.out.println(ex);
		}
		
		return e;
	}
	
	public void eingabeAusgeben(Eingabe e) {
		System.out.println("Ausgabe "+e.getTxt());
	}

}

class Eingabe {
	private String txt;

	public Eingabe(String txt) {
		this.txt = txt;
	}

	public String getTxt() {
		return txt;
	}
}
