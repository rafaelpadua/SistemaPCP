/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.LoginDao;
import entidades.Usuarios;
import java.util.List;
import views.LoginView;

/**
 *
 * @author Rafael
 */
public class UsuariosController {

    private static UsuariosController instancia = new UsuariosController();
    private LoginView view;
    private Usuarios usuarios = new Usuarios();

    public UsuariosController() {
    }

    public static UsuariosController getInastancia() {
        return instancia;
    }

    public void exibirInterfaceGrafica() {

        if (view == null) {
            view = new LoginView(this);
        }
        view.setVisible(true);
    }
    
    public List listarUsuarios(){
        List<Usuarios> lista =  new LoginDao().listarUsuarios();
        return lista;
    }
}
