package de.verbund.kunden.gui.utils;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

public class GUITools {

	public static GridBagConstraints getGridBagConstraints(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		// Ein bisserl Abstand
		gbc.insets = new Insets(5, 5, 5, 5);
	    return gbc;
    }

	public static GridBagConstraints getGridBagConstraints(int x, int y,
            boolean horizontalGefuellt) {
		GridBagConstraints gbc = getGridBagConstraints(x, y);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

	    return gbc;
    }
	
	public static void zentriere(Component c) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		int breiteBildschirm = (int)dim.getWidth();
		int hoeheBildschirm = (int)dim.getHeight();
		int breiteFenster = c.getWidth();
		int hoeheFenster = c.getHeight();
		
		int x = (breiteBildschirm / 2) - (breiteFenster / 2);
		int y = (hoeheBildschirm / 2) - (hoeheFenster / 2);
		
		c.setLocation(x, y);
	    
    }


}

