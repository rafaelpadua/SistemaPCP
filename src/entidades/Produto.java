/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


/**
 *
 * @author Rafael
 */
public class Produto {
    
    private Integer codigo;
    private String descricao;
    private Float TaxaDeProducao;
    private String unidade;
    private Integer  setup;

    public Float getTaxaDeProducao() {
        return TaxaDeProducao;
    }

    public void setTaxaDeProducao(Float TaxaDeProducao) {
        this.TaxaDeProducao = TaxaDeProducao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getSetup() {
        return setup;
    }

    public void setSetup(Integer setup) {
        this.setup = setup;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    
}
