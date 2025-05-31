/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.Conexao;
import Dao.UsuarioDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;
import view.ConsultarView;

/**
 *
 * @author strik
 */
public class ConsultarController {
    private final ConsultarView view;
    
    public ConsultarController(ConsultarView view){
        this.view = view;
    }
    
    public void consultarTodosUsuarios() throws SQLException{
        Connection conexao = new Conexao().getConnection();
        UsuarioDao userDao = new UsuarioDao(conexao);
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = userDao.buscarTodosUsuarios();
        //System.out.println(usuarios);
        for(int i = 0; i < usuarios.size(); i++){
            String id = Integer.toString(usuarios.get(i).getId());
            String nome = usuarios.get(i).getNome();
            
            view.setarValorTabela(id, i, 0);
            view.setarValorTabela(nome, i, 1);
        }
        
        
    }

    public void consultarUsuarioNomeId() throws SQLException {
        boolean fila = false;
        String consulta = view.getjTextField1().getText();
        if(!consulta.isBlank()){
            Connection conexao = new Conexao().getConnection();
            UsuarioDao userDao = new UsuarioDao(conexao);
            view.limparTabela();
            
            if(userDao.existeUsuarioEsteNome(consulta)){
                Usuario usuario = userDao.buscarUsuarioNome(new Usuario(consulta));
                view.setarValorTabela(Integer.toString(usuario.getId()), 0, 0);
                view.setarValorTabela(usuario.getNome(), 0, 1);
                fila = true;
            }
            
            int id = 0;
            try{
                id = Integer.parseInt(consulta);
            }catch(NumberFormatException e){}
            
            if(userDao.existeUsuarioEsteId(id)){
                Usuario usuario = userDao.buscarUsuarioId(new Usuario(id));
                
                if(!fila){
                    view.setarValorTabela(Integer.toString(usuario.getId()), 0, 0);
                    view.setarValorTabela(usuario.getNome(), 0, 1);
                }else{
                    view.setarValorTabela(Integer.toString(usuario.getId()), 1, 0);
                    view.setarValorTabela(usuario.getNome(), 1, 1);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Informe um ID/Usuário", "Erro:", 0);
        }
    }
}
