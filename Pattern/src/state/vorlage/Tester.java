package state.vorlage;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 Dokument doc = new Dokument();
	 
	 Bearbeiter bea = new Bearbeiter(doc);
	 System.out.println("\n*** Erster Durchlauf ("+doc.getStatus()+") *** ");
	 bea.edit();
	 bea.drucke();
	 bea.unterschreibe();
	 
	 System.out.println("\n*** Zweiter Durchlauf ("+doc.getStatus()+") *** ");
	 bea.edit();
	 bea.drucke();
	 bea.unterschreibe();

	 System.out.println("\n*** Dritter Durchlauf ("+doc.getStatus()+") *** ");
	 bea.edit();
	 bea.drucke();
	 bea.unterschreibe();

	}

}
