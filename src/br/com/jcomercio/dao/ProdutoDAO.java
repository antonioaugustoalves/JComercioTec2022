/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jcomercio.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import br.com.jcomercio.entidades.IBanco;
import java.util.ArrayList;
import java.util.List;

import br.com.jcomercio.entidades.IBanco;
import br.com.jcomercio.entidades.Produto;

/**
 *
 * @author ANTONIO
 */
public class ProdutoDAO implements IBanco {

    private Produto produto = new Produto();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutoDAO(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean salvar() {
        String sql = "INSERT INTO produtos (nome, descricao, quantidade, preco, categoria_id) "
                + "VALUES (?,?,?,?,?)";
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getQuantidade());
            pst.setDouble(4, produto.getPreco());
            pst.setInt(5, produto.getCodCategoria());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean excluir() {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, produto.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean atualizar() {
        String sql = "UPDATE produtos SET "
                + "nome = ?, descricao = ?, "
                + "preco = ?, quantidade = ?, "
                + "categoria_id = ? "
                + "WHERE id = ?";
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPreco());
            pst.setDouble(4, produto.getQuantidade());
            pst.setInt(5, produto.getCodCategoria());
            pst.setInt(6, produto.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean buscarPorId() {
        String sql = "SELECT id, nome, descricao, preco, quantidade, categoria_id "
                + "FROM categorias "
                + "WHERE id = " + produto.getId();

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            rs.next();

            if (rs.getRow() > 0) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setCodCategoria(rs.getInt("categoria_id"));
                return true;
            } else {
                System.out.println("Categoria não encontrada");
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }

    }
    
     public static ArrayList<Produto> listar() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT p.id as id, p.nome as nome, p.descricao as descricao, p.preco as preco, "
                + "p.quantidade as quantidade, c.nome as categoria FROM produtos p, categorias c "
                +"WHERE p.categoria_id = c.id";
        
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidade(rs.getDouble("quantidade"));
                prod.setCategoriaNome(rs.getString("categoria"));
                
                produtos.add(prod);
            }

            return produtos;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}