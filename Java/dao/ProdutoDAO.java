package dao;

import model.Produto;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final String sqlInsert;
    private final String sqlSelect;
    private final String sqlUpdate;
    private final String sqlDelete;
    private final String sqlCheckId;
    private final String sqlCheckName;

    public ProdutoDAO() {
        sqlInsert = "INSERT INTO produtos (nome, codBarras, preco, estoque) VALUES (?, ?, ?, ?)";
        sqlSelect = "SELECT * FROM produtos WHERE id = ?";
        sqlUpdate = "UPDATE produtos SET nome = ?, codBarras = ?, preco = ?, estoque = ? WHERE id = ?";
        sqlDelete = "DELETE FROM produtos WHERE id = ?";
        sqlCheckId = "SELECT 1 FROM produtos WHERE id = ?";
        sqlCheckName = "SELECT 1 FROM produtos WHERE nome = ?";
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
            throw new RuntimeException("ERRO na integridade dos dados!\n" + e.getMessage());
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

    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();

        String consulta = "SELECT * FROM produtos";
        try (Connection conn = Conexao.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setEstoque(rs.getInt("estoque"));
                produto.setCodigoBarras(rs.getString("codBarras"));
                produtos.add(produto);
            }

            return produtos;
        } catch (Exception e) {
            throw new RuntimeException(e);
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

    public List<String> capturarEstoque() {
        ArrayList<Produto> produtos = listarProdutos();

        List<String> linhas = new ArrayList<>();

        return null;
    }

    public boolean existePorId(int id) {
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCheckId)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // true se encontrou, false se não

        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar existência do produto.", e);
        }
    }

    public boolean existePorNome(String nome) {
        try (Connection conn = Conexao.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCheckName)) {

            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar nome do produto.", e);
        }
    }
}