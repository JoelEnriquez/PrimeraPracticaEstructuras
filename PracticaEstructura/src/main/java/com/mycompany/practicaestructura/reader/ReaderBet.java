/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaestructura.reader;

import com.mycompany.practicaestructura.objets.Bet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author joel
 */
public class ReaderBet {

    private String[] bets;
    private Bet[] betsAproved;
    private ArrayList<Integer> ordenCaballos;
    private boolean apuestaInvalida = false;
    private String apuestasInvalidas = "";
    //Duplicacion
    private Integer[] cantidadPasosDuplicacion;
    private long[] cantidadTiempoDuplicacion;
    private long promedioTiempoDupliacion;
    private int promedioPasosDuplicacion;
    private int cantidadMenorDuplicacion = 0;
    private int cantidadMayorDuplicacion = 0;
    //Calificacion Apuestas
    private Integer[] cantidadPasosCalificacion;
    private long[] cantidadTiempoCalificacion;
    private long promedioTiempoCalificacion;
    private int promedioPasosCalificacion;
    private int cantidadMenorCalificacion = 0;
    private int cantidadMayorCalificacion = 0;

    public ReaderBet(String[] bets, ArrayList<Integer> ordenCaballos) {
        this.bets = bets;
        this.ordenCaballos = ordenCaballos;
    }

    /**
     * On
     */
    public void analizarApuestas() {
        //Analizamos si gramaticalmente esta bien cada linea
        String apuestaActual = "";

        for (int i = 0; i < bets.length; i++) {
            apuestaActual = bets[i];
            comprobarApuesta(apuestaActual);
            if (apuestaInvalida) {
                bets[i] = null;
                apuestaInvalida = false;
            }
        }
    }

    public void comprobarApuesta(String bet) {
        String nombreApostador;
        Double monto = null;
        Integer[] listadoCaballos = new Integer[10];
        String[] apuesta = bet.split(",");
        //Verificamos el tamaño correcto
        if (apuesta.length != 12) {
            agregarApuestaIncorrecta(bet, "No venian los datos correctos");
        } else {
            nombreApostador = apuesta[0];
            //Verificamos tipo correcto dato numeros
            try {
                monto = Double.parseDouble(apuesta[1]);
            } catch (NumberFormatException e) {
                agregarApuestaIncorrecta(bet, "No venia un dato correcto en monto");
            }

            try {
                for (int i = 2; i < apuesta.length; i++) {
                    listadoCaballos[i - 2] = Integer.valueOf(apuesta[i]);
                }
            } catch (NumberFormatException e) {
                agregarApuestaIncorrecta(bet, "No venia un dato correcto en los caballos");
            }

            //Verificamos que no exista repeticion
            if (!apuestaInvalida && !comprobarRepeticion(listadoCaballos, bet)) {
                Bet betAproved = new Bet(nombreApostador, monto, listadoCaballos);
                if (betsAproved == null) {
                    betsAproved = new Bet[1];
                    betsAproved[0] = betAproved;
                } else {
                    Bet[] aux = new Bet[betsAproved.length+1];
                    for (int i = 0; i < betsAproved.length; i++) {
                        aux[i] = betsAproved[i];
                    }
                    aux[aux.length-1] = betAproved;
                    betsAproved = aux;
                }
            }
        }
    }

    public boolean comprobarRepeticion(Integer[] ordenCaballos, String apuesta) {
        int numeroPasos = 0;
        long tiempoProcesoInicio = System.currentTimeMillis();      
  
        for (int i = 0; i < ordenCaballos.length; i++) {
            //Tiempo Inicial
            numeroPasos++;
            ordenCaballos[ordenCaballos[i] % ordenCaballos.length]
                = ordenCaballos[ordenCaballos[i] % ordenCaballos.length] + ordenCaballos.length;
        }
        
        for (int i = 0; i < ordenCaballos.length; i++) {
            numeroPasos++;
            if (ordenCaballos[i] >= ordenCaballos.length * 2) {
                agregarApuestaIncorrecta(apuesta, "Hay repeticion de datos");
                establecerTiemposYPasos(tiempoProcesoInicio, numeroPasos);
                return true;
            }
        } 
        
        establecerTiemposYPasos(tiempoProcesoInicio, numeroPasos);
        return false;
    }
    
