package de.verbund.kunden.service;

import java.util.ArrayList;
import java.util.List;

import de.verbund.kunden.dto.Kunde;

/**
 * Klasse repräsentiert die BusinessEbene der Applikation.
 * 
 * @author fk
 * 
 */
public class KundenVerwaltungDummyImpl implements KundenVerwaltung {

	private static List<Kunde> liste;

	public KundenVerwaltungDummyImpl() {
		if (liste == null) {
			erstelleTestDaten();
		}
	}

	private void erstelleTestDaten() {
		liste = new ArrayList<Kunde>();
		liste.add(new Kunde("Hägar", "K00001"));
		liste.add(new Kunde("Sven", "K00002"));
		liste.add(new Kunde("Helga", "K00003"));
		for (int i = 0; i < liste.size(); i++) {
			liste.get(i).setId(i + 1L);
		}
	}

	@Override
	public List<Kunde> suche(String s) {
		List<Kunde> erg = new ArrayList<Kunde>();
		for (Kunde k : liste) {
			if (k.getName().toLowerCase().contains(s.toLowerCase())) {
				erg.add(k);
			}
		}
		return erg;
	}

	@Override
	public Kunde neuerKunde(Kunde k) throws PflichtFeldException {
		if (k.getName() == null || k.getName().isEmpty()) {
			throw new PflichtFeldException("Name ist ein Pflichtfeld!");
		}
		liste.add(k);
		k.setId(liste.size() * 1L);
		return k;
	}

	@Override
	public Kunde getKundeByID(Long id) {
		Kunde ret = null;
		if (id < liste.size()) {
			ret = liste.get(id.intValue());
		}
		return ret;
	}

}
