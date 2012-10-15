/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.TelaPrincipal;

/**
 *
 * @author Rafael
 */
public class TelaPrincipalController {
    
    private static TelaPrincipalController instancia = new TelaPrincipalController();
    private TelaPrincipal view;
    
    public static TelaPrincipalController getInstancia(){
    return instancia;
    }
    
    public void exibirInterfaceGrafica(){

        if(view == null){            
            view = new TelaPrincipal(this);
        }
        view.setVisible(true);
    }
    
    public void exibirCadastroDeProdutoView(){
        CadastroDeProdutoController.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirCadastroDeDemandaView(){
        CadastroDemandaController.getInstancia().exibirInterfaceGrafica();
    }
    
}