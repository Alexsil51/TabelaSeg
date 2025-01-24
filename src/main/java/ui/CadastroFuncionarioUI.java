/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author asgama
 */

import model.Funcionario;
import service.FuncionarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CadastroFuncionarioUI extends JFrame{
    
    private FuncionarioService funcionarioService;

    public CadastroFuncionarioUI(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
        initUI();
    }
    
    private JTextField nomeField;
    private JTextField cargoField;
    private JButton salvarButton;
    
    private void initUI() {
        setTitle("Cadastro de Funcionário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nomeField = new JTextField(20);
        cargoField = new JTextField(20);
        salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarFuncionario();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Cargo:"));
        panel.add(cargoField);
        panel.add(salvarButton);

        add(panel);
    }

    private void salvarFuncionario() {
        String nome = nomeField.getText();
        String cargo = cargoField.getText();

        Funcionario funcionario = new Funcionario(0, nome, cargo);
        funcionarioService.adicionarFuncionario(funcionario);

        JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso!");
    }
    
}
