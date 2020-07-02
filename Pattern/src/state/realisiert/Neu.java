package state.realisiert;

public class Neu implements BearbeitungsStatus{

	public Neu(Dokument doc){
        this.doc = doc;
    }
    private Dokument doc;
    
	@Override
	public void drucke() {
		System.out.println("Drucke Entwurf");
		
	}

	@Override
	public void editiere() {
		System.out.println("editiere...");
		
		
	}

	@Override
	public void unterschreibe() {
		System.out.println("Unterschreibe Dokument");
		doc.setAktuellerStatus(new Fertig(doc));
	}

}
