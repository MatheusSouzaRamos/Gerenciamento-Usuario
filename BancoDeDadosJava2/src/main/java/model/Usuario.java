/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author strik
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    
    public Usuario(int id, String nome, String senha){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario(String nome){
        this.nome = nome;
    }
    
    public Usuario(int id){
        this.id = id;
    }
    
    public Usuario(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getSenha(){
        return senha;
    }
}
