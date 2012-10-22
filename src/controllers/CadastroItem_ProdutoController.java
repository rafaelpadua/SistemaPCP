/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.CadastroItem_Produto;
import entidades.ItemProduto;
import entidades.Item;
import dao.ItemProdutoDao;
import entidades.Produto;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class CadastroItem_ProdutoController {

    private static CadastroItem_ProdutoController instancia = new CadastroItem_ProdutoController();
    private CadastroItem_Produto view;
    private ItemProduto item_produto = new ItemProduto();

    public CadastroItem_ProdutoController() {
    }

    /**
     * @return a instancia do controlador
     */
    public static CadastroItem_ProdutoController getInstancia() {
        return instancia;
    }

    /**
     * Exibe a interface gráfica do controlador
     */
    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new CadastroItem_Produto(this);
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

        if (view.sincronizarModelComView(item_produto)) {
            if ((item_produto.getItem() != null) && item_produto.getProduto() != null) {
                new ItemProdutoDao().salvar(item_produto);
            }
        }
    }

    public void atualizarItem_Produto() {
        if (view.sincronizarModelComView(item_produto)) {
            if ((item_produto.getItem() != null) && item_produto.getProduto() != null) {
                new ItemProdutoDao().atualizar(item_produto);
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
