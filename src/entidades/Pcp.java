/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rafael
 */
public class Pcp {
    
    private Integer codigo;
    private Integer produtoCodigo;
    private Integer disponibilidadeCodigo;
    private Double qtdPlanejamento;
    private Double qtdProgramado;
    private Double qtdControle;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getDisponibilidadeCodigo() {
        return disponibilidadeCodigo;
    }

    public void setDisponibilidadeCodigo(Integer disponibilidadeCodigo) {
        this.disponibilidadeCodigo = disponibilidadeCodigo;
    }

    public Integer getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(Integer produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

    public Double getQtdControle() {
        return qtdControle;
    }

    public void setQtdControle(Double qtdControle) {
        this.qtdControle = qtdControle;
    }

    public Double getQtdPlanejamento() {
        return qtdPlanejamento;
    }

    public void setQtdPlanejamento(Double qtdPlanejamento) {
        this.qtdPlanejamento = qtdPlanejamento;
    }

    public Double getQtdProgramado() {
        return qtdProgramado;
    }

    public void setQtdProgramado(Double qtdProgramado) {
        this.qtdProgramado = qtdProgramado;
    }
}
