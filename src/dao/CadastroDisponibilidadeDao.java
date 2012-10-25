/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexoes.GerandoConexao;
import entidades.Disponibilidade;
import entidades.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class CadastroDisponibilidadeDao {

    private Connection con;

    public CadastroDisponibilidadeDao() {
        this.con = GerandoConexao.getConexao();
    }

    public void salvar(Disponibilidade disp) {

        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into disponibilidade (codigo, mes, ano, dia,  hora) values (null, ?,?,?,?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, disp.getMes());
            ps.setInt(2, disp.getAno());
            ps.setInt(3, disp.getDia());
            ps.setInt(4, disp.getHoras());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Disponibilidade, cadastrado com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listar() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Disponibilidade> list = null;
        try {

            conn = this.con;

            String sql = "select * from disponibilidade";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Disponibilidade disponivel = new Disponibilidade();
                disponivel.setCodigo(rs.getInt(1));
                disponivel.setMes(rs.getString(2));
                disponivel.setAno(rs.getInt(3));
                disponivel.setDia(rs.getInt(4));
                disponivel.setHoras(rs.getInt(5));
                list.add(disponivel);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar Disponibilidade");
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return list;
    }

    public List listarPorMes() {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Disponibilidade> listaDispo = null;
        try {

            conn = this.con;

            String sql = "select disponibilidade.codigo, disponibilidade.mes, disponibilidade.ano, (disponibilidade.dia * disponibilidade.hora) from disponibilidade order by disponibilidade.ano, disponibilidade.mes ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            listaDispo = new ArrayList<>();
            while (rs.next()) {
                Disponibilidade dis = new Disponibilidade();
                dis.setCodigo(rs.getInt(1));
                dis.setMes(rs.getString(2));
                dis.setAno(rs.getInt(3));
                dis.setTotal(rs.getInt(4));
                listaDispo.add(dis);
            }
            return listaDispo;

        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            GerandoConexao.fecharConexao(conn, ps);
        }
        return listaDispo;
    }

    public void atualizar(Disponibilidade disponib) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "update disponibilidade set mes = ?, ano = ?, dia = ?, hora = ? where codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, disponib.getMes());
            ps.setString(2, disponib.getAno().toString());
            ps.setString(3, disponib.getDia().toString());
            ps.setString(4, disponib.getHoras().toString());
            ps.setString(5, disponib.getCodigo().toString());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Disponibilidade - " + disponib.getMes() + " - foi atualizado com sucesso  " + disponib.getCodigo());
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Disponibilidade dispo) {
        try {
            Connection conn;
            PreparedStatement ps;

            String sql = "delete from disponibilidade where codigo = ?";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dispo.getCodigo());
            ps.executeUpdate();
            GerandoConexao.fecharConexao(conn, ps);
            JOptionPane.showMessageDialog(null, "Disponibilidade - " + dispo.getMes() + ""
                    + " - foi excluido com sucesso.");
        } catch (SQLException ex) {

            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
