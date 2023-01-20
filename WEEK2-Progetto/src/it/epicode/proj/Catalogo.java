package it.epicode.proj;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catalogo {
	// LISTA LIBRI INSERITI NEL CATALOGO
	static List<Libro> listLibri = new ArrayList<Libro>();

	// LOGGER
	private static final Logger logger = LoggerFactory.getLogger(Catalogo.class);

	// MAIN
	public static void main(String[] args) throws IOException {
		
		// AGGIUNTA LIBRI
		addLibro(generateIsbn(), "ciao", LocalDate.ofYearDay(2012, 1), 50, "Angelo", "commedia");
		addLibro(generateIsbn(), "ciao", LocalDate.ofYearDay(2011, 1), 50, "Gerardo", "commedia");
		addLibro(generateIsbn(), "ciao", LocalDate.ofYearDay(2010, 1), 50, "Mario", "commedia");

		logger.info("Lista completa: " + listLibri.toString());

		// RIMOZIONE LIBRO
		removeLibro("ccc");

		// RICERCA
		cercaLibro("1234f");
		cercaLibroAnno("2012");
		cercaLibroAutore("Angelo");

		// SCRIVI SUL FILE CATALOGO.TXT
		scriviFile();
		readFile();
	}

	// GENERA CODICE UNIVOCO	
	public static String generateIsbn() {
		UUID isbn = UUID.randomUUID();
		return isbn.toString();
	}

	// FUNZIONE CHE AGGIUNGE UN LIBRO AL CATALOGO
	public static void addLibro(String isbn, String titolo, LocalDate anno, int pagine, String autore, String genere) {
		listLibri.add(new Libro(isbn, titolo, anno, pagine, autore, genere));
		logger.info("------------------Libro aggiunto correttamente------------------");
		logger.info("------------------Lista aggiornata: " + listLibri.toString() + "------------------");
	}

	// FUNZIONE CHE RIMUOVE UN LIBRO DAL CATALOGO TRAMITE CODICE ISBN
	public static void removeLibro(String isbn) {
		listLibri.removeIf(x -> x.getIsbm().equals(isbn));
		logger.info("Hai rimosso il libro con ISBN " + isbn);
		logger.info("Lista aggiornata: " + listLibri.toString());
	}

	// FUNZIONE PER RICERCA LIBRO TRAMITE CODICE ISBN
	public static void cercaLibro(String isbn) {
		Stream<Libro> streamLibro = listLibri.stream().filter(libro -> libro.getIsbm().equals(isbn));
		streamLibro
				.forEach(libro -> logger.info("------------------Libri trovati tramite codice ISBM-" + isbn + ": " + libro.toString() + "------------------"));
	}

	// FUNZIONE PER RICERCA LIBRO TRAMITE ANNO
	public static void cercaLibroAnno(String anno) {
		Stream<Libro> streamAnno = listLibri.stream()
				.filter(libro -> libro.getAnnoDiPubblicazione().toString().contains(anno));
		streamAnno.forEach(libro -> logger.info("------------------Libri trovati per anno " + anno + ": " + libro.toString() + "------------------"));
	}

	// FUNZIONE PER RICERCA LIBRO TRAMITE AUTORE
	public static void cercaLibroAutore(String autore) {
		Stream<Libro> streamAutore = listLibri.stream().filter(libro -> libro.getAutore().equals(autore));
		streamAutore.forEach(libro -> logger.info("------------------Libri trovati per autore " + autore + ": " + libro.toString() + "------------------"));
	}
	
	// FUNZIONE CHE SCRIVE I LIBRI IN UN FILE SU DISCO
	public static void scriviFile() {
		File file = new File("catalogo.txt");
		listLibri.forEach(libri -> {
			try {
				FileUtils.writeStringToFile(file, libri.toString(), "UTF-8", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("errore");
			}
		});

	}

	// FUNZIONE CHE LEGGE IL FILE SU DISCO
	public static void readFile() throws IOException {
		File file = new File("catalogo.txt");
		String content = FileUtils.readFileToString(file, "UTF-8");
		String[] segments = content.split("@");
		
		for(int i = 0; i < segments.length; i++) {
			logger.info("-------------------------------------------------");
			logger.info("LETTURA: " + segments[i]);
			logger.info("-------------------------------------------------");
		}
	}

}
