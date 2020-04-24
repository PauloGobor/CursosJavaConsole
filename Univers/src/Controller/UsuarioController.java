
package Controller;

import java.util.List;
import DAO.UsuarioDAO;
import Model.Usuario;

public class UsuarioController {

	private static Usuario usuario;
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}

	public String alterar(Long cod) {
		usuario = usuarioDAO.alterar(cod);
		return "sucesso";
	}

	public List<Usuario> listarUsuario() {
		return usuarioDAO.listar();
	}

	public String excluir(Long cod) {
		usuarioDAO.excluir(cod);
		return "sucesso";
	}

	public Usuario BuscarUsarioPorId(Long cod) {
		usuario = usuarioDAO.buscarPorId(cod);
		return usuario;
	}

	public Usuario BuscarUsarioPorCpf(String cpf) {
		return usuarioDAO.buscarPorCpf(cpf);
	}

}
