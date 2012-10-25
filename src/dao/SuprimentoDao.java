/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import conexoes.GerandoConexao;
import entidades.Suprimento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class SuprimentoDao {
    
    private Connection con;
    
     public SuprimentoDao() {
        this.con = GerandoConexao.getConexao();
    }
     
     public void salvar(Suprimento suprimento) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "";
            conn = this.con;
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, suprimento.getPrevisao().getProduto().getCodigo());
            ps.setInt(2, suprimento.getPrevisao().getCodigo());
            ps.setFloat(3, suprimento.getProduto().getTaxaDeProducao());
            ps.setDouble(4, suprimento.getTotal());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Item_Produto, foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
