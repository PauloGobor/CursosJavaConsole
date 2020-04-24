package View;

import Controller.CursoController;
import Controller.ProfessorController;
import Model.Curso;
import Model.Professor;
import Utils.Console;

public class AlterarCurso {
	public static CursoController crsct = new CursoController();
	public static Curso newcrs = new Curso();
	public static Professor professor = new Professor();
	public static ProfessorController prfctrl = new ProfessorController();

	public static void renderizar() {

		prfctrl = new ProfessorController();
		professor = new Professor();
		crsct = new CursoController();
		newcrs = new Curso();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("################       ALTERAR CURSO      #################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		String nome = Console.readString("Informe o nome do Curso que deseja alterar: ").toUpperCase();
		newcrs = crsct.BuscarCursoPorNome(nome);
		if (newcrs != null) {
			System.out.println("Preencher todos os campos com os dados do curso !");
			newcrs.setId(newcrs.getId());
			String l_cpf = Console.readString("Infome o CPF do Professor: ");
			professor = prfctrl.BuscarProfessorPorCpf(l_cpf);
			if (professor != null) {
				newcrs.setNome(Console.readString("Nome: ").toUpperCase());
				newcrs.setCategoria(Console.readString("Categoria: "));
				newcrs.setCargaHoraria(Console.readDouble("Carga Horaria: "));
				newcrs.setValor(Console.readDouble("Valor: "));
				newcrs.setQtdVagas(Console.readInt("Quantidade de vagas: "));
				newcrs.setProfessor(professor);

				crsct.salvar(newcrs);
				System.out.println("Curso" + newcrs.getNome() + " Alterado com Sucesso!");
				Console.readString("Pressione qualquer botão para continuar...");
			} else {
				System.out.println("Professor não Cadastrado");
				Console.readString("Pressione qualquer botão para continuar...");
			}
		} else {
			System.out.println("Curso não Cadastrado");
			Console.readString("Pressione qualquer botão para continuar...");

		}

	}

}
