/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class LoginDao {

    private Connection con;

    public LoginDao() {
        this.con = GerandoConexao.getConexao();
    }

    public List listarUsuarios() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Usuarios> lista = null;
        try {

            conn = this.con;

            String sql = "select * from usuario";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();

            while (rs.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setCodigo(rs.getInt(1));
                usuarios.setFuncao(rs.getString(2));
                usuarios.setUsuario(rs.getString(3));
                usuarios.setSenha(rs.getString(4));
                lista.add(usuarios);
            }
            return lista;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar usuario");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return lista;
    }
}
