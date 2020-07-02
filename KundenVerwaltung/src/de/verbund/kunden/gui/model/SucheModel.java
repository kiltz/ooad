package de.verbund.kunden.gui.model;

import java.util.List;

import de.verbund.kunden.dto.Kunde;
import de.verbund.kunden.gui.controller.SucheController;
import de.verbund.kunden.gui.view.SucheView;

public class SucheModel {

	private final SucheController sucheController;
	private SucheView sucheView;

	private String suchbegriff;
	private List<Kunde> liste;

	public SucheModel(SucheController sucheController) {
		this.sucheController = sucheController;
	}

	public void setView(SucheView sucheView) {
		this.sucheView = sucheView;

	}

	public String getSuchbegriff() {
		return suchbegriff;
	}

	public void setSuchbegriff(String suchbegriff) {
		this.suchbegriff = suchbegriff;
	}

	public List<Kunde> getListe() {
		return liste;
	}

	public void setListe(List<Kunde> liste) {
		this.liste = liste;
	}

}
