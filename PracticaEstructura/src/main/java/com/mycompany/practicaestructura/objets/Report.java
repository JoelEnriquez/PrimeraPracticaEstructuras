/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaestructura.objets;

/**
 *
 * @author joel
 */
public class Report {
    private String nombreProceso;
    private long tiempoPromedio;
    private int promedioPasos;
    private int mayorCantidadPasos;
    private int menorCantidadPasos;

    public Report(String nombreProceso, long tiempoPromedio, int promedioPasos, int mayorCantidadPasos, int menorCantidadPasos) {
        this.nombreProceso = nombreProceso;
        this.tiempoPromedio = tiempoPromedio;
        this.promedioPasos = promedioPasos;
        this.mayorCantidadPasos = mayorCantidadPasos;
        this.menorCantidadPasos = menorCantidadPasos;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public long getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(long tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public int getPromedioPasos() {
        return promedioPasos;
    }

    public void setPromedioPasos(int promedioPasos) {
        this.promedioPasos = promedioPasos;
    }

    public int getMayorCantidadPasos() {
        return mayorCantidadPasos;
    }

    public void setMayorCantidadPasos(int mayorCantidadPasos) {
        this.mayorCantidadPasos = mayorCantidadPasos;
    }

    public int getMenorCantidadPasos() {
        return menorCantidadPasos;
    }

    public void setMenorCantidadPasos(int menorCantidadPasos) {
        this.menorCantidadPasos = menorCantidadPasos;
    }

   
    
    
    
}
