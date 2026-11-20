import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GestorDbCheck {
    private static int count;
    private static void check(boolean ok, String msg) {
        count++;
        if (!ok) throw new AssertionError(msg);
    }

    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        check(java.sql.DriverManager.getDriver("jdbc:postgresql://127.0.0.1/test") != null, "PostgreSQL JDBC driver loaded");

        if (System.getenv("GESTOR_TEST_DATABASE") != null) {
            try (Connection cn = ConexionBD.conectar()) {
                try (Statement st = cn.createStatement()) {
                    st.execute("CREATE TEMP TABLE campeonato (\"NOMBRE\" text PRIMARY KEY)");
                    st.execute("CREATE TEMP TABLE estadio (\"NOMBRE\" text PRIMARY KEY, \"CAPACIDAD\" numeric)");
                }
                try (PreparedStatement ps = cn.prepareStatement("INSERT INTO campeonato (\"NOMBRE\") VALUES (?)")) {
                    ps.setString(1, "Liga Nacional");
                    check(ps.executeUpdate() == 1, "Insert campeonato");
                }
                try (PreparedStatement ps = cn.prepareStatement("INSERT INTO estadio (\"NOMBRE\", \"CAPACIDAD\") VALUES (?, ?)")) {
                    ps.setString(1, "Estadio Carlos Ugalde");
                    ps.setInt(2, 5600);
                    check(ps.executeUpdate() == 1, "Insert estadio");
                }
                try (PreparedStatement ps = cn.prepareStatement("SELECT \"CAPACIDAD\" FROM estadio WHERE \"NOMBRE\" = ?")) {
                    ps.setString(1, "Estadio Carlos Ugalde");
                    try (ResultSet rs = ps.executeQuery()) {
                        check(rs.next() && rs.getInt(1) == 5600, "Query estadio");
                    }
                }
            }
        }
        System.out.println("PASS: " + count + " assertions");
    }
}
