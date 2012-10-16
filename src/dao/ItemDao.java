/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexão;
import entidades.Item;
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
public class ItemDao {

    private Connection con;

    public ItemDao() {
        this.con = GerandoConexão.getConexao();
    }

    public void salvar(Item item) {
         try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into item (descricao, unidade) values (?, ?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getDescricao());
            ps.setString(2, item.getUnidade());
            ps.executeUpdate();
            GerandoConexão.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Item - " + item.getDescricao() + " - foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listar() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Item> list = null;
        try {

            conn = this.con;

            String sql = "select * from item";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Item item = new Item();
                item.setCodigo(rs.getInt(1));
                item.setDescricao(rs.getString(2));
                item.setUnidade(rs.getString(3));
                list.add(item);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar item");
        } finally {
            GerandoConexão.fecharConexao(conn, ps);
        }
        return list;
    }

    public Item listarPorId(Integer codigo) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Item item = null;
        try {

            conn = this.con;

            String sql = "select * from item where codigo = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                item = new Item();
                item.setCodigo(rs.getInt(1));
                item.setDescricao(rs.getString(2));
            }
            return item;

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexão.fecharConexao(conn, ps);
        }
        return item;
    }

    public void atualizar(Item item) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "update item set descricao = ?, unidade = ? where codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, item.getDescricao());
            ps.setString(2, item.getUnidade());
            ps.setString(3, Integer.toString(item.getCodigo()));
            ps.executeUpdate();
            GerandoConexão.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Item - " + item.getDescricao() + " - foi atualizado com sucesso  " + item.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(Item item) {
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from item where codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getCodigo());
            ps.executeUpdate();
            GerandoConexão.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Item - " + item.getDescricao() + ""
                    + " - foi excluido com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
