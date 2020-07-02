package de.verbund.kunden.service;

import java.util.List;

import de.verbund.kunden.dto.Kunde;

public interface KundenVerwaltung {

	List<Kunde> suche(String s);

	Kunde neuerKunde(Kunde k) throws PflichtFeldException;

	Kunde getKundeByID(Long id);

}
