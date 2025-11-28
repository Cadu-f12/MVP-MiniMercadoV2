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
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel do formulário
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // === CÓDIGO ===
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelForm.add(new JLabel("Código:"), gbc);

        gbc.gridx = 1;
        txtCodigo = new JTextField(20);
        panelForm.add(txtCodigo, gbc);

        // === CÓDIGO DE BARRAS ===
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelForm.add(new JLabel("Código de Barras:"), gbc);

        gbc.gridx = 1;
        txtCodigoBarras = new JTextField(20);
        panelForm.add(txtCodigoBarras, gbc);

        // === NOME ===
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelForm.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        txtNome = new JTextField(20);
        panelForm.add(txtNome, gbc);

        // === PREÇO ===
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelForm.add(new JLabel("Preço:"), gbc);

        gbc.gridx = 1;
        txtPreco = new JTextField(20);
        panelForm.add(txtPreco, gbc);

        // === ESTOQUE ===
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelForm.add(new JLabel("Quantidade em Estoque:"), gbc);

        gbc.gridx = 1;
        txtEstoque = new JTextField(20);
        panelForm.add(txtEstoque, gbc);

        add(panelForm, BorderLayout.CENTER);

        // Painel dos botões (inferior)
        JPanel panelBotoes = new JPanel();

        JButton btnBuscar = new JButton("Carregar Dados");
        JButton btnSalvar = new JButton("Salvar Alterações");

        panelBotoes.add(btnBuscar);
        panelBotoes.add(btnSalvar);

        add(panelBotoes, BorderLayout.SOUTH);


        /* ======== SUAS FUNCIONALIDADES (INALTERADAS) ======== */

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
                            Integer.parseInt(txtCodigo.getText()),
                            txtNome.getText(),
                            txtCodigoBarras.getText(),
                            Double.parseDouble(txtPreco.getText()),
                            Integer.parseInt(txtEstoque.getText())
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