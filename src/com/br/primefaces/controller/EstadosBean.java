/**
 * 
 */
package com.br.primefaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import com.br.primefaces.dao.EstadosDAO;
import com.br.primefaces.model.Estado;

@ManagedBean
@SessionScoped
/**
 * @author Christian
 *
 */
public class EstadosBean {
	private Estado estado = new Estado();
	private List<Estado> listEstados = new ArrayList<Estado>();
	String sCabecalhoModal, sMensagemModal;

	@PostConstruct
	public void init() {
		//Preenche a tabela com o estados
		preencherTabela();
	}

	/**
	 * Adiciona um novo estado no banco de dados
	 */
	public void addEstado() {
		EstadosDAO estadosDao = null;

		//Instancia o objeto
		estadosDao = new EstadosDAO();
		
		//Chama o metodo da dao para adicionar um novo estado
		estadosDao.addEstado(estado);

		//Preenche a tabela novamente, para que o novo estado seja demonstrado
		preencherTabela();

		/*PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('modalMessage').show();");*/
	}

	/**
	 * Preenche a tabela com os estados
	 */
	public void preencherTabela() {
		EstadosDAO estadosDao = null;

		//Instancia a classe 
		estadosDao = new EstadosDAO();

		//Recebe a lista de estados
		this.listEstados = estadosDao.selecionarEstados();
	}

	
	/**
	 *GETTERS E SETTERS DAS VARIAVEIS E DOS OBJETOS	  
	 */
	
	public List<Estado> getListEstados() {
		return this.listEstados;
	}

	public void setListEstados(List<Estado> listEstados) {
		this.listEstados = listEstados;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getsCabecalhoModal() {
		return this.sCabecalhoModal;
	}

	public void setsCabecalhoModal(String sCabecalhoModal) {
		this.sCabecalhoModal = sCabecalhoModal;
	}

	public String getsMensagemModal() {
		return this.sMensagemModal;
	}

	public void setsMensagemModal(String sMensagemModal) {
		this.sMensagemModal = sMensagemModal;
	}
}
