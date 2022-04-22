package jdbc_UM;

import java.sql.Connection;

public class Principal {
	
	public static void main(String[] args) {
		
		Conexao conexao = new Conexao();
		Connection conn = conexao.conectar();
		conexao.desconectar(conn);
	}

}
