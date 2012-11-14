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
   
private Produto produto;
private Disponibilidade disponibilidade;
private Previsao previsao;
private Setup setup;
private Integer HorasCarregamento;

    public Integer getHorasCarregamento() {
        return HorasCarregamento;
    }

    public void setHorasCarregamento(Integer HorasCarregamento) {
        this.HorasCarregamento = HorasCarregamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Previsao getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Previsao previsao) {
        this.previsao = previsao;
    }

    public Setup getSetup() {
        return setup;
    }

    public void setSetup(Setup setup) {
        this.setup = setup;
    }
}
