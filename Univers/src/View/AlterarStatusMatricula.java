package View;

import Controller.CursoController;
import Controller.MatriculaController;
import Controller.ProfessorController;
import Controller.UsuarioController;
import Model.Curso;
import Model.Matricula;
import Model.Professor;
import Model.Usuario;
import Utils.Console;

public class AlterarStatusMatricula {

	public static Curso curso = new Curso();
	public static Usuario usuario = new Usuario();
	public static Matricula matricula = new Matricula();
	public static MatriculaController mtrct = new MatriculaController();
	public static UsuarioController usrct = new UsuarioController();
	public static CursoController crsct = new CursoController();
	public static Professor professor = new Professor();
	public static ProfessorController profctr = new ProfessorController();

	public static void renderizar() {
		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("################       ALTERAR STATUS      ################");
		System.out.println("################        DA MATRICULA       ################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		curso = new Curso();
		usuario = new Usuario();
		matricula = new Matricula();
		mtrct = new MatriculaController();
		usrct = new UsuarioController();
		crsct = new CursoController();
		professor = new Professor();
		profctr = new ProfessorController();
		String newStatus;

		System.out.println("Infome os dados para realizar a Matricula do aluno\n");
		String cpfProfessor = Console.readString("Informe o CPF do Professor: ");
		professor = profctr.BuscarProfessorPorCpf(cpfProfessor);
		if (professor != null) {
			String nomeCurso = (Console.readString("Infome o nome do Curso").toUpperCase());
			curso = crsct.BuscarCursoPorNome(nomeCurso);

			if (curso.getProfessor().getId().equals(professor.getId())) {
				if (curso != null) {
					String cpfUser = Console.readString("Infome o CPF do Aluno");
					usuario = usrct.BuscarUsarioPorCpf(cpfUser);
					if (usuario != null) {
						matricula.setUsuario(usuario);
						matricula.setCurso(curso);
						matricula = mtrct.validaUsuarioMatricula(matricula.getUsuario().getId(),
								matricula.getCurso().getId());
						if (matricula != null) {
							String oldStatus = matricula.getStatus();
							int opcaoStatus = Console
									.readInt("Informe o status para a matricula do aluno: " + usuario.getNome()
											+ ", no curso: " + curso.getNome() + "\n1 - Aprovado\n2 - Reprovado\n");
							if (opcaoStatus == 1) {
								newStatus = "APROVADO";
							} else if (opcaoStatus == 2) {
								newStatus = "REPROVADO";
							} else {
								System.out.println("Opção invalida");
								newStatus = null;
							}
							if (newStatus != null) {
								matricula.setStatus(newStatus);
								mtrct.setMatricula(matricula);
								mtrct.salvar();
								System.out.println("A matricula do Aluno: " + usuario.getNome().toUpperCase()
										+ ", no Curso: " + curso.getNome() + " foi mudada do status:" + oldStatus
										+ " para :" + matricula.getStatus());
								Console.readString("Pressione qualquer botão para continuar...");
							} else {
								System.out.println("O status da matricula do aluno não foi alterada");
								Console.readString("Pressione qualquer botão para continuar...");
							}
						} else {
							System.out.println("Aluno não matriculado neste curso");
							Console.readString("Pressione qualquer botão para continuar...");
						}
					} else {
						System.out.println("Aluno não cadastrado");
						Console.readString("Pressione qualquer botão para continuar...");
					}
				} else {
					System.out.println("Curso não cadastrado");
					Console.readString("Pressione qualquer botão para continuar...");
				}
			} else {
				System.out.println("Status da Matricula devem ser feita pelo proprio professor do curso ");
				Console.readString("Pressione qualquer botão para continuar...");
			}
		} else {
			System.out.println("Professor não cadastrado");
			Console.readString("Pressione qualquer botão para continuar...");
		}
	}

}
