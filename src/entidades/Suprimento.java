/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import views.PrevisaoDeVendas;

/**
 *
 * @author Rafael
 */
public class Suprimento {
    
    private Produto produto;
    private String descItem;
    private Integer total;
    private String Unidade;

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
