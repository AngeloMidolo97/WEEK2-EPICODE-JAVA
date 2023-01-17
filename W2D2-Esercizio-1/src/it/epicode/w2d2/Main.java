package it.epicode.w2d2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inserisciNumero();
	}
	
	public static void inserisciNumero() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Inserisci un numero di parole da aggiungere: ");
		int n = Integer.parseInt(in.nextLine());
		
		Set<String> setParole = new HashSet<>();
		int c = 0;		
		for (int i = 0; i < n; i++) {
			System.out.println("Aggiungere parola " + (i + 1)+" di "+ n + " totali");
			String s = in.nextLine();
			
			if(setParole.contains(s)) {
				c++;
			}
			
			setParole.add(s);
			
		}
		System.out.println("Sono contenute " + setParole.size() + " parole distinte");
		System.out.println(setParole);
		System.out.println("Sono contenute " + c + " parole duplicate");
	}
}
