package state.realisiert;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dokument doc = new Dokument();

		for (int i = 0; i < 3; i++) {
			doc.editieren();
			doc.drucken();
			doc.unterschreiben();
			System.out.println("++++");
		}

	}

}
