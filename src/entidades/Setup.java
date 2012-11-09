/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rafael
 */
public class Setup {
    
    private Integer codigo;
    private Produto produtoinicio;
    private Produto produtofim;
    private Integer horas;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Produto getProdutofim() {
        return produtofim;
    }

    public void setProdutofim(Produto produtofim) {
        this.produtofim = produtofim;
    }

    public Produto getProdutoinicio() {
        return produtoinicio;
    }

    public void setProdutoinicio(Produto produtoinicio) {
        this.produtoinicio = produtoinicio;
    }
    
    @Override
    public boolean equals(Object obj) {
         if( obj instanceof Produto ) {
             Produto o = ( Produto ) obj;
             if( o.getCodigo() == this.getCodigo() ){
                 return true;
             } else {
                 return false;}
         } else{
             return false;}
     }

//    @Override
//    public String toString() {
//        return getProdutoinicio().getDescricao();
//    }
}
