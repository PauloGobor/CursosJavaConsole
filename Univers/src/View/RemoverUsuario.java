package View;

import Controller.UsuarioController;
import Model.Usuario;
import Utils.Console;

public class RemoverUsuario {
	public static Usuario usuario = new Usuario();
	public static UsuarioController usrct = new UsuarioController();

	public static void renderizar() {

		usrct = new UsuarioController();
		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("################       REMOVER USUARIO     ################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		String cpf = Console.readString("Infome o CPF do Usuario");
		usuario = usrct.BuscarUsarioPorCpf(cpf);
		if (usuario != null) {
			int conf = Console.readInt("Deseja confimar essa a��o? \n 1-sim/2-n�o");
			if (conf == 1) {
				usrct.excluir(usuario.getId());
				System.out.println("Usuario removido");
				Console.readString("Pressione ENTER para continuar...");
			} else {
				System.out.println("Opera��o cancelada pelo usuario");
				Console.readString("Pressione ENTER para continuar...");
			}
		} else {
			System.out.println("Usuario n�o cadastrado");
			Console.readString("Pressione ENTER para continuar...");

		}

	}

}
