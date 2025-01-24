/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author asgama
 */

import dao.ChaveDAO;
import dao.RegistroDAO;


import java.util.List;
import model.Registro;
import java.util.ArrayList;
import model.Chave;


public class RegistroService {
    
    private RegistroDAO registroDAO = new RegistroDAO();


public List<Chave> obterChavesEmprestadas() {
        // Simulação de dados para exemplo
        List<Chave> chaves = new ArrayList<>();
        chaves.add(new Chave(1, "Chave A", "Emprestada"));
        chaves.add(new Chave(2, "Chave B", "Disponível"));
        return chaves;
    }

    public void adicionarRegistro(Registro registro) {
        registroDAO.salvar(registro);
    }

    public void editarRegistro(Registro registro) {
        registroDAO.atualizar(registro);
    }

    public void removerRegistro(int id) {
        registroDAO.deletar(id);
    }

    public List<Registro> listarRegistros() {
        return registroDAO.listarTodos();
    }

    public Registro buscarRegistroPorId(int id) {
        return registroDAO.buscarRegistroPorId(id);
    }

}
    /*
    public Object obterChavesEmprestadas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    }
    

*/