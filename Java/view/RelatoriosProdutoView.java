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



        btnRelatorioEstoque.addActionListener(e -> {

            JDialog loading = criarLoading();

            SwingWorker<Void, Void> worker = new SwingWorker<>() {

                @Override
                protected Void doInBackground() {
                    relatorio.RelatorioDeEstoque(); // SEU método pesado
                    return null;
                }

                @Override
                protected void done() {
                    loading.dispose();
                    JOptionPane.showMessageDialog(null, "Relatório de estoque gerado com sucesso!");
                }
            };

            worker.execute();
            loading.setVisible(true);
        });


        btnCatalogoProdutos.addActionListener(e -> {

            JDialog loading = criarLoading();

            SwingWorker<Void, Void> worker = new SwingWorker<>() {

                @Override
                protected Void doInBackground() {
                    relatorio.RelatorioDeCatalogo();
                    return null;
                }

                @Override
                protected void done() {
                    loading.dispose();
                    JOptionPane.showMessageDialog(null, "Relatório de catálogo gerado com sucesso!");
                }
            };

            worker.execute();
            loading.setVisible(true);
        });


        painel.add(btnRelatorioEstoque);
        painel.add(btnCatalogoProdutos);

        add(painel);
    }

    private JDialog criarLoading() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Gerando relatório...");
        dialog.setSize(300, 100);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        JLabel label = new JLabel("Aguarde, gerando relatório...", SwingConstants.CENTER);
        dialog.add(label);

        return dialog;
    }

}

