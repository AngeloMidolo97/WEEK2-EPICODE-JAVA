package it.epicode.w2.proj;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catalogo {

	final static Logger logger = LoggerFactory.getLogger(Catalogo.class);
	static List<ArticoloDiLettura> listaArticoli = new ArrayList<ArticoloDiLettura>();
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// AGGIUNGO I LIBRI INIZIALI
		listaArticoli.add(new Libro(createID(), "Libro 1", LocalDate.ofYearDay(1997, 1), 150, "Angelo", "Avventura"));
		listaArticoli.add(new Libro(createID(), "Libro 2", LocalDate.ofYearDay(2005, 1), 200, "Mario", "Letteratura"));
		listaArticoli.add(new Libro(createID(), "Libro 3", LocalDate.ofYearDay(1970, 1), 200, "Andrea", "Fantasy"));
		listaArticoli
				.add(new Rivista(createID(), "Nature", LocalDate.ofYearDay(2020, 1), 200, Periodicita.settimanale));

		int scelta;

		do {
			System.out.printf("Premi un numero : %n" + "1 - per aggiungere un Libro %n"
					+ "2 - per aggiungere una Rivista %n" + "3 - per rimuovere un elemento dal catalogo %n"
					+ "4 - per trovare un articolo con ISBN %n" + "5 - per trovare un articolo tramite anno %n"
					+ "6 - per trovare un libro tramite autore %n" + "7 - per scrivere file sul disco %n"
					+ "8 - per leggere file dal disco %n%n" + "0 - per terminare il programma %n");
			scelta = Integer.parseInt(in.nextLine());

			switch (scelta) {
			case 1:
				aggiungiLibro();
				break;
			case 2:
				addRivista();
				break;
			case 3:
				removeElement();
				break;
			case 4:
				ricercaIsbn();
				break;
			case 5:
				ricercaAnno();
				break;
			case 6:
				ricercaAutore();
				break;
			case 7:
				scriviFile();
				break;
			case 8:
				leggiFile();
				break;

			}
		} while (scelta != 0);

		logger.info("operazioni terminate!");

	}

	// GENERATORE ISBN
	private static long idCounter = 0;

	public static synchronized String createID() {
		return String.valueOf(idCounter++);
	}

	// FUNZIONE CHE AGGIUNGE UN LIBRO
	public static void aggiungiLibro() {

		String isbn = createID();

		System.out.println("Inserisci titolo: ");
		String titolo = in.nextLine();

		System.out.println("Inserisci anno: ");
		LocalDate anno = (LocalDate.ofYearDay(Integer.parseInt(in.nextLine()), 1));

		System.out.println("Inserisci numero di pagine: ");
		int numeroPagine = Integer.parseInt(in.nextLine());

		System.out.println("Inserisci autore");
		String autore = in.nextLine();

		System.out.println("Inserisci genere");
		String genere = in.nextLine();

		listaArticoli.add(new Libro(isbn, titolo, anno, numeroPagine, autore, genere));

		logger.info("*************libro aggiunto!*************");
		logger.info("*************lista aggiornata*************");
		logger.info(listaArticoli.toString());

	}

	// FUNZIONE CHE AGGIUNGE UNA RIVISTA
	public static void addRivista() {

		String isbnR = createID();

		System.out.println("Inserisci titolo: ");
		String titoloR = in.nextLine();

		System.out.println("Inserisci anno: ");
		LocalDate annoR = (LocalDate.ofYearDay(Integer.parseInt(in.nextLine()), 1));

		System.out.println("Inserisci n.pagine: ");
		int numeroPagineR = Integer.parseInt(in.nextLine());

		System.out.println(
				"Inserisci periodicita della rivista:" + " 1 - Settimanale" + " 2 - Mensile" + " 3 - Semestrale");
		int scelta = Integer.parseInt(in.nextLine());
		Periodicita periodicitaR = Periodicita.settimanale;

		switch (scelta) {
		case 1:
			periodicitaR = Periodicita.settimanale;
			break;
		case 2:
			periodicitaR = Periodicita.mensile;
			break;
		case 3:
			periodicitaR = Periodicita.semestrale;
			break;
		}

		listaArticoli.add(new Rivista(isbnR, titoloR, annoR, numeroPagineR, periodicitaR));

		logger.info("************Rivista Aggiunta!************");
		logger.info("************Lista Aggiornata************");
		logger.info(listaArticoli.toString());
	}

	// RIMUOVE ELEMENTO TRAMITE COSICE ISBN
	public static void removeElement() {

		System.out.println("Inserisci ISBN: ");
		String isbn = in.nextLine();

		listaArticoli.removeIf(l -> l.getIsbn().equals(isbn));

		logger.info("Hai rimosso il libro con ISBN " + isbn);
		logger.info("Lista aggiornata: " + listaArticoli.toString());

	}

	// RICERCA UN ELEMENTO TRAMITE ISBN
	public static void ricercaIsbn() {

		System.out.println("Inserisci ISBN: ");
		String isbn = in.nextLine();

		Stream<ArticoloDiLettura> streamLibro = listaArticoli.stream().filter(l -> l.getIsbn().equals(isbn));
		streamLibro.forEach(l -> logger.info("Libro trovato tramite ISBN " + isbn + ": " + l.toString()));
	}

	// RICERCA UN ELEMENTO TRAMITE ANNO
	public static void ricercaAnno() {

		System.out.println("Inserisci anno: ");
		String anno = (in.nextLine());

		Stream<ArticoloDiLettura> streamAnno = listaArticoli.stream()
				.filter(l -> l.getAnnoPubblicazione().toString().contains(anno));
		streamAnno.forEach(l -> logger.info("Libri trovati dell'anno " + anno + ": " + l.toString()));
	}

	// RICERCA UN ELEMENTO TRAMITE AUTORE
	public static void ricercaAutore() {

		System.out.println("Inserisci autore: ");
		String autore = in.nextLine();

		Stream<Libro> streamAutore = listaArticoli.stream().filter(l -> l instanceof Libro).map(l -> (Libro) l)
				.filter(l -> l.getAutore().equals(autore));
		streamAutore.forEach(l -> logger.info("Libri trovati dell'autore " + autore + ": " + l.toString()));
	}

	// FUNZIONE PER SCRIVERE SU DISCO
	public static void scriviFile() {

		File file = new File("catalogo.txt");

		listaArticoli.forEach(l -> {
			try {
				FileUtils.writeStringToFile(file, l.toString(), "utf-8", true);
				logger.info("Hai salvato correttamente l'archivio sul disco");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	// FUNZIONE PER LEGGERE DAL FILE SU DISCO
	public static void leggiFile() throws IOException {
		File file = new File("catalogo.txt");
		String content = FileUtils.readFileToString(file, "utf-8");
		String[] segments = content.split("@");

		for (int i = 0; i < segments.length; i++) {
			logger.info("LETTURA " + segments[i]);
		}
	}

}
