package br.edu.ifba.avaliacao.drones.drones;

import br.edu.ifba.avaliacao.drones.sensoriamento.SensorAltitude;
import br.edu.ifba.avaliacao.drones.sensoriamento.SensorBateria;

public class DroneConcreto {
  public String id;
  public SensorAltitude sensorAltitude;
  public SensorBateria sensorBateria;
  private double x;
  private double y;

  public DroneConcreto(String id) {
    this.id = id;
    this.sensorAltitude = new SensorAltitude();
    this.sensorBateria = new SensorBateria();
  }

  public void monitorar() {

    sensorAltitude.coletarDados();
    sensorBateria.coletarDados();
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }
}
