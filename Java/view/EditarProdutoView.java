package view;

import model.Produto;
import service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditarProdutoView extends JFrame {
    private final JTextField txtCodigo;
    private final JTextField txtNome;
    private final JTextField txtPreco;
    private final JTextField txtEstoque;
    private final JTextField txtCodigoBarras;


    public EditarProdutoView() {
        setTitle("Editar Produto");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));
        setLocationRelativeTo(null);


        add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        add(txtCodigo);


        add(new JLabel("Codigo de Barras:"));
        txtCodigoBarras = new JTextField();
        add(txtCodigoBarras);

        JButton btnBuscar = new JButton("Carregar Dados");
        add(btnBuscar);
        add(new JLabel(""));


        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);


        add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        add(txtPreco);


        add(new JLabel("Estoque:"));
        txtEstoque = new JTextField();
        add(txtEstoque);


        JButton btnSalvar = new JButton("Salvar Alterações");
        add(btnSalvar);


        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtCodigo.getText().isEmpty()) {
                        throw new RuntimeException("código inválido: o campo não deve ser vazio!");
                    }
                    for (char c : txtCodigo.getText().toCharArray()) {
                        if (Character.isLetter(c)) {
                            throw new IllegalArgumentException("código inválido: contém letras ou caracteres especiais.");
                        }
                    }

                    ProdutoService service = new ProdutoService();
                    Produto p = service.ConsultarProduto(Integer.parseInt(txtCodigo.getText()));

                    txtNome.setText(p.getNome());
                    txtCodigoBarras.setText(p.getCodigoBarras());
                    txtPreco.setText(String.valueOf(p.getPreco()));
                    txtEstoque.setText(String.valueOf(p.getEstoque()));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtCodigo.getText().isEmpty()) {
                        throw new RuntimeException("código inválido: o campo não deve ser vazio!");
                    }
                    for (char c : txtCodigo.getText().toCharArray()) {
                        if (Character.isLetter(c)) {
                            throw new IllegalArgumentException("código inválido: contém letras ou caracteres especiais.");
                        }
                    }
                    ProdutoService service = new ProdutoService();

                    service.EditarProduto(
                        Integer.parseInt(txtCodigo.getText()),  // id
                        txtNome.getText(),                      // nome
                        txtCodigoBarras.getText(),              // codBarras
                        Double.parseDouble(txtPreco.getText()), // preco
                        Integer.parseInt(txtEstoque.getText())  // estoque
                    );

                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });


        setVisible(true);
    }
}