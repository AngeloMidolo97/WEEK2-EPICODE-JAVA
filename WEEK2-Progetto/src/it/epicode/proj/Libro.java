package it.epicode.proj;

import java.time.LocalDate;

public class Libro {
	//-------------------PROPRIETA-------------------
	private String isbm;
	private String titolo;
	private LocalDate annoDiPubblicazione;
	private int numeroPagine;
	
	private String autore;
	private String genere;
	
	//-------------------COSTRUTTORE-------------------
	public Libro(String isbm, String titolo, LocalDate annoDiPubblicazione, int numeroPagine, String autore,
			String genere) {
		super();
		this.isbm = isbm;
		this.titolo = titolo;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.numeroPagine = numeroPagine;
		this.autore = autore;
		this.genere = genere;
	}

	//-------------------GETTER AND SETTER-------------------
	public String getIsbm() {
		return isbm;
	}

	public void setIsbm(String isbm) {
		this.isbm = isbm;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getAnnoDiPubblicazione() {
		return annoDiPubblicazione;
	}

	public void setAnnoDiPubblicazione(LocalDate annoDiPubblicazione) {
		this.annoDiPubblicazione = annoDiPubblicazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "isbm: " + isbm + ", titolo: " + titolo + ", annoDiPubblicazione: " + annoDiPubblicazione
				+ ", numeroPagine: " + numeroPagine + ", autore: " + autore + ", genere: " + genere + "@";
	}

}
