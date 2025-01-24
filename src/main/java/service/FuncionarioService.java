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
import dao.FuncionarioDAO;
import model.Chave;

import java.util.List;
import model.Funcionario;

public class FuncionarioService {
    
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioDAO.salvar(funcionario);
    }

    public void editarFuncionario(Funcionario funcionario) {
        funcionarioDAO.atualizar(funcionario);
    }

    public void removerFuncionario(int id) {
        funcionarioDAO.deletar(id);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioDAO.listarTodos();
    }
}
