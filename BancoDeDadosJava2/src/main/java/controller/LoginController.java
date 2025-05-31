/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.Conexao;
import Dao.UsuarioDao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author strik
 */
public class LoginController {
    
    private LoginView view;
    
    public LoginController(LoginView view){
        this.view = view;
    }
    
    public void entrarComNomeSenha() throws SQLException{
        // validar campos
        String nome = view.getjTextField1().getText();
        String senha = view.getjPasswordField1().getText();
        
        if(!nome.isEmpty() && !senha.isBlank()){
            Connection conexao = new Conexao().getConnection();
            UsuarioDao userDao = new UsuarioDao(conexao);
            if(userDao.validarUsuario(new Usuario(nome,senha))){
                MenuView telaApp = new MenuView();
                telaApp.setVisible(true);
                view.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Usuário inválido", "Erro:", 0);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Insira um usuário válido", "Erro:", 0);
        }
        // validar usuario
        // transferir para outra tela
    
        
    }
    
}
