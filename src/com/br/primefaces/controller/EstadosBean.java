/**
 * 
 */
package com.br.primefaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

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
	private String sNomeEstado;	

	private boolean isDisabledUptade = true;
	private boolean isDisabledEnviar = false;

	/* Componentes */
	UIComponent txtEstado;
	UIComponent txtSigla;
	UIComponent lblIdEstado;
	UIComponent btnEnviar;
	/**/

	@PostConstruct
	public void init() {
		// Preenche a tabela com o estados
		preencherTabela();
	}

	/**
	 * Adiciona um novo estado no banco de dados
	 */
	public void addEstado() {
		EstadosDAO estadosDao = null;

		// Verifica se o usuario preencheu os campos de textos
		if (this.estado.getsNome().isEmpty() || this.estado.getsSigla().isEmpty()) {
			// Demonstra uma mensagem alertando ao usuário para preencher os campos
			mensagemAdd("Atenção!!", "Preencha os campos corretamente!!", FacesMessage.SEVERITY_WARN);

			// Para a execução do método
			return;
		}

		// Instancia o objeto
		estadosDao = new EstadosDAO();

		// Chama o metodo da dao para adicionar um novo estado
		estadosDao.addEstado(estado);

		this.estado = new Estado();

		// Preenche a tabela novamente, para que o novo estado seja demonstrado
		preencherTabela();

		// Demonstra uma mensagem de sucesso
		mensagemAdd("Sucesso!!", "Estado cadastrado com sucesso!!", FacesMessage.SEVERITY_INFO);

		/*
		 * PrimeFaces current = PrimeFaces.current();
		 * current.executeScript("PF('modalMessage').show();");
		 */
	}

	/**
	 * Preenche a tabela com os estados
	 */
	public void preencherTabela() {
		EstadosDAO estadosDao = null;

		// Instancia a classe
		estadosDao = new EstadosDAO();

		// Recebe a lista de estados
		this.listEstados = estadosDao.selecionarEstados();
	}

	/**
	 * Coloca os valores do estado selecionados nos campos de texto
	 */
	public void editarEstado(Estado e) {
		isDisabledUptade = false;
		isDisabledEnviar = true;
		sNomeEstado = e.getsNome();
		this.estado = e;
	}

	/**
	 * Realiza a atualiza do estado no banco de dados
	 */
	public void atualizarEstado() {
		EstadosDAO estadoDao = null;

		// Verifica se o usuario preencheu os campos de textos
		if (this.estado.getsNome().isEmpty() || this.estado.getsSigla().isEmpty()) {
			// Demonstra uma mensagem alertando ao usuário para preencher os campos
			mensagemAdd("Atenção!!", "Preencha os campos corretamente!!", FacesMessage.SEVERITY_WARN);

			// Para a execução do método
			return;
		}

		// Instancia a dao
		estadoDao = new EstadosDAO();

		// Atualiza o estado no banco de dados
		estadoDao.atualizarEstado(this.estado);

		isDisabledUptade = true;
		isDisabledEnviar = false;

		// Demonstra uma mensagem de sucesso
		mensagemAdd("Sucesso!!", "O estado "+sNomeEstado+" foi atualizado para "+estado.getsNome()+"!!", FacesMessage.SEVERITY_INFO);
	
		// Limpa a model para poder reutiliza-la novamente
		this.estado = new Estado();
	}

	/**
	 * Deleta um estado do banco de dados pelo Id
	 * 
	 * @param iIdEstado
	 */
	public void deletarEstado(Estado estado) {
		EstadosDAO estadoDao = null;

		// Instancia a dao
		estadoDao = new EstadosDAO();

		// Deleta o estado do banco de dados
		estadoDao.deletarEstado(estado.getiCodEstado());

		// Preenche a tabela do banco de dados
		preencherTabela();

		// Demonstra uma mensagem de sucesso
		mensagemAdd("Sucesso!!", "O estado "+estado.getsNome()+" foi deletado!!", FacesMessage.SEVERITY_INFO);
		
		estado = new Estado();
	}

	/**
	 * Demonstra um alerta
	 * 
	 * @param sSumario
	 * @param sMensagem
	 * @param fmsTipoMensagem
	 */
	public void mensagemAdd(String sSumario, String sMensagem, FacesMessage.Severity fmsTipoMensagem) {
		FacesContext context;
		FacesMessage facesMsg;

		// Recebe o contexto
		context = FacesContext.getCurrentInstance();

		// Define os atributos do alerta
		facesMsg = new FacesMessage(fmsTipoMensagem, sSumario, sMensagem);

		// Define a mensagem que será demonstrada
		context.addMessage(null, facesMsg);
	}


	/**
	 * GETTERS E SETTERS DAS VARIAVEIS E DOS OBJETOS
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

	public String getsNomeEstado() {
		return sNomeEstado;
	}

	public void setsNomeEstado(String sNomeEstado) {
		this.sNomeEstado = sNomeEstado;
	}

	public boolean isDisabledUptade() {
		return isDisabledUptade;
	}

	public void setDisabledUptade(boolean isDisabledUptade) {
		this.isDisabledUptade = isDisabledUptade;
	}

	public boolean isDisabledEnviar() {
		return isDisabledEnviar;
	}

	public void setDisabledEnviar(boolean isDisabledEnviar) {
		this.isDisabledEnviar = isDisabledEnviar;
	}

}
