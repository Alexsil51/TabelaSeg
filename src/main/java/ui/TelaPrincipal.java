/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author asgama
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import service.FuncionarioService;
import service.RegistroService;

public class TelaPrincipal extends JFrame {
    
    private JButton btnCadastroFuncionario;
    private JButton btnRetiradaChave;
    private JButton btnDevolucaoChave;
    private JButton btnRelatorio;
    private JButton btnCadastrarChave; // Novo botão

    private JTable tabelaChaves;
    private DefaultTableModel modeloTabela;

    private FuncionarioService funcionarioService;
    private RegistroService registroService;

    public TelaPrincipal(FuncionarioService funcionarioService, RegistroService registroService) {
        this.funcionarioService = funcionarioService;
        this.registroService = registroService;
        initUI();
    }

    private void initUI() {
        // Botões
        btnCadastroFuncionario = new JButton("Cadastro de Funcionário");
        btnRetiradaChave = new JButton("Retirada de Chave");
        btnDevolucaoChave = new JButton("Devolução de Chave");
        btnRelatorio = new JButton("Relatório");
        btnCadastrarChave = new JButton("Cadastrar Chave"); // Criando o botão

        // Ações dos botões
        btnCadastroFuncionario.addActionListener(e -> new CadastroFuncionarioUI(funcionarioService).setVisible(true));
        btnRetiradaChave.addActionListener(e -> new RetiradaChaveUI(registroService).setVisible(true));
        btnDevolucaoChave.addActionListener(e -> new DevolucaoChaveUI(registroService).setVisible(true));
        btnRelatorio.addActionListener(e -> new RelatorioUI().setVisible(true));
        btnCadastrarChave.addActionListener(e -> new CadastroChaveUI().setVisible(true)); // Ação do botão

        // Painel de botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridLayout(1, 5, 10, 10)); // Ajustar para 5 botões
        panelBotoes.add(btnCadastroFuncionario);
        panelBotoes.add(btnCadastrarChave); // Adiciona o botão ao painel
        panelBotoes.add(btnRetiradaChave);
        panelBotoes.add(btnDevolucaoChave);
        panelBotoes.add(btnRelatorio);

        // Tabela para exibir as chaves
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Chave", "Status"}, 0);
        tabelaChaves = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaChaves);

        // Atualizar a tabela com os dados das chaves
        atualizarTabela();

