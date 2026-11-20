import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Conexión centralizada para GestorDeportivo compatible con PostgreSQL 17 y 18 (SCRAM-SHA-256).
 * Configurable mediante GESTOR_JDBC_URL, GESTOR_DATABASE, GESTOR_USER y GESTOR_PASSWORD.
 */
public final class ConexionBD {
    private ConexionBD() {}

    private static String env(String key, String fallback) {
        String value = System.getenv(key);
        return value == null ? fallback : value;
    }

    public static Connection conectar() throws ClassNotFoundException, SQLException {
        return conectar(env("GESTOR_PASSWORD", ""));
    }

    public static Connection conectar(String fallbackPassword) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String dbName = env("GESTOR_DATABASE", "GestorDeportivo");
        String url = env("GESTOR_JDBC_URL", "jdbc:postgresql://127.0.0.1:5432/" + dbName);
        Properties props = new Properties();
        props.setProperty("user", env("GESTOR_USER", "postgres"));
        props.setProperty("password", env("GESTOR_PASSWORD", fallbackPassword == null ? "" : fallbackPassword));
        props.setProperty("connectTimeout", "5");
        return DriverManager.getConnection(url, props);
    }
}
