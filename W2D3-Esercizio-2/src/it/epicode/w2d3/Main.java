package it.epicode.w2d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	static int[] arrayRandom;
	static List<Integer> lista = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		generaValori();
		arrayRandom = generaValori(3000);
		
		Valori t1 = new Valori(arrayRandom, 0, 1000, lista);
		Valori t2 = new Valori(arrayRandom, 1000, 1000, lista);
		Valori t3 = new Valori(arrayRandom, 2000, 1000, lista);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(t1.getValori());
		
//		System.out.println(t1.getValori());
		
	}
	
	private static int[] generaValori(int size) {
		int[] arrayRandom = new int[size];
		Random random = new Random();
		for (int i = 0; i < arrayRandom.length; i++) {
			arrayRandom[i] = random.nextInt(200);
		}
		return arrayRandom;
	}

}

class Valori extends Thread {
	
	int[] valori;
	int indice;
	int nElementi;
	List<Integer> listaRisultati = new ArrayList<Integer>();
	
	public Valori(int[] valori, int indice, int nElementi, List<Integer> listaRisultati) {
		this.valori = valori;
		this.indice = indice;
		this.nElementi = nElementi;
		this.listaRisultati = listaRisultati;
	}
	
	@Override
	public void run() {	
		int sommaParziale = 0;
		for (int i = this.indice; i < this.indice + this.nElementi; i++) {
			sommaParziale += valori[i];
		}
		this.listaRisultati.add(sommaParziale);
	}

	public int[] getValori() {
		return valori;
	}

	public int getIndice() {
		return indice;
	}

	public int getnElementi() {
		return nElementi;
	}

	public List<Integer> getListaRisultati() {
		return listaRisultati;
	}
	
	
	
}
