package Controller;

import java.util.List;
import DAO.MatriculaDAO;
import Model.Matricula;

public class MatriculaController {

	private Matricula matricula;
	MatriculaDAO matriculaDAO = new MatriculaDAO();

	public MatriculaController() {
		matricula = new Matricula();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public void salvar() {
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		matriculaDAO.salvar(matricula);
		matricula = new Matricula();
		// return "sucesso";
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
