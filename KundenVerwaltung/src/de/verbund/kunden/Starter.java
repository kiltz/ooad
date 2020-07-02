package de.verbund.kunden;

import javax.swing.SwingUtilities;

import de.verbund.kunden.gui.view.HauptFenster;

public class Starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new HauptFenster();
			}
		});

	}

}
