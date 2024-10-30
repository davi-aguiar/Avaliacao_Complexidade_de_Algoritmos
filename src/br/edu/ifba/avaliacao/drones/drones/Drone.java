package br.edu.ifba.avaliacao.drones.drones;

import br.edu.ifba.avaliacao.drones.sensoriamento.Sensor;

public abstract class Drone {
  public String id;
  public Sensor sensorAltitude;
  public Sensor sensorBateria;

  public Drone(String id) {
    this.id = id;
  }

  public abstract void monitorar();
}
