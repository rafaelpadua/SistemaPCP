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
        
        System.out.println("entrando disponibilidade Dao");
        System.out.println(disp.getCodigo() + "\n" + disp.getMes() + "\n" + 
                disp.getAno() + "\n" + disp.getDia() + "\n" + disp.getHoras() + "\n" +
                disp.getObservacao());
        try {
            Connection conn = null;
            PreparedStatement ps = null;

            String sql = "insert into disponibilidade (codigo, mes, ano, dia,  hora, obs) values (null, ?,?,?,?,?)";
            conn = this.con;
            ps = conn.prepareStatement(sql);
            ps.setString(1, disp.getMes());
            ps.setInt(2, disp.getAno());
            ps.setInt(3, disp.getDia());
            ps.setTime(4, disp.getHoras());
            ps.setString(5, disp.getObservacao());
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
                disponivel.setHoras(rs.getTime(5));
                disponivel.setObservacao(rs.getString(6));
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
    
    public Produto listarPorId(Integer codigo) {
        
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

    public void atualizar(Disponibilidade disponib) {
//        try {
//            Connection conn = null;
//            PreparedStatement ps = null;
//
//            String sql = "update produto set descricao = ?, taxaproducao = ?, unidade = ?, setup = ? where codigo = ?";
//            conn = this.con;
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, disponib.getDescricao());
//            ps.setString(2, disponib.getTaxaDeProducao().toString());
//            ps.setString(3, disponib.getUnidade());
//            ps.setString(4, disponib.getSetup().toString());
//            ps.setString(5, disponib.getCodigo().toString());
//            ps.executeUpdate();
//            GerandoConexão.fecharConexao(conn, ps);
//            JOptionPane.showMessageDialog(null, "Produto - " + disponib.getDescricao() + " - foi atualizado com sucesso  " + disponib.getCodigo());
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
