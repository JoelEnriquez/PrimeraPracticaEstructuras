/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaestructura.structures;

/**
 *
 * @author joel
 * @param <T>
 */
public class Nodo<T> {
    
    private T contenido;
    private Nodo<T> anterior;
    private Nodo<T> siguiente;

   
    public Nodo(T contenido, Nodo<T> anterior, Nodo<T> siguiente){
        this.contenido = contenido;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    
    public Nodo(T contenido) {
        this.contenido = contenido;
    }


    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
}
