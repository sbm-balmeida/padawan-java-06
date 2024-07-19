package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement(
				"DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
				
		/*
		 * o metodo getUpadateCount() irá retornar um inteiro. Esse inteiro 
		 * significa, quantas linhas que foram modificadas após o Statement ser 
		 * executado.
		 */
		Integer linhaModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: " + 
							linhaModificadas);
	}

}
