package model;

import java.time.LocalDateTime;

public class Venda {
    private final int idVenda;
    private int idCliente; // Chave estrangeira -> Cliente
    private int idItensVenda; // Chave estrangeira -> ItensVenda
    private LocalDateTime data;
    private double desconto;
    private double total;

    public Venda(int idVenda) {
        if (idVenda < 1) {
            throw new IllegalArgumentException("Não é permitido ID igual ou menor que zero");
        }

        this.idVenda = idVenda;
    }
    public Venda(int idVenda, int idCliente, int idItensVenda, LocalDateTime data, double desconto, double total) {
        if (idVenda < 1) {
            throw new IllegalArgumentException("Não é permitido ID igual ou menor que zero");
        }

        this.idVenda = idVenda;
        setIdCliente(idCliente);
        setIdItensVenda(idItensVenda);
        setData(data);
        setDesconto(desconto);
        setTotal(total);
    }

    public int getIdVenda() {
        return idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        if (idCliente < 1) {
            throw new IllegalArgumentException("Não é permitido ID igual ou menor que zero");
        }

        this.idCliente = idCliente;
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

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        if (data == null) {
            throw new NullPointerException("Este atributo não deve ser vazio");
        }

        this.data = data;
    }

    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        if (desconto < 0.01) {
            throw new IllegalArgumentException("Neste atributo não é permitido valores iguais ou menores que zero");
        }

        this.desconto = desconto;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        if (total < 0.01) {
            throw new IllegalArgumentException("Neste atributo não é permitido valores iguais ou menores que zero");
        }

        this.total = total;
    }
}