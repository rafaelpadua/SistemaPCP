/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rafael
 */
public class Item {
    
    private Integer codigo;
    private String descricao;
    private String unidade;

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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    @Override
    public boolean equals(Object obj) {
         if( obj instanceof Item ) {
             Item o = ( Item ) obj;
             if( o.getCodigo() == this.getCodigo() ){
                 return true;
             } else {
                 return false;}
         } else{
             return false;}
     }

    @Override
    public String toString() {
        return getDescricao();
    }
}
