package com.example.demo;

import com.example.demo.utils.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PartidaController implements Initializable {

    @FXML
    private Label energiaVitalJ1, energiaVitalJ2, energiaLuchaJ1, energiaLuchaJ2;
    @FXML
    private Button btSuper1J1, btSuper2J1, btSuper3J1, btSuper1J2, btSuper2J2, btSuper3J2;
    @FXML
    private Button btnIniciar;
    @FXML
    private Button btAtaque1J1, btAtaque2J1, btDefensa1J1, btDefensa2J1, btAtaque1J2, btAtaque2J2, btDefensa1J2, btDefensa2J2;
    private PersonajeController personajeController;
    private Jugador j1, j2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializar();
    }

    public void setearDatos(Jugador jugador, Jugador jugador2, PersonajeController personajeController) {
        j1 = jugador;
        j2 = jugador2;
    }

    public void inicializar() {
        btnIniciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(j1.getEquipo().getListaSuperheroe().get(0).getAliasSuperheroe());
            }
        });
    }
}
