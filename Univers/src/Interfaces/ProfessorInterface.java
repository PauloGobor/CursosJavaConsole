package Interfaces;

import java.util.List;

import Model.Professor;

public interface ProfessorInterface {
	
	public void salvar(Professor professor);

	public List<Professor> listarProfessores();

	public Professor buscarProfessorPorId(Long cod);
	
	public Professor buscarProfessorPorCpf(String cpf);



}
