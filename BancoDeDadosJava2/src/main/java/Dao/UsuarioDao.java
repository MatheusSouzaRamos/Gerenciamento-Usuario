/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author strik
 */
public class UsuarioDao {
    
    private final Connection connection;
    
    public UsuarioDao(Connection connection){
        this.connection = connection;
    }
    
    public void inserirUsuarioBancoDados(Usuario usuario) throws SQLException{
        String sql = "insert into usuario(nome,senha) values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSenha());
        statement.execute();
    }
    
    public boolean validarUsuario(Usuario usuario) throws SQLException{
        String sql = "select * from usuario where nome = ? and senha = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultado = statement.getResultSet();
        
        return resultado.next();
    }
    
    public void deletarUsuarioBancoDados(Usuario usuario) throws SQLException{
        String sql = "delete from usuario where nome = ? and senha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSenha());
        statement.execute();
    }
    
    // listar todos
    public ArrayList<Usuario> buscarTodosUsuarios() throws SQLException{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        String sql = "select * from usuario";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultado = statement.getResultSet();
        
        while(resultado.next()){
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            usuarios.add(new Usuario(id, nome));
        }
        
        return usuarios;
    }
    
     // buscar um em especifico
    public Usuario buscarUsuarioNome(Usuario usuarioBuscar) throws SQLException{
        String sql = "select * from usuario where nome = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuarioBuscar.getNome());
        statement.execute();
        
        Usuario usuario = new Usuario("", "");
        ResultSet resultado = statement.getResultSet();
        if(resultado.next()){
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            usuario.setId(id);
            usuario.setNome(nome);
        }
        
        return usuario;
    }
    
    public Usuario buscarUsuarioId(Usuario usuarioBuscar) throws SQLException{
        String sql = "select * from usuario where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuarioBuscar.getId());
        statement.execute();
        
        Usuario usuario = new Usuario("", "");
        
        ResultSet resultado = statement.getResultSet();
        
        if(resultado.next()){
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            usuario.setId(id);
            usuario.setNome(nome);
        }
        return usuario;
    }
    
    public boolean existeUsuarioEsteNome(String nome) throws SQLException{
        String sql = "select from usuario where nome = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado.next();
    }
    
    public boolean existeUsuarioEsteId(int id) throws SQLException {
        String sql = "select from usuario where id = ?";
        PreparedStatement statemant = connection.prepareStatement(sql);
        statemant.setInt(1, id);
        statemant.execute();
        ResultSet resultado = statemant.getResultSet();
        return resultado.next();
    }
    
    // editar usuario
    
    public void editarNomeUsuarioBancoDados(Usuario usuario, String novoNome) throws SQLException{
        String sql = "update usuario set nome = ? where nome = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, novoNome);
        statement.setString(2, usuario.getNome());
        statement.execute();
    }
    
    public void editarSenhaUsuarioBancoDados(Usuario usuario, String novaSenha) throws SQLException{
        String sql = "update usuario set senha = ? where nome = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, novaSenha);
        statement.setString(2, usuario.getNome());
        statement.execute();
    }
}
