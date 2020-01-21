/**
 * 
 */
package com.br.primefaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.primafaces.database.DatabaseFactory;
import com.br.primefaces.model.Estado;

/**
 * @author Christian
 *
 */
public class EstadosDAO {
	Connection conexao = null;
	
	/**
	 * Construtor
	 */
	public EstadosDAO() 
	{
		try {
		//Realiza a conexao com o banco de dados
		conexao = DatabaseFactory.conectar();
		}
		catch (Exception err) 
		{
			err.printStackTrace();
		}
	}
	
	/**
	 * Adiciona um novo estado no banco de dados
	 * @param estado
	 */
	public void addEstado(Estado estado)
	{
		StringBuilder sbComando = null;
		PreparedStatement pstComando = null;
		
		try 
		{
			//Instancia o objeto
			sbComando = new StringBuilder();
			
			//Monta o comando
			sbComando.append(" INSERT INTO TBL_ESTADOS (ESTADO, SIGLA) ");
			sbComando.append(" VALUES (?, ?) ");
				
			//Atribui o comando a ser executado no preparedstatement
			pstComando = this.conexao.prepareStatement(sbComando.toString());
			
			//Define os valores dos parametros da consulta
			pstComando.setString(1, estado.getsNome());
			pstComando.setString(2, estado.getsSigla());
			
			//Executa o comando
			pstComando.executeUpdate();
			
		}
		catch(SQLException sqlErr) 
		{
			sqlErr.printStackTrace();
		}
		finally 
		{
			//Desconecta do banco e finaliza o preparedstatement
			DatabaseFactory.desconectar(this.conexao, pstComando);
		}
	}
	
	/**
	 * Seleciona todos os estados do banco de dados
	 * @return
	 */
	public List<Estado> selecionarEstados()
	{
		List<Estado> listEstados = null;
		PreparedStatement pstComando = null;
		String sComando;
		ResultSet rstEstados = null;
		Estado estado = null;
		
		try 
		{
			//Monta o comando
			sComando = " SELECT * FROM TBL_ESTADOS ";
			
			//Atribui o comando a ser executado no preparedstatement
			pstComando = this.conexao.prepareStatement(sComando);
			
			//Executa o comando e atribui os valores retornados no resultset
			rstEstados = pstComando.executeQuery();
			
			//Instancia a lista de estados
			listEstados = new ArrayList<Estado>();
			
			//Realiza um laço pelos valores retornados 
			while(rstEstados.next()) 
			{
				//Instancia o objeto
				estado = new Estado();
				
				//Adiciona os valores retornados nos atributos da model estado
				estado.setiCodEstado(rstEstados.getInt("ID_ESTADO"));
				estado.setsNome(rstEstados.getString("ESTADO"));
				estado.setsSigla(rstEstados.getString("SIGLA"));
				
				//Adiciona na lista os valores retornados
				listEstados.add(estado);
			}
			
			//Retorna a lista de estados
			return listEstados;
		}
		catch(SQLException sqlErr)
		{
			sqlErr.printStackTrace();
		}
		finally
		{
			//Finaliza a conexao, preparedstatement e o resultset
			DatabaseFactory.desconectar(this.conexao, pstComando, rstEstados);
		}
		
		return listEstados;
	}

	/**
	 * Atualiza o estado no banco de dados
	 * @param estado
	 */
	public void atualizarEstado(Estado estado) 
	{
		StringBuilder sbComando;
		PreparedStatement pstComando = null;
		
		
		try 
		{
			//Instancia o string builder
			sbComando = new StringBuilder();
			
			//Monta o comando
			sbComando.append(" UPDATE TBL_ESTADOS ");
			sbComando.append(" SET ESTADO = ?, SIGLA = ? ");
			sbComando.append(" WHERE ID_ESTADO = ? ");
			
			//Define o comando a ser executado
			pstComando = conexao.prepareStatement(sbComando.toString());
			
			//Define os valores dos parametros
			pstComando.setString(1, estado.getsNome());
			pstComando.setString(2, estado.getsSigla());
			pstComando.setInt(3, estado.getiCodEstado());
			
			//Executa o comando
			pstComando.executeUpdate();
		}
		catch(Exception err) 
		{
			err.printStackTrace();
		}
		finally 
		{
			DatabaseFactory.desconectar(conexao, pstComando);
		}
	}
	
	/**
	 * Deleta o estado pelo id
	 * @param iIdEstado
	 */
	public void deletarEstado(int iIdEstado)
	{
		StringBuilder sbComando;
		PreparedStatement pstComando = null;
		
		try 
		{
			//Instancia o stringbuilder
			sbComando = new StringBuilder();
			
			//Monta o comando
			sbComando.append(" DELETE FROM TBL_ESTADOS ");
			sbComando.append(" WHERE ID_ESTADO = ? ");
			
			//Define o comando a ser executado
			pstComando = conexao.prepareStatement(sbComando.toString());
			
			//Define os parametros
			pstComando.setInt(1, iIdEstado);
			
			//Executa o comando
			pstComando.executeUpdate();
		}
		catch(Exception err) 
		{
			err.printStackTrace();
		}
		finally 
		{
			DatabaseFactory.desconectar(conexao, pstComando);
		}
	}
}

