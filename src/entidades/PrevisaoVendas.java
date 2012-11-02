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
public class PrevisaoVendas {
    
    private Integer codigo;
    private Produto produto;
    private Double  quantidade;
    private Date dataDemanda;
    private Integer ordem;
    private String unidade;
    private Double carregamento;

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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getCarregamento() {
        return carregamento;
    }

    public void setCarregamento(Double carregamento) {
        this.carregamento = carregamento;
    }
    
    
     
     @Override
    public String toString() {
        return getProduto().getDescricao();
    }
}
