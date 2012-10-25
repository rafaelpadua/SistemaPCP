
package controllers;

import dao.ItemProdutoDao;
import entidades.Suprimento;
import dao.ProdutoDao;
import entidades.Produto;
import java.util.List;
import views.SuprimentoView;

public class SuprimentoController {
    
    private static SuprimentoController instancia = new SuprimentoController();
    private SuprimentoView view;
    private Suprimento materiais = new Suprimento();

    public SuprimentoController() {
    }

    /**
     * @return a instancia do controlador
     */
    public static SuprimentoController getInstancia() {
        return instancia;
    }

    /**
     * Exibe a interface gráfica do controlador
     */
    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new SuprimentoView(this);
        }
        view.setVisible(true);
    }

    public List<Produto> listarProdutos() {
        List<Produto> lista = new ProdutoDao().listar();
        return lista;
    }    
}
