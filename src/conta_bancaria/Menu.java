package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.util.Cores;

public class Menu {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        int opcao;

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
                    break;
                case 2:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Listar todas as Contas:  \n" + Cores.TEXT_RESET);
                    break;
                case 3:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Consultar dados da Conta - por número:  \n" + Cores.TEXT_RESET);
                    break;
                case 4:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Atualizar dados da Conta:  \n" + Cores.TEXT_RESET);
                    break;
                case 5:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Apagar a Conta:  \n" + Cores.TEXT_RESET);
                    break;
                case 6:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Saque:  \n" + Cores.TEXT_RESET);
                    break;
                case 7:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Depósito:  \n" + Cores.TEXT_RESET);
                    break;
                case 8:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n▶ Transferência entre Contas:  \n" + Cores.TEXT_RESET);
                    break;
                case 9:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\nBanco do Brazil com Z - O seu Futuro começa aqui!\n" + Cores.TEXT_RESET);
                    sobre();
                    leia.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_YELLOW_BACKGROUND + "\n⚠ Opção Inválida!\n" + Cores.TEXT_RESET);
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
}
