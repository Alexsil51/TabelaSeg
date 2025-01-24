/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author asgama
 */

import model.Chave;
import service.ChaveService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CadastroChaveUI extends JFrame {
    
    private JTextField txtDescricao;
    private ChaveService chaveService;

    public CadastroChaveUI() {
        chaveService = new ChaveService();

        // Configurar a tela de cadastro de chaves
        setTitle("Cadastro de Chaves");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));

        JLabel lblDescricao = new JLabel("Descrição:");
        txtDescricao = new JTextField();

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = txtDescricao.getText();
                Chave chave = new Chave(0, descricao); // O ID pode ser gerado automaticamente
                chaveService.adicionarChave(chave);
                JOptionPane.showMessageDialog(null, "Chave salva com sucesso!");
                txtDescricao.setText("");
            }
        });

        add(lblDescricao);
        add(txtDescricao);
        add(new JLabel()); // Placeholder
        add(btnSalvar);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
}
