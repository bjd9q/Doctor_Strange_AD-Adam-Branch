package com.example.demo;

import com.example.demo.utils.Superheroe;

import java.util.ArrayList;

public class Pruebas {

    public static void main(String[] args) {
        MongoDB mongoDB = new MongoDB();
        mongoDB.conectionMongo();
        mongoDB.rellenarEscenario();
        mongoDB.allHeroes();


    }
}
