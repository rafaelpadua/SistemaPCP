/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import entidades.Produto;

/**
 *
 * @author Rafael
 */
public class ProdutoDao {

    private Connection con;

    public ProdutoDao() {
        this.con = GerandoConexao.getConexao();
    }

    public void salvar(Produto produto) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into produto (descricao, taxaProducao, unidade, setup) values (?, ?, ?, ?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getDescricao());
            ps.setString(2, produto.getTaxaDeProducao().toString());
            ps.setString(3, produto.getUnidade());
            ps.setString(4, produto.getSetup().toString());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Produto - " + produto.getDescricao() + " - foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listar() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Produto> list = null;
        try {

            conn = this.con;

            String sql = "select * from produto";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt(1));
                produto.setDescricao(rs.getString(2));
                produto.setTaxaDeProducao(rs.getFloat(3));
                produto.setUnidade(rs.getString(4));
                produto.setSetup(rs.getInt(5));


                list.add(produto);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produto");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return list;
    }
    
    public List listarDescricaoProduto() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Produto> list = null;
        try {

            conn = this.con;

            String sql = "select produto.descricao from produto order by descricao";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setDescricao(rs.getString(1));
                list.add(produto);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produto");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return list;
    }


    public Produto listarProdutoPorId(Integer codigo) {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Produto produto = null;
        try {

            conn = this.con;

            String sql = "select * from produto where codigo = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setCodigo(rs.getInt(1));
                produto.setDescricao(rs.getString(2));
            }
            return produto;
            
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return produto;
    }

    public void atualizar(Produto produto) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "update produto set descricao = ?, taxaproducao = ?, unidade = ?, setup = ? where codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, produto.getDescricao());
            ps.setString(2, produto.getTaxaDeProducao().toString());
            ps.setString(3, produto.getUnidade());
            ps.setString(4, produto.getSetup().toString());
            ps.setString(5, produto.getCodigo().toString());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Produto - " + produto.getDescricao() + " - foi atualizado com sucesso  " + produto.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(Produto produto) {
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from produto where codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, produto.getCodigo());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Produto - " + produto.getDescricao() + ""
                    + " - foi excluido com sucesso.");
        } catch (SQLException ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
