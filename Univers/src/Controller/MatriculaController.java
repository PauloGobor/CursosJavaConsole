package Controller;

import java.util.List;
import DAO.MatriculaDAO;
import Model.Matricula;

public class MatriculaController {

	private static Matricula matricula = new Matricula();
	private static MatriculaDAO matriculaDAO = new MatriculaDAO();

	public void salvar(Matricula matricula) {
		matriculaDAO.salvar(matricula);
	}

	public List<Matricula> listarMatriculas() {
		return matriculaDAO.listar();
	}

	public List<Matricula> listarMatriculasPorCurso(Long cod, String status) {
		return matriculaDAO.listarMatriculasPorCurso(cod, status);
	}

	public Matricula validaUsuarioMatricula(Long usrcod, Long crscod) {
		return matriculaDAO.validaUsuarioMatricula(usrcod, crscod);
	}

	// mostrar para o aluno os cursos que ele esta matriculado
	public List<Matricula> listarMatriculasPorAluno(Long cod, String status) {
		return matriculaDAO.listarMatriculasPorAluno(cod, status);
	}

}
