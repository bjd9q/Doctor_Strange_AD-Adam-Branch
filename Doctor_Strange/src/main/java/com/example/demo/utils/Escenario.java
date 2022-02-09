package com.example.demo.utils;

public class Escenario implements ListaEscenario{
    private String nombreEscenario;
    private int numMonedas, numJugadores, numMovimientos, energiaVital;
    //ArrayList<Integer> escenarioAtributosList= new ArrayList<Integer>();
    private String imagen;

    public Escenario() {
    }

    public Escenario(String nombreEscenario) {
        this.nombreEscenario=nombreEscenario;
       //crearEscenario();
    }



    public Escenario(String nombreEscenario, int numMonedas, int numJugadores, int numMovimientos, int energiaVital, String imagen) {
        this.nombreEscenario = nombreEscenario;
        this.numMonedas = numMonedas;
        this.numJugadores = numJugadores;
        this.numMovimientos = numMovimientos;
        this.energiaVital = energiaVital;
        this.imagen = imagen;
    }

    public int getNumMonedas() {
        return numMonedas;
    }

    public void setNumMonedas(int numMonedas) {
        this.numMonedas = numMonedas;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getNumMovimientos() {
        return numMovimientos;
    }

    public void setNumMovimientos(int numMovimientos) {
        this.numMovimientos = numMovimientos;
    }

    public int getEnergiaVital() {
        return energiaVital;
    }

    public void setEnergiaVital(int energiaVital) {
        this.energiaVital = energiaVital;
    }

    /*public Escenario(String nombreEscenario, ArrayList<Integer> escenarioAtributosList, String imagen) {
        this.nombreEscenario = nombreEscenario;
        this.escenarioAtributosList = escenarioAtributosList;
        this.imagen = imagen;
        crearEscenario();
    }*/

    /*public void crearEscenario(){
        switch (nombreEscenario) {
            case SANCTUM:
                setDatos("Sanctum Sanctorum", sanctumEsc, "https://allgamersin.com/wp-content/uploads/2019/06/MarvelsAvengers_10-743x420.jpg");
                break;
            case STARK:
                setDatos("Stark Tower", starkEsc, "https://files.lafm.com.co/assets/public/2018-07/avengers1_0.jpg");
                break;
            case ACADEMY:
                setDatos("Massachusetts Academy", academyEsc, "https://files.lafm.com.co/assets/public/2018-07/avengers16_0.jpg");
                break;
        }
    }*/

    /*public void setDatos(String nombreEscenario,List<Integer> escenarioList, String imagen) {
        this.nombreEscenario=nombreEscenario;
        escenarioAtributosList.addAll(escenarioList);
        this.imagen = imagen;
    }*/

    public String getNombreEscenario() {
        return nombreEscenario;
    }

    public void setNombreEscenario(String nombreEscenario) {
        this.nombreEscenario = nombreEscenario;
    }

    /*public ArrayList<Integer> getEscenarioAtributosList() {
        return escenarioAtributosList;
    }

    public void setEscenarioAtributosList(ArrayList<Integer> escenarioAtributosList) {
        this.escenarioAtributosList = escenarioAtributosList;
    }*/

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
