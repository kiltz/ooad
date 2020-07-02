package state.realisiert;

public class Dokument {
	private BearbeitungsStatus aktuellerStatus;
	
	public void setAktuellerStatus(BearbeitungsStatus aktuellerStatus){
        this.aktuellerStatus = aktuellerStatus;
    }
	public BearbeitungsStatus getAktuellerZustand(){
		return aktuellerStatus;
	}
    //Defaultzustand Neutral im Konstruktor setzen.
    public Dokument(){
        setAktuellerStatus(new Neu(this));
    }

    public void drucken() {
        aktuellerStatus.drucke();
    }

    public void editieren() {
        aktuellerStatus.editiere();
    }

    public void unterschreiben() {
        aktuellerStatus.unterschreibe();
    }
	
}
