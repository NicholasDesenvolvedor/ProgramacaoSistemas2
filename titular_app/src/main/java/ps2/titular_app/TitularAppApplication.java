package ps2.titular_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static ps2.titular_app.ES.*;

@SpringBootApplication
public class TitularAppApplication implements CommandLineRunner {

	@Autowired
	private TitularRepo titularrepo;

	public static void main(String[] args) {
		SpringApplication.run(TitularAppApplication.class, args);
	}

	public void criar() {
		System.out.println("Você escolheu criar um novo titular, \n Digite os dados...");
		String nome = input("nome: "); 
		String cpf = input("CPF: "); 
		Titular novo = new Titular ();
		novo.setNome(nome);
		novo.setCpf(cpf);
		titularrepo.save(novo);
		System.out.println("Titular criado com o id " + novo.getId());
	}

	public void lerTudo() {
		Iterable<Titular> titulares = titularrepo.findAll();
		for (Titular t : titulares) {
			System.out.println(t);
		}
	}
	
	public void Buscar(){
		long escolhido = Long.parseLong(input("Digite o ID: "));
		Titular t = titularrepo.findById(escolhido).get();
		System.out.println(t);
	}
	public void DeletarUsuario(){
		long escolhido = Long.parseLong(input("Digite o ID: "));
		Titular t = titularrepo.findById(escolhido).get();
		titularrepo.delete(t);
	}
	public void AlterarUsuario(){
		long escolhido = Long.parseLong(input("Digite o ID: "));
		Titular t = titularrepo.findById(escolhido).get();
		System.out.println("Digite os novos dados do usuario (Nome e CPF)");
		String nome = input("nome: "); 
		String cpf = input("CPF: "); 
		t.setNome(nome);
		t.setCpf(cpf);
		titularrepo.save(t);
	}
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println("# GERENCIADOR DE TITULARES!");
		boolean sair = false;
		String menu = "\n(1) Listar todos os titulares \n";
		menu += "\n(2) Buscar um titular específico pelo número \n";
		menu += "\n(3) Criar um novo titular \n";
		menu += "\n(4) Alterar os dados do titular \n";
		menu += "\n(5) Apagar um titular \n";
		menu += "\n(0) Sair ";

		menu += "Escolha uma opção: ";

		while (!sair) {
			String op = input(menu);
			switch (op) {
				case "1":
					lerTudo();
					break;
				case "2":
					Buscar();
					break;
				case "3":
					criar();
					break;
				case "4":
					AlterarUsuario();
					break;
				case "5":
					DeletarUsuario();
					break;
				case "0":
					sair = true;
					break;
				default:
					print("Opção inválida!");
			}
		}
	}

}