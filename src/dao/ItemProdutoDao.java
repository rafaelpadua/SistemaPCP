/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.ItemProduto;
import entidades.Produto;
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
public class ItemProdutoDao {
    
     private Connection con;

    public ItemProdutoDao() {
        this.con = GerandoConexao.getConexao();
    }

    public void salvar(ItemProduto item) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into produto_item (produto_codigo, item_codigo, quantidade) values (?, ?, ?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getProduto().getCodigo());
            ps.setInt(2, item.getItem().getCodigo());
            ps.setString(3, Float.toString(item.getQuantidade()));
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Item_Produto, foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listar() {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<ItemProduto> list = null;
        try {

            conn = this.con;

            String sql = "select * from produto_item order by produto_codigo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                ItemProduto item = new ItemProduto();
                item.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(1)));
                item.setItem(new ItemDao().listarPorId(rs.getInt(2)));
                item.setQuantidade(rs.getFloat(3));
                list.add(item);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar item");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return list;
    }

    public void atualizar(ItemProduto item) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            String sql = "update produto_item set quantidade = ? where produto_codigo = ? and item_codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, Float.toString(item.getQuantidade()));
            ps.setInt(2, item.getProduto().getCodigo());
            ps.setInt(3, item.getItem().getCodigo());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Item_Produto foi atualizado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
