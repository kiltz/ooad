package oop.basic.erbe.abstrakt;

import javax.swing.JFrame;

/**
 * Meine Klasse "hat einen" JFrame 
 * @author tz
 *
 */
public abstract class FensterVorlage {
	private JFrame fenster;
	
	public FensterVorlage() {
		fenster = new JFrame();
		
		initKomponents(fenster);
		
		fenster.setVisible(true);
	}

	protected abstract void initKomponents(JFrame fenster2);

}
