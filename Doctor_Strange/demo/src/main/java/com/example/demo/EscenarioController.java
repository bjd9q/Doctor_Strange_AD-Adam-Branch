package com.example.demo;

import com.example.demo.utils.Escenario;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
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


public class EscenarioController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private Button btSeleccionar, btIzquierda, btDerecha;
    @FXML
    private ImageView imagenEscenario;
    @FXML
    private Label tituloEscenario;
    @FXML
    private ProgressBar progressBar;

    private ArrayList<Escenario> listaEscenarios;

    private List<Escenario> escenariosRecuperados;
    private int numImagen = 0;
    private MongoDB mongoDB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        crearListas();
        acciones();
    }

    private void crearListas() {
        escenariosRecuperados = mongoDB.rellenarEscenario();
        imagenEscenario.setImage(new Image(escenariosRecuperados.get(0).getImagen()));
        tituloEscenario.setText(escenariosRecuperados.get(0).getNombreEscenario());
    }
    private void instancias() {
        listaEscenarios = new ArrayList<>();
        escenariosRecuperados = new ArrayList<>();
        mongoDB = new com.example.demo.MongoDB();
        mongoDB.conectionMongo();
    }
    private void acciones() {
        btDerecha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                numImagen = numImagen + 1;
                if (numImagen < 3) {
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
                numImagen = numImagen - 1;
                if (numImagen >= 0) {
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
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        btSeleccionar.setVisible(false);
                        progressBar.setVisible(true);
                        double progress = 0;

                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(8);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            progress +=0.01;
                            progressBar.setProgress(progress);
                        }

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {

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
                        PersonajeController personajeController = fxmlLoader.getController();
                        escenarioSeleccionado = mongoDB.obtenerEscenario(tituloEscenario.getText());
                        personajeController.setearDatos(escenarioSeleccionado, EscenarioController.this);
                        timeline.setOnFinished(t -> {
                            stackPane.getChildren().remove(stackPane);
                        });

                        timeline.play();
                            }

                        });
                    }
                });
                thread.start();
            }
        });

    }



}
