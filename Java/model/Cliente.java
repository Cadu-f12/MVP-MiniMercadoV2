package model;

public abstract class Cliente {
    private int idCliente;
    private String nome;
    private String telefone; // (Campo opcional)
    private Categoria nivelFidelidade;

    public Cliente() {}
    public Cliente(int idCliente, String nome, Categoria nivelFidelidade, String telefone) {
        setIdCliente(idCliente);
        setNome(nome);
        setNivelFidelidade(nivelFidelidade);
        setTelefone(telefone);
    }

    /* ID do cliente */
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        if (idCliente < 1) {
            throw new IllegalArgumentException("id_cliente inválido: valor <= 0 detectado.");
        }

        this.idCliente = idCliente;
    }

    /* Nome */
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new NullPointerException("nome inválido: valor vazio (\"\") ou null detectado.");
        }

        // Verificação de números no nome
        for (char caracter : nome.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != ' ') {
                throw new IllegalArgumentException("nome inválido: contém números ou caracteres especiais não permitidos.");
            }
        }

        this.nome = nome;
    }

    /* Telefone */
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if (telefone != null) {
            if (telefone.isEmpty()) {
                throw new NullPointerException("telefone inválido: string vazia (\"\") detectada.");
            }
            for (char caracter : telefone.toCharArray()) {
                if (!Character.isDigit(caracter)) {
                    throw new IllegalArgumentException("telefone inválido: contém caracteres não numéricos.");
                }
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
            throw new NullPointerException("nivelFidelidade inválido: valor null detectado.");
        }
        this.nivelFidelidade = nivelFidelidade;
    }

    /* CPF & CNPJ */
    abstract public String getDocumento();
    abstract public void setDocumento(String documento);
}