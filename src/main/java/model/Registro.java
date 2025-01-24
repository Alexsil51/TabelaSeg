/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asgama
 */

import java.time.LocalDateTime;


public class Registro {
    
   private int id;
    private int chaveId;
    private int funcionarioId;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;

    // Construtor que está sendo usado no RegistroService
    public Registro(int id, int chaveId, int funcionarioId, LocalDateTime dataRetirada) {
        this.id = id;
        this.chaveId = chaveId;
        this.funcionarioId = funcionarioId;
        this.dataRetirada = dataRetirada;
    }

    // Construtor completo
    public Registro(int id, int chaveId, int funcionarioId, LocalDateTime dataRetirada, LocalDateTime dataDevolucao) {
        this.id = id;
        this.chaveId = chaveId;
        this.funcionarioId = funcionarioId;
        this.dataRetirada = dataRetirada;
        this.dataDevolucao = dataDevolucao;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChaveId() {
        return chaveId;
    }

    public void setChaveId(int chaveId) {
        this.chaveId = chaveId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public LocalDateTime getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDateTime dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
