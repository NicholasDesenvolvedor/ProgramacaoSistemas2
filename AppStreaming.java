import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AppStreaming {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        List<Midia> midias = new ArrayList<>();
        String resposta;
        while (true) { 
            System.out.println("O que deseja fazer:");
            System.out.println("(1) Adicionar novo Filme.");
            System.out.println("(2) Adicionar nova Série.");
            System.out.println("(3) Listar todas as mídias.");
            System.out.println("(4) Sair.");
            resposta = entrada.nextLine();

            if (resposta.equals("1")) { 
                System.out.println("Você escolheu adicionar um novo Filme.");
                System.out.println("Digite o nome do filme: ");
                String nomeFilme = entrada.nextLine();
                System.out.println("Digite o tempo de duração em minutos (somente digitos): ");
                int duracaoFilme = entrada.nextInt();
                Filme f = new Filme (nomeFilme , duracaoFilme);
                midias.add(f);
            } else if (resposta.equals("2")) {
                System.out.println("Você escolheu adicionar uma nova Série.");
                System.out.println("Digite o nome da serie: ");
                String nomeSerie = entrada.nextLine();
                System.out.println("Digite o numero da primeira temporada: ");
                int numeroTemp = Integer.parseInt(entrada.nextLine());
                System.out.println("Digite o nome do primeiro episódio: ");
                String nomePrimeiroEP = entrada.nextLine();
                System.out.println("Digite a duração em minutos do primeiro episodio: ");
                int duracaoPrimeiroEP = Integer.parseInt(entrada.nextLine());
                System.out.println("Digite o nome do segundo episódio: ");
                String nomeSegundoEP = entrada.nextLine();
                System.out.println("Digite a duração em minutos do primeiro episodio: ");
                int duracaoSegundoEP = Integer.parseInt(entrada.nextLine());
                Episodio primeiroEP = new Episodio (nomePrimeiroEP, duracaoPrimeiroEP);
                Episodio segundoEP = new Episodio (nomeSegundoEP, duracaoSegundoEP);
                Temporada tempo = new Temporada (numeroTemp);
                tempo.adicionar(primeiroEP);
                tempo.adicionar(segundoEP);

                System.out.println("Digite o numero da segunda temporada: ");
                int segundaTempo = Integer.parseInt(entrada.nextLine());
                System.out.println("Digite o nome do primeiro episódio: ");
                String nomePrimeiEP = entrada.nextLine();
                System.out.println("Digite a duração em minutos do primeiro episodio: ");
                int duracaoPrimeioEP = Integer.parseInt(entrada.nextLine());
                System.out.println("Digite o nome do segundo episódio: ");
                String nomeSegunEP = entrada.nextLine();
                System.out.println("Digite a duração em minutos do primeiro episodio: ");
                int duracaoSegunEP = Integer.parseInt(entrada.nextLine());
                Episodio primeiE = new Episodio (nomePrimeiEP, duracaoPrimeioEP);
                Episodio segunE = new Episodio (nomeSegunEP, duracaoSegunEP);
                Temporada tempoDois = new Temporada (segundaTempo);
                tempo.adicionar(primeiE);
                tempo.adicionar(segunE);
                Serie s = new Serie (nomeSerie);
                s.adicionar(tempo);
                s.adicionar(tempoDois);
                midias.add(s);

            } else if (resposta.equals("3")) { 
                System.out.println("Você escolheu listar todas as mídias.");
                for (int i = 0; i < midias.size(); i ++){
                    System.out.println(midias.get(i).info());
                }
            } else if (resposta.equals("4")) { 
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        entrada.close();
    }
}
