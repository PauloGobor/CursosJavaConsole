package View;

import Controller.UsuarioController;
import Model.Usuario;
import Utils.Console;

public class AlterarUsuario {
	public static Usuario newuser = new Usuario();
	public static UsuarioController usrct = new UsuarioController();

	public static void renderizar() {
		newuser = new Usuario();
		usrct = new UsuarioController();

		System.out.println("###########################################################");
		System.out.println("###########################################################");
		System.out.println("#################     ALTERAR USUARIO     #################");
		System.out.println("###########################################################");
		System.out.println("###########################################################\n");

		// mudar para buscar por cpf

		String cpf = Console.readString("Infome o CPF do Usuario");
		newuser = usrct.BuscarUsarioPorCpf(cpf);
		if (newuser != null) {
			System.out.println("Preencher todos os campos com os dados do usuario");

			newuser.setId(newuser.getId());
			newuser.setNome(Console.readString("Nome: "));
			newuser.setEmail(Console.readString("Email: "));
			newuser.setIdade(Console.readInt("Idade: "));
			newuser.setSexo(Console.readString("Sexo: "));
			newuser.setTelefone(Console.readString("Telefone: "));

			usrct.salvar(newuser);

			System.out.println("Usuario " + newuser.getNome() + " alterado com Sucesso!!!");
			Console.readString("Pressione ENTER para continuar...");
		} else {
			System.out.println("Usuario não encontrado no sistema");
			Console.readString("Pressione ENTER para continuar...");
		}
	}
}
