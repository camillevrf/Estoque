/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.DAO;

import br.com.projeto.jbc.ConnectionFactory;
import br.com.projeto.modelo.Fornecedores;
import br.com.projeto.modelo.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author camil
 */
public class ProdutosDAO {

    private Connection con;

    public ProdutosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    //Cadastro

    public void cadastrarProdutos(Produtos obj) {  // o metodo vai receber o objeto empacotado do clienteModelo

        try {
            //Comandos SQL
            String sql = "insert into tb_produtos(descricao,preco,qtd_estoque,for_id)"
                    + "values(?,?,?,?)";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());

            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    //METODO listar todos os Fornecedores
    public List<Produtos> listarProdutos() {
        try {
            //criar lista
            List<Produtos> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id=f.id)";  // p é o apelido dado a tabela produtos, ao inves do for id se mostra o nome do fornecedor na coluna nome e o inner join junta para acontecer essa interação e o on de ligação   
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();        //obj que pega todos os dados de produtos
                Fornecedores f = new Fornecedores();  //obj que pega todos os dados de fornecedores

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));

                obj.setFornecedor(f);

                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "Erro" + erro);
            return null;
        }
    }

    // Alterar
    public void alterarProdutos(Produtos obj) {
        try {
            //Comandos SQL
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());

            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setInt(5, obj.getId());

            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    //Excluir
    public void excluirProdutos(Produtos obj) {
        try {
            String sql = "delete from tb_produtos where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }

    }

    //Buscar produttos
    public List<Produtos> BuscarProdutosPorNome(String nome) {
        try {
            //criar lista
            List<Produtos> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id=f.id) where p.descricao like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();        //obj que pega todos os dados de produtos
                Fornecedores f = new Fornecedores();  //obj que pega todos os dados de fornecedores

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));

                obj.setFornecedor(f);

                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "Erro" + erro);
            return null;
        }
    }

    //
    public Produtos ConsultaPorNome(String nome) {
        try {

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id=f.id) where p.descricao = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();        //obj que pega todos os dados de produtos
            Fornecedores f = new Fornecedores();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));

                obj.setFornecedor(f);

            }
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "Produto não encontrado!");
            return null;
        }
    }

    //Busca produto por cod
    public Produtos buscarPorcodigo(int id) {
        try {

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id=f.id) where p.id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();        //obj que pega todos os dados de produtos
            Fornecedores f = new Fornecedores();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));

                obj.setFornecedor(f);

            }
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "Produto não encontrado!");
            return null;
        }
    }

        //Metodo que atualiza o estoque 
    
    public void baixarEstoque(int id, int qtd_nova){
        try{
            
            String sql = "update tb_produtos set qtd_estoque=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            stmt.execute();
            stmt.close();
       
        }catch (Exception erro) {
            JOptionPane.showConfirmDialog(null, "Erro" + erro);
            
        }
    }

        //Metodo que retorna o estoque atual
    public int retornaEstoqueAtual(int id){
      try{
        int qtd_estoque = 0;
        
        String sql = "SELECT qtd_estoque from tb_produtos where id=?";
        
        PreparedStatement stmt = con.prepareStatement(sql);
            
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
         if (rs.next()) {
             qtd_estoque =(rs.getInt("qtd_estoque"));         
         }
       
         return qtd_estoque;
      }catch (SQLException erro) {
          throw new RuntimeException(erro);
      }   
   
    }

        // metodo para adicionar estoque
    public void adicionarEstoque(int id, int qtd_nova){
        try{
            
            String sql = "update tb_produtos set qtd_estoque=? where id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            stmt.execute();
            stmt.close();
       
        }catch (Exception erro) {
            JOptionPane.showConfirmDialog(null, "Erro" + erro);
            
        }
    }
         

}
