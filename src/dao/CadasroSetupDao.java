/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.Setup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class CadasroSetupDao {

    private Connection con;

    public CadasroSetupDao() {
        this.con = GerandoConexao.getConexao();
    }

    public void salvar(Setup setup) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into setup (produto_codmont, produto_coddesmont, horas) values (?, ?, ?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, setup.getProdutoinicio().getCodigo());
            ps.setInt(2, setup.getProdutofim().getCodigo());
            ps.setInt(3, setup.getHoras());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Setup - " + setup.getProdutofim().getDescricao() + " - foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List listar() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Setup> list = null;
        try {

            conn = this.con;

            String sql = "select * from setup";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Setup setup = new Setup();
                setup.setCodigo(rs.getInt(1));
                setup.setProdutoinicio(new ProdutoDao().listarProdutoPorId(rs.getInt(2)));
                setup.setProdutofim(new ProdutoDao().listarProdutoPorId(rs.getInt(3)));
                setup.setHoras(rs.getInt(4));
                list.add(setup);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar setup");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return list;
    }

    public Setup listarSetupPorCodigoProduto(Integer codigo) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Setup setup = null;
        try {

            conn = this.con;

            String sql = "select setup.horas from setup where produto_codmont = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
          
            while (rs.next()) {
                setup = new Setup();
                setup.setHoras(rs.getInt(1));
            }
            return setup;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar setup por produto");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return setup;
    }
    
    public void excluir(Setup setup){
    
               try {
            Connection conn;
            PreparedStatement ps;

            String sql = "select * from setup where codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, setup.getCodigo());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Setup - " + setup.getCodigo() + ""
                    + " - foi excluido com sucesso.");
        } catch (SQLException ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
}
