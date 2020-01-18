/**
 * 
 */
package com.br.primefaces.model;

/**
 * @author Christian
 *
 */
public class ClientePessoaFisica extends PessoaFisica{
	//Atributos
	private int idClientePf;
	private int idCodigoClientePf;
	private String statusComprador;
	private String statusLocador;
	private String statusLocatorio;
	private String statusVendedor;
	/**
	 * @return the idClientePf
	 */
	public int getIdClientePf() {
		return idClientePf;
	}
	/**
	 * @param idClientePf the idClientePf to set
	 */
	public void setIdClientePf(int idClientePf) {
		this.idClientePf = idClientePf;
	}
	/**
	 * @return the idCodigoClientePf
	 */
	public int getIdCodigoClientePf() {
		return idCodigoClientePf;
	}
	/**
	 * @param idCodigoClientePf the idCodigoClientePf to set
	 */
	public void setIdCodigoClientePf(int idCodigoClientePf) {
		this.idCodigoClientePf = idCodigoClientePf;
	}
	/**
	 * @return the statusComprador
	 */
	public String getStatusComprador() {
		return statusComprador;
	}
	/**
	 * @param statusComprador the statusComprador to set
	 */
	public void setStatusComprador(String statusComprador) {
		this.statusComprador = statusComprador;
	}
	/**
	 * @return the statusLocador
	 */
	public String getStatusLocador() {
		return statusLocador;
	}
	/**
	 * @param statusLocador the statusLocador to set
	 */
	public void setStatusLocador(String statusLocador) {
		this.statusLocador = statusLocador;
	}
	/**
	 * @return the statusLocatorio
	 */
	public String getStatusLocatorio() {
		return statusLocatorio;
	}
	/**
	 * @param statusLocatorio the statusLocatorio to set
	 */
	public void setStatusLocatorio(String statusLocatorio) {
		this.statusLocatorio = statusLocatorio;
	}
	/**
	 * @return the statusVendedor
	 */
	public String getStatusVendedor() {
		return statusVendedor;
	}
	/**
	 * @param statusVendedor the statusVendedor to set
	 */
	public void setStatusVendedor(String statusVendedor) {
		this.statusVendedor = statusVendedor;
	}
}
