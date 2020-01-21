/**
 * 
 */
package com.br.primefaces.tratamentoerros;

/**
 * @author Christian
 *
 */
public class Excessoes extends Exception {
	public Excessoes(String sMessage) 
	{
		super(sMessage);
	}
	
	public Excessoes(String sMessage, Throwable thrCause) 
	{
		super(sMessage, thrCause);
	}
}
