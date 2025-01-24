/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asgama
 */
import dao.RegistroDAO;
import ui.TelaPrincipal;
import service.FuncionarioService;
import service.RegistroService;

public class Main {
    
    
    public static void main(String[] args) {
          // Inicialize os serviços
        FuncionarioService funcionarioService = new FuncionarioService();
        RegistroService registroService = new RegistroService();

        // Inicie a interface principal
        TelaPrincipal telaPrincipal = new TelaPrincipal(funcionarioService, registroService);
        telaPrincipal.setVisible(true);
        
        // Adicione mensagens para testar o fluxo do código
        System.out.println("Iniciando teste de conexão...");

        RegistroDAO dao = new RegistroDAO();
        dao.testarConexao();  // Chama o método para testar a conexão
        
        System.out.println("Teste de conexão finalizado.");
    
    }
}


   

