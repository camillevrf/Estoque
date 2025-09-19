/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.modelo;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author camil
 */
public class Utilitarios {
    //metodo para limpar os campos - assim, ele percorre todos os componentes e coloca o texto nulo
    
    public void Limpatela(JPanel container){
        Component components[] = container.getComponents();
        for (Component component : components){
            if (component instanceof JTextField){
                ((JTextField) component).setText(null);
            }
        }
    } 
    
    
}


