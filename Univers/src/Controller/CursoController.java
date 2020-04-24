package Controller;

import java.util.List;

import DAO.CursoDAO;
import Model.Curso;

public class CursoController {

	private static Curso curso = new Curso();
	private static CursoDAO cursoDAO = new CursoDAO();

	public void salvar(Curso curso) {
		cursoDAO.salvar(curso);
	}

	public String alterar(Long cod) {
		curso = cursoDAO.alterar(cod);
		return "sucesso";
	}

	public List<Curso> listarCurso() {
		return cursoDAO.listar();
	}

	public String excluir(Long cod) {
		cursoDAO.excluir(cod);
		return "sucesso";
	}

	public Curso buscarCursoPorId(Long cod) {

		curso = cursoDAO.buscarPorId(cod);
		return curso;
	}

	public Curso BuscarCursoPorNome(String nome) {
		return cursoDAO.buscarPorNome(nome);
	}

}
