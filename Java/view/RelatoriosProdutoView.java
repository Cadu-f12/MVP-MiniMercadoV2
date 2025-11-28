package view;

import service.ProdutoService;
import service.Relatorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatoriosProdutoView extends JFrame {
    private final Relatorio relatorio;
    private JButton btnRelatorioEstoque;
    private JButton btnCatalogoProdutos;

    public RelatoriosProdutoView() {
        relatorio = new Relatorio();
        setTitle("Relatórios de Produto");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(2, 1, 10, 10));

        btnRelatorioEstoque = new JButton("Criar Relatório de Estoque");
        btnCatalogoProdutos = new JButton("Criar Catálogo de Produtos");

        btnRelatorioEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relatorio.RelatorioDeEstoque();
            }
        });

        btnCatalogoProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relatorio.RelatorioDeCatalogo();
            }
        });

        painel.add(btnRelatorioEstoque);
        painel.add(btnCatalogoProdutos);

        add(painel);
    }
}

