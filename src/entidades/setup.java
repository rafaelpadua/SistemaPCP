/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rafael
 */
public class setup {
    
    private Integer codigo;
    private Produto inicio;
    private Produto fim;
    private Double horas;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Produto getFim() {
        return fim;
    }

    public void setFim(Produto fim) {
        this.fim = fim;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    public Produto getInicio() {
        return inicio;
    }

    public void setInicio(Produto inicio) {
        this.inicio = inicio;
    }
    
}
