package jdbc_DOIS;

/**
 * 
 * @author jose.m.a.oliveira
 *Classe utilizada para representar um carro.
 *
 */

public class Carro {
	
	private String placa;
	private String modelo;
	private Double potencia;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getPotencia() {
		return potencia;
	}
	public void setPotencia(Double potencia) {
		this.potencia = potencia;
	}
}
