/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.modelo;

/**
 *
 * @author camil
 */
public class Fornecedores extends Clientes {
    private String cnpj;
    
    //getters e setters

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
        @Override //representa sobre escrita
    public String toString(){
        return this.getNome();
    }
}
