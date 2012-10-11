/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ItemDao;
import views.CadastroItem;
import entidades.Item;
import java.util.List;

public class CadastroDeItemControlller {

    private static CadastroDeItemControlller instancia = new CadastroDeItemControlller();
    private CadastroItem view;
    private Item item = new Item();

    public CadastroDeItemControlller() {
    }

    public static CadastroDeItemControlller getInstancia() {
        return instancia;
    }
    
    public void exibirInterfaceGrafica(){

        if(view == null){
            view = new CadastroItem(this);
        }
        view.setVisible(true);
    }
   
    
    /**
     * Salva o cliente no banco de dados
     */
    public void salvarItem(){

        view.sincronizarModelComView(item);
        if (item.getCodigo() != null){
            new ItemDao().salvar(item);
        }else{ 
            new ItemDao().atualizar(item);
        }
    }

    /**    
     * @return a lista de clientes cadastrados
     */
    public List<Item> listarItens(){

        List<Item> lista = new ItemDao().listar();
        return lista;
    }

    /**
     * Exclui o cliente no banco de dados
     */
    public void excluirItem(){

        view.sincronizarModelComView(item);
        if(item.getCodigo() != null){
            new ItemDao().excluir(item);
        }
    }
}
