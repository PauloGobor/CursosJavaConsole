package View;

import Controller.ProfessorController;
import Model.Professor;
import Utils.Console;
import Utils.Valida;

public class CadastrarProfessor {
	public static Professor prf = new Professor();
	public static ProfessorController prfctr = new ProfessorController();

	public static void renderizar() {
		prf = new Professor();
		prfctr = new ProfessorController();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("###############     CADASTRAR  PROFESSOR     ##############");
		System.out.println("###########################################################");
		System.out.println("###########################################################");

		System.out.println("Infome os dados de Cadastro do Professor\n");
		prf.setCpf(Console.readString("CPF: "));
		if (Valida.isCPF(prf.getCpf())) {
			if (prfctr.BuscarProfessorPorCpf(prf.getCpf()) == null) {
				prf.setNome(Console.readString("Nome: "));
				prf.setEmail(Console.readString("Email: "));
				prf.setIdade(Console.readInt("Idade: "));
				prf.setSexo(Console.readString("Sexo: "));
				prfctr.salvar(prf);
				System.out.println("Professor Cadastrado com Sucesso!");
				Console.readString("Pressione qualquer botão para continuar...");
			} else {
				System.out.println("Professor ja tem cadastro no sistema! ! !");
				Console.readString("Pressione qualquer botão para continuar...");
			}
		} else {
			System.out.println("CPF Inválido! ! !");
			Console.readString("Pressione qualquer botão para continuar...");

		}
	}
}