    private void establecerTiemposYPasos(long tiempoInicial, int pasosTotales){
        long tiempoProcesoFin = System.currentTimeMillis() - tiempoInicial;
        
        //Menor cantidad de pasos
        if (cantidadMenorDuplicacion ==0) {
            cantidadMenorDuplicacion = pasosTotales;
        } else {
            if (pasosTotales<cantidadMenorDuplicacion) {
                cantidadMenorDuplicacion = pasosTotales;
            }
        }
        //Mayor cantidad de pasos
        if (pasosTotales > cantidadMayorDuplicacion) {
            cantidadMayorDuplicacion = pasosTotales;
        }
        
        
        //Agregar pasos y tiempo a la lista correspondiente
        if (cantidadPasosDuplicacion == null) {
            cantidadPasosDuplicacion = new Integer[1];
            cantidadPasosDuplicacion[0] = pasosTotales;
        } else {
            //HAcemos una copia y guardamos el nuevo elemento
            Integer[] auxPasos = new Integer[cantidadPasosDuplicacion.length+1];
            System.arraycopy(cantidadPasosDuplicacion, 0, auxPasos, 0, cantidadPasosDuplicacion.length);
            auxPasos[auxPasos.length-1] = pasosTotales;
            cantidadPasosDuplicacion = auxPasos;
        }
        
        if (cantidadTiempoDuplicacion == null) {
            cantidadTiempoDuplicacion = new long[1];
            cantidadTiempoDuplicacion[0] = tiempoProcesoFin;
        } else {
            //HAcemos una copia y guardamos el nuevo elemento
            long[] auxTiempo = new long[cantidadTiempoDuplicacion.length+1];
            System.arraycopy(cantidadTiempoDuplicacion, 0, auxTiempo, 0, cantidadTiempoDuplicacion.length);
            auxTiempo[auxTiempo.length-1] = pasosTotales;
            cantidadTiempoDuplicacion = auxTiempo;
        }
        
    }

    public void agregarApuestaIncorrecta(String apuesta, String mensaje) {
        apuestasInvalidas = apuestasInvalidas + "Error en la apuesta: " + apuesta + " debido a " + mensaje+ ".\n";
        apuestaInvalida = true;
    }

    public Integer[] getCantidadPasosDuplicacion() {
        return cantidadPasosDuplicacion;
    }

    public long[] getCantidadTiempoDuplicacion() {
        return cantidadTiempoDuplicacion;
    }

    public int getCantidadMenorDuplicacion() {
        return cantidadMenorDuplicacion;
    }

    public int getCantidadMayorDuplicacion() {
        return cantidadMayorDuplicacion;
    }

    public Integer[] getCantidadPasosCalificacion() {
        return cantidadPasosCalificacion;
    }

    public long[] getCantidadTiempoCalificacion() {
        return cantidadTiempoCalificacion;
    }

    public int getCantidadMenorCalificacion() {
        return cantidadMenorCalificacion;
    }

    public int getCantidadMayorCalificacion() {
        return cantidadMayorCalificacion;
    }
    
    public long getPromedioTiempoDuplicacion(){
        long aux = 0;
        for (int i = 0; i < cantidadTiempoDuplicacion.length; i++) {
            aux += cantidadTiempoDuplicacion[i];
        }
        return aux/cantidadTiempoDuplicacion.length;
    }
    
    public int getPromedioPasosDuplicacion(){
        int aux = 0;
        for (int i = 0; i < cantidadPasosDuplicacion.length; i++) {
            aux += cantidadPasosDuplicacion[i];
        }
        return aux/cantidadPasosDuplicacion.length;
    }
    
    public String getErroresApuestas(){
        return apuestasInvalidas;
    }
    

}
