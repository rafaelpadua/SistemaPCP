/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class GerandoConexão {

    public static Connection getConexao() {
   
            Connection con = null;

            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/projeto", "root", "120284");
            } catch (SQLException exception) {
                System.out.println("Deu pau na conexao");
            }
            return con;
        }

    /**
     * Fecha a conexão com o banco de dados
     */
    public static void fecharConexao(Connection con, Statement stm) {
        try {
            con.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(GerandoConexão.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
