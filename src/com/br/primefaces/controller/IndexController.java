/**
 * 
 */
package com.br.primefaces.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.br.primefaces.model.ClientePessoaFisica;

@ManagedBean
@SessionScoped
/**
 * 
 * @author Christian
 *
 */
public class IndexController {
	private ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
	private List<ClientePessoaFisica> listClientePessoaFisica = new ArrayList<ClientePessoaFisica>();
	
	public void preencherLista() 
	{
		try {
		//Adicionou o objeto na lista
		listClientePessoaFisica.add(clientePessoaFisica);
		
		//Limpa o objeto
		clientePessoaFisica = new ClientePessoaFisica();
		}
		catch(Exception err) 
		{
			System.err.println(err.getMessage());
		}
	}

	public ClientePessoaFisica getClientePessoaFisica() {
		return clientePessoaFisica;
	}

	public void setClientePessoaFisica(ClientePessoaFisica clientePessoaFisica) {
		this.clientePessoaFisica = clientePessoaFisica;
	}

	public List<ClientePessoaFisica> getListClientePessoaFisica() {
		return listClientePessoaFisica;
	}

	public void setListClientePessoaFisica(List<ClientePessoaFisica> listClientePessoaFisica) {
		this.listClientePessoaFisica = listClientePessoaFisica;
	}


	
	
	
}
