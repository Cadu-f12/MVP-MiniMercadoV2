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
                    if (txtCodigo.getText().isEmpty()) {
                        throw new IllegalArgumentException("código inválido: o campo não deve ser vazio!");
                    }
                    for (char c : txtCodigo.getText().toCharArray()) {
                        if (Character.isLetter(c)) {
                            throw new IllegalArgumentException("código inválido: contém letras ou caracteres especiais.");
                        }
                    }

                    ProdutoService service = new ProdutoService();
                    Produto p = service.ConsultarProduto(Integer.parseInt(txtCodigo.getText()));

                    txtResultado.setText(
                        "Nome: " + p.getNome() + "\n" +
                        "Código: " + p.getCodigoBarras() + "\n" +
                        "Preço: " + p.getPreco() + "\n" +
                        "Estoque: " + p.getEstoque()
                    );
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
