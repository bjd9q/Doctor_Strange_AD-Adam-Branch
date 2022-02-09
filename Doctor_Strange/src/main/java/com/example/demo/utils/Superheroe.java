package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;


public class Superheroe implements ListaSuperheroes,ListaMovimiento{

    private String aliasSuperheroe, identidadSecreta, origen, afiliacion;
    private ArrayList<Integer> parrillaPoderes = new ArrayList<Integer>();
    private ArrayList<String> movimientos = new ArrayList<>();
    private int coste, recompensa, energiaVital,energiaInicial=80;


    public Superheroe() {
    }

    public Superheroe(String aliasSuperheroe, Escenario escenario) {
        this.aliasSuperheroe = aliasSuperheroe;
        crearSuperheroes(escenario);
    }

    public void crearSuperheroes(Escenario escenario) {
        switch (aliasSuperheroe) {
            case DOCTORSTRANGE:
                setDatos("Stephen Strange", "Humano Magico", STRANGEACADEMY, doctorStrange,doctorStrangeAtaque,doctorStrangeDefensa, escenario);
                break;
            case THOR:
                setDatos("Thor Odinson", "Asgardian", LEAGUEOFREALMS, thor,thorAtaque,thorDefensa, escenario);
                break;
            case SPIDERMAN:
                setDatos("Peter Parker", "Humano Mutado", LEAGUEOFREALMS, spiderman,spiderManAtaque,spiderManDefensa,escenario);
                break;
            case DEADPOOL:
                setDatos("Wade Wilson", "Humano Mejorado", XFORCE, deadpool,deadpoolAtaque,deadpoolDefensa ,escenario);
                break;
            case IRONMAN:
                setDatos("Anthony Stark", "Humano Mejorado", AVENGERS, ironman,ironManAtaque,ironManDefensa,escenario);
                break;
            case WOLVERINE:
                setDatos("James “Logan” Howlett", "Homo Superior", XMEN, wolverine,wolverineAtaque,wolverineDefensa, escenario);
                break;
            case HULK:
                setDatos("Bruce Banner", "Humano Mutado", AVENGERS, hulk,hulkAtaque,hulkDefensa, escenario);
                break;
            case THEPUNISHER:
                setDatos("Frank Castle", "Humano Mejorado", SAVAGEAVENGERS, thepunisher, thePunisherAtaque,thePunisherDefensa,escenario);
                break;
            case BLACKPANTHER:
                setDatos("T'Challa", "Humano Mejorado", AVENGERS, blackpanther, blackPantherAtaque,blackPantherDefensa,escenario);
                break;
            case CAPITANAMERICA:
                setDatos("Steve Rogers", "Humano Mejorado", AVENGERS, captainamerica,capitanAmericaAtaque,capitanAmericaDefensa, escenario);
                break;
            case LOKI:
                setDatos("Loki Odinson", "Asgardian", LEAGUEOFREALMS, loki,lokiAtaque,lokiDefensa, escenario);
                break;
            case CAPTAINMARVEL:
                setDatos("Carol Danvers", "Kree", AFORCE, captainmarvel,captainMarvelAtaque,captainMarvelDefensa, escenario);
                break;
        }

    }

    public void setDatos(String identidadSecreta, String origen, String afiliacion, List<Integer> list,
                         List<String> listaAtaque,List<String> listaDefensa, Escenario escenario) {

       int monedas = escenario.getNumMonedas();
        int miembros = escenario.getNumJugadores();
        int energiaVital = escenario.getEnergiaVital();
        this.identidadSecreta = identidadSecreta;
        this.origen = origen;
        this.afiliacion = afiliacion;
        parrillaPoderes.addAll(list);
        movimientos.addAll(listaAtaque);
        movimientos.addAll(listaDefensa);
        this.coste = (int) ((monedas / miembros) * ((list.get(0) + list.get(1) + list.get(2) + list.get(3) + list.get(4) + list.get(5)) / 30.0)); //ver por que divirlo
        this.recompensa = (int) (coste * (((list.get(0) + list.get(1) + list.get(2) + list.get(3) + list.get(4) + list.get(5)) / 6.0) / 7.0));
        this.energiaVital = energiaVital;
    }


    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<String> movimientos) {
        this.movimientos = movimientos;
    }

    public String getIdentidadSecreta() {
        return identidadSecreta;
    }
    public void setIdentidadSecreta(String identidadSecreta) {
        this.identidadSecreta = identidadSecreta;
    }
    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }
    public ArrayList<Integer> getParrillaPoderes() {
        return parrillaPoderes;
    }
    public void setParrillaPoderes(ArrayList<Integer> parrillaPoderes) {
        this.parrillaPoderes = parrillaPoderes;
    }
    public void setCoste(int coste) {
        this.coste = coste;
    }
    public int getRecompensa() {
        return recompensa;
    }
    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
    public int getCoste() {
        return coste;
    }
    public String getAliasSuperheroe() {
        return aliasSuperheroe;
    }
    public void setAliasSuperheroe(String aliasSuperheroe) {
        this.aliasSuperheroe = aliasSuperheroe;
    }
    public int getEnergiaVital() {
        return energiaVital;
    }
    public void setEnergiaVital(int energiaVital) {
        if (energiaVital < 0)
            energiaVital = 0;
        this.energiaVital = energiaVital;
    }
    public String getAfiliacion() {
        return afiliacion;
    }
    public int getEnergiaInicial() {
        return energiaInicial;
    }
    public void setEnergiaInicial(int energiaInicial) {
        this.energiaInicial = energiaInicial;
    }
}
