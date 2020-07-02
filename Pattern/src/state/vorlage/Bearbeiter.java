package state.vorlage;

public class Bearbeiter {

	private Dokument doc;
	public Bearbeiter(Dokument doc) {
	    this.doc = doc;
    }

	public void drucke() {
		if (doc.getStatus() == Status.NEU) {
			System.out.println("Drucke Entwurf");
		} else if (doc.getStatus() == Status.FERTIG) {
			System.out.println("Drucke Original");
			doc.setStatus(Status.GEDRUCKT);
		} else if (doc.getStatus() == Status.GEDRUCKT) {
			System.out.println("Drucke Kopie");
		}
		
		
	}
	public void edit() {
		if (doc.getStatus() == Status.NEU) {
			System.out.println("editiere...");
		} else {
			System.out.println("Editieren nicht möglich!");
		}
		
	}
	
	public void unterschreibe() {
		if (doc.getStatus() == Status.NEU) {
			doc.setStatus(Status.FERTIG);
			System.out.println("Unterschreibe Dokument");
		} else {
			System.out.println("Dokument ist schon unterschrieben");
		}
	}
}
