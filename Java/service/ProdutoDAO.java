package service;

import model.Produto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProdutoDAO {
    private final String sqlInsert;

    public ProdutoDAO() {
        sqlInsert = "INSERT INTO produtos (nome, codBarras, preco, estoque) VALUES (?, ?, ?, ?)";
    }

    public void insert(String nome, String codBarras, double preco, int estoque) {
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setCodigoBarras(codBarras);
            produto.setPreco(preco);
            produto.setEstoque(estoque);

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getCodigoBarras());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getEstoque());

            pstmt.executeUpdate();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.err.println("ERRO na integridade dos dados: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERRO (ClientesDAO/insert): " + e.getMessage());
        }
    }
}