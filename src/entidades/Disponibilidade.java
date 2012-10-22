/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;

/**
 *
 * @author Rafael
 */
public class Disponibilidade {
    
    private Integer codigo;
    private String mes;
    private Integer Ano;
    private Integer dia;
    private Time horas;
    private String observacao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Time getHoras() {
        return horas;
    }

    public void setHoras(Time horas) {
        this.horas = horas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getAno() {
        return Ano;
    }

    public void setAno(Integer Ano) {
        this.Ano = Ano;
    }
}
