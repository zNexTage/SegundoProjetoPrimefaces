/**
 * 
 */
package com.br.primefaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.br.primefaces.dao.CidadeDAO;
import com.br.primefaces.dao.EstadosDAO;
import com.br.primefaces.model.Cidade;
import com.br.primefaces.model.Estado;

@ManagedBean
@SessionScoped
/**
 * @author Christian
 *
 */
public class CidadeBean {

	Cidade cidade = new Cidade();
	Estado estado = new Estado();

	List<Cidade> listCidade = new ArrayList<Cidade>();
	List<Estado> listEstado = new ArrayList<Estado>();

	private boolean isDisabledUptade;
	private boolean isDisabledEnviar;
	private boolean isDisabledCancelar;	

	@PostConstruct
	public void init() {
		isDisabledUptade = true;
		isDisabledEnviar = false;
		isDisabledCancelar = true;	
		
		preencherTabela();
		preencherComboEstado();
	}

	public void preencherTabela() {
		listCidade = new CidadeDAO().selecionarCidades();
	}

	public List<Estado> preencherComboEstado() {
		listEstado = new EstadosDAO().selecionarEstados();

		return listEstado;
	}

	/**
	 * Adiciona uma nova cidade no banco de dados
	 */
	public void addCidade() 
	{
		new CidadeDAO().addCidade(this.cidade);
		
		this.cidade = new Cidade();
		
		preencherTabela();
	}

	/**
	 * Atualiza a cidade no banco de dados
	 * 
	 * @param cidade
	 */
	public void atualizaCidade() {
		new CidadeDAO().atualizarCidade(this.cidade);
		
		this.cidade = new Cidade();
		
		preencherTabela();
	}
	
	public void deletarCidade(int iIdCidade) 
	{
		new CidadeDAO().apagarCidade(iIdCidade);
		
		preencherTabela();
	}
	
	/**
	 * Pega o valor da linha do datatable que o usuario escolheu
	 */
	public void getValueDataTable(Cidade cidade) 
	{
		this.cidade = cidade;
		
		isDisabledEnviar = true;
		isDisabledUptade=false;		
		isDisabledCancelar = false;
	}	
	
	public void cancelarAtualizacao() 
	{
		this.cidade = new Cidade();
		
		isDisabledEnviar = false;
		isDisabledUptade=true;		
		isDisabledCancelar = true;
	}

	/**
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the listCidade
	 */
	public List<Cidade> getListCidade() {
		return listCidade;
	}

	/**
	 * @param listCidade the listCidade to set
	 */
	public void setListCidade(List<Cidade> listCidade) {
		this.listCidade = listCidade;
	}

	/**
	 * @return the listEstado
	 */
	public List<Estado> getListEstado() {
		return listEstado;
	}

	/**
	 * @param listEstado the listEstado to set
	 */
	public void setListEstado(List<Estado> listEstado) {
		this.listEstado = listEstado;
	}

	/**
	 * @return the isDisabledUptade
	 */
	public boolean isDisabledUptade() {
		return isDisabledUptade;
	}

	/**
	 * @param isDisabledUptade the isDisabledUptade to set
	 */
	public void setDisabledUptade(boolean isDisabledUptade) {
		this.isDisabledUptade = isDisabledUptade;
	}

	/**
	 * @return the isDisabledEnviar
	 */
	public boolean isDisabledEnviar() {
		return isDisabledEnviar;
	}

	/**
	 * @param isDisabledEnviar the isDisabledEnviar to set
	 */
	public void setDisabledEnviar(boolean isDisabledEnviar) {
		this.isDisabledEnviar = isDisabledEnviar;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	/**
	 * @return the visibilityBtnCancelar
	 */
	public boolean isDisabledCancelar() {
		return isDisabledCancelar;
	}

	/**
	 * @param visibilityBtnCancelar the visibilityBtnCancelar to set
	 */
	public void setDisabledCancelar(boolean isDisabledCancelar) {
		this.isDisabledCancelar = isDisabledCancelar;
	}

}
