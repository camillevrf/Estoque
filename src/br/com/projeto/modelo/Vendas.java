/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.modelo;

/**
 *
 * @author camil
 */
public class Vendas {
  //Atributos
  private int id;
  private Clientes cliente;
  private String data_venda;
  private double total_vendas;
  private String obs;
    
  // getter e setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public double getTotal_vendas() {
        return total_vendas;
    }

    public void setTotal_vendas(double total_vendas) {
        this.total_vendas = total_vendas;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
  
}
