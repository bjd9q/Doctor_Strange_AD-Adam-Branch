package com.example.demo.utils;

public class Jugador {

    private Escenario escenario;
    private String alias_jugador;
    private int num_monedas_jugador;
    private Organizacion organizacion;
    private Equipo equipo;

    public Jugador(Escenario escenario,Equipo equipo) {
        this.escenario = escenario;
        this.num_monedas_jugador = escenario.getNumMonedas();
        this.equipo = equipo;
        this.organizacion =organizacion;
    }

    public Jugador(Escenario escenario){
        this.escenario=escenario;
        this.num_monedas_jugador = escenario.getNumMonedas();
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Escenario getEscenario() {
        return this.escenario;
    }
    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }
    public String getAlias_jugador() {
        return this.alias_jugador;
    }
    public void setAlias_jugador(String alias_jugador) {
        this.alias_jugador = alias_jugador;
    }
    public int getNum_monedas_jugador() {
        return this.num_monedas_jugador;
    }
    public void setNum_monedas_jugador(int num_monedas_jugador) {
        this.num_monedas_jugador = num_monedas_jugador;
    }

}
