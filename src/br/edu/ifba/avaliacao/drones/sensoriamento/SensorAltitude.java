package br.edu.ifba.avaliacao.drones.sensoriamento;

import java.util.Random;

public class SensorAltitude implements Sensor {

  private int altitude;

  @Override
  public int coletarDados() {
    Random random = new Random();
    this.altitude = random.nextInt(1000);
    return altitude;
  }

  public int getAltitude() {
    return altitude;
  }

  @Override
  public int getNivelBateria() {
    return 0;
  }

}
