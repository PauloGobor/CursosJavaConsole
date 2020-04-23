package Interfaces;

import java.util.List;

import Model.Curso;

public interface CursoInterface {

	public void salvar(Curso curso);

	public List<Curso> listarCursos();

	public Curso buscarCursoPorId(Long cod);

	public Curso buscarCursoPorNome(String nome);

	public Curso alterar(Long cod);

	public void excluir(Long id);

}
