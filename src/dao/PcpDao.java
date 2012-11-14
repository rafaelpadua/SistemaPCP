/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.Disponibilidade;
import entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafael
 */
public class PcpDao {
    
    private Connection con;

    public PcpDao() {
        this.con = GerandoConexao.getConexao();
    }
    
        public void salvar(Produto produto, Disponibilidade dispo) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into pcp (produto_codigo, disponibilidade_codigo) values (?, ?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, produto.getCodigo());
            ps.setInt(2, dispo.getCodigo());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
