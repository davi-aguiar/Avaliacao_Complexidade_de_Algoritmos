package br.edu.ifba.avaliacao.drones.monitoramento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.avaliacao.drones.drones.DroneConcreto;

public class Monitoramento {
  private List<DroneConcreto> drones;

  // Construtor - Complexidade O(n)
  // Inicializa a lista de N drones e atribui posições aleatórias a cada um.
  // A complexidade é linear porque percorre um loop de tamanho N.
  public Monitoramento(int quantidadeDrones) {
    this.drones = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < quantidadeDrones; i++) {
      DroneConcreto drone = new DroneConcreto("Drone" + (i + 1));
      drone.setX(random.nextDouble() * 100);
      drone.setY(random.nextDouble() * 100);
      drones.add(drone);
    }
  }

  // D1 - Imprimir a lista de drones monitorados - Complexidade O(n)
  // Percorre a lista de drones e imprime seus IDs.
  public void imprimirListaDrones() {
    System.out.println("Lista de Drones Monitorados:");
    for (DroneConcreto drone : drones) {
      System.out.println("- " + drone.id);
    }
  }

  // Método para iniciar o monitoramento - Complexidade O(n)
  // Itera sobre a lista de drones e simula o monitoramento de cada um.
  public void iniciarMonitoramento() {
    for (DroneConcreto drone : drones) {
      drone.monitorar();
    }
  }

  // D2 - Imprimir leituras por drone - Complexidade O(n)
  // Percorre a lista de drones e imprime as leituras de cada um.
  public void imprimirLeiturasPorDrone() {
    System.out.println("\nLeituras dos Drones:");
    for (DroneConcreto drone : drones) {
      System.out.println("Leituras do Drone " + drone.id + ":");
      System.out.println("Altitude: " + drone.sensorAltitude.getAltitude());
      System.out.println("Bateria: " + drone.sensorBateria.getNivelBateria());
    }
  }

  // D3 - Ordenar drones por altitude - Complexidade O(n^2)
  // Implementa o Bubble Sort para ordenar os drones pela altitude.
  // A complexidade é O(n^2) devido aos loops aninhados.
  public void ordenarPorAltitude() {
    int n = drones.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (drones.get(j).sensorAltitude.getAltitude() > drones.get(j + 1).sensorAltitude.getAltitude()) {
          // Troca os drones de posição
          DroneConcreto temp = drones.get(j);
          drones.set(j, drones.get(j + 1));
          drones.set(j + 1, temp);
        }
      }
    }
  }

  // D4 - Calcular a rota mais curta (Problema do Caixeiro Viajante) -
  // Complexidade O(n!)
  // Gera todas as permutações possíveis para encontrar a rota de menor distância.
  // A complexidade é fatorial devido ao número de permutações.

  // Possibilidade de força bruta: Para N grandes, o número de permutações (N!) é
  // enorme,
  // e o algoritmo precisa verificar todas as rotas para encontrar a ótima.
  public void calcularRotaMaisCurta() {
    List<DroneConcreto> melhorRota = new ArrayList<>();
    double menorDistancia = Double.MAX_VALUE;
    permutarDrones(new ArrayList<>(), drones, melhorRota, menorDistancia);
    System.out.println("\nMelhor Rota para Monitoramento:");
    for (DroneConcreto drone : melhorRota) {
      System.out.println("- " + drone.id);
    }
    System.out.printf("Distância Total: %.2f unidades\n", calcularDistanciaTotal(melhorRota));
  }

  // Método recursivo para permutar drones - Complexidade O(n!)
  // Este método gera todas as permutações possíveis.
  // Possível situação de força bruta devido ao alto número de permutações com N
  // grande.
  private void permutarDrones(List<DroneConcreto> rotaParcial, List<DroneConcreto> dronesRestantes,
      List<DroneConcreto> melhorRota, double menorDistanciaAtual) {
    if (dronesRestantes.isEmpty()) {
      double distanciaAtual = calcularDistanciaTotal(rotaParcial);
      if (distanciaAtual < menorDistanciaAtual) {
        menorDistanciaAtual = distanciaAtual;
        melhorRota.clear();
        melhorRota.addAll(rotaParcial);
      }
    } else {
      for (int i = 0; i < dronesRestantes.size(); i++) {
        List<DroneConcreto> novaRotaParcial = new ArrayList<>(rotaParcial);
        novaRotaParcial.add(dronesRestantes.get(i));

        List<DroneConcreto> novosDronesRestantes = new ArrayList<>(dronesRestantes);
        novosDronesRestantes.remove(i);

        permutarDrones(novaRotaParcial, novosDronesRestantes, melhorRota, menorDistanciaAtual);
      }
    }
  }

  // Método auxiliar para calcular a distância total de uma rota - Complexidade
  // O(n)
  private double calcularDistanciaTotal(List<DroneConcreto> rota) {
    double distancia = 0.0;
    for (int i = 0; i < rota.size() - 1; i++) {
      distancia += calcularDistanciaEntre(rota.get(i), rota.get(i + 1));
    }
    // Retorna ao ponto inicial
    distancia += calcularDistanciaEntre(rota.get(rota.size() - 1), rota.get(0));
    return distancia;
  }

  // Cálculo de distância entre dois drones - Complexidade O(1)
  private double calcularDistanciaEntre(DroneConcreto drone1, DroneConcreto drone2) {
    return Math.sqrt(Math.pow(drone1.getX() - drone2.getX(), 2) + Math.pow(drone1.getY() - drone2.getY(), 2));
  }
}
