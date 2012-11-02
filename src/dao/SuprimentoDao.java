/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import conexoes.GerandoConexao;
import entidades.Suprimento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class SuprimentoDao {

    private Connection con;

    public SuprimentoDao() {
        this.con = GerandoConexao.getConexao();
    }

    public List listarSuprimento() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Suprimento> lista = null;

        try {

            conn = this.con;

            String sql = "select produto.codigo,  item.descricao, (previsao.quantidade * produto_item.quantidade), item.unidade "
                    + "from produto , item , produto_item , previsao "
                    + "where produto_item.item_codigo = item.codigo and "
                    + "produto_item.produto_codigo = produto.codigo and "
                    + "previsao.produto_codigo = produto_item.produto_codigo order by produto.codigo asc";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Suprimento suprimento = new Suprimento();
                suprimento.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(1)));
                suprimento.setDescItem((rs.getString(2)));
                suprimento.setTotal((rs.getInt(3)));
                suprimento.setUnidade(rs.getString(4));
                lista.add(suprimento);

            }
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return lista;
    }

    public List listarSuprimentosPorDescricao(String supri) {

        java.sql.PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Suprimento suprimento = null;
        List<Suprimento> lista = null;

        try {
            conn = this.con;
            String sql = "select produto.codigo, item.descricao, sum(previsao.quantidade * produto_item.quantidade) ,item.unidade  "
                    + "from produto , item , produto_item , previsao where produto.descricao = ? "
                    + "and produto_item.item_codigo = item.codigo "
                    + "and produto_item.produto_codigo = produto.codigo "
                    + "and previsao.produto_codigo = produto_item.produto_codigo group by item.descricao";
                    
            ps = conn.prepareStatement(sql);
            ps.setString(1,supri);
            rs = ps.executeQuery();
            lista = new ArrayList<>();

            while (rs.next()) {
                suprimento = new Suprimento();
                suprimento.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(1)));
                suprimento.setDescItem((rs.getString(2)));
                suprimento.setTotal((rs.getInt(3)));
                suprimento.setUnidade(rs.getString(4));
                lista.add(suprimento);
            }
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return lista;
    }
}
