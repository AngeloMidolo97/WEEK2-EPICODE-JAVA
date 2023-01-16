package it.epicode.w2d1;

import java.util.Scanner;

public class Main {

	int km, lt; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("Inserire il numero di km percorsi");
		int a = Integer.parseInt(in.nextLine());

		System.out.println("Inserire il numero di litri consumati");
		int b = Integer.parseInt(in.nextLine());
		
		try {
			System.out.println("Hai consumato " + calcolaConsumo(a, b) + " Lt per km");
		} catch (ArithmeticException c) {
			System.out.println("Errore il numero non è divisibile per 0!");
		}
	}

	public static int calcolaConsumo(int km, int lt) {
		int consumo = 0;

		consumo = km / lt;

		return consumo;
	}

}
