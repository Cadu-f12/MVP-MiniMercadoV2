package view;

import service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DeletarProdutoView extends JFrame {
    private final JTextField txtCodigo;


    public DeletarProdutoView() {
        setTitle("Deletar Produto");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);


        add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        add(txtCodigo);


        JButton btnDeletar = new JButton("Excluir");
        add(btnDeletar);


        btnDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProdutoService service = new ProdutoService();
                    service.DeletarProduto(Integer.parseInt(txtCodigo.getText()));
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        setVisible(true);
    }
}
