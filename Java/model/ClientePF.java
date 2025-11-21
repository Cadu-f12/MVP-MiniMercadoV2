package model;

public class ClientePF extends Cliente{
    private String cpf;

    public ClientePF(int idCliente) {
        super(idCliente);
    }
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
            throw new NullPointerException("O campo não deve ser vazio");
        }

        // Verificação de caracteres especiais
        for (char caracter : cpf.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                throw new IllegalArgumentException("Não são permitidos caracteres especiais, apenas números");
            }
        }

        this.cpf = cpf;
    }
}