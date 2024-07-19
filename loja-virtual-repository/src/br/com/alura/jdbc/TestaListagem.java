package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		/*
		 * .execute, ele vai nos retornar um booleano true quando o retorno do meu 
		 * Statement for uma lista.
		 */
//		boolean resultado =  stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
//		System.out.println(resultado);
		
		PreparedStatement stm = connection.prepareStatement(
				"SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		
//		interface ResultSet -> irá retornar o conteudo da tabela PRODUTO
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			
			String nome = rst.getString("NOME");
			System.out.println(nome);
			
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
			
		}
		
		System.out.println("Fechando conexão!");
		connection.close();
	}

}
