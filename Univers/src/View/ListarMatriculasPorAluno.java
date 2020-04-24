package View;

import java.util.List;

import Controller.CursoController;
import Controller.MatriculaController;
import Controller.UsuarioController;
import Model.Matricula;
import Model.Usuario;
import Utils.Console;

public class ListarMatriculasPorAluno {
	public static Usuario user = new Usuario();
	public static UsuarioController usrct = new UsuarioController();
	public static MatriculaController mtctr = new MatriculaController();
	public static CursoController crsct = new CursoController();

	public static void renderizar() {
		user = new Usuario();
		usrct = new UsuarioController();
		mtctr = new MatriculaController();
		crsct = new CursoController();
		String status;

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("################     LISTAR MATRÍCULA     #################");
		System.out.println("################         POR ALUNO        #################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		// mudar para buscar por cpf
		String cpf = Console.readString("Infome o CPF do Usuario");
		user = usrct.BuscarUsarioPorCpf(cpf);
		if (user != null) {
			int opcaoStatus = Console.readInt("Informe o status da matricula para o Aluno: " + user.getNome()
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
				List<Matricula> matriculas = mtctr.listarMatriculasPorAluno(user.getId(), status);
				System.out.print("#Curso # Usuario # Status\n");
				System.out.print("###########################################################\n");
				for (Matricula matricula : matriculas) {
					System.out.print(matricula.getCurso().getNome() + " #  ");
					System.out.print(matricula.getUsuario().getNome() + " #  ");
					System.out.println(matricula.getStatus());
				}
				System.out.print("###########################################################\n\n");
				Console.readString("\nPressione qualquer botao para continuar...");
			} else {
				System.out.println("Opção de Status Invalida");
				Console.readString("Pressione qualquer botão para continuar...");
			}
		} else {
			System.out.println("Aluno não cadastrado");
			Console.readString("Pressione qualquer botão para continuar...");
		}
	}

}
