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


public class RetiradaChaveUI extends JFrame{
    
    private RegistroService registroService;

    private JTextField chaveIdText;
    private JTextField funcionarioIdText;

    public RetiradaChaveUI(RegistroService registroService) {
        this.registroService = registroService;
        initUI();
    }

    private void initUI() {
        setTitle("Retirada de Chave");
        setSize(300, 200);
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Apenas fecha esta janela
        setLocationRelativeTo(null);
       // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setLocationRelativeTo(null);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel chaveIdLabel = new JLabel("ID da Chave:");
        chaveIdLabel.setBounds(10, 20, 80, 25);
        panel.add(chaveIdLabel);

        chaveIdText = new JTextField(20);
        chaveIdText.setBounds(100, 20, 165, 25);
        panel.add(chaveIdText);

        JLabel funcionarioIdLabel = new JLabel("ID do Funcionário:");
        funcionarioIdLabel.setBounds(10, 50, 120, 25);
        panel.add(funcionarioIdLabel);

        funcionarioIdText = new JTextField(20);
        funcionarioIdText.setBounds(130, 50, 135, 25);
        panel.add(funcionarioIdText);

        JButton retirarButton = new JButton("Retirar");
        retirarButton.setBounds(10, 80, 150, 25);
        panel.add(retirarButton);

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRetirada();
            }
        });
    }

    private void handleRetirada() {
        try {
            int chaveId = Integer.parseInt(chaveIdText.getText());
            int funcionarioId = Integer.parseInt(funcionarioIdText.getText());
            LocalDateTime dataRetirada = LocalDateTime.now();

            // Crie o registro e adicione usando o serviço
            Registro registro = new Registro(0, chaveId, funcionarioId, dataRetirada);
            registroService.adicionarRegistro(registro);

            JOptionPane.showMessageDialog(this, "Chave retirada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para ID da Chave e ID do Funcionário.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao retirar a chave.", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
