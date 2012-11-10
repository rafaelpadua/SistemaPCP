/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import views.PrevisaoView;
import entidades.Produto;
import entidades.Previsao;
import dao.PrevisaoDao;

/**
 *
 * @author Rafael
 */
public class CadastroDemandaController {

    private static CadastroDemandaController instancia = new CadastroDemandaController();
    private PrevisaoView view;
    private Previsao model = new Previsao();

    public CadastroDemandaController() {
    }

    /**
     * @return the instancia
     */
    public static CadastroDemandaController getInstancia() {
        return instancia;
    }

    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new PrevisaoView(this);
        }

        view.setVisible(true);

    }

    public List<Produto> listaTiposDeProduto() {

        return CadastroDeProdutoController.getInstancia().listarProdutos();

    }

    public void salvarDemandas() {

        if (view.sincronizarModelComView(model)) {

            if (model.getCodigo() == null) {
                new PrevisaoDao().salvar(model);
            } else {
                new PrevisaoDao().atualizar(model);
            }
        }

    }

    public List<Previsao> listarDemandas() {

        List<Previsao> lista = new PrevisaoDao().listar();
        return lista;
    }

    public void excluirServico() {

        view.sincronizarModelComView(model);
        if (model.getCodigo() != null) {
            new PrevisaoDao().excluir(model);
        }
    }
}
