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
            throw new IllegalArgumentException("id_produto inválido: valor <= 0 detectado.");
        }
        this.idProduto = idProduto;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new NullPointerException("nome inválido: valor null ou string vazia (\"\") detectado.");
        }
        
        for (char c : nome.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                throw new IllegalArgumentException("nome inválido: contém números ou caracteres especiais.");
            }
        }
        
        this.nome = nome;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras) {
        if (codigoBarras != null) {
            if (codigoBarras.isEmpty()) {
                throw new NullPointerException("codBarras inválido: string vazia (\"\") detectada.");
            }
            for (char c : codigoBarras.toCharArray()) {
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException("codBarras inválido: contém caracteres não numéricos.");
                }
            }
        }
        this.codigoBarras = codigoBarras;
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

    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("estoque inválido: valor negativo detectado.");
        }
        this.estoque = estoque;
    }

    public String getCodigo() {
        return "";
    }
}