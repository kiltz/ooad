package features.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener, WindowListener {
	private static final long serialVersionUID = 1L;

	private JTextField eingabe;
	private JTextArea ausgabe;
	private ChatClient client;

	public ClientGUI(String titel) {
		// Fenster hübsch machen
		setTitle("SocketClient: " + titel);
		init();
		client = new ChatClient(this);
	}

	public static void main(String[] args) {
		new ClientGUI("aus Main");
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.addWindowListener(this);
		Container pane = getContentPane();

		JPanel unten = new JPanel();

		eingabe = new JTextField(15);
		unten.add(eingabe);
		eingabe.addActionListener(this);

		ausgabe = new JTextArea();
		JScrollPane textScroller = new JScrollPane(ausgabe);
		pane.add(textScroller, BorderLayout.CENTER);
		pane.add(unten, BorderLayout.SOUTH);

		setSize(300, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == eingabe) {
			sende();
		}
	}

	private void sende() {
		String e = eingabe.getText();

		Kommando kdo = new Kommando();
		kdo.setKommando("text");
		kdo.addParameter(e);

		client.sende(kdo);
		eingabe.setText("");
		eingabe.requestFocus();
	}

	public void ausgabe(String txt) {
		ausgabe.append(txt + "\n");
	}

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosing(WindowEvent e) {
		client.beende();

	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
