package com;
public class Restaurante {
    private String nombre;
    private String localizacion;
    private String horario;
    private int puntuacion;

    public Restaurante(String nombre, String localizacion, String horario, int puntuacion) {
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.horario = horario;
        this.puntuacion = puntuacion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "Nombre='" + nombre + '\'' +
                ", Localizacion='" + localizacion + '\'' +
                ", Horario='" + horario + '\'' +
                ", Puntuacion=" + puntuacion +
                '}';
    }
}