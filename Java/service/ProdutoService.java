package service;

import dao.ProdutoDAO;

import java.sql.SQLException;

public class ProdutoService {
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public void CadastrarProduto(String nome, String codBarras, double preco, int estoque) {
        if (produtoDAO.existePorNome(nome)) {
            throw new RuntimeException("O produto " + nome + " já existe no sistema");
        }

        try {
            produtoDAO.insert(nome, codBarras, preco, estoque);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ConsultarProduto(int id) {
        if (!produtoDAO.existePorId(id)) {
            throw new RuntimeException("O produto do id " + id + " não existe no sistema");
        }

        produtoDAO.select(id);
    }

    public void EditarProduto(int id, String nome, String codBarras, double preco, int estoque) {
        if (!produtoDAO.existePorId(id)) {
            throw new RuntimeException("O produto do id " + id + " não existe no sistema");
        }

        produtoDAO.update(id, nome, codBarras, preco, estoque);
    }

    public void DeletarProduto(int id) {
        if (!produtoDAO.existePorId(id)) {
            throw new RuntimeException("O produto do id " + id + " não existe no sistema");
        }

        produtoDAO.delete(id);
    }
}