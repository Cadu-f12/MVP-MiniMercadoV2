import view.CadastroProdutoView;
import view.ConsultarProdutoView;
import view.DeletarProdutoView;
import view.EditarProdutoView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // ====== JANELA PRINCIPAL ======
        JFrame frame = new JFrame("Mini Mercado - Menu Principal");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel de fundo
        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12); // espaçamento entre botões

        // ======= ESTILO DOS BOTÕES =======
        Font fonteBotao = new Font("Segoe UI", Font.BOLD, 16);

        JButton btnCadastrar = new JButton("Cadastrar Produto");
        JButton btnConsultar = new JButton("Consultar Produto");
        JButton btnEditar = new JButton("Editar Produto");
        JButton btnDeletar = new JButton("Deletar Produto");

        JButton[] botoes = { btnCadastrar, btnConsultar, btnEditar, btnDeletar };

        for (JButton b : botoes) {
            b.setPreferredSize(new Dimension(250, 45));
            b.setFont(fonteBotao);
            b.setFocusPainted(false);
            b.setBackground(new Color(52, 152, 219));
            b.setForeground(Color.WHITE);
            b.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Efeito hover (mouse por cima)
            b.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    b.setBackground(new Color(41, 128, 185));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    b.setBackground(new Color(52, 152, 219));
                }
            });
        }

        // ====== AÇÕES DOS BOTÕES ======
        btnCadastrar.addActionListener(e -> new CadastroProdutoView().setVisible(true));
        btnConsultar.addActionListener(e -> new ConsultarProdutoView().setVisible(true));
        btnEditar.addActionListener(e -> new EditarProdutoView().setVisible(true));
        btnDeletar.addActionListener(e -> new DeletarProdutoView().setVisible(true));

        // ====== ADICIONA OS BOTÕES NA TELA ======
        gbc.gridy = 0;
        panel.add(btnCadastrar, gbc);
        gbc.gridy = 1;
        panel.add(btnConsultar, gbc);
        gbc.gridy = 2;
        panel.add(btnEditar, gbc);
        gbc.gridy = 3;
        panel.add(btnDeletar, gbc);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
