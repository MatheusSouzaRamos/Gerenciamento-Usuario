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
import view.EditarView;

/**
 *
 * @author strik
 */
public class EditarController {
    
    private final EditarView view;
    
    public EditarController(EditarView view){
        this.view = view;
    }
    
    public void trocarNomeUsuario() throws SQLException{
        String nome = view.getjTextField1().getText();
        String senha = view.getjPasswordField1().getText();
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDao userDao = new UsuarioDao(conexao);
        Usuario usuario = new Usuario(nome,senha);
        
        if(!nome.isBlank() && !senha.isBlank()){
            String novoNome = view.getjTextField2().getText();
            if(!novoNome.isBlank()){
                if(userDao.validarUsuario(usuario)){
                    
                    if( userDao.existeUsuarioEsteNome(novoNome) ){
                        JOptionPane.showMessageDialog(null, "Usuário já existente, tente outro nome de usuário", "Erro:", 0);
                    }else{
                        userDao.editarNomeUsuarioBancoDados(usuario, novoNome);
                        JOptionPane.showMessageDialog(null, "Nome de usuário alterado", "Info:", 1);
                        view.limparCampos();
                    }   
                }else{
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado / Senha incorreta", "Erro:", 0);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Insira um novo nome", "Erro:", 0);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Insira um usuário válido", "Erro:", 0);
        }
    }
    
    public void trocarSenhaUsuario() throws SQLException{
        String nome = view.getjTextField1().getText();
        String senha = view.getjPasswordField1().getText();
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDao userDao = new UsuarioDao(conexao);
        
        Usuario usuario = new Usuario(nome, senha);
        
        if(!nome.isBlank() && !senha.isBlank()){
            String novaSenha = view.getjPasswordField2().getText();
            String cNovaSenha = view.getjPasswordField3().getText();
            
            if(!novaSenha.isBlank() && !cNovaSenha.isBlank()){
                if(novaSenha.equals(cNovaSenha)){
                    if(userDao.validarUsuario(usuario)){
                        userDao.editarSenhaUsuarioBancoDados(usuario, novaSenha);
                        JOptionPane.showMessageDialog(null, "Senha de usuário alterada", "Info", 1);
                        view.limparCampos();
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro:", 0);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Erro:", 0);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Insira a senha nos dois campos correspondentes", "Erro:", 0);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Insira um usuário válido", "Erro:", 0);
        }
    }
    
}
