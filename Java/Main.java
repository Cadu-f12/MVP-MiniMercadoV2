import view.CadastroProdutoView;
import view.ConsultarProdutoView;
import view.DeletarProdutoView;
import view.EditarProdutoView;

class Main {
    public static void main(String[] args) {
        new CadastroProdutoView().setVisible(true);
        new ConsultarProdutoView();
        new EditarProdutoView();
        new DeletarProdutoView();

    }
}