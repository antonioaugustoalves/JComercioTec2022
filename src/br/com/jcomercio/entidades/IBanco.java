/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.jcomercio.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANTONIO
 */
public interface IBanco {
    public boolean salvar();
    public boolean excluir();
    public boolean atualizar();
    public boolean buscarPorId();
    
}
