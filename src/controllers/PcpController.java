/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Pcp;
import java.util.List;
import views.PcpView;
import views.PlanejamentoView;

/**
 *
 * @author Rafael
 */
public class PcpController {

    private static PcpController instancia = new PcpController();
    private PcpView view;
    private Pcp pcp = new Pcp();

    public PcpController() {
    }

    public static PcpController getInstancia() {
        return instancia;
    }

    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new PcpView(this);
        }
        view.setVisible(true);
    }

    public List calculandoCarregamento() {
        return null;
    }
}
