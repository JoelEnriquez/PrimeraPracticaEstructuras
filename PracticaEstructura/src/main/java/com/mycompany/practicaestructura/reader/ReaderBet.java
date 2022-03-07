/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaestructura.reader;

import com.mycompany.practicaestructura.objets.Bet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    public ReaderBet(String[] bets, ArrayList<Integer> ordenCaballos) {
        this.bets = bets;
        this.ordenCaballos = ordenCaballos;
    }
    
    /**
     * On
     */
    public void analizarApuestas(){
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
    
    public void comprobarApuesta(String bet){
        String[] apuesta = bet.split(",");
        //Verificamos el tamaño correcto
        if (apuesta.length!=11) {
            agregarApuestaIncorrecta(bet, "No venian los datos correctos");
        } else {
            //Verificamos tipo correcto dato
            if (apuesta[0] instanceof String) {
                
            }
        }
    }
    
    public void comprobarRepeticion(String[] ordenCaballos, String apuesta){
        
    }
    
    public void agregarApuestaIncorrecta(String apuesta, String mensaje){
        apuestasInvalidas = apuestasInvalidas + "Error en la apuesta: "+apuesta+" debido a "+mensaje;
        apuestaInvalida = true;
    }    
    
}
