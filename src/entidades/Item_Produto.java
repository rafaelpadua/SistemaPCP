/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rafael
 */
public class Item_Produto {
    
    private Integer codigoProduto;
    private Integer CodigoItem;
    private Float quantidade;

    public Integer getCodigoItem() {
        return CodigoItem;
    }

    public void setCodigoItem(Integer CodigoItem) {
        this.CodigoItem = CodigoItem;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
}
