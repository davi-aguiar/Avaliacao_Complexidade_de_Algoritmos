package br.edu.ifba.avaliacao.drones;

import br.edu.ifba.avaliacao.drones.monitoramento.Monitoramento;

public class App {
    public static void main(String[] args) throws Exception {
        int quantidadeDrones = 10; // Você pode alterar o valor para N drones
        Monitoramento monitoramento = new Monitoramento(quantidadeDrones);

        // Inicia o monitoramento
        monitoramento.iniciarMonitoramento();

        // D1 - Imprime a lista de drones monitorados
        monitoramento.imprimirListaDrones();

        // D2 - Imprime as leituras por drone
        monitoramento.imprimirLeiturasPorDrone();

        // D3 - Ordena por altitude e imprime as leituras ordenadas
        monitoramento.ordenarPorAltitude();
        System.out.println("\nDrones ordenados por altitude:");
        monitoramento.imprimirLeiturasPorDrone();

        // D4 - Calcula e exibe a rota mais curta para o monitoramento dos drones
        // (O(N!))
        monitoramento.calcularRotaMaisCurta();
    }
}
