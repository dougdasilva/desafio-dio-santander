package Exceptions;

public class SaldoNegativoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SaldoNegativoException(String msg) {
		super(msg);
	}
	
	
}
