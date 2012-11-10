/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CadastroDisponibilidadeDao;
import dao.PrevisaoDao;
import entidades.Disponibilidade;
import entidades.Pcp;
import entidades.Previsao;
import java.util.List;
import views.PCPView;

/**
 *
 * @author Rafael
 */
public class PcpController {

    private static PcpController instancia = new PcpController();
    private PCPView view;
    private Pcp pcp;

    public PcpController() {
    }

    public static PcpController getInstancia() {
        return instancia;
    }

    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new PCPView(this);
        }
        view.setVisible(true);
    }

    public List calculandoCarregamento() {
        return null;
    }
    
    public List listarDisponibilidadeporMes(String mes){
        List<Disponibilidade>lista = new CadastroDisponibilidadeDao().listarPorMes(mes);
        return  lista;
    }
    
    public List listarPrevisoes(String mes){
        List<Previsao> lista = new PrevisaoDao().listarPrevisaoPorMes(mes);
        return lista;
    }
}
