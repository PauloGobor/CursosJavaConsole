package View;

import java.util.List;

import Controller.CursoController;
import Controller.MatriculaController;
import Controller.UsuarioController;
import Model.Curso;
import Model.Matricula;
import Utils.Console;

public class ListarMatriculasPorCurso {
	public static MatriculaController mtctr = new MatriculaController();
	public static UsuarioController usrct = new UsuarioController();
	public static CursoController crsct = new CursoController();

	public static void renderizar() {

		mtctr = new MatriculaController();
		usrct = new UsuarioController();
		crsct = new CursoController();
		String status;

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("################     LISTAR MATRÍCULA     #################");
		System.out.println("################         POR CURSO        #################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		String nome = Console.readString("Informe o Nome do Curso");
		Curso curso = crsct.BuscarCursoPorNome(nome);
		if (curso != null) {
			int opcaoStatus = Console.readInt("Informe o status da matricula para o Curso: " + curso.getNome()
					+ "\n1 - Todos\n2 - Cursando\n3 - Aprovado\n4 - Reprovado\n");
			if (opcaoStatus == 1) {
				status = "TODOS";
			} else if (opcaoStatus == 2) {
				status = "CURSANDO";
			} else if (opcaoStatus == 3) {
				status = "APROVADO";
			} else if (opcaoStatus == 4) {
				status = "REPROVADO";
			} else {
				status = null;
			}
			if (status != null) {
				List<Matricula> matriculas = mtctr.listarMatriculasPorCurso(curso.getId(), status);
				System.out.print("#Curso # Usuario # Status\n");
				System.out.print("###########################################################\n");
				for (Matricula matricula : matriculas) {
					System.out.print(matricula.getCurso().getNome() + " -  ");
					System.out.print(matricula.getUsuario().getNome() + " -  ");
					System.out.println(matricula.getStatus());
				}
				System.out.print("###########################################################\n\n");
				Console.readString("Pressione ENTER para continuar...");
			} else {
				System.out.println("Opção Invalida para o Status da Matricula");
				Console.readString("Pressione ENTER para continuar...");
			}
		} else {
			System.out.println("Curso não cadastrado");
			Console.readString("Pressione ENTER para continuar...");
		}
	}
}
