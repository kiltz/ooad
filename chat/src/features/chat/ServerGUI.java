package features.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton jbBeenden;
	private JTextArea ausgabe;
	private ChatServer server;
	private JScrollPane textScroller;

	public ServerGUI() {
		init();
		server = new ChatServer(this);
	}

	public static void main(String[] args) {
		ServerGUI frame = new ServerGUI();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("SocketServer");
		Container pane = getContentPane();

		JPanel unten = new JPanel();

		jbBeenden = new JButton("beende");
		unten.add(jbBeenden);
		jbBeenden.addActionListener(this);

		ausgabe = new JTextArea();
		textScroller = new JScrollPane(ausgabe);
		pane.add(textScroller, BorderLayout.CENTER);
		pane.add(unten, BorderLayout.SOUTH);

		setSize(300, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbBeenden) {
			server.sendePingAnAlle();
			// TODO sauberes Ende
		}
	}

	public void ausgabe(String txt) {
		ausgabe.append(txt + "\n");
		Point point = new Point(0, (int) (ausgabe.getSize().getHeight()));
		textScroller.getViewport().setViewPosition(point);
	}

	public JTextArea getAusgabe() {
		return ausgabe;
	}
}
