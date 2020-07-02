package de.verbund.kunden;

import java.util.List;

import de.verbund.kunden.dto.Kunde;
import de.verbund.kunden.service.KundenVerwaltung;
import de.verbund.kunden.service.PflichtFeldException;

public class KundenBD {

	private final KundenVerwaltung service;

	public KundenBD() {
		service = ServiceLocator.getKundenVerwaltung();
	}

	public List<Kunde> suche(String s) {
		// Delegiere zum EJB-Service
		return service.suche(s);
	}

	public Kunde neuerKunde(Kunde k) throws PflichtFeldException {
		return service.neuerKunde(k);
	}

	public Kunde holePerId(Long id) {

		return service.getKundeByID(id);
	}
}
