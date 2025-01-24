/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asgama
 */



public class Chave {
    private int id;
    private String descricao;
    private String status;

    // Construtor completo
    public Chave(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    // Construtor parcial
    public Chave(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.status = "Disponível";
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
















/*

public class Chave {
    
    
    private int id;
    private String descricao;
    private String status;
    
    // Construtores, getters e setters
    
    public Chave(int id, String descricao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

public String getStatus() {
        return status;
    }

  public void setStatus(String status) {
        this.status = status;
    }
}

    public Object getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}



*/

