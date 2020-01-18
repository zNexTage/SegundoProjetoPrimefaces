/**
 * 
 */
package com.br.primefaces.model;

/**
 * @author Christian
 *
 */
public class Email extends Telefone{
	//Atributos
	private int idEmail;
	private int fkPessoa;
	private String tipoEmail;
	private String email;
	
	//Getters e Setters
	/**
	 * @return the idEmail
	 */
	public int getIdEmail() {
		return idEmail;
	}
	/**
	 * @param idEmail the idEmail to set
	 */
	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}
	/**
	 * @return the idCodigoEmail
	 */
	public int getFkPessoa() {
		return fkPessoa;
	}
	/**
	 * @param idCodigoEmail the idCodigoEmail to set
	 */
	public void setFkPessoa(int fkPessoa) {
		this.fkPessoa = fkPessoa;
	}
	/**
	 * @return the tipoEmail
	 */
	public String getTipoEmail() {
		return tipoEmail;
	}
	/**
	 * @param tipoEmail the tipoEmail to set
	 */
	public void setTipoEmail(String tipoEmail) {
		this.tipoEmail = tipoEmail;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
