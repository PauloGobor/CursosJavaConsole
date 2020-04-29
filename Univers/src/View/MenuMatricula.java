package View;

import Utils.Console;

public class MenuMatricula {
	public static void renderizar() {

		int opcao;
		do {
			System.out.println("###########################################################");
			System.out.println("###########################################################");
			System.out.println("#################      MENU MATR�CULA     #################");
			System.out.println("###########################################################");
			System.out.println("###########################################################\n");
			System.out.println("1 - Realizar Matr�cula");
			System.out.println("2 - Listar Matriculas");
			System.out.println("3 - Listar Matriculas por Curso");
			System.out.println("4 - Listar Matriculas por Aluno\n");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Escolha um op��o");

			switch (opcao) {
			case 1:
				RealizarMatricula.renderizar();
				break;
			case 2:
				ListarMatriculas.renderizar();
				break;
			case 3:
				ListarMatriculasPorCurso.renderizar();
				break;
			case 4:
				ListarMatriculasPorAluno.renderizar();
			case 0:
				System.out.println("\nSaindo...");
				break;
			default:
				System.out.println("Op��o Inv�lida!!! \n ");
				break;
			}
		} while (opcao != 0);

	}

}
