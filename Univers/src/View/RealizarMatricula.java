package View;

import Controller.CursoController;
import Controller.MatriculaController;
import Controller.UsuarioController;
import Model.Curso;
import Model.Matricula;
import Model.Usuario;
import Utils.Console;
import Utils.Valida;

public class RealizarMatricula {
	public static Curso curso = new Curso();
	public static Usuario usuario = new Usuario();
	public static Matricula matricula = new Matricula();
	public static MatriculaController mtrct = new MatriculaController();
	public static UsuarioController usrct = new UsuarioController();
	public static CursoController crsct = new CursoController();
	public static final String statusMatricula = "CURSANDO";

	public static void renderizar() {
		curso = new Curso();
		usuario = new Usuario();
		matricula = new Matricula();
		mtrct = new MatriculaController();
		usrct = new UsuarioController();
		crsct = new CursoController();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("################    REALIZAR MATRÍCULA     ################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		System.out.println("Infome os dados para realizar a Matricula do aluno\n");
		String cpfUser = Console.readString("Infome o CPF do Usuario");
		usuario = usrct.BuscarUsarioPorCpf(cpfUser);
		if (usuario != null) {
			String nomeCurso = (Console.readString("Infome o nome do Curso").toUpperCase());
			curso = crsct.BuscarCursoPorNome(nomeCurso);
			if (curso != null) {
				matricula.setUsuario(usuario);
				matricula.setCurso(curso);
				if (mtrct.validaUsuarioMatricula(matricula.getUsuario().getId(),
						matricula.getCurso().getId()) == null) {
					if (Valida.QuantidadeVagasCurso(curso)) {
						int conf = Console.readInt("Deseja confirmar a matricula do aluno:" + usuario.getNome()
								+ " no curso " + curso.getNome() + "\n1-Sim \n2-Não");
						System.out.println("");
						if (conf == 1) {
							matricula.setStatus(statusMatricula);
							mtrct.salvar(matricula);
							System.out.println("A matricula do Aluno:" + usuario.getNome() + ", no Curso:"
									+ curso.getNome() + " foi realizada com Sucesso");
							Console.readString("Pressione qualquer botão para continuar...");
						} else {
							System.out.println("Operação cancelada pelo usuario.");
							Console.readString("Pressione qualquer botão para continuar...");
						}
					} else {
						System.out.println("Não tem mais vagas para o curso:" + curso.getNome());
						Console.readString("Pressione qualquer botão para continuar...");
					}
				} else {
					System.out.println("Aluno ja matriculado neste curso");
					Console.readString("Pressione qualquer botão para continuar...");
				}
			} else {
				System.out.println("Curso não cadastrado");
				Console.readString("Pressione qualquer botão para continuar...");
			}
		} else {
			System.out.println("Aluno não cadastrado");
			Console.readString("Pressione qualquer botão para continuar...");
		}

	}

}
