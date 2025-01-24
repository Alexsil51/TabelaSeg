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
import java.util.List;

public class RelatorioUI extends JFrame{
    
    public RelatorioUI() {
        initUI();
    }
    
    private JTextArea relatorioArea;
    private RegistroService registroService;

    public RelatorioUI(RegistroService registroService) {
        this.registroService = registroService;
        initUI();
    }

    private void initUI() {
        setTitle("Relatório de Registros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        relatorioArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(relatorioArea);

        add(scrollPane);

        gerarRelatorio();
    }

    private void gerarRelatorio() {
        List<Registro> registros = registroService.listarRegistros();
        StringBuilder relatorio = new StringBuilder();

        for (Registro registro : registros) {
            relatorio.append("ID: ").append(registro.getId()).append("\n")
                     .append("ID da Chave: ").append(registro.getChaveId()).append("\n")
                     .append("ID do Funcionário: ").append(registro.getFuncionarioId()).append("\n")
                     .append("Data de Retirada: ").append(registro.getDataRetirada()).append("\n")
                     .append("Data de Devolução: ").append(registro.getDataDevolucao()).append("\n\n");
        }

        relatorioArea.setText(relatorio.toString());
    }
    
}
