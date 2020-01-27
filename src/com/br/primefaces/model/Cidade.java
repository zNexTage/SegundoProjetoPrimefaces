/**
 * 
 */
package com.br.primefaces.model;

/**
 * @author Christian
 *
 */
public class Cidade extends Estado {
	private int iIdCidade;
	private String sNomeCidade;
	
	
	public int getiIdCidade() {
		return iIdCidade;
	}
	public void setiIdCidade(int iIdCidade) {
		this.iIdCidade = iIdCidade;
	}
	public String getsNomeCidade() {
		return sNomeCidade;
	}
	public void setsNomeCidade(String sNomeCidade) {
		this.sNomeCidade = sNomeCidade;
	}
}
