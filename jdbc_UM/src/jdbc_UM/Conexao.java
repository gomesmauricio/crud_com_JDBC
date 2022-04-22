package jdbc_UM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	public Connection conectar() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			System.out.println("Conectou no banco de dados. ");
		}catch (SQLException ex) {
			System.out.println("Erro: Não conseguiu conectar no BD. ");
		}catch (ClassNotFoundException ex) {
			System.out.println("Erro: Não encontrou o driver do BD.");			
		}
		
		return conn;
	}
	
	public void desconectar(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.isClosed();
				System.out.println("Desconectou do banco de dados. ");
			}
		}catch (SQLException ex) {
			System.out.println("Não conseguiu deconectar do BD. ");
		}
	}

}
