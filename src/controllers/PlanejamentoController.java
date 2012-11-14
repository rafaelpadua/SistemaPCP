/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.PlanejamentoDao;
import entidades.Planejamento;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import views.PlanejamentoProducaoView;

/**
 *
 * @author Rafael
 */
public class PlanejamentoController {

    private static PlanejamentoController instancia = new PlanejamentoController();
    private PlanejamentoProducaoView view;
    private Planejamento pcp;

    public PlanejamentoController() {
    }

    public static PlanejamentoController getInstancia() {
        return instancia;
    }

    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new PlanejamentoProducaoView(this);
        }
        view.setVisible(true);
    }

    public void listarProdutosCadastrados(JTable tabela) {
        int x = 0;
        List<Planejamento> lista = new PlanejamentoDao().listarPlanejamentoDoMes();
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);

        while (x < lista.size()) {
            for (int i = 1; i <= lista.get(x).getDisponibilidade().getDia(); i++) {
                for (int y = 1; y <= lista.get(x).getDisponibilidade().getHoras(); y++) {
                    modelo.addRow(new Object[]{i, y, lista.get(x).getProduto().getDescricao()});      
                }
            }
            x++;
        }
    }
}
    

