package Interfaces;

import java.util.List;
import Model.Usuario;

public interface UsuarioInterface {

	public void salvar(Usuario usuario);

	public Usuario autenticar(String login, String senha);

	public List<Usuario> listarUsuario();

	public Usuario alterar(Long cod);

	public Usuario buscarUsuarioPorId(Long cod);
	
	public Usuario buscarUsuarioPorCpf(String cpf);

	public void excluir(Long id);

}
