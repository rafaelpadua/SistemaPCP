/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rafael
 */
public class Usuarios {
    
    private String funcao;
    private String cpf;
    private String senha;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
