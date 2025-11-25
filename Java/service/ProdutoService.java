package service;

import dao.ProdutoDAO;

public class ProdutoService {
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public void CadastrarProduto(String nome, String codBarras, double preco, int estoque) {
        // Aqui deveria entrar um metodo para verificar se o atributo nome já existe no banco de dados.


        try {
            produtoDAO.insert(nome, codBarras, preco, estoque);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ConsultarProduto(int id) {


        produtoDAO.select(id);
    }

    public void EditarProduto(int id, String nome, String codBarras, double preco, int estoque) {


        produtoDAO.update(id, nome, codBarras, preco, estoque);
    }

    public void DeletarProduto(int id) {


        produtoDAO.delete(id);
    }
}