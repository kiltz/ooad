package oop.basic.erbe;

import javax.swing.JFrame;

public class MeinFenster {

	private JFrame fenster;
	public MeinFenster() {
		fenster = new JFrame();
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(400, 300);
		fenster.setTitle("Mein kleines unnützes Fenster");
		fenster.setLocationRelativeTo(null);
		fenster.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MeinFenster();

	}

}
