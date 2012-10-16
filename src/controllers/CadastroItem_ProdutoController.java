/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.CadastroItem_Produto;
import entidades.Item_Produto;
import entidades.Item;
import dao.Item_ProdutoDao;
import entidades.Produto;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class CadastroItem_ProdutoController {

    private static CadastroItem_ProdutoController instancia = new CadastroItem_ProdutoController();
    private CadastroItem_Produto view;
    private Item_Produto item_produto = new Item_Produto();

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

    public List<Item_Produto> listarIten_Produto() {

        List<Item_Produto> lista = new Item_ProdutoDao().listar();
        return lista;
    }

    /**
     * Salva o cliente no banco de dados
     */
    public void salvarItem_Produto() {

        if (view.sincronizarModelComView(item_produto)) {
            if ((item_produto.getItem() != null) && item_produto.getProduto() != null) {
                new Item_ProdutoDao().salvar(item_produto);
            }
        }
    }

    /**
     * Exclui o cliente no banco de dados
     */
    public void excluirItem_Produto() {
        
        view.sincronizarModelComView(item_produto);
        if(item_produto.getProduto().getCodigo() != null){
            new Item_ProdutoDao().excluir(item_produto);
        }
    }

    public void alterarItem_Produto() {
//        view.sincronizarModelComView(item_produto);
//        if (item_produto.getCodigoItem() == null){
//        new Item_ProdutoDao().atualizar(item_produto);
//        }
    }

    public void listarPorCodigo() {
    }

    public List<Produto> listarProdutos() {

        return CadastroDeProdutoController.getInstancia().listarProdutos();

    }

    public List<Item> listarItens() {

        return CadastroDeItemControlller.getInstancia().listarItens();

    }
}
