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
            throw new IllegalArgumentException("Não é permitido ID igual ou menor que zero");
        }
        this.idItensVenda = idItensVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        if (nomeProduto == null || nomeProduto.isEmpty()) {
            throw new NullPointerException("Este atributo não deve ser vazio");
        }

        // Verificação de números no nome
        for (char caracter : nomeProduto.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != ' ') {
                throw new IllegalArgumentException("Apenas letras são permitidas");
            }
        }

        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if (quantidade < 1) {
            throw new IllegalArgumentException("Não é permitido ID igual ou menor que zero");
        }

        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco < 0.01) {
            throw new IllegalArgumentException("O atributo não deve ser igual ou menor que zero");
        }

        this.preco = preco;
    }
}
