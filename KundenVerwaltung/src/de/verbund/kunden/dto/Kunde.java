package de.verbund.kunden.dto;

/**
 * Data Transfer-Objekt für einen Kunden.
 * 
 * @author fk
 * 
 */
public class Kunde {
	private Long id;
	private String name;
	private String kdNr;

	public Kunde() {
	}

	public Kunde(String name, String kdNr) {
		super();
		this.name = name;
		this.kdNr = kdNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKdNr() {
		return kdNr;
	}

	public void setKdNr(String kdNr) {
		this.kdNr = kdNr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
