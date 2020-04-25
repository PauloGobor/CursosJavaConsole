package View;

import Controller.CursoController;
import Model.Curso;
import Utils.Console;

public class RemoverCurso {
	public static Curso curso = new Curso();
	public static CursoController crsct = new CursoController();

	public static void renderizar() {
		crsct = new CursoController();
		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("#################      REMOVER CURSO      #################");
		System.out.println("###########################################################");
		System.out.println("###########################################################");

		String nome = Console.readString("Informe o Nome do Curso");
		curso = crsct.BuscarCursoPorNome(nome);
		if (curso != null) {
			int conf = Console.readInt("Deseja confimar essa a��o? \n 1-sim/2-n�o \n");
			if (conf == 1) {
				crsct.excluir(curso.getId());
				System.out.println("Curso" + curso.getNome() + " removido");
				Console.readString("Pressione ENTER para continuar...");
			} else {
				System.out.println("Opera��o cancelada pelo usuario");
				Console.readString("Pressione ENTER para continuar...");
			}
		} else {
			System.out.println("Curso n�o cadastrado");
			Console.readString("Pressione ENTER para continuar...");

		}

	}

}
