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
            throw new NullPointerException("O campo não deve ser vazio");
        }

        // Verificação de caracteres especiais
        for (char caracter : cnpj.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                throw new IllegalArgumentException("Não são permitidos caracteres especiais, apenas números");
            }
        }
        this.cnpj = cnpj;
    }
}