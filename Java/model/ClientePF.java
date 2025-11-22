package model;

public class ClientePF extends Cliente{
    private String cpf;

    public ClientePF() {}
    public ClientePF(int idCliente, String nome, Categoria nivelFidelidade, String telefone, String cpf) {
        super(idCliente, nome, nivelFidelidade, telefone);

        setDocumento(cpf);
    }

    /* CPF */
    @Override
    public String getDocumento() {
        return this.cpf;
    }
    @Override
    public void setDocumento(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new NullPointerException("cpf inválido: valor null ou string vazia (\"\") detectado.");
        }

        // Verificação de caracteres especiais
        for (char caracter : cpf.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                throw new IllegalArgumentException("cpf inválido: contém caracteres não numéricos.");
            }
        }
        this.cpf = cpf;
    }
}