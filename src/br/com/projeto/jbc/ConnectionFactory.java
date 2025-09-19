/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jbc;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author camil
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
      
        try {
        
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/BDVENDAS","teste","123");
        
       }catch(Exception erro) {
           throw new RuntimeException(erro);
       }
    }
}
