/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.DAO;

import br.com.projeto.jbc.ConnectionFactory;
import br.com.projeto.modelo.Clientes;
import br.com.projeto.modelo.ItemVenda;
import br.com.projeto.modelo.Produtos;
import br.com.projeto.modelo.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author camil
 */
public class ItemVendaDAO {
    private Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

        //metodo cadastra Itens
    public void cadastraItem(ItemVenda obj){
       try {
            //Comandos SQL
            String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal)"
                    + "values(?,?,?,?)";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
            
            //Execução do comando SQL
            stmt.execute();
            stmt.close();

           

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    } 
       // metodo listar itens vendidos por id
     public List<ItemVenda> listarVendasPorVenda( int venda_id) {
        try {
            //criar lista
            List<ItemVenda> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select p.descricao,i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                    + " inner join tb_produtos as p on (i.produto_id = p.id) where i.venda_id = ?";  
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,venda_id);
           
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               ItemVenda item = new ItemVenda();
               Produtos prod = new Produtos();
               
               prod.setDescricao(rs.getString("p.descricao"));
               item.setQtd(rs.getInt("i.qtd"));
               prod.setPreco(rs.getDouble("p.preco"));
               item.setSubtotal(rs.getDouble("i.subtotal"));
               
               item.setProduto(prod);
               
               lista.add(item);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "Erro" + erro);
            return null;
        }
    }



}
    

