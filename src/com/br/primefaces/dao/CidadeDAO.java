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

import com.br.primefaces.model.Cidade;
import com.br.primafaces.database.*;

/**
 * @author Christian
 *
 */
public class CidadeDAO {
	private Connection conexao;
	
	public CidadeDAO() 
	{
		conexao = DatabaseFactory.conectar();
	}
	/**
	 * Adiciona uma nova cidade no banco de dados
	 * @param cidade
	 */
	public void addCidade(Cidade cidade) 
	{
		PreparedStatement pstComando = null;
		StringBuilder sbComando;
		
		try 
		{
			sbComando = new StringBuilder();
			
			sbComando.append(" INSERT INTO TBL_CIDADES (FK_ESTADO, NOME_CIDADE) ");
			sbComando.append(" VALUES(?,?) ");
			
			pstComando = conexao.prepareStatement(sbComando.toString());
			
			pstComando.setInt(1, cidade.getiCodEstado());
			pstComando.setString(2, cidade.getsNomeCidade());
			
			pstComando.executeUpdate();
		}
		catch(SQLException sqlErr) 
		{
			sqlErr.printStackTrace();
		}
		finally 
		{
			DatabaseFactory.desconectar(conexao, pstComando);
		}
	}
	
	/**
	 * Seleciona todas as cidades salvas no banco de dados
	 * @return
	 */
	public List<Cidade> selecionarCidades()
	{
		PreparedStatement pstComando = null;
		StringBuilder sbComando;
		ResultSet rsCidades = null;
		List<Cidade> listCidade = null;
		Cidade cidade = null;
		
		sbComando = new StringBuilder();
				
		sbComando.append(" SELECT CIDADES.ID_CIDADE, CIDADES.NOME_CIDADE, CIDADES.FK_ESTADO, ESTADOS.ESTADO, ESTADOS.SIGLA  ");
		sbComando.append(" FROM TBL_CIDADES CIDADES ");
		sbComando.append(" INNER JOIN TBL_ESTADOS ESTADOS ON CIDADES.FK_ESTADO = ESTADOS.ID_ESTADO ");
		
		try {
			pstComando = conexao.prepareStatement(sbComando.toString());
			
			rsCidades = pstComando.executeQuery();
			
			listCidade = new ArrayList<Cidade>();
			
			while(rsCidades.next()) 
			{
				cidade = new Cidade();
				
				cidade.setiIdCidade(rsCidades.getInt("ID_CIDADE"));
				cidade.setsNomeCidade(rsCidades.getString("NOME_CIDADE"));
				cidade.setiCodEstado(rsCidades.getInt("FK_ESTADO"));
				cidade.setsNome(rsCidades.getString("ESTADO"));
				cidade.setsSigla(rsCidades.getString("SIGLA"));
				
				listCidade.add(cidade);
			}
			
			return listCidade;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			DatabaseFactory.desconectar(conexao, pstComando, rsCidades);
		}
		
		
		return listCidade;
	}
	
	/**
	 * Atualiza as informações de uma cidade pelo id no banco de dados
	 * @param cidade
	 */
	public void atualizarCidade(Cidade cidade) 
	{
		PreparedStatement pstComando = null;
		StringBuilder sbComando;
		
		sbComando = new StringBuilder();
		
		sbComando.append(" UPDATE TBL_CIDADES ");
		sbComando.append(" SET FK_ESTADO = ?, NOME_CIDADE = ? ");
		sbComando.append(" WHERE ID_CIDADE = ? ");
		
		try {
			pstComando = conexao.prepareStatement(sbComando.toString());
			
			pstComando.setInt(1, cidade.getiCodEstado());
			pstComando.setString(2, cidade.getsNomeCidade());
			pstComando.setInt(3, cidade.getiIdCidade());
			
			pstComando.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			DatabaseFactory.desconectar(conexao, pstComando);
		}
		
	}
	
	/**
	 * Apaga uma cidade pelo id no banco de dados
	 * @param iIdCidade
	 */
	public void apagarCidade(int iIdCidade)
	{
		PreparedStatement pstComando = null;
		StringBuilder sbComando = null;
		
		sbComando = new StringBuilder();
		
		sbComando.append(" DELETE FROM TBL_CIDADES ");
		sbComando.append(" WHERE ID_CIDADE = ? ");
		
		try {
			pstComando = conexao.prepareStatement(sbComando.toString());
			
			pstComando.setInt(1, iIdCidade);
			
			pstComando.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			DatabaseFactory.desconectar(conexao, pstComando);
		}
		
		
	}
}
