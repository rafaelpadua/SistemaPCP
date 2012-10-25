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
    private PrevisaoVendas previsao;
    private Double total;

    public PrevisaoVendas getPrevisao() {
        return previsao;
    }

    public void setPrevisao(PrevisaoVendas previsao) {
        this.previsao = previsao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
