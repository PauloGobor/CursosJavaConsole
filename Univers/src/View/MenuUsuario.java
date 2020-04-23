package View;

import Utils.Console;

public class MenuUsuario {

	public static void renderizar() {

		int opcao;
		do {
			System.out.println("###########################################################");
			System.out.println("###########################################################");
			System.out.println("#################      MENU USUARIO      ##################");
			System.out.println("###########################################################");
			System.out.println("###########################################################");
			System.out.println("1 - Cadastrar Usuario");
			System.out.println("2 - Listar Usuario");
			System.out.println("3 - Alterar Usuario");
			System.out.println("4 - Remover Usuario\n");
			System.out.println("0 - Sair");
			opcao = Console.readInt("Escolha um opção");

			switch (opcao) {
			case 1:
				CadastrarUsuario.renderizar();
				break;
			case 2:
				ListarUsuario.renderizar();
				break;
			case 3:
				AlterarUsuario.renderizar();
				break;
			case 4:
				RemoverUsuario.renderizar();
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
