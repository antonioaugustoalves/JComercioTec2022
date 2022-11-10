
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jcomercio.entidades;

import java.time.LocalDate;

/**
 *
 * @author ANTONIO
 */
public class Cliente extends Pessoa {
    private LocalDate dataNascimento;
    private String cpf;
    private String estadoCivil;

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return this.id+ " - "+ this.nome;
    }

    public Cliente() {
    }

    public Cliente(int id, String nome) {
        super(id, nome);
    }
    
    
    
    
    
}
