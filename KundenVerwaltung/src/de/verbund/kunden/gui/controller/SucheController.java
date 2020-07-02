package de.verbund.kunden.gui.controller;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

import de.verbund.kunden.KundenBD;
import de.verbund.kunden.dto.Kunde;
import de.verbund.kunden.gui.model.SucheModel;
import de.verbund.kunden.gui.view.HauptFenster;
import de.verbund.kunden.gui.view.SucheView;

public class SucheController implements Observer {
	private final HauptFenster hauptFenster;
	private final SucheModel sucheModel;
	private final SucheView sucheView;
	private final KundenBD bd;

	public SucheController(HauptFenster hauptFenster) {
		this.hauptFenster = hauptFenster;
		sucheModel = new SucheModel(this);
		sucheView = new SucheView(hauptFenster, this, sucheModel);
		sucheModel.setView(sucheView);
		bd = new KundenBD();
	}

	public void suche() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				List<Kunde> liste = bd.suche(sucheModel.getSuchbegriff());
				sucheModel.setListe(liste);
				sucheView.aktualisiere();
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		suche();

	}

	public void byeBye() {
		hauptFenster.removeObserver(this);

		System.out.println("nehme mich raus...");
	}

}
