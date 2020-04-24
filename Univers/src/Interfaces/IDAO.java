package Interfaces;

import java.util.List;

import Model.Curso;
import Model.Usuario;

public interface IDAO<T> {

	void salvar(T objeto);

	List<T> listar();

	T buscarPorId(Long id);

	T buscarPorNome(String nome);

	T alterar(Long id);

	void excluir(Long id);
	
	T buscarPorCpf(String cpf);

}
