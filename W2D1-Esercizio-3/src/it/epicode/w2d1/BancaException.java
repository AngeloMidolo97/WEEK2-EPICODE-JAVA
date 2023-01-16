package it.epicode.w2d1;

public class BancaException extends Exception {
	String message;

	public BancaException(String message) {
		super(message);
	}
}
