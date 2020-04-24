package View;

import java.util.List;
import Controller.CursoController;
import Model.Curso;
import Utils.Console;

public class ListarCurso {
	public static CursoController crsct = new CursoController();
	public static List<Curso> cursos = crsct.listarCurso();

	public static void renderizar() {

		crsct = new CursoController();
		cursos = crsct.listarCurso();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("#################       LISTAR CURSO      #################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		System.out.print("Nome # Prof. # Horas # Vagas # Valor # \n");
		System.out.print("###########################################################\n\n");
		for (Curso curso : cursos) {
			// System.out.print(curso.getNome().charAt(1 - 2) + "\n");
			System.out.print(curso.getNome() + "   ");
			System.out.print(curso.getProfessor().getNome()+ "   ");
			System.out.print(curso.getCargaHoraria() + "    ");
			System.out.print(curso.getQtdVagas() + "     ");
			System.out.println("R$: " + curso.getValor());

		}

		Console.readString("Pressione qualquer botao para voltar");
	}

}
