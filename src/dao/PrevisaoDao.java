/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.Previsao;
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
public class PrevisaoDao {

    private Connection con;

    public PrevisaoDao() {
        this.con = GerandoConexao.getConexao();
    }

    public void salvar(Previsao previsao) {

        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into previsao (mes, ano, produto_codigo, quantidade, ordem) values (?,?,?,?,?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, previsao.getMes());
            ps.setInt(2, previsao.getAno());
            ps.setInt(3, previsao.getProduto().getCodigo());
            ps.setDouble(4, previsao.getQuantidade());
            ps.setInt(5, previsao.getOrdem());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Produto foi cadastrado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao Salvar Demanda " + ex);
        }

    }

    public void atualizar(Previsao previsao) {
    }

    public List listar() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Previsao> listP = null;
        try {

            conn = this.con;

            String sql = "select previsao.codigo, previsao.mes, previsao.ano, previsao.produto_codigo, previsao.quantidade, previsao.ordem, (previsao.quantidade /produto.TaxaProducao) "
                    + "from previsao, produto where produto_codigo = produto.codigo";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            listP = new ArrayList<>();
            while (rs.next()) {
                Previsao previsao = new Previsao();
                previsao.setCodigo(rs.getInt(1));
                previsao.setMes(rs.getString(2));
                previsao.setAno(rs.getInt(3));
                previsao.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(4)));
                previsao.setQuantidade(rs.getDouble(5));
                previsao.setOrdem(rs.getInt(6));
                previsao.setCarregamento(rs.getDouble(7));

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

    public void excluir(Previsao previsao) {
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
            Logger.getLogger(PrevisaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Previsao listarPrevisaoPorCodigo(Integer codigo) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Previsao previsao = null;
        try {

            conn = this.con;

            String sql = "select * from previsao where codigo = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            while (rs.next()) {
                previsao = new Previsao();
                previsao.setCodigo(rs.getInt(1));
                previsao.setMes(rs.getString(2));
                previsao.setAno(rs.getInt(3));
                previsao.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(4)));
                previsao.setQuantidade(rs.getDouble(5));
                previsao.setOrdem(rs.getInt(6));
            }
            return previsao;

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return previsao;
    }

    public Previsao listarPrevisaoPorMes(String mes) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Previsao previsao = null;
        try {

            conn = this.con;

            String sql = "select * from previsao where mes = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, mes);
            rs = ps.executeQuery();

            while (rs.next()) {
                previsao = new Previsao();
                previsao.setCodigo(rs.getInt(1));
                previsao.setMes(rs.getString(2));
                previsao.setAno(rs.getInt(3));
                previsao.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(4)));
                previsao.setQuantidade(rs.getDouble(5));
                previsao.setOrdem(rs.getInt(6));
            }
            return previsao;

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return previsao;
    }

    public Double somarCarregamento() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Double soma = null;
        try {

            conn = this.con;

            String sql = "select sum(previsao.quantidade /produto.TaxaProducao) from previsao, produto where produto_codigo = produto.codigo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                soma = rs.getDouble(1);
            }
            return soma;

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return soma;
    }    
}
