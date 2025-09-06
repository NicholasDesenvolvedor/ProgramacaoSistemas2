import java.math.BigDecimal;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Consulta de contas!");
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.rmjfvjlcrbevotjquuxx&password=Colepoudo10$";
        Connection c = DriverManager.getConnection(url);
        System.out.println("Conexão ok!");
        String sql = "SELECT * FROM CONTAS";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        while (resultado.next()) {
            long nro = resultado.getLong("nro_conta");
            double saldo = resultado.getDouble("saldo");
            System.out.println("Número: " + nro + " - R$ " + saldo);
        }
        c.close();
    }

    public static void read() throws SQLException {
        String url = System.getenv ("URL");
        String username = System.getenv("USERNAME");
        String password = System.getenv ("PASSWORD");
        Connection c = DriverManager.getConnection(url, username, password);
        String sql = "SELECT * FROM contas";
        PreparedStatement stm = c. prepareStatement (sql);
        ResultSet rs = stm. executeQuery();
        while (rs.next()) {
            long nro = rs.getLong("nro_conta");
            BigDecimal saldo = rs.getBigDecimal ("saldo");
            System.out.println("Conta número: " + nro + " tem saldo de R$ " + saldo);
        }
        c. close();
    }

    public static void create() throws SQLException {
        System.out.print("Número para a nova conta: ");
        long nro = Long.parseLong(System.console() .readLine());
        System.out.print("Saldo da nova conta: ");
        BigDecimal saldo = new BigDecimal(System.console().readLine());
        String url = System. getenv ("URL");
        String username = System.getenv ("USERNAME");
        String password = System. getenv ("PASSWORD" );
        Connection c = DriverManager. getConnection(url, username, password);
        String sql = "INSERT INTO contas VALUES (?,?)";
        PreparedStatement prepstm = c. prepareStatement (sql);
        prepstm.setLong(1, nro);
        prepstm.setBigDecimal(2, saldo);
        int ret = prepstm.executeUpdate();
        System.out.println("Número de registros inseridos: " + ret);
        c. close ();
    }

    public static void update() throws SQLException {
        System.out.print("Número de uma conta já existente: ");
        long nro = Long.parseLong (System.console().readLine());
        System.out.print("Novo saldo para esta conta: ");
        BigDecimal saldo = new BigDecimal (System.console().readLine());
        String url = System. getenv ("URL");
        String username = System. getenv("USERNAME") ;
        String password = System. getenv("PASSWORD") ;
        Connection c = DriverManager.getConnection(url, username, password);
        String sql = "UPDATE contas SET saldo=? WHERE nro_conta=?";
        PreparedStatement prepstm = c. prepareStatement (sql);
        prepstm.setBigDecimal(1, saldo);
        prepstm.setLong(2, nro);
        int ret = prepstm.executeUpdate();
        System.out.println("Número de registros alterados: " + ret); 
        c.close();
    }

    public static void delete() throws SQLException {
        System.out.print("Número de uma conta já existente: ");
        long nro = Long.parseLong(System. console() .readLine());
        String url = System. getenv ("URL");
        String username = System. getenv ("USERNAME") ;
        String password = System. getenv ("PASSWORD") ;
        Connection c = DriverManager.getConnection(url, username, password);
        String sql = "DELETE FROM contas WHERE nIo_conta=?";
        PreparedStatement prepstm = c. prepareStatement(sql);
        prepstm.setLong (1, nro);
        int ret = prepstm. executeUpdate();
        System.out.println("Número de registros apagados: " + ret);
        c. close();
    }
}