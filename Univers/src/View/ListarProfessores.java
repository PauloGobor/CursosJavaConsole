package View;

import java.util.List;

import Controller.ProfessorController;
import Model.Professor;
import Utils.Console;

public class ListarProfessores {
	public static ProfessorController prfct = new ProfessorController();
	public static List<Professor> professores = prfct.listarProfessor();
	public static void renderizar() {

		prfct = new ProfessorController();
		professores = prfct.listarProfessor();
		
		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("###############      LISTAR PROFESSORES    ################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");


		System.out.print("#Nome # Idade # Email\n");
		System.out.print("###########################################################\n");
		for (Professor professor : professores) {
			System.out.print(professor.getNome() + " # ");
			System.out.print(professor.getIdade() + " # ");
			System.out.println(professor.getEmail() + " # ");
		}
		System.out.print("###########################################################\n\n");
		Console.readString("Pressione qualquer botao para voltar");
	}

}
