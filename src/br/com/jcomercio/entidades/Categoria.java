/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jcomercio.entidades;

import br.com.jcomercio.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ANTONIO
 */
public class Categoria {
    private int id;
    private String nome;
    private String descricao;
    
    public static void carregarCombo(JComboBox combo, int cod){
        Categoria categoria = null;
        String sql = "SELECT id, upper(nome)as nome FROM categorias";
        combo.removeAllItems();
        combo.addItem("SELECIONE UMA CATEGORIA");
        try{
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Categoria cat = new Categoria(rs.getInt("id"), rs.getString("nome"));
                if(cod == rs.getInt("id")){
                    categoria = cat;
                }
                
                combo.addItem(cat);
            }
            
            if(categoria != null){
                combo.setSelectedItem(categoria);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de onexão, não foi possivel carregar as categorias");
            ex.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    //toString
    @Override
    public String toString() {
        return this.id+" - "+this.nome;
    }
    
    //Construtor
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria() {
    }
    
    public static boolean validarNome(String strNome){
        boolean ehValido = false;
        if (strNome.length() >= 2){
            ehValido = true;
        }
        return ehValido;
    }
    
    
    
    
  
    
    
}
