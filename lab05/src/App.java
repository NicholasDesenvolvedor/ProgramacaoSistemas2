import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        ContaDao dao;
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.rmjfvjlcrbevotjquuxx&password=Colepoudo10$";
        dao = new ContaDao(ConnectionFactory.getConnection(url));
        List<Conta> contas;
        String resposta;

        while (true) { 
            System.out.println("O QUE DESEJA FAZER:");
            System.out.println("(1) Listar todas as contas");
            System.out.println("(2) Buscar uma conta específica pelo número");
            System.out.println("(3) Criar uma nova conta");
            System.out.println("(4) Alterar o saldo de uma conta");
            System.out.println("(5) Apagar uma conta");
            System.out.println("(0) Sair");
            resposta = entrada.nextLine();

             if (resposta.equals("1")) { 
                contas = dao.lerTodas();
                System.out.println(contas);
            }
            else if (resposta.equals("2")){
                System.out.println("Digite o numero da conta que gostaria de buscar:");
                long id = entrada.nextLong();
                System.out.println(dao.buscarPeloNumero(id));
                break;
            }
            else if (resposta.equals("3")){
                System.out.println("Você escolheu criar uma nova conta");
                System.out.println("Digite o numero da conta");
                long numero = entrada.nextLong();
                System.out.println("Digite o saldo da conta");
                BigDecimal saldo = entrada.nextBigDecimal();
                Conta t = new Conta (numero, saldo);
                boolean resul = dao.criar(t);
                if (resul) {
                    System.out.println("Conta criada!");
                }
                else {
                    System.out.println("Conta invalida, tente novamente");
                }
                break;
            }
            else if (resposta.equals("4")){

            }
            else if (resposta.equals("5")){

            }
            else if (resposta.equals("0")) { 
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        entrada.close();
    }
}