/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jcomercio.dao;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.jcomercio.entidades.Caixa;
import br.com.jcomercio.entidades.IBanco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANTONIO
 */
public class CaixaDAO implements IBanco{
    private Caixa caixa = new Caixa();

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public CaixaDAO(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public boolean salvar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean buscarPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static List listar(){
        List<Caixa> movimentos = new ArrayList();
        String sql = "SELECT id, cliente_id, fornecedor_id, tipo_movimento, valor "
                +"FROM caixa";
        try{
            Connection con = Conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Caixa cx = new Caixa();
                cx.setId(rs.getInt("id"));
                cx.setIdCliente(rs.getInt("cliente_id"));
                cx.setIdFornecedor(rs.getInt("fornecedor_id"));
                cx.setTipoMovimento(rs.getString("tipo_movimento"));
                cx.setValor(rs.getDouble("valor"));
                movimentos.add(cx);
            }
            
            return movimentos;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        
    }
    
    
    public static void main(String[] args) {
        double entrada = 0;
        double saida = 0;
        double saldo = 0;
        
        List<Caixa> movimentacao = CaixaDAO.listar();
        
        for(Caixa cx : movimentacao){
            if(cx.getTipoMovimento().equals("E")){
                entrada = entrada + cx.getValor();
            }else{
                saida = saida + cx.getValor();
            }
        }
        
        saldo = entrada - saida;
        System.out.println("Entrada: "+ entrada);
        System.out.println("Saida: "+ saida);
        System.out.println("Saldo: "+ saldo);
    }
    
}
