/**
 * 
 */
package com.br.primefaces.model;

import java.sql.Date;

/**
 * @author Christian
 *
 */
public class PesquisaCadastral extends Email{
	private int idPesquisa;
	private int idCodigoPesquisaCadastral;
	private int codigoCliente;
	private Date dataPesquisa;
	private String situacaoCadastral;	
	private Date dataProximaPesquisa;

	//Getters e Setters
	/**
	 * @return the idPesquisa
	 */
	public int getIdPesquisa() {
		return idPesquisa;
	}

	/**
	 * @param idPesquisa the idPesquisa to set
	 */
	public void setIdPesquisa(int idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	/**
	 * @return the idCodigoPesquisaCadastral
	 */
	public int getIdCodigoPesquisaCadastral() {
		return idCodigoPesquisaCadastral;
	}

	/**
	 * @param idCodigoPesquisaCadastral the idCodigoPesquisaCadastral to set
	 */
	public void setIdCodigoPesquisaCadastral(int idCodigoPesquisaCadastral) {
		this.idCodigoPesquisaCadastral = idCodigoPesquisaCadastral;
	}

	/**
	 * @return the codigoCliente
	 */
	public int getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * @return the dataPesquisa
	 */
	public Date getDataPesquisa() {
		return dataPesquisa;
	}

	/**
	 * @param dataPesquisa the dataPesquisa to set
	 */
	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	/**
	 * @return the situacaoCadastral
	 */
	public String getSituacaoCadastral() {
		return situacaoCadastral;
	}

	/**
	 * @param situacaoCadastral the situacaoCadastral to set
	 */
	public void setSituacaoCadastral(String situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}

	/**
	 * @return the dataProximaPesquisa
	 */
	public Date getDataProximaPesquisa() {
		return dataProximaPesquisa;
	}

	/**
	 * @param dataProximaPesquisa the dataProximaPesquisa to set
	 */
	public void setDataProximaPesquisa(Date dataProximaPesquisa) {
		this.dataProximaPesquisa = dataProximaPesquisa;
	}
}
