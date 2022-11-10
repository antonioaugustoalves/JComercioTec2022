/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jcomercio.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ANTONIO
 */
public class Conexao {

    private static final String SERVIDOR = "jdbc:postgresql://localhost:5432/jcomercio";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "2312";
    
    public static void main(String[] args) {
        try{
            Connection con = Conexao.getConexao();
            JOptionPane.showMessageDialog(null, "Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro de conexao!");
        }
    }

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Falha na conexão!");
        }
    }

}
