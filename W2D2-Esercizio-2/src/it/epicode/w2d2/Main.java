package it.epicode.w2d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = generaLista(10);
		ordinaLista(list);
		pariDispari(list, true);
	}

	public static ArrayList<Integer> generaLista(int n) {
		Random random = new Random();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(random.nextInt(100));
		}
		System.out.printf("Genera lista casuale:%n%n " + list + "%n");
		System.out.println("-------------------------------");
		return list;
	}

	public static void ordinaLista(ArrayList<Integer> list) {
		Collections.sort(list);
		System.out.printf("Lista ordinata (crescente):%n%n " + list + "%n");
		System.out.println("-------------------------------");
		Collections.reverse(list);
		System.out.printf("Lista ordinata (decrescente):%n%n " + list + "%n");
		System.out.println("-------------------------------");
	}

	public static void pariDispari(ArrayList<Integer> list, boolean b) {

		ArrayList<Integer> listPari = new ArrayList<>();
		ArrayList<Integer> listDispari = new ArrayList<>();

		if (b) {
			for (int i = 0; i < list.size(); i++) {
				if (i % 2 == 0) {
					listPari.add(list.get(i));
				}
			}
			System.out.println(listPari);
			
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (i % 2 != 0) {
					listDispari.add(list.get(i));
				}
			}
			System.out.println(listDispari);
		}
	}

}
