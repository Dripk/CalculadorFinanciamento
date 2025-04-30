package main;

import java.util.ArrayList;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        System.out.println("=== SIMULADOR DE FINANCIAMENTO ===");

        // Criar 4 financiamentos
        for (int i = 1; i <= 4; i++) {
            System.out.println("\nFinanciamento #" + i);
            
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJuros = interfaceUsuario.pedirTaxaJuros();

            Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJuros);
            financiamentos.add(novoFinanciamento);

            // Mostrar resultados individuais
            novoFinanciamento.mostrarDadosFinanciamento();
            double pagamentoMensal = novoFinanciamento.calcularPagamentoMensal();
            double totalPagamento = novoFinanciamento.calcularTotalPagamento();
            interfaceUsuario.mostrarResultados(pagamentoMensal, totalPagamento);
        }

        // Calcular totais
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        
        for (Financiamento f : financiamentos) {
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularTotalPagamento();
        }

        // Mostrar totais
        interfaceUsuario.mostrarTotais(totalImoveis, totalFinanciamentos);
    }
}