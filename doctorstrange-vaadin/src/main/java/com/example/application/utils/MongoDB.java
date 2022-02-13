package com.example.application.utils;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MongoDB {

    private MongoClient client = null;
    private MongoDatabase db = null;
    private Escenario escenarioSeleccionado;
    private List<Superheroe> allHeroes;


    public void conectionMongo() {
        client = MongoClients.create("mongodb+srv://AnaPozo:AnaPozo@cluster0.nnpyi.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        db = client.getDatabase("DoctorStrange");
    }

    public Escenario obtenerEscenario(String nombreEscenario) {
        String imagen = "";
        int monedasIniciales = 0, numJugadores = 0, numMovimientos = 0, energiaVital = 0;
        MongoCollection<Document> collection = db.getCollection("Escenarios");
        Document findDocument = new Document("_id", nombreEscenario);


        for (Document document : collection.find(findDocument)) {
            monedasIniciales = document.getInteger("Monedas_iniciales");
            numJugadores = document.getInteger("Numero_jugadores");
            numMovimientos = document.getInteger("Numero_movimientos");
            energiaVital = document.getInteger("Energia_vital");
            imagen = document.getString("Imagen");
        }


        escenarioSeleccionado = new Escenario(nombreEscenario, monedasIniciales, numJugadores, numMovimientos, energiaVital,
                imagen);
        return escenarioSeleccionado;
    }

    public List<Escenario> rellenarEscenario() {
        String imagen = "", nombreEscenario = "";
        int monedasIniciales = 0, numJugadores = 0, numMovimientos = 0, energiaVital = 0;
        MongoCollection<Document> collection = db.getCollection("Escenarios");
        List<Document> escenarios = new ArrayList<>();
        List<Escenario> escenariosFinal = new ArrayList<>();

        collection.find().iterator().forEachRemaining(escenarios::add);

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

    public List<Superheroe> allHeroes() {
        String identidadSecreta = null,origen= null,afiliacion= null,aliasSuperheroe=null;
        Integer coste = null;
        String img=null;
        String imgFace=null;
        int mediaPoder=0;
        ArrayList<String> ataque = null,defensa = null;
        ArrayList<Integer> parrillaPoderes = new ArrayList<>();
        List<Document> superheroes = new ArrayList<>();
        allHeroes = new ArrayList<>();


        MongoCollection<Document> collection = db.getCollection("SuperHeroesEnteros");

        collection.find().iterator().forEachRemaining(superheroes::add);

        for (int i = 0; i < superheroes.size(); i++) {
            Document document = superheroes.get(i);
            aliasSuperheroe = document.getString("_id");
            identidadSecreta = document.getString("identidadsecreta");
            origen = document.getString("origen");
            afiliacion = document.getString("afiliacion");

            Document docParrillapoderes = new Document((Map<String, Object>) document.get("parrillapoderes"));
            parrillaPoderes.add(docParrillapoderes.getInteger("habilidadLucha"));
            parrillaPoderes.add(docParrillapoderes.getInteger("proyeccionEnergia"));
            parrillaPoderes.add(docParrillapoderes.getInteger("resistencia"));
            parrillaPoderes.add(docParrillapoderes.getInteger("velocidad"));
            parrillaPoderes.add(docParrillapoderes.getInteger("fuerza"));
            parrillaPoderes.add(docParrillapoderes.getInteger("inteligencia"));
            img = document.getString("img_completo");
            imgFace = document.getString("img_cara");
            int a =docParrillapoderes.getInteger("habilidadLucha");
            int b =docParrillapoderes.getInteger("proyeccionEnergia");
            int c =docParrillapoderes.getInteger("resistencia");
            int d =docParrillapoderes.getInteger("velocidad");
            int e =docParrillapoderes.getInteger("fuerza");
            int f =docParrillapoderes.getInteger("inteligencia");

            coste = (int) ((10000 / 3) * ((a+b+c+d+e+f) / 30.0));
            mediaPoder = a+b+c+d+e+f/6;
            Document docMovimientos = new Document((Map<String, Object>) document.get("movimientos"));
            ataque = (ArrayList) docMovimientos.get("ataque");
            defensa = (ArrayList) docMovimientos.get("defensa");

            Superheroe superheroe = new Superheroe(aliasSuperheroe,identidadSecreta,origen,afiliacion,coste,ataque,defensa,parrillaPoderes,escenarioSeleccionado,img,imgFace,mediaPoder);
            allHeroes.add(superheroe);
        }
        return allHeroes;
    }

    public List<Superheroe> getAllHeroes() {
        return allHeroes;
    }
    public void setAllHeroes(List<Superheroe> allHeroes) {
        this.allHeroes = allHeroes;
    }
}
