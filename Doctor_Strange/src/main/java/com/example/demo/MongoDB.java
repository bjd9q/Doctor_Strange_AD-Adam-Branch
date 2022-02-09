package com.example.demo;


import com.example.demo.utils.Escenario;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;


import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    private MongoClient client = null;
    private MongoDatabase db = null;
    private Escenario escenario;

    /*public static void main(String[] args) {
         MongoClient client = null;
         MongoDatabase db = null;
        client =  MongoClients.create("mongodb+srv://AnaPozo:AnaPozo@cluster0.nnpyi.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        db = client.getDatabase("DoctorStrange");
        String imagen="", nombreEscenario="";
        int monedasIniciales=0, numJugadores=0, numMovimientos=0, energiaVital=0;
        MongoCollection<Document> collection = db.getCollection("Escenarios");
        List<Document> escenarios = new ArrayList<>();
        List<Escenario> escenariosFinal = new ArrayList<>();

        collection
                .find()
                .iterator()
                .forEachRemaining(escenarios::add);

        for (int i = 0; i < escenarios.size(); i++) {
            Document document = escenarios.get(i);
                nombreEscenario = document.getString("_id");
                monedasIniciales = document.getInteger("Monedas_iniciales");
                numJugadores = document.getInteger("Numero_jugadores");
                numMovimientos = document.getInteger("Numero_movimientos");
                energiaVital = document.getInteger("Energia_vital");
                imagen = document.getString("Imagen");
                Escenario escenarioSeleccionado = new Escenario(nombreEscenario, monedasIniciales, numJugadores, numMovimientos, energiaVital,
                        imagen);
                escenariosFinal.add(escenarioSeleccionado);
                System.out.println(escenarioSeleccionado.getNombreEscenario());
                System.out.println(escenarioSeleccionado.getNumMonedas());
                System.out.println(escenarioSeleccionado.getEnergiaVital());
                System.out.println(escenarioSeleccionado.getNumJugadores());
        }
    }*/


    public void conectionMongo(){
         client =  MongoClients.create("mongodb+srv://AnaPozo:AnaPozo@cluster0.nnpyi.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
         db = client.getDatabase("DoctorStrange");
    }
   public Escenario obtenerEscenario(String nombreEscenario){
        String imagen="";
        int monedasIniciales=0, numJugadores=0, numMovimientos=0, energiaVital=0;
       MongoCollection<Document> collection = db.getCollection("Escenarios");
       Document findDocument = new Document("_id", nombreEscenario);

       for (Document document : collection.find(findDocument)) {
           //System.out.println(document.getInteger("Monedas_iniciales"));
           monedasIniciales = document.getInteger("Monedas_iniciales");
           numJugadores = document.getInteger("Numero_jugadores");
           numMovimientos = document.getInteger("Numero_movimientos");
           energiaVital = document.getInteger("Energia_vital");
           imagen = document.getString("Imagen");
       }


       Escenario escenarioSeleccionado = new Escenario(nombreEscenario, monedasIniciales, numJugadores, numMovimientos, energiaVital,
               imagen);
        return escenarioSeleccionado;
   }

   public List<Escenario> rellenarEscenario(){
       String imagen="", nombreEscenario="";
       int monedasIniciales=0, numJugadores=0, numMovimientos=0, energiaVital=0;
       MongoCollection<Document> collection = db.getCollection("Escenarios");
       List<Document> escenarios = new ArrayList<>();
       List<Escenario> escenariosFinal = new ArrayList<>();

       collection
               .find()
               .iterator()
               .forEachRemaining(escenarios::add);

       for (int i = 0; i < escenarios.size(); i++) {
           Document document = escenarios.get(i);
               nombreEscenario = document.getString("_id");
               monedasIniciales = document.getInteger("Monedas_iniciales");
               numJugadores = document.getInteger("Numero_jugadores");
               numMovimientos = document.getInteger("Numero_movimientos");
               energiaVital = document.getInteger("Energia_vital");
               imagen = document.getString("Imagen");
               Escenario escenarioSeleccionado = new Escenario(nombreEscenario, monedasIniciales, numJugadores, numMovimientos, energiaVital,
                       imagen);
               escenariosFinal.add(escenarioSeleccionado);
       }
       return escenariosFinal;
   }

     /*


       MongoCollection<Document> collection = db.getCollection("SuperHeroesEnteros");
        Document findDocument = new Document("_id", "Spiderman");

        for (Document document : collection.find(findDocument)) {
            System.out.println(document.getString("identidadsecreta"));
        }
        Bson bson = new Document("identidadsecreta","Tom Holland");
        Bson update = new Document("$set",bson);
        collection.updateOne(findDocument,update);

        for (Document document : collection.find(findDocument)) {
            System.out.println(document.getString("identidadsecreta"));
        }
    }
    */



}
