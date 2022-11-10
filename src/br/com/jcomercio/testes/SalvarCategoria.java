/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jcomercio.testes;

import br.com.jcomercio.dao.CategoriaDAO;
import br.com.jcomercio.entidades.Categoria;

/**
 *
 * @author ANTONIO
 */
public class SalvarCategoria {
    public static void main(String[] args) {
        Categoria cat = new Categoria();
        cat.setNome("Peças");
        cat.setDescricao("Peças para computador");
        
        CategoriaDAO cd = new CategoriaDAO(cat);
        
        if(cd.salvar()){
            System.out.println("Sucesso!");
        }else{
            System.out.println("Erro!");
        }
    }
}
