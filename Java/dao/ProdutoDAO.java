package dao;

import model.Produto;
import util.Conexao;

import java.sql.*;

public class ProdutoDAO {
    private final String sqlInsert;
    private final String sqlSelect;
    private final String sqlUpdate;
    private final String sqlDelete;

    public ProdutoDAO() {
        sqlInsert = "INSERT INTO produtos (nome, codBarras, preco, estoque) VALUES (?, ?, ?, ?)";
        sqlSelect = "SELECT * FROM produtos WHERE id = ?";
        sqlUpdate = "UPDATE produtos SET nome = ?, codBarras = ?, preco = ?, estoque = ? WHERE id = ?";
        sqlDelete = "DELETE FROM produtos WHERE id = ?";
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
            throw new RuntimeException("ERRO na integridade dos dados - " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Produto select(int id) {
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Produto produto = new Produto();
            while(rs.next()) {
                produto.setIdProduto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setCodigoBarras(rs.getString("codBarras"));
            }

            rs.close();
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void update(int id, String nome, String codBarras, double preco, int estoque) {
        Produto produto = select(id);

        produto.setNome(nome);

        produto.setCodigoBarras(codBarras);

        produto.setPreco(preco);
        produto.setEstoque(estoque);

        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getCodigoBarras());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getEstoque());
            pstmt.setInt(5, produto.getidProduto());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection conn = Conexao.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}