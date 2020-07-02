package de.verbund.kunden.gui.controller;

import de.verbund.kunden.KundenBD;
import de.verbund.kunden.dto.Kunde;
import de.verbund.kunden.gui.model.NeuModel;
import de.verbund.kunden.gui.view.HauptFenster;
import de.verbund.kunden.gui.view.NeuView;
import de.verbund.kunden.service.PflichtFeldException;

/**
 * Der Controller als Singleton
 * 
 * @author tz
 * 
 */
public class NeuController {

	private static NeuController instance;
	private static HauptFenster hauptFenster;
	private final NeuModel neuModel;
	private final NeuView neuView;
	private final KundenBD bd;

	private NeuController() {
		neuModel = new NeuModel(this);
		neuView = new NeuView(hauptFenster, this, neuModel);
		neuModel.setView(neuView);
		bd = new KundenBD();
	}

	public synchronized static NeuController installController(HauptFenster fenster) {
		if (instance == null) {
			hauptFenster = fenster;
			System.out.println("Erzeuge neuen NeuController");
			instance = new NeuController();
		} else {
			if (instance.neuView != null) {
				instance.neuView.pruefeView();
			}
		}
		return instance;
	}

	public void speichern() {
		Kunde k = new Kunde(neuModel.getName(), neuModel.getKdNr());
		try {
			k = bd.neuerKunde(k);
			neuView.meldeOk(k.getId());
			hauptFenster.notifyObservers();
		} catch (PflichtFeldException e) {
			// Was tun mit der Ex? :(
			neuView.meldeFehler(e.getMessage());
		}
	}

}
