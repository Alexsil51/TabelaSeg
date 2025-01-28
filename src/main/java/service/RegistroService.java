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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.List;
import model.Registro;
import java.util.ArrayList;
import model.Chave;


public class RegistroService {
    
    private RegistroDAO registroDAO = new RegistroDAO();
    private final String url = "jdbc:mysql://localhost:3306/controle_chaves";
    private final String user = "root";
    private final String password = "1234";

    
    public List<Chave> obterChavesEmprestadas() {
    List<Chave> chaves = new ArrayList<>();
    String sql = "SELECT id, descricao, status FROM Chaves WHERE status = 'Emprestada'";

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Chave chave = new Chave(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getString("status")
            );
            chaves.add(chave);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return chaves;
}

/*
public List<Chave> obterChavesEmprestadas() {
        // Simulação de dados para exemplo
        List<Chave> chaves = new ArrayList<>();
        chaves.add(new Chave(1, "Chave A", "Emprestada"));
        chaves.add(new Chave(2, "Chave B", "Disponível"));
        return chaves;
    }
*/
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