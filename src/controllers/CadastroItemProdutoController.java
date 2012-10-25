/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.CadastroItemProduto;
import entidades.ItemProduto;
import entidades.Item;
import dao.ItemProdutoDao;
import entidades.Produto;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class CadastroItemProdutoController {

    private static CadastroItemProdutoController instancia = new CadastroItemProdutoController();
    private CadastroItemProduto view;
    private ItemProduto itemProduto = new ItemProduto();

    public CadastroItemProdutoController() {
    }

    /**
     * @return a instancia do controlador
     */
    public static CadastroItemProdutoController getInstancia() {
        return instancia;
    }

    /**
     * Exibe a interface gráfica do controlador
     */
    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new CadastroItemProduto(this);
        }
        view.setVisible(true);
    }

    public List<ItemProduto> listarIten_Produto() {

        List<ItemProduto> lista = new ItemProdutoDao().listar();
        return lista;
    }

    /**
     * Salva o cliente no banco de dados
     */
    public void salvarItem_Produto() {

        if (view.sincronizarModelComView(itemProduto)) {
            if ((itemProduto.getItem() != null) && itemProduto.getProduto() != null) {
                new ItemProdutoDao().salvar(itemProduto);
            }
        }
    }

    public void atualizarItem_Produto() {
        if (view.sincronizarModelComView(itemProduto)) {
            if ((itemProduto.getItem() != null) && itemProduto.getProduto() != null) {
                new ItemProdutoDao().atualizar(itemProduto);
            }
        }    
    }

    public List<Produto> listarProdutos() {

        return CadastroDeProdutoController.getInstancia().listarProdutos();

    }

    public List<Item> listarItens() {

        return CadastroDeItemControlller.getInstancia().listarItens();

    }
}