        // Layout principal
        setLayout(new BorderLayout());
        add(panelBotoes, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setTitle("Tela Principal");
        setSize(800, 600);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void atualizarTabela() {
        // Exemplo: Obter as chaves do RegistroService
        modeloTabela.setRowCount(0); // Limpar a tabela
        registroService.obterChavesEmprestadas().forEach(chave -> {
            modeloTabela.addRow(new Object[]{chave.getId(), chave.getDescricao(), chave.getStatus()});
        });
    }
}



/* antes Adicionar Botão Cadastrar Chave
public class TelaPrincipal extends JFrame {
    
    private JButton btnCadastroFuncionario;
    private JButton btnRetiradaChave;
    private JButton btnDevolucaoChave;
    private JButton btnRelatorio;

    private JTable tabelaChaves;
    private DefaultTableModel modeloTabela;

    private FuncionarioService funcionarioService;
    private RegistroService registroService;

    public TelaPrincipal(FuncionarioService funcionarioService, RegistroService registroService) {
        this.funcionarioService = funcionarioService;
        this.registroService = registroService;
        initUI();
    }

    private void initUI() {
        // Botões
        btnCadastroFuncionario = new JButton("Cadastro de Funcionário");
        btnRetiradaChave = new JButton("Retirada de Chave");
        btnDevolucaoChave = new JButton("Devolução de Chave");
        btnRelatorio = new JButton("Relatório");

        btnCadastroFuncionario.addActionListener(e -> new CadastroFuncionarioUI(funcionarioService).setVisible(true));
        btnRetiradaChave.addActionListener(e -> new RetiradaChaveUI(registroService).setVisible(true));
        btnDevolucaoChave.addActionListener(e -> new DevolucaoChaveUI(registroService).setVisible(true));
        btnRelatorio.addActionListener(e -> new RelatorioUI().setVisible(true));

        // Painel de botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridLayout(1, 4, 10, 10));
        panelBotoes.add(btnCadastroFuncionario);
        panelBotoes.add(btnRetiradaChave);
        panelBotoes.add(btnDevolucaoChave);
        panelBotoes.add(btnRelatorio);

        // Tabela para exibir as chaves
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Chave", "Status"}, 0);
        tabelaChaves = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaChaves);

        // Atualizar a tabela com os dados das chaves
        atualizarTabela();

        // Layout principal
        setLayout(new BorderLayout());
        add(panelBotoes, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setTitle("Tela Principal");
        setSize(800, 600);
        //setExtendedState(JFrame.MAXIMIZED_BOTH); // Opcional: abre maximizado
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void atualizarTabela() {
        // Exemplo: Obter as chaves do RegistroService
        modeloTabela.setRowCount(0); // Limpar a tabela
        registroService.obterChavesEmprestadas().forEach(chave -> {
            modeloTabela.addRow(new Object[]{chave.getId(), chave.getDescricao(), chave.getStatus()});
        });
    }
}

*/

/**
codigo antes implementar tela de chaves emprestadas
import javax.swing.*;
import java.awt.*;
import service.FuncionarioService;
import service.RegistroService;

public class TelaPrincipal extends JFrame {
    
    private JButton btnCadastroFuncionario;
    private JButton btnRetiradaChave;
    private JButton btnDevolucaoChave;
    private JButton btnRelatorio;

    private FuncionarioService funcionarioService;
    private RegistroService registroService;

    public TelaPrincipal(FuncionarioService funcionarioService, RegistroService registroService) {
        this.funcionarioService = funcionarioService;
        this.registroService = registroService;
        initUI();
    }

    private void initUI() {
        btnCadastroFuncionario = new JButton("Cadastro de Funcionário");
        btnRetiradaChave = new JButton("Retirada de Chave");
        btnDevolucaoChave = new JButton("Devolução de Chave");
        btnRelatorio = new JButton("Relatório");

        btnCadastroFuncionario.addActionListener(e -> new CadastroFuncionarioUI(funcionarioService).setVisible(true));
        btnRetiradaChave.addActionListener(e -> new RetiradaChaveUI(registroService).setVisible(true));
        btnDevolucaoChave.addActionListener(e -> new DevolucaoChaveUI(registroService).setVisible(true));
        btnRelatorio.addActionListener(e -> new RelatorioUI().setVisible(true));

        JPanel panel = new JPanel();
        panel.add(btnCadastroFuncionario);
        panel.add(btnRetiradaChave);
        panel.add(btnDevolucaoChave);
        panel.add(btnRelatorio);

        add(panel);

        setTitle("Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
}


  /*
    private RegistroService registroService;

    public TelaPrincipal() {
        this.registroService = new RegistroService();
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Controle de Chaves");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setLocationRelativeTo(null);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton btnCadastroFuncionario = new JButton("Cadastro Funcionário");
        btnCadastroFuncionario.setBounds(10, 20, 180, 25);
        panel.add(btnCadastroFuncionario);
        btnCadastroFuncionario.addActionListener(e -> new CadastroFuncionarioUI().setVisible(true));

        JButton btnRetiradaChave = new JButton("Retirada de Chave");
        btnRetiradaChave.setBounds(10, 60, 180, 25);
        panel.add(btnRetiradaChave);
        btnRetiradaChave.addActionListener(e -> new RetiradaChaveUI(registroService).setVisible(true));

        JButton btnDevolucaoChave = new JButton("Devolução de Chave");
        btnDevolucaoChave.setBounds(10, 100, 180, 25);
        panel.add(btnDevolucaoChave);
        btnDevolucaoChave.addActionListener(e -> new DevolucaoChaveUI(registroService).setVisible(true));

        JButton btnRelatorio = new JButton("Relatório");
        btnRelatorio.setBounds(10, 140, 180, 25);
        panel.add(btnRelatorio);
        btnRelatorio.addActionListener(e -> new RelatorioUI().setVisible(true));
    }
    */