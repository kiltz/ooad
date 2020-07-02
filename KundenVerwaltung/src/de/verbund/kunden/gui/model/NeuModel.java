package de.verbund.kunden.gui.model;

import de.verbund.kunden.gui.controller.NeuController;
import de.verbund.kunden.gui.view.NeuView;

/**
 * Das Model
 * 
 * @author tz
 * 
 */
public class NeuModel {

	private final NeuController neuController;
	private NeuView neuView;

	private String kdNr;
	private String name;

	public NeuModel(NeuController neuController) {
		this.neuController = neuController;
	}

	public void setView(NeuView neuView) {
		this.neuView = neuView;

	}

	public String getKdNr() {
		return kdNr;
	}

	public void setKdNr(String kdNr) {
		this.kdNr = kdNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void reset() {
		setName(null);
		setKdNr(null);

	}

}
