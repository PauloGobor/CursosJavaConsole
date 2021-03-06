package View;

import java.util.List;

import Controller.UsuarioController;
import Model.Usuario;
import Utils.Console;

public class ListarUsuario {
	public static UsuarioController usrct = new UsuarioController();
	public static List<Usuario> usuarios = usrct.listarUsuario();

	public static void renderizar() {

		usrct = new UsuarioController();
		usuarios = usrct.listarUsuario();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("################       LISTAR USUARIO      ################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		System.out.print("# Nome # Idade # Email # Telefone #\n");
		System.out.print("########################################################### \n");
		for (Usuario usuario : usuarios) {
			System.out.print(usuario.getNome() + " # ");
			System.out.print(usuario.getIdade() + " # ");
			System.out.print(usuario.getEmail() + " # ");
			System.out.println(usuario.getTelefone() + " # ");

		}
		System.out.print("########################################################### \n\n");
		Console.readString("Pressione ENTER para continuar...");

	}

}
