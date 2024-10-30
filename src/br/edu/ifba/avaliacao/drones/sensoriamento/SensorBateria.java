package br.edu.ifba.avaliacao.drones.sensoriamento;

import java.util.Random;

public class SensorBateria implements Sensor {

  private int nivelBateria;
  private int altitude;

  @Override
  public int coletarDados() {
    Random random = new Random();
    nivelBateria = 100;
    return nivelBateria;
  }

  public int getNivelBateria() {
    return nivelBateria;
  }

  public void setNivelBateria(int nivelBateria) {
    this.nivelBateria = nivelBateria;
  }

  public int getAltitude() {
    return altitude;
  }

}
