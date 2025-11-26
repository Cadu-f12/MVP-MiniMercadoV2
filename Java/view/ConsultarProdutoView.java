package view;

import model.Produto;
import service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConsultarProdutoView extends JFrame {
    private final JTextField txtCodigo;
    private final JTextArea txtResultado;


    public ConsultarProdutoView() {
        setTitle("Consultar Produto");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);


        JPanel topo = new JPanel(new FlowLayout());
        topo.add(new JLabel("Código:"));
        txtCodigo = new JTextField(10);
        topo.add(txtCodigo);
        JButton btnBuscar = new JButton("Buscar");
        topo.add(btnBuscar);
        add(topo, BorderLayout.NORTH);


        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        add(new JScrollPane(txtResultado), BorderLayout.CENTER);


        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProdutoService service = new ProdutoService();
                    String codigo = txtCodigo.getText();
                    Produto p = service.ConsultarProduto(Integer.parseInt(codigo));
                    if (p != null) {
                        txtResultado.setText(
                                "Nome: " + p.getNome() + "\n" +
                                        "Código: " + p.getCodigo() + "\n" +
                                        "Preço: " + p.getPreco() + "\n" +
                                        "Estoque: " + p.getEstoque()
                        );
                    } else {
                        txtResultado.setText("Produto não encontrado.");
                    }
                } catch (Exception ex) {
                    txtResultado.setText("Erro: " + ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
