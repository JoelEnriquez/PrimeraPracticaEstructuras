/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaestructura.objets;

/**
 *
 * @author joel
 */
public class Bet {
    private Gambler gambler;
    private Double mount;
    private Integer[] listHorses;

    public Bet(String gambler, Double mount, Integer[] listHorses) {
        this.gambler = new Gambler(gambler, 0);
        this.mount = mount;
        this.listHorses = listHorses;
    }

    public Gambler getGambler() {
        return gambler;
    }

    public void setGambler(Gambler gambler) {
        this.gambler = gambler;
    }

    public Double getMount() {
        return mount;
    }

    public void setMount(Double mount) {
        this.mount = mount;
    }

    public Integer[] getListHorses() {
        return listHorses;
    }

    public void setListHorses(Integer[] listHorses) {
        this.listHorses = listHorses;
    }
    
    
}
