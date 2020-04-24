package Controller;

import java.util.List;

import DAO.ProfessorDAO;
import Model.Professor;

public class ProfessorController {

	private static Professor professor = new Professor();
	private static ProfessorDAO professorDAO = new ProfessorDAO();

	public void salvar(Professor professor) {
		professorDAO.salvar(professor);
	}

	public List<Professor> listarProfessor() {
		return professorDAO.listar();
	}

	public Professor BuscarProfessorPorId(Long cod) {
		professor = professorDAO.buscarPorId(cod);
		return professor;
	}

	public Professor BuscarProfessorPorCpf(String cpf) {
		return professorDAO.buscarPorCpf(cpf);
	}

}
