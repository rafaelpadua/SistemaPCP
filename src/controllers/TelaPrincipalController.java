/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JButton;
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
    
    public void exibirInterfaceGraficaAdministrador(){
        if(view == null){            
            view = new TelaPrincipalView(this);
        }
        view.setVisible(true);
    }
    
    public void exibirInterfaceGraficaEngenheiroProducao(){
    
    if(view == null){            
            view = new TelaPrincipalView(this);
        }
        view.setVisible(true);
        view.bloquearBotoesEngenheiroProducao();
    }
    
    public void exibirGraficaAnalistaPCP(){
    if(view == null){            
            view = new TelaPrincipalView(this);
        }
        view.setVisible(true);
        view.bloquearBotoesAnalistaPCP();
    }
    
    public void exibirGraficaCompras(){
     if(view == null){            
            view = new TelaPrincipalView(this);
        }
        view.setVisible(true);
       view.BloquearCompras();
    }
    
    public void exibirGraficaGerentePCP(){
    if(view == null){            
            view = new TelaPrincipalView(this);
        }
        view.setVisible(true);
       view.bloquearGerenytePCP();
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
