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
import model.Chave;

import java.util.List;

public class ChaveService {
    
    private ChaveDAO chaveDAO = new ChaveDAO();

    public void adicionarChave(Chave chave) {
        chaveDAO.salvar(chave);
    }

    public void editarChave(Chave chave) {
        chaveDAO.atualizar(chave);
    }

    public void removerChave(int id) {
        chaveDAO.deletar(id);
    }

    public List<Chave> listarChaves() {
        return chaveDAO.listarTodos();
    }
}
