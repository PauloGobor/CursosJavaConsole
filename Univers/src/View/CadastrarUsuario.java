package View;

import Controller.UsuarioController;
import Model.Usuario;
import Utils.Console;
import Utils.Valida;

public class CadastrarUsuario {

	public static Usuario user = new Usuario();
	public static UsuarioController usrct = new UsuarioController();

	public static void renderizar() {

		user = new Usuario();
		usrct = new UsuarioController();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("###############     CADASTRAR  USUARIO     ################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		System.out.println("Infome os dados de Cadastro do Usuario\n");
		user.setCpf(Console.readString("CPF: "));
		if (Valida.isCPF(user.getCpf())) {
			if (usrct.BuscarUsarioPorCpf(user.getCpf()) == null) {
				user.setNome(Console.readString("Nome: "));
				user.setEmail(Console.readString("Email: "));
				user.setSexo(Console.readString("Sexo: "));
				user.setIdade(Console.readInt("Idade: "));
				user.setTelefone(Console.readString("Telefone: "));
				// registra o Ususario
				usrct.salvar(user);
				System.out.println("Usuario Cadastrado com Sucesso!");
				Console.readString("Pressione ENTER para continuar...");
			} else {
				System.out.println("Usuario ja Cadastrado! ! !");
				Console.readString("Pressione ENTER para continuar...");
			}
		} else {
			System.out.println("CPF Inválido! ! !");
			Console.readString("Pressione ENTER para continuar...");

		}

	}

}
