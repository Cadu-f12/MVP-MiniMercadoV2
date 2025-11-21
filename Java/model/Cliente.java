package model;

public abstract class Cliente {
    private final int idCliente;
    private String nome;
    private String telefone;
    private Categoria nivelFidelidade;

    public Cliente(int idCliente) {
        if (idCliente < 1) {
            throw new IllegalArgumentException("Não é permitido ID igual ou menor que zero");
        }

        this.idCliente = idCliente;
    }
    public Cliente(int idCliente, String nome, Categoria nivelFidelidade, String telefone) {
        if (idCliente < 1) {
            throw new IllegalArgumentException("Não é permitido ID negativo");
        }

        this.idCliente = idCliente;
        setNome(nome);
        setNivelFidelidade(nivelFidelidade);
        setTelefone(telefone);
    }

    /* ID do cliente */
    public int getIdCliente() {
        return idCliente;
    }

    /* Nome */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new NullPointerException("Este atributo não deve ser vazio");
        }

        // Verificação de números no nome
        for (char caracter : nome.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != ' ') {
                throw new IllegalArgumentException("Apenas letras são permitidas");
            }
        }

        this.nome = nome;
    }

    /* Telefone */
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new NullPointerException("Este atributo não deve ser vazio");
        }

        // Veficação de caracteres especiais
        for (char caracter : telefone.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                throw new IllegalArgumentException("Não são permitidos caracteres especiais, apenas números");
            }
        }

        this.telefone = telefone;
    }

    /* Nível de fidelidade */
    public Categoria getNivelFidelidade() {
        return nivelFidelidade;
    }
    public void setNivelFidelidade(Categoria nivelFidelidade) {
        if (nivelFidelidade == null) {
            throw new NullPointerException("Este atributo não deve ser vazio");
        }
        this.nivelFidelidade = nivelFidelidade;
    }

    /* CPF & CNPJ */
    abstract public String getDocumento();
    abstract public void setDocumento(String documento);
}