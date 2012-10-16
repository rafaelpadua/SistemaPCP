/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexão;
import entidades.Item_Produto;
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
public class Item_ProdutoDao {
    
     private Connection con;

    public Item_ProdutoDao() {
        this.con = GerandoConexão.getConexao();
    }

    public void salvar(Item_Produto item) {
        System.out.println("Entrado Item_ProdutoDaoSalvar");
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
            GerandoConexão.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Item_Produto, foi cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listar() {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Item_Produto> list = null;
        try {

            conn = this.con;

            String sql = "select * from produto_item";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Item_Produto item = new Item_Produto();
                item.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(1)));
                item.setItem(new ItemDao().listarPorId(rs.getInt(2)));
                item.setQuantidade(rs.getFloat(3));
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

    public Produto listarPorId(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Produto produto = null;
        try {

            conn = this.con;

            String sql = "select produto.descricao from produto where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setDescricao(rs.getString(1));
            }
            return produto;

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexão.fecharConexao(conn, ps);
        }
      return produto;
    }
    
    public void atualizar(Item_Produto item) {
//        try {
//            Connection conn = null;
//            PreparedStatement ps = null;
//
//            String sql = "update produto_item set produto_codigo = ?, item_codigo = ?, quantidade = ?";
//            conn = this.con;
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, Integer.toString(item.getCodigoProduto()));
//            ps.setString(2, Integer.toString(item.getCodigoItem()));
//            ps.setString(3, Float.toString(item.getQuantidade()));
//            ps.executeUpdate();
//            GerandoConexão.fecharConexao(conn, ps);
//            JOptionPane.showMessageDialog(null, "Item_Produto foi atualizado com sucesso");
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public void excluir(Item_Produto item) {
//        try {
//            Connection conn;
//            PreparedStatement ps;
//
//            String sql = "delete from produto_item where produto_codigo = ?, produto_item = ?";
//            conn = this.con;
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, item.getCodigoProduto());
//            ps.executeUpdate();
//            GerandoConexão.fecharConexao(conn, ps);
//            JOptionPane.showMessageDialog(null, "Item_Produto foi excluido com sucesso.");
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    
    
}
