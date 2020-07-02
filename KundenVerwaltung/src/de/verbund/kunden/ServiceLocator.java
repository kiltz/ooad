package de.verbund.kunden;

import de.verbund.kunden.service.KundenVerwaltung;
import de.verbund.kunden.service.KundenVerwaltungDummyImpl;

public class ServiceLocator {

	public static KundenVerwaltung getKundenVerwaltung() {
		return new KundenVerwaltungDummyImpl();
	}

}
