package View;

import Utils.Console;

public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;
		do {
			System.out.println("###########################################################");
			System.out.println("###########################################################");
			System.out.println("#################       CURSOS ONLINE        ##############");
			System.out.println("###########################################################");
			System.out.println("###########################################################\n");
			System.out.println("1 - Menu Usuario");
			System.out.println("2 - Menu Curso");
			System.out.println("3 - Menu Professor");
			System.out.println("4 - Menu Matricula\n");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Escolha um opção");

			switch (opcao) {
			case 1:
				MenuUsuario.renderizar();
				break;
			case 2:
				MenuCurso.renderizar();
				break;
			case 3:
				MenuProfessor.renderizar();
				break;
			case 4:
				MenuMatricula.renderizar();
				break;
			case 0:
				System.out.println("\nSaindo...");
				break;
			default:
				System.out.println("Opção Inválida!!! \n ");
				break;
			}
		} while (opcao != 0);

	}

}
	