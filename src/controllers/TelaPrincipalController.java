/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.TelaPrincipalView;

/**
 *
 * @author Rafael
 */
public class TelaPrincipalController {
    
    private static TelaPrincipalController instancia = new TelaPrincipalController();
    private TelaPrincipalView view;
    
    public static TelaPrincipalController getInstancia(){
    return instancia;
    }
    
    public void exibirInterfaceGrafica(){

        if(view == null){            
            view = new TelaPrincipalView(this);
        }
        view.setVisible(true);
    }
    
    public void exibirCadastroDeProdutoView(){
        CadastroDeProdutoController.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirCadastroDeDemandaView(){
        CadastroDemandaController.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirCadastroDeDisponibilidadeView(){
        CadastroDisponibilidadeController.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirSuprimentosView(){
        SuprimentoController.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirSetupView(){
        SetupController.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirPcpView(){
        PlanejamentoController.getInstancia().exibirInterfaceGrafica();
    }
}
