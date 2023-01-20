package it.epicode.proj;

import java.time.LocalDate;

public class Rivista {
	//-------------------PROPRIETA-------------------
	private String isbm;
	private String titolo;
	private LocalDate annoDiPubblicazione;
	private int numeroPagine;
	
	Periodicita periodicita;

	//-------------------COSTRUTTORE-------------------
	public Rivista(String isbm, String titolo, LocalDate annoDiPubblicazione, int numeroPagine,
			Periodicita periodicita) {
		super();
		this.isbm = isbm;
		this.titolo = titolo;
		this.annoDiPubblicazione = annoDiPubblicazione;
		this.numeroPagine = numeroPagine;
		this.periodicita = periodicita;
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

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	
	
	
}
