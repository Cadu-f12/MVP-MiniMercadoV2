package model;

public class Produto {
    private int idProduto;
    private String nome;
    private String codigoBarras; // (Campo opcional)
    private double preco;
    private int estoque;

    public Produto() {}
    public Produto(int idProduto, String nome, String codigoBarras, double preco, int estoque) {
        setIdProduto(idProduto);
        setNome(nome);
        setCodigoBarras(codigoBarras);
        setPreco(preco);
        setEstoque(estoque);
    }

    public int getidProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        if (idProduto < 1) {
            throw new IllegalArgumentException("Não é permitido ID igual ou menor que zero");
        }
        this.idProduto = idProduto;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new NullPointerException("Este atributo não deve ser vazio");
        }
        
        for (char c : nome.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                throw new IllegalArgumentException("Apenas letras são permitidas");
            }
        }
        
        this.nome = nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras) {
        for (char c : codigoBarras.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Não são permitidos caracteres especiais e espaços, apenas números");
            }
        }

        this.codigoBarras = codigoBarras;
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

    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O atributo não deve ser negativo");
        }
        
        this.estoque = estoque;
    }
}