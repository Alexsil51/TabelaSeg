/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author asgama
 */

import model.Registro;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO {
    
    private String url = "jdbc:mysql://localhost:3306/controle_chaves";
    private String user = "root";
    private String password = "1234";
    
     // Método para testar a conexão com o banco de dados
    public void testarConexao() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }

    // Métodos de acesso ao banco de dados
    
     // Método para salvar um novo registro
    public void salvar(Registro registro) {
        String sql = "INSERT INTO Registros (chave_id, funcionario_id, data_retirada) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, registro.getChaveId());
            stmt.setInt(2, registro.getFuncionarioId());
            stmt.setObject(3, registro.getDataRetirada());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    // Método para atualizar um registro existente
    public void atualizar(Registro registro) {
        String sql = "UPDATE Registros SET chave_id = ?, funcionario_id = ?, data_retirada = ?, data_devolucao = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, registro.getChaveId());
            stmt.setInt(2, registro.getFuncionarioId());
            stmt.setObject(3, registro.getDataRetirada());
            stmt.setObject(4, registro.getDataDevolucao());
            stmt.setInt(5, registro.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

*/
    
    // Método para atualizar um registro existente
public void atualizar(Registro registro) {
    String sql = "UPDATE Registros SET chave_id = ?, funcionario_id = ?, data_retirada = ?, data_devolucao = ? WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, registro.getChaveId());
        stmt.setInt(2, registro.getFuncionarioId());
        stmt.setObject(3, registro.getDataRetirada());
        stmt.setObject(4, registro.getDataDevolucao());
        stmt.setInt(5, registro.getId());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Método para registrar a devolução de uma chave (adicionado)
public void devolverChave(int registroId) {
    String sqlUpdate = "UPDATE Registros SET data_devolucao = ?, status = ? WHERE id = ?";
    
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
            stmtUpdate.setObject(1, LocalDateTime.now());  // Data de devolução (agora)
            stmtUpdate.setString(2, "Devolvida");  // Status indicando que a chave foi devolvida
            stmtUpdate.setInt(3, registroId);  // O ID do registro a ser atualizado
            stmtUpdate.executeUpdate();  // Executando a atualização
            
            // Log para depuração
            System.out.println("Executando update para o registro com ID: " + registroId);
            System.out.println("Novo status: Devolvida, Novo horário: " + LocalDateTime.now());

            stmtUpdate.executeUpdate();  // Executando a atualização
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Método para deletar um registro pelo ID
    public void deletar(int id) {
        String sql = "DELETE FROM Registros WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os registros
    public List<Registro> listarTodos() {
        List<Registro> registros = new ArrayList<>();
        String sql = "SELECT * FROM Registros";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Registro registro = new Registro(
                    rs.getInt("id"),
                    rs.getInt("chave_id"),
                    rs.getInt("funcionario_id"),
                    rs.getTimestamp("data_retirada").toLocalDateTime(),
                    rs.getTimestamp("data_devolucao") != null ? rs.getTimestamp("data_devolucao").toLocalDateTime() : null
                );
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Método para buscar um registro pelo ID
    public Registro buscarRegistroPorId(int id) {
        String sql = "SELECT * FROM Registros WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Registro(
                        rs.getInt("id"),
                        rs.getInt("chave_id"),
                        rs.getInt("funcionario_id"),
                        rs.getTimestamp("data_retirada").toLocalDateTime(),
                        rs.getTimestamp("data_devolucao") != null ? rs.getTimestamp("data_devolucao").toLocalDateTime() : null
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
