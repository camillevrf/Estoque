/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.DAO;

import java.sql.Connection;
import br.com.projeto.modelo.Clientes;
import br.com.projeto.jbc.ConnectionFactory;
import br.com.projeto.modelo.WebServiceCep;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

/*
 *
 * @author camil
 */
public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //METODO CADASTRAR CLIENTE
    public void cadastrarCliente(Clientes obj) {  // o metodo vai receber o objeto empacotado do clienteModelo

        try {
            //Comandos SQL
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql); //classe utilizada para tratar os comandos SQL e executar
            stmt.setString(1, obj.getNome());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um nome
            stmt.setString(2, obj.getRg());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um rg
            stmt.setString(3, obj.getCpf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cpf
            stmt.setString(4, obj.getEmail());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(5, obj.getTelefone());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um telefone
            stmt.setString(6, obj.getCelular());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um celular
            stmt.setString(7, obj.getCep());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cep
            stmt.setString(8, obj.getEndereço());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá endereco
            stmt.setInt(9, obj.getNumero());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um numero
            stmt.setString(10, obj.getComplemento());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um complemento
            stmt.setString(11, obj.getBairro());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um bairro
            stmt.setString(12, obj.getCidade());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cidade
            stmt.setString(13, obj.getUf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um estado

            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    //METODO ALTERAR CLIENTE
    public void alterarCliente(Clientes obj) {
            try {
            //Comandos SQL
            String sql = "update tb_clientes set nome=?, rg=?,cpf=?, email=?, telefone=?, celular=?, cep=?, "
                    +"endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id =?";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql); //classe utilizada para tratar os comandos SQL e executar
            stmt.setString(1, obj.getNome());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele alterara um nome
            stmt.setString(2, obj.getRg());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um rg
            stmt.setString(3, obj.getCpf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um cpf
            stmt.setString(4, obj.getEmail());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um email
            stmt.setString(5, obj.getTelefone());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um telefone
            stmt.setString(6, obj.getCelular());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um celular
            stmt.setString(7, obj.getCep());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um cep
            stmt.setString(8, obj.getEndereço());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' endereco
            stmt.setInt(9, obj.getNumero());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um numero
            stmt.setString(10, obj.getComplemento());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um complemento
            stmt.setString(11, obj.getBairro());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um bairro
            stmt.setString(12, obj.getCidade());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um cidade
            stmt.setString(13, obj.getUf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele '' um estado
            
            stmt.setInt(14,obj.getId());
            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
    //METODO EXCLUIR CLIENTE

    public void excluirCliente(Clientes obj) {
        try {
            //Comandos SQL
            String sql = "delete from tb_clientes where id=?";

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

    //METODO listar todos os CLIENTES
    public List<Clientes> listarClientes() {
        try {
            //criar lista
            List<Clientes> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
        public Clientes ConsultaPorNome(String nome){
            try{
            
            String sql = "select * from tb_clientes where nome = ?"; //procura todos os clientes cujo sejam parecidos
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            
             if (rs.next()) {                   //se ele encontrar alguem, ele vai mudar o objeto e retorna
 
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
        //metodo consultaCliente por cpf
        public Clientes ConsultaPorCPF(String cpf){
            try{
            
            String sql = "select * from tb_clientes where cpf = ?"; //procura todos os clientes cujo sejam parecidos
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            
             if (rs.next()) {                   //se ele encontrar alguem, ele vai mudar o objeto e retorna
 
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
                JOptionPane.showMessageDialog(null, "Cliente não encontrado");
            return null;
        }
    }
        
        //METODO PARA BUSCAR CLIENTES - retorna uma lista
    
     public List<Clientes> BuscarClientesPorNome(String nome) {
        try {
            //criar lista
            List<Clientes> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select * from tb_clientes where nome like ?"; //procura todos os clientes cujo sejam parecidos
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
           
            
            while (rs.next()) {
                 Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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

        // metodo de Busca pelo CEP

        public Clientes buscaCep(String cep) {    //parametro de cep
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep); //pesquisa
       

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {        // se a pesquisa tiver sucesso ele retorna os obj
            obj.setEndereço(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }


}
    