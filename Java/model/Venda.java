package model;

import java.time.LocalDateTime;

public class Venda {
    private int idVenda;
    private int idCliente; // Chave estrangeira -> Cliente
    private int idItensVenda; // Chave estrangeira -> ItensVenda
    private LocalDateTime data;
    private double desconto; // Caso o desconto seja null, significa sem desconto
    private double total; // total = subtotal - desconto

    public Venda() {}
    public Venda(int idVenda, int idCliente, int idItensVenda, LocalDateTime data, double desconto, double total) {
        setIdVenda(idVenda);
        setIdCliente(idCliente);
        setIdItensVenda(idItensVenda);
        setData(data);
        setDesconto(desconto);
        setTotal(total);
    }

    public int getIdVenda() {
        return idVenda;
    }
    public void setIdVenda(int idVenda) {
        if (idVenda < 1) {
            throw new IllegalArgumentException("id_venda inválido: valor menor que 1 detectado.");
        }
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        if (idCliente < 1) {
            throw new IllegalArgumentException("venda.id_cliente inválido: valor <= 0 detectado.");
        }
        this.idCliente = idCliente;
    }

    public int getIdItensVenda() {
        return idItensVenda;
    }
    public void setIdItensVenda(int idItensVenda) {
        if (idItensVenda < 1) {
            throw new IllegalArgumentException("id_itensVenda inválido: valor <= 0 detectado.");
        }
        this.idItensVenda = idItensVenda;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        if (data == null) {
            throw new NullPointerException("data inválida: valor null detectado.");
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
            throw new IllegalArgumentException("desconto inválido: valor menor que 0.01 detectado.");
        }
        this.total = total;
    }
}