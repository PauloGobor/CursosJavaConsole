package View;

import Utils.Console;

public class MenuProfessor {
	public static void renderizar() {
		// TODO Auto-generated method stub
		int opcao;
		do {
			System.out.println("###########################################################");
			System.out.println("###########################################################");
			System.out.println("################      MENU PROFESSOR      #################");
			System.out.println("###########################################################");
			System.out.println("###########################################################\n");
			System.out.println("1 - Cadastrar Professor");
			System.out.println("2 - Listar Professores");
			System.out.println("3 - Alterar Status Matricula\n");//professor deve ser o mesmo do curso
			System.out.println("0 - Sair");
			opcao = Console.readInt("Escolha um opção");

			switch (opcao) {
			case 1:
				CadastrarProfessor.renderizar();
				break;
			case 2:
				ListarProfessores.renderizar();
				break;
			case 3:
				AlterarStatusMatricula.renderizar();
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
