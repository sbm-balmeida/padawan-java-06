package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	/*
	 * a interface Datasource que vai fazer com que o nosso Pool funcione, vai expor
	 * as infomações do nosso Pool de conexões.
	 */
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?"
				+ "useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		/*o setMaxPoolSize() irá setar o número máximo de conexões disponíveis que 
		 * eu quero permitir que sejam abertas.
		 */
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
//		return DriverManager.getConnection(
//				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&"
//				+ "serverTimezone=UTC",	"root", "root");
		return this.dataSource.getConnection();
	}
}
