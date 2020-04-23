package Controller;

import java.util.List;

import DAO.ProfessorDAO;
import Model.Professor;

public class ProfessorController {
	
	private Professor professor;
	ProfessorDAO professorDAO = new ProfessorDAO();
	

	
	public void salvar(Professor professor) {
		professorDAO = new ProfessorDAO();
		professorDAO.salvar(professor);
		professor = new Professor();
		//return "sucesso";
	}
	
	public List<Professor> listarProfessor()	{		
		return professorDAO.listarProfessores();
	}
	
	public Professor BuscarProfessorPorId(Long cod) {
		professorDAO = new ProfessorDAO();
		professor = professorDAO.buscarProfessorPorId(cod);
		return professor;
	}
	
	public Professor BuscarProfessorPorCpf(String cpf) {
		return professorDAO.buscarProfessorPorCpf(cpf);
	}
	
	

}
