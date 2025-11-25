package service;

import dao.ProdutoDAO;

public class ProdutoService {

    public void CadastrarProduto(String nome, String codBarras, double preco, int estoque) {
        // Aqui deveria entrar um metodo para verificar se o atributo nome já existe no banco de dados.

        ProdutoDAO produtoDAO = new ProdutoDAO();
        try {
            produtoDAO.insert(nome, codBarras, preco, estoque);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ConsultarProduto(int id) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.select(id);
    }

    public void EditarProduto(int id, String nome, String codBarras, double preco, int estoque) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.update(id, nome, codBarras, preco, estoque);
    }

    public void DeletarProduto(int id) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.delete(id);
    }
}