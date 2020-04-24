
package Controller;

import java.util.List;
import DAO.UsuarioDAO;
import Model.Usuario;

public class UsuarioController {

	private Usuario usuario;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public UsuarioController() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void salvar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		usuario = new Usuario();
		// return "sucesso";
	}

//	public String autenticar() {
//		String retorno = "erro";
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		Usuario logado = usuarioDAO.autenticar(usuario.getEmail(), usuario.getSenha());
//		if(logado == null) retorno = "sucesso";
//		usuario = new Usuario();
//		return retorno;
//	}

	public String alterar(Long cod) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario = usuarioDAO.alterar(cod);
		return "sucesso";
	}

	public List<Usuario> listarUsuario() {
		return usuarioDAO.listar();
	}

	public String excluir(Long cod) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(cod);
		usuario = new Usuario();
		return "sucesso";
	}

	public Usuario BuscarUsarioPorId(Long cod) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario = usuarioDAO.buscarPorId(cod);
		return usuario;
	}

	public Usuario BuscarUsarioPorCpf(String cpf) {
		return usuarioDAO.buscarPorCpf(cpf);
	}

}
