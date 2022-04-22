package jdbc_DOIS;

import java.util.Scanner;

/**
 * 
 * @author jose.m.a.oliveira
 * Classe utilizada para testar o CRUD de carro.
 *
 */

public class Principal {
	
	public static void main(String[] args) {
		
		CarroDAO carroDAO = new CarroDAO();
		char opcao = ' ';
		do {
			Carro carro = null;
			opcao = menu();
			switch (opcao) {
			case 'I':
				carro = coletarDados();
				carroDAO.incluir(carro);
				break;
				
			case 'E':
				String placaExcluir = consultarPlaca();
				carro = carroDAO.consultarPorPlaca(placaExcluir);
						carroDAO.excluir(carro);
				break;
				
			case 'A':
				carro = coletarDados();
						carroDAO.alterarPorPlaca(carro);
				break;
				
			case 'C':
				String placaConsultar = consultarPlaca();
				carro = carroDAO.consultarPorPlaca(placaConsultar);
				break;
			}
			mostrarDadosCarro(carro);
		}while (opcao != 'S'); 
			
	}
	
	public static char menu() {
		Scanner s = new Scanner(System.in);
		char opcao = ' ';
		
		System.out.println("Escolha a sua opção: ");
		System.out.println("\t(I)ncluir");
		System.out.println("\t(E)xcluir");
		System.out.println("\t(A)lterar");
		System.out.println("\t(C)nsultar");
		System.out.println("\t(S)air");
		System.out.println("\nOpcao: ");
		opcao = s.nextLine().toUpperCase().charAt(0);
		return opcao;
	}
	
	public static String consultarPlaca() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite a placa do carro: ");
		return s.nextLine();
	}
	
	public static Carro coletarDados() {
		Scanner s = new Scanner(System.in);
		Carro carro = new Carro();
		
		System.out.println("Digite a placa do carro: ");
		carro.setPlaca(s.nextLine());
		System.out.println("Digite o modelo do carro: ");
		carro.setModelo(s.nextLine());
		System.out.println("Digite a potência do carro: ");
		carro.setPotencia(s.nextDouble());
		return carro;
	}
	
	public static void mostrarDadosCarro(Carro carro) {
		if (carro != null) {
			System.out.println("\n############ DADOS DO CARRO #############");			
			System.out.println("PLACA: " + carro.getPlaca());			
			System.out.println("MODELO: " + carro.getModelo());			
			System.out.println("POTENCIA DO MOTOR: " + carro.getPotencia() +"\n");			
		}
	}

}
