package oop.basic.erbe.abstrakt;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MeinKleinerDialog extends FensterVorlage {

	@Override
	protected void initKomponents(JFrame fenster) {
		fenster.setLayout(new FlowLayout());
		fenster.add(new JButton("tuNix"));
		
	}
	
	public static void main(String[] args) {
		new MeinKleinerDialog();
	}
}
