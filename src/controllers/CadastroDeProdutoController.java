/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ProdutoDao;
import entidades.Produto;
import views.CadastroProdutoView;
import java.util.List;


public class CadastroDeProdutoController {
    
    private static CadastroDeProdutoController instancia = new CadastroDeProdutoController();
    private CadastroProdutoView view;
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
            view = new CadastroProdutoView(this);
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
        if(produto.getCodigo() == null){
        new ProdutoDao().salvar(produto);
    }else{
        new ProdutoDao().atualizar(produto);
        }
    }

    /**
     * Exclui o cliente no banco de dados
     */
    public void excluirProduto(){
        
        view.sincronizarModelComView(produto);
        if(produto.getDescricao() != null){
            new ProdutoDao().excluir(produto);
        }
    }
    
   
    public void exibirCadastrodeItemView(){
        CadastroDeItemControlller.getInstancia().exibirInterfaceGrafica();
    }
    
    public void exibirCadastrodeitem_produtoView(){
        CadastroItemProdutoController.getInstancia().exibirInterfaceGrafica();
    }
    
    
}
