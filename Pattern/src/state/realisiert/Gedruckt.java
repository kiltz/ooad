package state.realisiert;

public class Gedruckt implements BearbeitungsStatus{
	
	 private Dokument doc;
	 
	public Gedruckt(Dokument doc){
        this.doc = doc;
    }
   
    
	@Override
	public void drucke() {
		System.out.println("Drucke Kopie");
		
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
