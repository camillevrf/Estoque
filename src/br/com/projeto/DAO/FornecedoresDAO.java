/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.DAO;

import br.com.projeto.jbc.ConnectionFactory;
import br.com.projeto.modelo.Fornecedores;
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
public class FornecedoresDAO {
     // Conexão
  private Connection con;

    public FornecedoresDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    //Cadastrar Fornecedores
    public void cadastrarFornecedores(Fornecedores obj) {  // o metodo vai receber o objeto empacotado do clienteModelo

        try {
            //Comandos SQL
       String sql = "insert into tb_fornecedores(nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql); //classe utilizada para tratar os comandos SQL e executar
            stmt.setString(1, obj.getNome());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um nome
            stmt.setString(2, obj.getCnpj());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um rg
            stmt.setString(3, obj.getEmail());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(4, obj.getTelefone());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um telefone
            stmt.setString(5, obj.getCelular());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um celular
            stmt.setString(6, obj.getCep());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cep
            stmt.setString(7, obj.getEndereço());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá endereco
            stmt.setInt(8, obj.getNumero());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um numero
            stmt.setString(9, obj.getComplemento());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um complemento
            stmt.setString(10, obj.getBairro());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um bairro
            stmt.setString(11, obj.getCidade());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cidade
            stmt.setString(12, obj.getUf());   // i

            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
            //METODO ALTERAR Fornecedor
    public void alterarFornecedor(Fornecedores obj) {
            try {
            //Comandos SQL
            String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, "
                    +"endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id =?";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql); //classe utilizada para tratar os comandos SQL e executar
            stmt.setString(1, obj.getNome());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um nome
            stmt.setString(2, obj.getCnpj());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um rg
            stmt.setString(3, obj.getEmail());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(4, obj.getTelefone());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um telefone
            stmt.setString(5, obj.getCelular());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um celular
            stmt.setString(6, obj.getCep());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cep
            stmt.setString(7, obj.getEndereço());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá endereco
            stmt.setInt(8, obj.getNumero());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um numero
            stmt.setString(9, obj.getComplemento());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um complemento
            stmt.setString(10, obj.getBairro());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um bairro
            stmt.setString(11, obj.getCidade());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cidade
            stmt.setString(12, obj.getUf());   // i
            
            stmt.setInt(13,obj.getId());
            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
    //METODO EXCLUIR CLIENTE

    public void excluirFonecedor(Fornecedores obj) {
        try {
            //Comandos SQL
            String sql = "delete from tb_fornecedores where id=?";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql); //classe utilizada para tratar os comandos SQL e executar
            stmt.setInt(1,obj.getId()); 
     
            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
        //METODO listar todos os Fornecedores
    public List<Fornecedores> listarFornecedores() {
        try {
            //criar lista
            List<Fornecedores> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select * from tb_fornecedores";
            PreparedStatement stmt = con.prepareStatement(sql);

            java.sql.ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedores obj = new Fornecedores();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereço(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }
 //metodo consultaCliente por Nome 
        public Fornecedores ConsultaPorNome(String nome){
            try{
            
            String sql = "select * from tb_fornecedores where nome = ?"; //procura todos os clientes cujo sejam parecidos
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            java.sql.ResultSet rs = stmt.executeQuery();
            Fornecedores obj = new Fornecedores();
            
             if (rs.next()) {                   //se ele encontrar alguem, ele vai mudar o objeto e retorna
 
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereço(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
             }
             return obj;
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Fornecedor não encontrado");
            return null;
        }
    }
       
        
        //METODO PARA BUSCAR CLIENTES - retorna uma lista
    
     public List<Fornecedores> BuscarFornecedoresPorNome(String nome) {
        try {
            //criar lista
            List<Fornecedores> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select * from tb_fornecedores where nome like ?"; //procura todos os clientes cujo sejam parecidos
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
           
            
            while (rs.next()) {
                 Fornecedores obj = new Fornecedores();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereço(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    } 






}
