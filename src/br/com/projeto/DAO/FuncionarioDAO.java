/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.DAO;

import br.com.projeto.jbc.ConnectionFactory;
import br.com.projeto.modelo.Funcionarios;
import br.com.projeto.tela_views.Formulario_Menu;
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
public class FuncionarioDAO {
   // Conexão
  private Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

     // Metodo de Cadastrar
     public void cadastrarFuncionarios(Funcionarios obj) {  // o metodo vai receber o objeto empacotado do clienteModelo

        try {
            //Comandos SQL
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql); //classe utilizada para tratar os comandos SQL e executar
            stmt.setString(1, obj.getNome());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um nome
            stmt.setString(2, obj.getRg());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um rg
            stmt.setString(3, obj.getCpf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cpf
            stmt.setString(4, obj.getEmail());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(5, obj.getSenha());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(6, obj.getCargo());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(7, obj.getNivel_Acesso());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(8, obj.getTelefone());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um telefone
            stmt.setString(9, obj.getCelular());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um celular
            stmt.setString(10, obj.getCep());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cep
            stmt.setString(11, obj.getEndereço());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá endereco
            stmt.setInt(12, obj.getNumero());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um numero
            stmt.setString(13, obj.getComplemento());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um complemento
            stmt.setString(14, obj.getBairro());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um bairro
            stmt.setString(15, obj.getCidade());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cidade
            stmt.setString(16, obj.getUf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um estado

            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

            //Metodo listar todos os funcionários
     public List<Funcionarios> listarFuncionarios() {
        try {
            //criar lista
            List<Funcionarios> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(); //obj que recebe a execução de um select

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_Acesso(rs.getString("nivel_acesso"));
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

            //metodo excluir funcionario
            public void excluirFuncionario(Funcionarios obj) {
        try {
            //Comandos SQL
            String sql = "delete from tb_funcionarios where id=?";

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
             //METODO ALTERAR Funcionario
        public void alterarFuncionario(Funcionarios obj) {
            try {
            //Comandos SQL
            String sql = "update tb_funcionarios set nome=?, rg=?,cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, "
                    +"endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id =?";

            //conectar o banco de dado e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql); //classe utilizada para tratar os comandos SQL e executar
            stmt.setString(1, obj.getNome());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um nome
            stmt.setString(2, obj.getRg());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um rg
            stmt.setString(3, obj.getCpf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cpf
            stmt.setString(4, obj.getEmail());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(5, obj.getSenha());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(6, obj.getCargo());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(7, obj.getNivel_Acesso());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um email
            stmt.setString(8, obj.getTelefone());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um telefone
            stmt.setString(9, obj.getCelular());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um celular
            stmt.setString(10, obj.getCep());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cep
            stmt.setString(11, obj.getEndereço());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá endereco
            stmt.setInt(12, obj.getNumero());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um numero
            stmt.setString(13, obj.getComplemento());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um complemento
            stmt.setString(14, obj.getBairro());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um bairro
            stmt.setString(15, obj.getCidade());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um cidade
            stmt.setString(16, obj.getUf());   // isso mostra que a cada interrogação, o que estiver no atributo obj ele receberá um estado
 
            stmt.setInt(17,obj.getId());
            //Execução do comando SQL
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
             //metodo consultaCliente por Nome 
        public Funcionarios ConsultaPorNome(String nome){
            try{
            
            String sql = "select * from tb_funcionarios where nome = ?"; //procura todos os clientes cujo sejam parecidos
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();
            
             if (rs.next()) {                   //se ele encontrar alguem, ele vai mudar o objeto e retorna
 
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_Acesso(rs.getString("nivel_acesso"));
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
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
            return null;
        }
    }
        
        
            
    
        
        //METODO PARA BUSCAR Funcionario - retorna uma lista
    
     public List<Funcionarios> BuscarClientesPorNome(String nome) {
        try {
            //criar lista
            List<Funcionarios> lista = new ArrayList<>();
            //Criar o comando sql e executar
            String sql = "select * from tb_funcionarios where nome like ?"; //procura todos os clientes cujo sejam parecidos
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
           
            
            while (rs.next()) {
                 Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_Acesso(rs.getString("nivel_acesso"));
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

           //Metodo de efetuar Login
         public void efetuaLogin(String email,String senha){
            try{
                
                //comando sql
              String sql="select * from tb_funcionarios where email=? and senha=?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, email);
              stmt.setString(2, senha);
              
              ResultSet rs = stmt.executeQuery();
              
               if (rs.next()) {
                //usuario logou
                
                
                //se o usuario seja do tipo admin
                if(rs.getString("nivel_acesso").equals("Administrador")){   //captura o nível de acesso
                
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo ao Sistema!");   
                    Formulario_Menu tela= new  Formulario_Menu();
                    tela.usuariologado=rs.getString("nome");
                    tela.setVisible(true);
                }
                else if(rs.getString("nivel_acesso").equals("Usuário")){
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo ao Sistema!");   
                    Formulario_Menu tela= new  Formulario_Menu();
                    tela.usuariologado=rs.getString("nome");
                    
                    tela.menu_posicao.setVisible(false);
                    tela.menu_controlevendas.setVisible(false);
                    
                    tela.setVisible(true); 
                }   
                
                
               
               }else{
                JOptionPane.showMessageDialog(null, "Email ou Senha incorreta. Verifique os dados e tente novamente. ");   
               }

              
            } catch(SQLException erro){
                 JOptionPane.showMessageDialog(null, "Erro:" + erro);
            }
         }
     
    
     
}
