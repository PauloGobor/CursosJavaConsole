package View;

import Controller.CursoController;
import Controller.ProfessorController;
import Model.Curso;
import Model.Professor;
import Utils.Console;

public class CadastrarCurso {
	public static Curso curso = new Curso();
	public static Professor professor = new Professor();
	public static ProfessorController prfctrl = new ProfessorController();
	public static CursoController crsct = new CursoController();
	public static void renderizar() {

		curso = new Curso();
		professor = new Professor();
		prfctrl = new ProfessorController();
		crsct = new CursoController();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("#############       CADASTRO DE CURSO       ###############");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		System.out.println("Infome os dados de Cadastro do Curso\n");
		curso.setNome(Console.readString("Nome:").toUpperCase());
		if (crsct.BuscarCursoPorNome(curso.getNome()) == null) {
			String l_cpf = Console.readString("Infome o CPF do professor ");
			professor = prfctrl.BuscarProfessorPorCpf(l_cpf);
			if (professor != null) {
				curso.setCategoria(Console.readString("Categoria: "));
				curso.setCargaHoraria(Console.readDouble("Carga Horaria: "));
				curso.setValor(Console.readDouble("Valor: "));
				curso.setQtdVagas(Console.readInt("Quantidade de vagas: "));
				curso.setProfessor(professor);

				crsct.salvar(curso);
				System.out.println("Curso " + curso.getNome() + " Cadastrado com Sucesso!!!");
				Console.readString("Pressione qualquer botão para continuar...");
			} else {
				System.out.println("Professor não encontrado");
				Console.readString("Pressione qualquer botão para continuar...");
			}

		} else {
			System.out.println("Curso ja cadastrado");
			Console.readString("Pressione qualquer botão para continuar...");
		}
	}
}
