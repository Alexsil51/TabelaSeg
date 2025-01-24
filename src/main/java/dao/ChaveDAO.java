/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author asgama
 */

import model.Chave;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChaveDAO {
    
    private String url = "jdbc:mysql://localhost:3306/controle_chaves";
    private String user = "root";
    private String password = "1234";

    // Métodos de acesso ao banco de dados
    
    public void salvar(Chave chave) {
        String sql = "INSERT INTO Chaves (descricao) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, chave.getDescricao());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    chave.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Chave chave) {
        String sql = "UPDATE Chaves SET descricao = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chave.getDescricao());
            stmt.setInt(2, chave.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM Chaves WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Chave> listarTodos() {
        List<Chave> chaves = new ArrayList<>();
        String sql = "SELECT * FROM Chaves";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Chave chave = new Chave(
                    rs.getInt("id"),
                    rs.getString("descricao")
                        // rs.getString("status") 
                );
                chaves.add(chave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chaves;
    }
}
