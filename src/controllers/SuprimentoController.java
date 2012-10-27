
package controllers;

import dao.ProdutoDao;
import entidades.Suprimento;
import dao.SuprimentoDao;
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
    
    public List ListarSuprimentos(){
    List<Suprimento> lista = new SuprimentoDao().listarSuprimento();
    return  lista;
    }
    
    public List<Produto> listaProduto(){
    
    List<Produto> lista = new ProdutoDao().listar();
    return lista;
    }

    public List<Suprimento> listarSuprimentos(Object descricao) {
        
        List<Suprimento> lista = new SuprimentoDao().listarSuprimentosPorNome(15);
        System.out.println(lista);
        
        return null;
    }
}
      