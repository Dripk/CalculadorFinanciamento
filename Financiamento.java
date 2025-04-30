package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Getters
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Métodos de cálculo
    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    // Método para mostrar dados do financiamento
    public void mostrarDadosFinanciamento() {
        System.out.println("\nDados do Financiamento:");
        System.out.printf("Valor do Imóvel: R$ %.2f\n", this.valorImovel);
        System.out.printf("Prazo: %d anos\n", this.prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", this.taxaJurosAnual);
        System.out.printf("Total do Financiamento: R$ %.2f\n", this.calcularTotalPagamento());
    }
}