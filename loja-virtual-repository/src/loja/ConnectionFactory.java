package loja;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
//	a Datasource que vai fazer com que o nosso Pool funcione
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?"
				+ "useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection recuperarConexao() throws SQLException {
//		return DriverManager.getConnection(
//				"jdbc:mysql://localhost/loja_virtual?useTimezone=true&"
//				+ "serverTimezone=UTC",	"root", "root");
		return this.dataSource.getConnection();
	}
}
