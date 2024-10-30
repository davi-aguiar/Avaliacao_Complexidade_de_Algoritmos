package br.edu.ifba.avaliacao.drones.sensoriamento;

public interface Sensor {
  int coletarDados();

  int getAltitude();

  int getNivelBateria();
}
