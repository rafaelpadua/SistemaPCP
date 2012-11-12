/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.org.apache.bcel.internal.generic.LLOAD;
import dao.CadastroDisponibilidadeDao;
import dao.PlanejamentoDao;
import dao.PrevisaoDao;
import entidades.Disponibilidade;
import entidades.Planejamento;
import entidades.Previsao;
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

    public void listarProdutosCadastrados(String mes, JTable tabela) {
        List<Planejamento> lista = new PlanejamentoDao().listarPlanejamentoDoMes(mes);
        Disponibilidade listaDispo = new CadastroDisponibilidadeDao().listarPorMes(mes);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();

        for (int i = (modelo.getRowCount() - 1); i >= 0; --i) {
            modelo.removeRow(i);
        }

        for (Planejamento obj : lista) {
            for (int i = 1; i <= listaDispo.getDia(); i++) {
                for (int y = 1; y <= listaDispo.getHoras(); y++) {
                    while(obj.getHorasCarregamento() > listaDispo.getHoras()){
                    modelo.addRow(new Object[]{i, y, obj.getProduto().getDescricao()});
                    }
                }
            }
        }
    }
}
