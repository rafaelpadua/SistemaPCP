/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.Planejamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Rafael
 */
public class PlanejamentoDao {

    private Connection con;

    public PlanejamentoDao() {
        this.con = GerandoConexao.getConexao();
    }

    public List listarPlanejamentoDoMes(String mes) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Planejamento> lista = null;
        try {
            conn = this.con;
            String sql = "select produto.codigo , (previsao.quantidade / produto.taxaProducao ) from produto , previsao where produto.codigo = previsao.produto_codigo and previsao.mes = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, mes);
            rs = ps.executeQuery();
            lista = new ArrayList<>();

            while (rs.next()) {
               Planejamento planejamento = new Planejamento();
                planejamento.setProduto(new ProdutoDao().listarProdutoPorId(rs.getInt(1)));
                planejamento.setHorasCarregamento(rs.getInt(2));
                lista.add(planejamento);
            }
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return lista;
    }
}
