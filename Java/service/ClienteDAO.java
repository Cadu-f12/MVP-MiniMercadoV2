package service;

import model.Categoria;
import model.Cliente;
import model.ClientePF;
import model.ClientePJ;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {
    private final String sqlInsert;

    public ClienteDAO() {
        sqlInsert = "INSERT INTO clientes(tipo, nome, telefone, categoria, documento) VALUES (?, ?, ?, ?, ?)";
    }

    public void insert(String tipo, String nome, String telefone, Categoria categoria,  String documento) {
        try (Connection conn = Conexao.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {

            Cliente cliente;
            if (tipo.equals("PF")) {
                pstmt.setString(1, tipo);

                cliente = new ClientePF();
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
                cliente.setNivelFidelidade(categoria);
                cliente.setDocumento(documento);
            } else if (tipo.equals("PJ")) {
                pstmt.setString(1, tipo);

                cliente = new ClientePJ();
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
                cliente.setNivelFidelidade(categoria);
                cliente.setDocumento(documento);
            } else {
                throw new IllegalArgumentException("O tipo deve ser literalmente \"PF\" ou \"PJ\" apenas");
            }

            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getTelefone());

            switch (cliente.getNivelFidelidade()) {
                case NULO -> {
                    pstmt.setString(4, "Sem fidelidade");
                }
                case BRONZE -> {
                    pstmt.setString(4, "Bronze");
                }
                case PRATA -> {
                    pstmt.setString(4, "Prata");
                }
                case OURO -> {
                    pstmt.setString(4, "Ouro");
                }
            }

            pstmt.setString(5, documento);

            pstmt.executeUpdate();
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new RuntimeException("ERRO na integridade dos dados - " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}