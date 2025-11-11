package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/mvp";
    private static final String USER = "root";
    private static final String LOGIN = "senai";

    public Connection abrirConexao() {
        try {
            return DriverManager.getConnection(URL, USER, LOGIN);
        } catch (SQLException e) {
            System.err.printf("""
            Erro ao conectar ao banco de dados: %s%n""",
            e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("""
            Driver JDBC não encontrado!""");
            return null;
        }
    }

    public void fecharConexao(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.err.printf("""
                Erro ocorrido: %s%n""",
                e.getMessage());
            }
        }
    }

}