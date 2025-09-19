/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.DAO;

import br.com.projeto.jbc.ConnectionFactory;
import br.com.projeto.modelo.Clientes;
import br.com.projeto.modelo.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDate;
/**
 *
 * @author camil
 */
public class VendasDAO {

    private Connection con;

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Cadastrar Venda
    public void cadastrarVenda(Vendas obj) {
        try {
            //Comandos SQL
            String sql = "insert into tb_vendas(cliente_id, data_venda, total_venda, observacoes)"
                    + "values(?,?,?,?)";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_venda());
            stmt.setDouble(3, obj.getTotal_vendas());
            stmt.setString(4, obj.getObs());
            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    //Retorna a ultima venda
    public int retornaUltimaVenda() {
        try {
            int idvenda = 0;    //inicializa com 0 

            String sql = "select max(id) id from tb_vendas";   //função max retorna o valor maximo de id registrado
            PreparedStatement ps = con.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vendas p = new Vendas();
                p.setId(rs.getInt("id"));
                idvenda = p.getId();

            }
            return idvenda;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
       //Metodo de filtrar vendas popr data
    
     public List<Vendas> listarVendasPorPeriodo( LocalDate data_inicial, LocalDate data_final) {
        try {
            //criar lista
            List<Vendas> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select v.id, date_format(v.data_venda,'%d/%m/%Y') as data_formatada, c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                    + " inner join tb_clientes as c on (v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ?";  // select na tabela de vendas (apelido v). o BETWEEN possibilita select entre valores
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1,data_inicial.toString());
            stmt.setString(2,data_final.toString());
           
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas obj = new Vendas();        //obj que pega todos os dados de produtos
                Clientes c = new Clientes();
                
               obj.setId(rs.getInt("v.id"));
               obj.setData_venda(rs.getString("data_formatada"));
               c.setNome(rs.getString("c.nome"));
               obj.setTotal_vendas(rs.getDouble("v.total_venda"));
               obj.setObs(rs.getString("v.observacoes"));

               obj.setCliente(c);
               
               lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "Erro" + erro);
            return null;
        }
    }
        //Metodo calcular total da venda por data
     public double retornaTotalVendaPorData(LocalDate data_venda){
      try {
         double totalvenda = 0;
         
          String sql = "select sum(total_venda) as total from tb_vendas where data_venda=?"; //a função sum calvcula totas as colunas de uma determinada coluna
      
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, data_venda.toString());
      
           ResultSet rs = ps.executeQuery();
           
           if (rs.next()) {
             totalvenda = rs.getDouble("total");
           }
          
           return totalvenda;
           
      }catch (SQLException erro) {
        throw new RuntimeException(erro);  
      }
  
     } 
}
