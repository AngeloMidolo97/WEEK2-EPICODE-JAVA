package it.epicode.w2d3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Es1 t1 = new Es1("*");
		Es1 t2 = new Es1("#");
		
		t1.start();
		t2.start();
		
		t1.setName("Primo Thread(*)");
		t2.setName("Secondo Thread(#)");

	}
}

class Es1 extends Thread{
	private String sym;
	
	public Es1(String sym) {
		this.sym = sym;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Indice: " + i + ", Simbolo: " + sym + ", Nome Thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
