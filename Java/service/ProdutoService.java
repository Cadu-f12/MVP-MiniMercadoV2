package service;

import dao.ProdutoDAO;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

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

    public Produto ConsultarProduto(int id) {
        if (!produtoDAO.existePorId(id)) {
            throw new RuntimeException("O produto do id " + id + " não existe no sistema");
        }


        return produtoDAO.select(id);
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

    public List<String> capturarEstoque() {
        ArrayList<Produto> produtos = produtoDAO.listarProdutos();

        List<String> linhas = new ArrayList<>();
        linhas.add("RELATÓRIO DE ESTOQUE");
        linhas.add("-".repeat(30));
        linhas.add(String.format("| %-20s | %-7s |", "PRODUTO", "ESTOQUE"));

        for (Produto produto : produtos) {
            linhas.add(String.format("| %-20s | %7d |", produto.getNome(), produto.getEstoque()));
        }

        return linhas;
    }
}