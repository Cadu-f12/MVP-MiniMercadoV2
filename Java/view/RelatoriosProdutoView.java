package view;

import service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatoriosProdutoView extends JFrame {

    private JButton btnRelatorioEstoque;
    private JButton btnCatalogoProdutos;

    public RelatoriosProdutoView() {
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
                ProdutoService produtoService = new ProdutoService();
                produtoService.capturarEstoque();
            }
        });

        btnCatalogoProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutoService produtoService = new ProdutoService();
                produtoService.capturarPrecos();
            }
        });

        painel.add(btnRelatorioEstoque);
        painel.add(btnCatalogoProdutos);

        add(painel);
    }
}

