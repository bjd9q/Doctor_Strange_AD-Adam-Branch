package com.example.demo;

import com.example.demo.utils.Escenario;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class EscenarioController implements Initializable{

    @FXML
    private StackPane stackPane;
    @FXML
    private Button btSeleccionar, btIzquierda, btDerecha;
    @FXML
    private ImageView imagenEscenario;
    @FXML
    private Label tituloEscenario;
    private ArrayList<Escenario> listaEscenarios;
    private List<Escenario> escenariosRecuperados;
    private int numImagen = 0;
    private PersonajeController personajeController;
    private MongoDB mongoDB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
       crearListas();
        acciones();
    }

   private void crearListas() {
       escenariosRecuperados = mongoDB.rellenarEscenario();
       /* listaEscenarios.add(new Escenario("Sanctum Sanctorum", 1000, 3, 10, 100, "https://allgamersin.com/wp-content/uploads/2019/06/MarvelsAvengers_10-743x420.jpg"));
        listaEscenarios.add(new Escenario("Stark Tower", 20000,5,25,200, "https://files.lafm.com.co/assets/public/2018-07/avengers1_0.jpg"));
        listaEscenarios.add(new Escenario("Massachusetts Academy", 80000,7,40,300, "https://files.lafm.com.co/assets/public/2018-07/avengers16_0.jpg"));
        imagenEscenario.setImage(new Image(listaEscenarios.get(0).getImagen()));
        tituloEscenario.setText(listaEscenarios.get(0).getNombreEscenario());*/
       imagenEscenario.setImage(new Image(escenariosRecuperados.get(0).getImagen()));
       tituloEscenario.setText(escenariosRecuperados.get(0).getNombreEscenario());
    }

    private void acciones() {
        btDerecha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numImagen = numImagen+1;
                if (numImagen<3){
                    imagenEscenario.setImage(new Image(escenariosRecuperados.get(numImagen).getImagen()));
                    tituloEscenario.setText(escenariosRecuperados.get(numImagen).getNombreEscenario());
                } else {
                    numImagen = numImagen - 1;
                }
            }
        });
        btIzquierda.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numImagen = numImagen-1;
                if (numImagen>=0){
                    imagenEscenario.setImage(new Image(escenariosRecuperados.get(numImagen).getImagen()));
                    tituloEscenario.setText(escenariosRecuperados.get(numImagen).getNombreEscenario());
                } else {
                    numImagen = numImagen + 1;
                }
            }
        });
        btSeleccionar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Escenario escenarioSeleccionado;
                FXMLLoader fxmlLoader = new FXMLLoader(Escenario.class.getResource("/com/example/demo/personaje-view.fxml"));

                Parent root = null;
                try {
                    root = fxmlLoader.load();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = btSeleccionar.getScene();
                root.translateYProperty().set(scene.getHeight());
                stackPane.getChildren().add(root);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(0.60), kv);
                timeline.getKeyFrames().add(kf);
                com.example.demo.PersonajeController personajeController = fxmlLoader.getController();
                escenarioSeleccionado = mongoDB.obtenerEscenario(tituloEscenario.getText());
                personajeController.setearDatos(escenarioSeleccionado, EscenarioController.this);
                timeline.setOnFinished(t -> {
                    stackPane.getChildren().remove(stackPane);
                });

                timeline.play();
            }
        });
    }

    private void instancias() {
        listaEscenarios = new ArrayList<>();
        escenariosRecuperados = new ArrayList<>();
        mongoDB = new com.example.demo.MongoDB();
        mongoDB.conectionMongo();
    }

}
