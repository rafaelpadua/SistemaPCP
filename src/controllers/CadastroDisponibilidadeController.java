
package controllers;

import java.util.List;
import entidades.Disponibilidade;
import views.CadastroDisponibilidade;


/**
 *
 * @author Rafael
 */
import dao.CadastroDisponibilidadeDao;
public class CadastroDisponibilidadeController {
    
    private static CadastroDisponibilidadeController instancia = new CadastroDisponibilidadeController();
    private CadastroDisponibilidade view;
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
            view = new CadastroDisponibilidade(this);
        }
        view.setVisible(true);
    }

    public List<Disponibilidade> listarDisponibilidade() {

        List<Disponibilidade> lista = new CadastroDisponibilidadeDao().listar();
        return lista;
    }
    
    public List CalculandoDisponibilidadePorMes(){
    
        List disponivel =  new CadastroDisponibilidadeDao().listarPorMes();
        return disponivel;
    }

    /**
     * Salva o cliente no banco de dados
     */
    public void salvar() {

      view.sincronizarModelComView(disponib);
       System.out.println(disponib.getCodigo());
       System.out.println(disponib.getMes());
       System.out.println(disponib.getAno());
       System.out.println(disponib.getDia());
       System.out.println(disponib.getHoras());
       
        if(disponib.getCodigo() == null){
            System.out.println("Disponibilidade Constroller entrando...");
        new CadastroDisponibilidadeDao().salvar(disponib);
        
    }else{
        new CadastroDisponibilidadeDao().atualizar(disponib);
        }
    }

    public void atualizarItem_Produto() {
//        if (view.sincronizarModelComView(disponib)) {
//            if ((disponib.getItem() != null) && disponib.getProduto() != null) {
//                new Item_ProdutoDao().atualizar(disponib);
//            }
//        }    
    }    
}
