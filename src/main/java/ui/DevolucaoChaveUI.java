/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author asgama
 */

import model.Registro;
import service.RegistroService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;


public class DevolucaoChaveUI extends JFrame{
    
    private RegistroService registroService;

    public DevolucaoChaveUI(RegistroService registroService) {
        this.registroService = registroService;
        initUI();
    }
    
    private JTextField registroIdField;
    private JButton salvarButton;
   

    private void initUI() {
        setTitle("Devolução de Chave");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Apenas fecha esta janela
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registroIdField = new JTextField(20);
        salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDevolucao();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("ID do Registro:"));
        panel.add(registroIdField);
        panel.add(salvarButton);

        add(panel);
    }

    private void salvarDevolucao() {
        int registroId = Integer.parseInt(registroIdField.getText());
        LocalDateTime dataDevolucao = LocalDateTime.now();

        Registro registro = registroService.buscarRegistroPorId(registroId);
        if (registro != null) {
            registro.setDataDevolucao(dataDevolucao);
            registroService.editarRegistro(registro);
            JOptionPane.showMessageDialog(this, "Devolução registrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Registro não encontrado!");
        }
    }
    
   
}
