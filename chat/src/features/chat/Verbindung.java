package features.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Verbindung implements Runnable {

	private Socket socket;
	private ChatServer socketServer;
	private boolean ok = true;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public Verbindung(Socket socket, ChatServer socketServer) {
		this.socket = socket;
		this.socketServer = socketServer;
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

			while (ok) {

				try {
					Serializable gesendet = (Serializable) in.readObject();
					Serializable returnObj = verarbeite(gesendet);
					// Rückgabe des Objektes
					// out.writeObject(returnObj);
				} catch (ClassNotFoundException e) {
					socketServer.sage("Fehler beim Lesen: " + e.getMessage());
					e.printStackTrace();
				}
			}
			// beenden
			in.close();
			out.close();
			socketServer.sage("...beendet");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void sende(Kommando obj) {
		try {
			// Sende zum Server
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Serializable verarbeite(Serializable gesendet) {

		Kommando kdo = null;
		String meldung = null;
		if (gesendet instanceof Kommando) {
			kdo = (Kommando) gesendet;
		} else {
			// unerwarteter Fehler
			kdo = new Kommando();
			kdo.setReturnWert("Fehlerhafter Aufruf!");
		}
		if (kdo.getKommando().equals("beende")) {
			ok = false;
			meldung = "Und tschüß!";
		}
		if (kdo.getKommando().equals("text")) {
			socketServer.sendeAnAlle(kdo);
		}

		socketServer.sage(meldung);
		return gesendet;
	}

	public void beende() {
		System.out.println("sterbe....");
		Kommando kdo = new Kommando();
		kdo.setKommando("beende");
		try {
			out.writeObject(kdo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
