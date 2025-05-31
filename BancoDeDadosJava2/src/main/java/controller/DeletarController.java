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
import view.DeletarView;

/**
 *
 * @author strik
 */
public class DeletarController {
    private final DeletarView view;
    
    public DeletarController(DeletarView view){
        this.view = view;
    }
    
    public void deletarUsuario() throws SQLException{
        String nome = view.getjTextField1().getText();
        String senha = view.getjPasswordField1().getText();
        String cSenha = view.getjPasswordField2().getText();
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDao userDao = new UsuarioDao(conexao);
        
        if(!nome.isEmpty() && !senha.isEmpty() && !cSenha.isEmpty()){
            if(senha.equals(cSenha)){
                Usuario usuario = new Usuario(nome, senha);
                if(userDao.validarUsuario(usuario)){
                    userDao.deletarUsuarioBancoDados(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário deletado.", "Info:", 1);
                    view.limparCampos();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuário/Senha incoreta.", "Erro:", 0);
                }    
            }else{
                JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Erro:", 0);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Informe um usuário válido.", "Eroo:", 0);
        }

    }
    
}
