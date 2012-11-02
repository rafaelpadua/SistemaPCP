/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import views.PrevisaoDeVendas;
import entidades.Produto;
import entidades.PrevisaoVendas;
import dao.PrevisaoDeVendasDao;
/**
 *
 * @author Rafael
 */
public class CadastroDemandaController {
    
    private static CadastroDemandaController instancia = new CadastroDemandaController();
    private PrevisaoDeVendas view;
    private PrevisaoVendas model = new PrevisaoVendas();

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
            view = new PrevisaoDeVendas(this);
        }

        view.setVisible(true);

    }

    public List<Produto> listaTiposDeProduto() {

        return CadastroDeProdutoController.getInstancia().listarProdutos();

    }
    
    public void salvarDemandas() {

        if (view.sincronizarModelComView(model)) {

            if (model.getCodigo() == null) {
                new PrevisaoDeVendasDao().salvar(model);
            } else {
                new PrevisaoDeVendasDao().atualizar(model);
            }
        }

    }

    public List<PrevisaoVendas> listarDemandas(){
        
        List<PrevisaoVendas> lista = new PrevisaoDeVendasDao().listar();
        return lista;
    }
    
    public void excluirServico(){

        view.sincronizarModelComView(model);
        if(model.getCodigo() != null){
            new PrevisaoDeVendasDao().excluir(model);
        }
    }    
    
    public List<PrevisaoVendas> listarCarregamentos(){
        
        List<PrevisaoVendas> lista = new PrevisaoDeVendasDao().calculandoCarregamento();
        return lista;
    }
}
