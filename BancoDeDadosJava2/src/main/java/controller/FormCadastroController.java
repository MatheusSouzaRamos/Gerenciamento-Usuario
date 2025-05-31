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
import view.FormCadastroView;

/**
 *
 * @author strik
 */
public class FormCadastroController {
    
    private final FormCadastroView view;
    
    public FormCadastroController(FormCadastroView view){
        this.view = view;
    }
      
    public void cadastrarUsuarioBancoDados() throws SQLException{
        String nome = view.getjTextField1().getText();
        String senha = view.getjPasswordField1().getText();
        String cSenha = view.getjPasswordField2().getText();
        
        if(!nome.isBlank() && !senha.isBlank() && !cSenha.isBlank()){
            if(senha.equals(cSenha)){
                Connection conexao = new Conexao().getConnection();
                UsuarioDao userDao = new UsuarioDao(conexao);
                Usuario usuario = new Usuario(nome,senha);
                if(userDao.existeUsuarioEsteNome(usuario.getNome())){
                    JOptionPane.showMessageDialog(null, "Usuário já cadastrado, tente novamente.", "Erro:", 0);
                }else{
                    userDao.inserirUsuarioBancoDados(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado.", "Info:", 1);
                    view.limparCampos();
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "As senhas não coincidem", "Erro:", 0);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Insisira um cadastro válido.", "Erro:", 0);
        }
    }
    
}
