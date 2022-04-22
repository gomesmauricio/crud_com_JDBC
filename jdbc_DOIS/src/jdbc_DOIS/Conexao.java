package jdbc_DOIS;

/**
 * @author jose.m.a.oliveira
 * Classe utilizada para executar as ações sobre o banco de dados.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	
	private Connection conectar() {
		try {
			String usuario = "root";
			String senha = "root";
			String ipDoBanco = "localhost";
			String nomeDoBanco = "mydb";
			String stringDeConexao = "jdbc:mysql://" + ipDoBanco + "/" + nomeDoBanco;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(stringDeConexao, usuario, senha);
			System.out.println("Conectou no banco de dados.");
		}catch (SQLException ex) {
			System.out.println("Erro: Não conseguiu conectar no BD.");			
		}catch (ClassNotFoundException ex) {
			System.out.println("Erro: Não encontrou o driver do BD. ");
		}
		return conn;
	}
		
	public ResultSet executarConsulta(String consulta) {
		conn = conectar();
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(consulta);
		}catch (SQLException ex) {
			System.out.println("Não conseguiu executar a consulta\n" + consulta);
			//Caso ocorra algum erro desconecta do banco de dados.
			desconectar();		
		}
		return rs;
	}
	
	public boolean executarDML(String dml) {
		boolean ok = false;
		
		conn = conectar();
		try {
			stm = conn.createStatement();
			stm.execute(dml);
			ok = true;
		}catch (SQLException ex) {
			System.out.println("Não conseguiu executar o DML\n" + dml);
		}finally {
			desconectar();
		}
		return ok;
	}
	
	public void desconectar() {
		fecharResultSet(this.rs);
		fecharStatement(stm);
		fecharConnection(conn);
	}
	
	public void fecharConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Desconectou do banco de dados. ");
			}
		} catch (SQLException ex) {
			System.out.println("Não conseguiu desconectar O BD. ");
		}	
	} 
	
	public void fecharStatement(Statement stm) {
		try {
			if (stm != null && !stm.isClosed()) {
				stm.isClosed();
			}			
		} catch (SQLException e) {
			System.out.println("Erro ao fechar o procedimento de consulta.");
		}
	}
	
	public void fecharResultSet(ResultSet resultado) {
		try {
			if (resultado != null && !resultado.isClosed()) {
				resultado.isClosed();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao fechar o resultado da cunsulta. ");
		}
	}
	
}
