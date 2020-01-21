package com.br.primafaces.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author chris
 *
 */
public class DatabaseFactory {
	private final static String CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://localhost:1433;user=sa;password=chriskywalker19;databaseName=DB_IMOB";

	/**
	 * Realiza a conexao com o banco de dados
	 */
	public static Connection conectar() {
		Connection conexao = null;
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conexao = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexao;
	}

	/**
	 * Desconecta do banco de dados
	 * 
	 * @param conexao
	 */
	public static void desconectar(Connection conexao) {
		try {
			if (!conexao.isClosed()) {
				conexao.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void desconectar(Connection conexao, PreparedStatement pstComando) {
		try {
			if (!conexao.isClosed()) {
				conexao.close();
			}
			if (!pstComando.isClosed()) {
				pstComando.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void desconectar(Connection conexao, PreparedStatement pstComando, ResultSet rstObjeto) {
		try {
			if (!conexao.isClosed()) {
				conexao.close();
			}
			if (!pstComando.isClosed()) {
				pstComando.close();
			}
			if(!rstObjeto.isClosed()) 
			{
				rstObjeto.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
