package model;

public class ClientePJ extends Cliente{
    private String cnpj;

    public ClientePJ() {}
    public ClientePJ(int idCliente, String nome, Categoria nivelFidelidade, String telefone, String cnpj) {
        super(idCliente, nome, nivelFidelidade, telefone);

        setDocumento(cnpj);
    }

    /* CNPJ */
    @Override
    public String getDocumento() {
        return this.cnpj;
    }
    @Override
    public void setDocumento(String cnpj) {
        if (cnpj == null || cnpj.isEmpty()) {
            throw new NullPointerException("cnpj inválido: valor null ou string vazia (\"\") detectado.");
        }

        // Verificação de caracteres especiais
        for (char caracter : cnpj.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                throw new IllegalArgumentException("cnpj inválido: contém caracteres não numéricos.");
            }
        }
        this.cnpj = cnpj;
    }
}