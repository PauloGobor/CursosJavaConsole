package View;

import java.util.List;
import Controller.MatriculaController;
import Model.Matricula;
import Utils.Console;

public class ListarMatriculas {
	public static MatriculaController mtctr = new MatriculaController();

	public static void renderizar() {

		mtctr = new MatriculaController();


		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("#################     LISTAR MATRÍCULA     ################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		List<Matricula> matriculas = mtctr.listarMatriculas();


		System.out.print("# Usuario # Curso # Status\n");
		System.out.print("###########################################################\n");
		for (Matricula matricula : matriculas) {
			System.out.print(matricula.getUsuario().getNome() + " # ");
			System.out.print(matricula.getCurso().getNome() + "# ");
			System.out.println(matricula.getStatus());

		}
		System.out.print("###########################################################\n\n");

		Console.readString("\nPressione qualquer tecla ");
	}
}
