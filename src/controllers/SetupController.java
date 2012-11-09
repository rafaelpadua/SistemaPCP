/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CadasroSetupDao;
import dao.ProdutoDao;
import entidades.Produto;
import entidades.Setup;
import java.util.List;
import views.PlanejamentoView;
import views.SetupView;

/**
 *
 * @author Rafael
 */
public class SetupController {
    
    private static SetupController instancia = new SetupController();
    private SetupView view;
    private Setup setup = new Setup();
    
    public SetupController(){
    }
    
    public static SetupController getInstancia() {
        return instancia;
    }
    
    public void exibirInterfaceGrafica(){

        if(view == null){
            view = new SetupView(this);
        }
        view.setVisible(true);
    }
    
    public void salvar(){
        view.sincronizarModelComView(setup);
        if (setup.getCodigo() == null){
            new CadasroSetupDao().salvar(setup);
        }else{ 
   
        }
    }
    
    public List<Produto> listarProdutosCadastrados(){
        List<Produto> lista = new ProdutoDao().listar();
        return lista;
    }
    
    public List<Setup> listarSetupCadastrado(){
    List<Setup> lista = new CadasroSetupDao().listar();
    return lista;
    }
    
}
