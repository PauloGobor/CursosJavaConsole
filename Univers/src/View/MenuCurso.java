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
			System.out.println("Escolha um opção!!!");
			System.out.println("1 - Cadastrar Curso");
			System.out.println("2 - Listar Curso");
			System.out.println("3 - Alterar Curso");
			System.out.println("4 - Remover Curso\n");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Escolha um opção");

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
				System.out.println("Opção Inválida!!! \n ");
				break;
			}
		} while (opcao != 0);

	}

}
