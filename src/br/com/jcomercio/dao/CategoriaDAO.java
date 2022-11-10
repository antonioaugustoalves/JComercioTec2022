/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jcomercio.dao;

import br.com.jcomercio.entidades.Categoria;
import br.com.jcomercio.entidades.IBanco;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;



/**
 *
 * @author ANTONIO
 */
public class CategoriaDAO implements IBanco {
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDAO(Categoria categoria) {
        this.categoria = categoria;
    }

   
    
    
    

    @Override
    public boolean salvar() {
        String query = "INSERT INTO categorias "
                +"(nome, descricao) VALUES (?,?)";
        
        try{
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1,categoria.getNome());
            ps.setString(2,categoria.getDescricao());
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean excluir() {
        String query = "DELETE FROM categorias "
                +"WHERE id = ?";
        try{
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1,categoria.getId());
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar() {
        String query = "UPDATE categorias SET "
                +"nome = ?, "
                +"descricao = ? "
                +"WHERE id = ?";
        
        try{
            Connection con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categoria.getNome());
            ps.setString(2, categoria.getDescricao());
            ps.setInt(3, categoria.getId());
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
            
        }
    }

    @Override
    public boolean buscarPorId() {
         String query = "SELECT nome, descricao "
                 +"FROM categorias WHERE id = "
                 +categoria.getId();
         try{
             Connection conexao = Conexao.getConexao();
             PreparedStatement ps = conexao.prepareStatement(query);
             ResultSet rs = ps.executeQuery();
             rs.next();
             if(rs.getRow() > 0){
                 categoria.setNome(rs.getString("nome"));
                 categoria.setDescricao(rs.getString("descricao"));
                 return true;
             }else{
                 System.out.println("Não há resultados");
                 return false;
             }
         }catch(SQLException ex){
             ex.printStackTrace();
             return false;
         }
    }

  public static ArrayList<Categoria> listar(){
      String query = "SELECT id, nome, "
              + "descricao "
              +"FROM categorias ORDER BY nome";
      ArrayList<Categoria> listaDeCategorias = new ArrayList<>();
      
      try{
        Connection con = Conexao.getConexao();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Categoria cat = new Categoria();
            cat.setId(rs.getInt("id"));
            cat.setNome(rs.getString("nome"));
            cat.setDescricao(rs.getString("descricao"));
            
            listaDeCategorias.add(cat);
        }
        
        return listaDeCategorias;
      }catch(SQLException ex){
          ex.printStackTrace();
          return null;
      }
  }

}
