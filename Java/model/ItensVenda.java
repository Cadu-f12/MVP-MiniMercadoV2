package model;

import java.util.Date;

public class ItensVenda {
    private int idItensVenda;
    private String nomeProduto;
    private int quantidade;
    private double preco; // preço = quantidade * produto

    public ItensVenda() {}
    public ItensVenda(int idItensVenda, String nomeProduto, int quantidade, double preco) {
        setIdItensVenda(idItensVenda);
        setNomeProduto(nomeProduto);
        setQuantidade(quantidade);
        setPreco(preco);
    }

    public int getIdItensVenda() {
        return idItensVenda;
    }
    public void setIdItensVenda(int idItensVenda) {
        if (idItensVenda < 1) {
            throw new IllegalArgumentException("id_itensVenda inválido: valor <= 0 detectado.");
        }
        this.idItensVenda = idItensVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        if (nomeProduto == null || nomeProduto.isEmpty()) {
            throw new NullPointerException("nome_produto inválido: valor null ou string vazia (\"\") detectado.");
        }

        // Verificação de números no nome
        for (char caracter : nomeProduto.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != ' ') {
                throw new IllegalArgumentException("nome inválido: contém números ou caracteres especiais.");
            }
        }

        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if (quantidade < 1) {
            throw new IllegalArgumentException("quantidade inválida: valor menor que 1 detectado.");
        }

        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco < 0.01) {
            throw new IllegalArgumentException("preco inválido: valor menor que 0.01 detectado.");
        }

        this.preco = preco;
    }
}
