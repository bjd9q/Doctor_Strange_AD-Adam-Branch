package com.example.application.utils;

public class v {
    public static void main(String[] args) {
        MongoDB mongoDB = new MongoDB();
        mongoDB.conectionMongo();
        Escenario escenario ;
        escenario = mongoDB.obtenerEscenario("Sanctum Sanctorum");
        System.out.println(escenario.getNombreEscenario());

    }
}
