package features.chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer implements Runnable {

	private ServerGUI serverGUI;
	private boolean ok = true;

	// neu 1:n: Die Liste für die Verbindungen
	private List<Verbindung> verbindungen;

	public ChatServer(ServerGUI serverGUI) {
		// merken der GUI
		this.serverGUI = serverGUI;
		// neu 1:n:
		verbindungen = new ArrayList<>();

		// Erzeuge Thread
		Thread t = new Thread(this);
		t.start();

	}

	public void run() {
		// Warte auf Verbindung
		try {
			ServerSocket server = new ServerSocket(4444);
			while (ok) {
				serverGUI.ausgabe("Warte auf Client...");
				Socket socket = server.accept();
				InetAddress adr = socket.getInetAddress();
				serverGUI.ausgabe("...habe einen von " + adr.getHostAddress());
				serverGUI.ausgabe("HostName " + adr.getHostName());
				Verbindung v = new Verbindung(socket, this);
				verbindungen.add(v);
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void beende() {
		for (int i = 0; i < verbindungen.size(); ++i) {
			Verbindung v = (Verbindung) verbindungen.get(i);
			v.beende();
		}
	}

	public void sage(String txt) {

		serverGUI.ausgabe(txt);

	}

	public void sendePingAnAlle() {
		Kommando kdo = new Kommando();
		kdo.setKommando("info");
		kdo.addParameter("Ping vom Server");
		sendeAnAlle(kdo);

	}

	public void sendeAnAlle(Kommando kdo) {
		for (int i = 0; i < verbindungen.size(); ++i) {
			Verbindung v = (Verbindung) verbindungen.get(i);
			// TODO Lebt die Verbindung noch?

			v.sende(kdo);
		}

	}
}
