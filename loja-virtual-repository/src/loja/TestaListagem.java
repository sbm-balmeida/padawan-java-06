package loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", 
				"root", "root");
		
		Statement stm = con.createStatement();
//		.execute, ele vai nos retornar um booleano true quando o retorno do meu Statement for uma lista.
//		boolean resultado =  stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
//		System.out.println(resultado);
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		//interface ResultSet -> irá retornar o conteudo da tabela PRODUTO
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
		con.close();
	}

}
