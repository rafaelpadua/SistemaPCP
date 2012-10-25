
package controllers;

import java.util.List;
import entidades.Disponibilidade;
import views.DisponibilidadeView;


/**
 *
 * @author Rafael
 */
import dao.CadastroDisponibilidadeDao;
public class CadastroDisponibilidadeController {
    
    private static CadastroDisponibilidadeController instancia = new CadastroDisponibilidadeController();
    private DisponibilidadeView view;
    private Disponibilidade disponib = new Disponibilidade();

    public CadastroDisponibilidadeController() {
    }

    /**
     * @return a instancia do controlador
     */
    public static CadastroDisponibilidadeController getInstancia() {
        return instancia;
    }

    /**
     * Exibe a interface gráfica do controlador
     */
    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new DisponibilidadeView(this);
        }
        view.setVisible(true);
    }
    
    
    public void excluir(){
    
        view.sincronizarModelComView(disponib);
        if (disponib.getCodigo() != null){
        new CadastroDisponibilidadeDao().excluir(disponib);
        }
    
    }
    
    /**
     * Salva o cliente no banco de dados
     */
    public void salvar() {

      view.sincronizarModelComView(disponib);       
        if(disponib.getCodigo() == null){
        new CadastroDisponibilidadeDao().salvar(disponib);     
    }else{
        new CadastroDisponibilidadeDao().atualizar(disponib);
        }
    }
    
        public List<Disponibilidade> listarDisponibilidade() {

        List<Disponibilidade> lista = new CadastroDisponibilidadeDao().listar();
        return lista;
    }
    
    public List CalculandoDisponibilidadePorMes(){
    
        List<Disponibilidade> disponivel =  new CadastroDisponibilidadeDao().listarPorMes();
        return disponivel;     
    }
}
