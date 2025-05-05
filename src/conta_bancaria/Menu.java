package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        ContaController contas = new ContaController();
        
        int opcao, numero, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo, limite, valor;
        
        //dados teste
        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
        
        while (true) {
            System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND);
            System.out.println("\n"														
            		        +  "       ╔════════════════════════════════════════════════════╗       ");
            System.out.println("       ║                BANCO DO BRAZIL COM Z               ║       ");
            System.out.println("       ╠════════════════════════════════════════════════════╣       ");
            System.out.println("       ║  1. Criar Conta                                    ║       ");
            System.out.println("       ║  2. Listar todas as Contas                         ║       ");
            System.out.println("       ║  3. Buscar Conta por Número                        ║       ");
            System.out.println("       ║  4. Atualizar Dados da Conta                       ║       ");
            System.out.println("       ║  5. Apagar Conta                                   ║       ");
            System.out.println("       ║  6. Sacar                                          ║       ");
            System.out.println("       ║  7. Depositar                                      ║       ");
            System.out.println("       ║  8. Transferir valores entre Contas                ║       ");
            System.out.println("       ║  9. Sair                                           ║       ");
            System.out.println("       ╚════════════════════════════════════════════════════╝       ");
            System.out.println(" Escolha com a opção desejada:                                      ");
			System.out.println("                                                                    " + Cores.TEXT_RESET);
            
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Criar Conta:  \n" + Cores.TEXT_RESET);
                    
                    System.out.println("Digite o número da agencia: ");
                    agencia = leia.nextInt();
                    
                    System.out.println("Digite o nome do titular: ");
                    leia.skip("\\R");
                    titular = leia.nextLine();
                     
                    System.out.println("Digite o tipo da conta (1 - CC | 2 - CP: ");
                    tipo = leia.nextInt();
                     
                    System.out.println("Digite o saldo inicial da  conta: ");
                    saldo = leia.nextFloat();
                     
                     switch(tipo) {
                     case 1 ->{
                    	 		System.out.println("Digite o limite da conta: ");
                    	 		limite = leia.nextFloat();
                    	 		contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                     		  }
                     
                     case 2 ->{
		             	 		System.out.println("Digite o dia do aniversario da conta: ");
		             	 		aniversario = leia.nextInt();
		             	 		contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		              		  }
                     
                     }
                     
                     
	                    keyPress();
	                    break;
	                case 2:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Listar todas as Contas:  \n" + Cores.TEXT_RESET);
	                    contas.listarTodas();
	                    keyPress();
	                    break;
	                case 3:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Consultar dados da Conta - por número:  \n" + Cores.TEXT_RESET);
	                    System.out.println("Digite o número da conta: ");
	                    numero = leia.nextInt();
	                    
	                    contas.procurarPorNumero(numero);
	                    
	                    keyPress();
	                    break;
	                case 4:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Atualizar dados da Conta:  \n" + Cores.TEXT_RESET);
	                    
	                    System.out.println("Digite o número da conta: ");
	                    numero = leia.nextInt();
	                    
	                    Optional<Conta> conta = contas.buscarNaCollection(numero);
	                    
	                    // Existe?
	                    if(conta.isPresent()) {
	                    	
	                    	System.out.println("Digite o número da agencia: ");
	                        agencia = leia.nextInt();
	                        
	                        System.out.println("Digite o nome do titular: ");
	                        leia.skip("\\R");
	                        titular = leia.nextLine();
	                         
	                        //Recuperar tipo da conta
	                        tipo = conta.get().getTipo();
	                       
	                         
	                        System.out.println("Digite o saldo inicial da  conta: ");
	                        saldo = leia.nextFloat();
	                    	
	                        //Indentificar tipo
	                        switch(tipo) {
	                        case 1 ->{// Se for Conta Corrente
	                       	 		System.out.println("Digite o limite da conta: ");
	                       	 		limite = leia.nextFloat();
	                       	 		contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
	                        		  }
	                        
	                        case 2 ->{// Se for Conta Poupanca
	   		             	 		System.out.println("Digite o dia do aniversario da conta: ");
	   		             	 		aniversario = leia.nextInt();
	   		             	 		contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
	   		              		  }  
	                        }
   	
	                    }else
	                    	System.out.printf("\nA conta número %d nao existe!", numero);
	                    
	                    
	                    keyPress();
	                    break;
	                case 5:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Apagar a Conta:  \n" + Cores.TEXT_RESET);
	                    
	                    System.out.println("Digite o número da conta: ");
	                    numero = leia.nextInt();
	                    
	                    contas.deletar(numero);
	                    
	                    keyPress();
	                    break;
	                case 6:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Saque:  \n" + Cores.TEXT_RESET);
	                    
	                    System.out.println("Digite o número da conta: ");
	                    numero = leia.nextInt();
	                    
	                    System.out.println("Digite o valor do saque: ");
	                    valor = leia.nextFloat();
	                    
	                    contas.sacar(numero,valor);
	                    keyPress();
	                    break;
	                case 7:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Depósito:  \n" + Cores.TEXT_RESET);
	                    
	                    System.out.println("Digite o número da conta: ");
	                    numero = leia.nextInt();
	                    
	                    System.out.println("Digite o valor do depósito: ");
	                    valor = leia.nextFloat();
	                    
	                    contas.depositar(numero,valor);
	                    keyPress();
	                    break;
	                case 8:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Transferência entre Contas:  \n" + Cores.TEXT_RESET);
	                    
	                    System.out.println("Digite o número da conta de Origem: ");
	                    numero = leia.nextInt();
	                    
	                    System.out.println("Digite o número da conta de Destino: ");
	                    numeroDestino = leia.nextInt();
	                    
	                    System.out.println("Digite o valor do depósito: ");
	                    valor = leia.nextFloat();
	                    
	                    contas.transferir(numero, numeroDestino, valor);
	                    keyPress();
	                    break;
	                case 9:
	                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\nBanco do Brazil com Z - O seu Futuro começa aqui!\n" + Cores.TEXT_RESET);
	                    sobre();
	                    leia.close();
	                    System.exit(0);
	                    keyPress();
	                    break;
	                default:
	                    System.out.println(Cores.TEXT_RED_BOLD + "\n Opção Inválida!\n" + Cores.TEXT_RESET);
	                    keyPress();
	                    break;
            }
        }
    }

    public static void sobre() {
        System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND);
        System.out.println("╔═════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                       SOBRE O PROJETO                                   ║");
        System.out.println("╠═════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Desenvolvido por: Pablo Furtado Casagrande                              ║");
        System.out.println("║ Email: furtadocasagrandepablo@gmail.com                                 ║");
        System.out.println("║ GitHub: https://github.com/Pablo-Casagrande                             ║");
        System.out.println("║ LinkedIn: linkedin.com/in/pablo-furtado-casagrande-08663434a/           ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════════╝");
        System.out.println(Cores.TEXT_RESET);
    }
    
    public static void keyPress() {

    	try {
    		 
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
 
		} catch (IOException e) {
 
			System.err.println("Ocorreu um erro ao tentar ler o teclado");
 
		}
	}
}
