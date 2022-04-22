package jdbc_DOIS;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author jose.m.a.oliveira
 * Classe utilizada para executar as operações de dados, que envolvem o 
 * Carro.
 *
 */
public class CarroDAO {
	
	public void incluir(Carro carro) {
		String incluir = "INSERT INTO CARRO VALUES ('" +carro.getPlaca() + "', '" + carro.getModelo() + "', " + carro.getPotencia() + ")";
		Conexao conexao = new Conexao();
		conexao.executarDML(incluir);
		System.out.println("Carro Registrado com sucesso!");
		
	}
	
	public Carro consultarPorPlaca(String placa) {
		Conexao conexao = new Conexao();
		Carro carro = null;
		try {
			String consulta = "SELECT * FROM CARRO WHERE PLACA =  '"+placa +"'";
			ResultSet rs = conexao.executarConsulta(consulta);
			if (rs.next()) {
				carro = new Carro();
				carro.setModelo(rs.getString("MODELO"));
				carro.setPlaca(rs.getString("PLACA"));
				carro.setPotencia(rs.getDouble("POTENCIA"));
			}
		}catch(SQLException ex) {
			System.out.println("Não conseguiu consultar os dados do Carro");
		}finally {
			conexao.desconectar();
		}
		return carro;
	}
	
	public void alterarPorPlaca(Carro carro) {
		String update = "UPDATE CARRO SET MODELO = '"+carro.getModelo() + "', POTENCIA =" + carro.getPotencia() + "WHERE PLACA ='"+carro.getPlaca()+"'";
		Conexao conexao = new Conexao();
		conexao.executarDML(update);
	}
	
	public void excluir(Carro carro) {
		String delete = "DELETE FROM CARRO WHERE PLACA ='" + carro.getPlaca() + "'";
		Conexao conexao = new Conexao();
		conexao.executarDML(delete);
		System.out.println("Excluido com sucesso!");
	}	

}
