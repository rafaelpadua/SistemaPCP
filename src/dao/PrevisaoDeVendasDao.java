/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.PrevisaoVendas;
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
public class PrevisaoDeVendasDao {
    
    private Connection con;
    
    public PrevisaoDeVendasDao(){
        this.con = GerandoConexao.getConexao();
    }
    
    public void salvar(PrevisaoVendas previsao){

          try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into previsao (data, produto_codigo, quantidade, unidade, ordem) values (?,?,?,?,?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(previsao.getDataDemanda().getTime()));
            ps.setInt(2, previsao.getProduto().getCodigo());
            ps.setFloat(3, previsao.getQuantidade());
            ps.setString(4, previsao.getUnidade());
            ps.setInt(5, previsao.getOrdem());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Produto foi cadastrado com sucesso");
        } catch (SQLException ex) {
              System.out.println("Erro ao Salvar Demanda " + ex);
        }
    
    }
    
    public void atualizar(PrevisaoVendas previsao){
    
    }
    
    public List listar(){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<PrevisaoVendas> listP = null;
        try {

            conn = this.con;
            // codigo, data, produto_codigo quantidade, unidade, ordem
            String sql = "select * from previsao order by codigo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            listP = new ArrayList<>();
            while (rs.next()) {
                PrevisaoVendas previsao = new PrevisaoVendas();
                previsao.setCodigo(rs.getInt(1));
                previsao.setDataDemanda(new java.util.Date(rs.getDate(2).getTime()));
                previsao.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(3)));
                previsao.setQuantidade(rs.getFloat(4));
                previsao.setUnidade(rs.getString(5));
                previsao.setOrdem(rs.getInt(6));
                
                listP.add(previsao);
            }
            return listP;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar previsão " + ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return listP;
    }
    
    public List<Produto> listarProdutoPorDescricao(){
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Produto> list = null;
        try {

            conn = this.con;

            String sql = "select * from produto order by descricao";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setDescricao(rs.getString(2));             
                list.add(produto);
            }
            return list;

        } catch (SQLException ex) {
            System.out.println("Erro ao listar previsão");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return list;
    }
    
    
    public void excluir(PrevisaoVendas previsao){
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from previsao where codigo  = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, previsao.getCodigo());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Previsão foi excluido com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(PrevisaoDeVendasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
