package it.epicode.w2d2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	static HashMap<String, String> rubrica = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rubrica.put("Andrea", "3334567890");
		rubrica.put("Mario", "3334567891");
		rubrica.put("Carlo", "3334567892");
		
		aggiungiContatto(rubrica);
		System.out.println(rubrica);
		rubrica.get("angelo");
		cancellaContatto(rubrica);
		System.out.println(rubrica);
		cercaPerNome(rubrica);
		cercaPerNumero(rubrica);
	}
	
	
	static Scanner in = new Scanner(System.in);
	public static void aggiungiContatto(HashMap<String, String> rubrica) {
		
		
		
		System.out.println("Nome contatto: ");
		String nome = in.nextLine();
		
		System.out.println("Numero di telefono: ");
		String numero = in.nextLine();
		
		rubrica.put(nome, numero);
		
		

	}
	
	public static void cancellaContatto(HashMap<String, String> rubrica) {
		System.out.println("Inserire il nome del contatto da cancellare: ");
		String nome = in.nextLine();
		
		rubrica.remove(nome);
	}
	
	public static void cercaPerNome(HashMap<String, String> rubrica) {
		System.out.println("Inserisci il nome: ");
		String nome = in.nextLine();
		
		System.out.println("numero di " + nome + " " + rubrica.get(nome));
		
	}
	
	public static void cercaPerNumero(HashMap<String, String> rubrica) {
		System.out.println("Inserisci il numero: ");
		String numero = in.nextLine();
		String nome = null;
		for(String c : rubrica.keySet()) {
			if(numero.equals(rubrica.get(c))){
				nome = c;
			}
		}
		System.out.println("Questo numero è di " + nome);
	}

}













