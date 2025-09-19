/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.modelo;

/**
 *
 * @author camil
 */
public class Funcionarios extends Clientes{  //extensão da classe cliente
    //Atributos
    private String Senha;
    private String Cargo;
    private String Nivel_Acesso;
    
    //GETTERS E SETTERS 

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getNivel_Acesso() {
        return Nivel_Acesso;
    }

    public void setNivel_Acesso(String Nivel_Acesso) {
        this.Nivel_Acesso = Nivel_Acesso;
    }
    
}
