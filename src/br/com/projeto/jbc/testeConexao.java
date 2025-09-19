/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jbc;

import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class testeConexao {
   
  public static void main(String[]args){
      
      try{
          
          new ConnectionFactory().getConnection();
          JOptionPane.showMessageDialog(null, "Conectado com Sucesso!");
      } catch(Exception erro){
         JOptionPane.showMessageDialog(null, "Não Conectado!"+erro); 
      }
  }
}
