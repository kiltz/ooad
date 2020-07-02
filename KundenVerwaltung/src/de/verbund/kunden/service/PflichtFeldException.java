package de.verbund.kunden.service;

public class PflichtFeldException extends Exception {

	private static final long serialVersionUID = 1L;

	public PflichtFeldException(String meldung) {
		super(meldung);
	}
}
