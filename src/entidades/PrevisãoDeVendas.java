/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class PrevisãoDeVendas {
    
    private Integer codigo;
    private String Produto;
    private Float  quantidade;
    private Date dataDemanda;
    private Integer ordem;

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataDemanda() {
        return dataDemanda;
    }

    public void setDataDemanda(Date dataDemanda) {
        this.dataDemanda = dataDemanda;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
}
