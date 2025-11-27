package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    public void CriarRelatorio() {
        List<String> linhas = new ArrayList<>();

        linhas.add("RELATÓRIO DE ESTOQUE");
        linhas.add("---------------");
        linhas.add("Produto: Arroz");
        linhas.add("Produto: Feijão");


        try {
            Files.write(Path.of("Java/relatorio.txt"), linhas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

