package Controller;

import java.util.List;

import DAO.CursoDAO;
import Model.Curso;



public class CursoController {
	
	private Curso curso;
	CursoDAO CursoDAO = new CursoDAO();

	public CursoController() {
		curso = new Curso();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void salvar() {
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.salvar(curso);
		curso = new Curso();
		//return "sucesso";
	}

	public String alterar(Long cod) {
		CursoDAO cursoDAO = new CursoDAO();
		curso = cursoDAO.alterar(cod);
		return "sucesso";
	}
	
	public List<Curso> listarCurso()	{		
		return CursoDAO.listarCursos();
	}
	
	
	public String excluir(Long cod)	{
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.excluir(cod);
		curso = new Curso();
		return "sucesso";
	}
	
	public Curso buscarCursoPorId(Long cod) {
		CursoDAO cursoDAO = new CursoDAO();
		curso = cursoDAO.buscarCursoPorId(cod);
		return curso;
	}
	
	public Curso BuscarCursoPorNome(String nome) {
		return CursoDAO.buscarCursoPorNome(nome);
	}
	

}
