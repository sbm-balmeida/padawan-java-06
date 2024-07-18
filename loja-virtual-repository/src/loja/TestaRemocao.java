package loja;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		/*o metodo getUpadateCount() irá retornar um inteiro. Esse inteiro 
		 * significa, quantas linhas que foram modificadas após o Statement ser 
		 * executado.
		 */
		Integer linhaModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foram modificadas: " + 
							linhaModificadas);
	}

}
