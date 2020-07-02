package state.realisiert;

public class Fertig implements BearbeitungsStatus{

	public Fertig(Dokument doc){
        this.doc = doc;
    }
    private Dokument doc;
    
	@Override
	public void drucke() {
		System.out.println("Drucke Original");
		doc.setAktuellerStatus(new Gedruckt(doc));
	}

	@Override
	public void editiere() {
		System.out.println("Editieren nicht möglich!");
		
	}

	@Override
	public void unterschreibe() {
		System.out.println("Dokument ist schon unterschrieben");
		
	}

}
