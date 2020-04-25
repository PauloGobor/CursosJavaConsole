package View;

import Utils.Console;

public class MenuCurso {
	public static void renderizar() {
		// TODO Auto-generated method stub
		int opcao;
		do {
			System.out.println("###########################################################");
			System.out.println("###########################################################");
			System.out.println("#################       MENU CURSO       ##################");
			System.out.println("###########################################################");
			System.out.println("###########################################################\n");
			System.out.println("Escolha um op��o!!!");
			System.out.println("1 - Cadastrar Curso");
			System.out.println("2 - Listar Curso");
			System.out.println("3 - Alterar Curso");
			System.out.println("4 - Remover Curso\n");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Escolha um op��o");

			switch (opcao) {
			case 1:
				CadastrarCurso.renderizar();
				break;
			case 2:
				ListarCurso.renderizar();
				break;
			case 3:
				AlterarCurso.renderizar();
				break;
			case 4:
				RemoverCurso.renderizar();
				break;
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
