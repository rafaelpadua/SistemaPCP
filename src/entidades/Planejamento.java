/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rafael
 */
public class Planejamento {
    
    private String mes;
    private Integer ano;
    private Produto produto;
    private Integer HorasCarregamento;

    public Integer getHorasCarregamento() {
        return HorasCarregamento;
    }

    public void setHorasCarregamento(Integer HorasCarregamento) {
        this.HorasCarregamento = HorasCarregamento;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
