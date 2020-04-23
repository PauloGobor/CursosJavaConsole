package Interfaces;

import java.util.List;

import Model.Matricula;


public interface MatriculaInterface {
	public void salvar(Matricula matricula);

	public List<Matricula> listarMatriculas();

	public List<Matricula> listarMatriculasPorCurso(Long cod, String status);
	
	public List<Matricula> listarMatriculasPorAluno(Long cod, String status);

	public Matricula validaUsuarioMatricula(Long usrcod, Long crscod);
}
