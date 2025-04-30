package util;

import modelo.Financiamento;
import java.util.Scanner;


public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in);
    
    public double pedirValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel (maior que 0): ");
            String input = scanner.nextLine().replace(",", ".");
            
            try {
                valor = Double.parseDouble(input);
                if (valor <= 0) {
                    System.out.println("Valor inválido! O valor deve ser positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número (ex: 300000).");
                valor = -1; // Força nova iteração
            }
        } while (valor <= 0);
        
        return valor;
    }
        
    public int pedirPrazoFinanciamento() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento em anos (1 a 50): ");
            String input = scanner.nextLine();
            
            try {
                prazo = Integer.parseInt(input);
                if (prazo < 1 || prazo > 50) {
                    System.out.println("Prazo inválido! Digite um valor entre 1 e 50 anos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro (ex: 30).");
                prazo = -1; // Força nova iteração
            }
        } while (prazo < 1 || prazo > 50);
        
        return prazo;
    }
    
    public double pedirTaxaJuros() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (ex: 8.5): ");
            String input = scanner.nextLine().replace(",", ".");
            
            try {
                taxa = Double.parseDouble(input);
                if (taxa <= 0 || taxa > 30) {
                    System.out.println("Taxa inválida! Digite um valor entre 0.1 e 30%.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número (ex: 8.5 ou 8,5).");
                taxa = -1; // Força nova iteração
            }
        } while (taxa <= 0 || taxa > 30);
        
        return taxa;
    }
    
    public void mostrarResultados(double pagamentoMensal, double totalPagamento) {
        System.out.printf("\n=== RESULTADO DO FINANCIAMENTO ===\n");
        System.out.printf("Parcela mensal: R$ %.2f\n", pagamentoMensal);
        System.out.printf("Total a pagar em %d anos: R$ %.2f\n", (int)(totalPagamento / (pagamentoMensal * 12)), totalPagamento);
    }
    
    public void mostrarTotais(double totalImoveis, double totalFinanciamentos) {
        System.out.printf("\n=== TOTAIS GERAIS ===\n");
        System.out.printf("Valor total de todos os imóveis: R$ %.2f\n", totalImoveis);
        System.out.printf("Valor total de todos os financiamentos: R$ %.2f\n", totalFinanciamentos);
        System.out.printf("Juros totais: R$ %.2f\n", totalFinanciamentos - totalImoveis);
    }
}