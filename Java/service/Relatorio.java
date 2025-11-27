package service;

import dao.ProdutoDAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    public void RelatorioDeEstoque() {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        List<String> linhas = produtoDAO.capturarEstoque();

        try {
            Files.write(Path.of("Java/relatorio.txt"), linhas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}