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
    private final ProdutoService produtoService = new ProdutoService();

    public void RelatorioDeEstoque() {
        List<String> linhas = produtoService.capturarEstoque();

        try {
            Files.write(Path.of("Java/estoque.txt"), linhas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void RelatorioDeCatalogo() {
        List<String> linhas = produtoService.capturarPrecos();

        try {
            Files.write(Path.of("Java/catalogo.txt"), linhas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}