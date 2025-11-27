package view;

import service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProdutoView extends JFrame {

    // Campos da tela
    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtCodigo;
    private JTextField txtEstoque;

    // Variáveis que outras classes podem acessar
    public static String nomeProduto;
    public static double precoProduto;
    public static String codigoBarras;
    public static int quantidadeEstoque;

    public CadastroProdutoView() {
        setTitle("Cadastro de Produto");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        // Painel do formulário
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelForm.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        txtNome = new JTextField(20);
        panelForm.add(txtNome, gbc);

        // Preço
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelForm.add(new JLabel("Preço:"), gbc);

        gbc.gridx = 1;
        txtPreco = new JTextField(20);
        panelForm.add(txtPreco, gbc);

        // Código de barras
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelForm.add(new JLabel("Código de Barras:"), gbc);

        gbc.gridx = 1;
        txtCodigo = new JTextField(20);
        panelForm.add(txtCodigo, gbc);

        // Estoque
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelForm.add(new JLabel("Quantidade em Estoque:"), gbc);

        gbc.gridx = 1;
        txtEstoque = new JTextField(20);
        panelForm.add(txtEstoque, gbc);

        add(panelForm, BorderLayout.CENTER);

        // Painel dos botões
        JPanel panelBotoes = new JPanel();

        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnVoltar);

        add(panelBotoes, BorderLayout.SOUTH);

        // Botão Salvar
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDados();
            }
        });

        // Botão Voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });
    }

    // Método que salva os dados nas variáveis públicas
    private void salvarDados() {
        try {
            ProdutoService produtoService = new ProdutoService();

            String nome;
            String codigo;
            String preco;
            String estoque;

            if (txtNome.getText().isEmpty()) {
                throw new RuntimeException("O campo nome não deve ser vazio!");
            } else {
                nome = txtNome.getText();
            }
            if (txtCodigo.getText().isEmpty()) {
                codigo = null;
            } else {
                codigo = txtCodigo.getText();
            }
            if (txtPreco.getText().isEmpty()) {
                throw new RuntimeException("O campo preço não deve ser vazio!");
            } else {
                preco = txtPreco.getText();
            }
            if (txtEstoque.getText().isEmpty()) {
                throw new RuntimeException("O campo estoque não deve ser vazio!");
            } else {
                estoque = txtEstoque.getText();
            }

            produtoService.CadastrarProduto(
                    nome,
                    codigo,
                    Double.parseDouble(preco),
                    Integer.parseInt(estoque)
            );

            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao capturar dados!\n" + e.getMessage());
        }
    }
}