/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProdutoDao;
import entidades.Produto;
import views.CadastroProduto;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class CadastroDeProdutoController {
    
    private static CadastroDeProdutoController instancia = new CadastroDeProdutoController();
    private CadastroProduto view;
    private Produto produto = new Produto();  
    
    public CadastroDeProdutoController() {
    }
    
    /**
     * @return a instancia do controlador
     */
    public static CadastroDeProdutoController getInstancia() {
        return instancia;
    }
   

    /**
     * Exibe a interface gráfica do controlador
     */
    public void exibirInterfaceGrafica(){

        if(view == null){
            view = new CadastroProduto(this);
        }
        view.setVisible(true);
    }
    
        public List<Produto> listarProdutos(){

        List<Produto> lista = new ProdutoDao().listar();
        return lista;
    }
   
    
    /**
     * Salva o cliente no banco de dados
     */
    public void salvarProduto(){
        view.sincronizarModelComView(produto);
        new ProdutoDao().salvar(produto);
    }

    /**
     * Exclui o cliente no banco de dados
     */
    public void excluirProduto(){

        view.sincronizarModelComView(produto);
        if(produto.getDescricao() == null){
            new ProdutoDao().excluir(produto);
        }
    }
    
    public void alterarProduto(){
        view.sincronizarModelComView(produto);
        if (produto.getCodigo() == null){
        new ProdutoDao().atualizar(produto);
        }
    }
    
    
    public void exibirCadastrodeItemView(){
        CadastroDeItemControlller.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirCadastrodeitem_produtoView(){
        CadastroItem_ProdutoController.getInstancia().exibirInterfaceGrafica();
    }
    
    
}
