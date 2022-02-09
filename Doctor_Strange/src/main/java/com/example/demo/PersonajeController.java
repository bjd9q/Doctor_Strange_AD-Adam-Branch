package com.example.demo;

import com.example.demo.utils.Escenario;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonajeController implements Initializable {

    @FXML
    private Button btEmpezar, btnDoc, btnCapMar, btnCapi, btnDeadpool, btnHulk, btnIron, btnLoki, btnPanther, btnPunish, btnSpider, btnThor, btnWol;

    @FXML
    private ImageView imgPlayerOne, imgPers2J1, imgPers2J2, imgPers3J1, imgPers3J2;

    @FXML
    StackPane stackPane;

    private  EscenarioController escenarioController;

    /*private Parent root;
    private Scene scene;
    private final Escenario escenario = new Escenario("Sanctum Sanctorum");
    private boolean Player1personaje1Select, Player1personaje2Select, Player1personaje3Select;
    private boolean Player2personaje1Select, Player2personaje2Select, Player2personaje3Select;

    private final Superheroe doctor_strange = new Superheroe("Doctor Strange", this.escenario);
    private final Superheroe thor = new Superheroe("Thor", this.escenario);
    private final Superheroe spiderman = new Superheroe("Spiderman", this.escenario);
    private final Superheroe deadpool = new Superheroe("Deadpool", this.escenario);
    private final Superheroe iron_man = new Superheroe("Iron Man", this.escenario);
    private final Superheroe wolverine = new Superheroe("Daredevil", this.escenario);
    private final Superheroe hulk = new Superheroe("Hulk", this.escenario);
    private final Superheroe the_punisher = new Superheroe("The Punisher", this.escenario);
    private final Superheroe black_panther = new Superheroe("Black Panther", this.escenario);
    private final Superheroe capitan_america = new Superheroe("Capitan America", this.escenario);


    private Image imgDocSelect, imgSpidermanSelect, imgThorSelect, imgIronSelect, imgDeadSelect, imgWolSelect, imgPunishSelect, imgCapSelect, imgLokiSelect, imgHulkSelect, imgCapMarSelect, imgPantherSelect;


    private final int maxSuperheroes = 2;
    private final Equipo equipo1 = new Equipo();
    private final Equipo equipo2 = new Equipo();

    private final Jugador jugador1 = new Jugador(escenario, equipo1);
    private final Jugador jugador2 = new Jugador(escenario, equipo2);

    private final int monedasJugador = jugador1.getNum_monedas_jugador();
    private final int monedasJugador2 = jugador2.getNum_monedas_jugador();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instancia();
        accionHover();
    }

    private void instancia() {

        imgDocSelect = new Image("assets/img/docSelect.png");
        imgSpidermanSelect = new Image("assets/img/spidi.png");
        imgThorSelect = new Image("assets/img/thorSelect.png");
        imgIronSelect = new Image("assets/img/ironSelect.png");
        imgDeadSelect = new Image("assets/img/deadSelect.png");
        imgWolSelect = new Image("assets/img/wolSelect.png");
        imgPunishSelect = new Image("assets/img/punishSelect.png");
        imgCapSelect = new Image("assets/img/capiSelect.png");
        imgLokiSelect = new Image("assets/img/lokiSelect.png");
        imgHulkSelect = new Image("assets/img/hulkSelect.png");
        imgCapMarSelect = new Image("assets/img/capMarSelect.png");
        imgPantherSelect = new Image("assets/img/pantherSelect.png");
    }


    public void accionHover() {
        btnDoc.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgDocSelect);
            }
        });


        btnSpider.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgSpidermanSelect);

            }
        });


        btnThor.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgThorSelect);
            }
        });
        btnIron.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgIronSelect);

            }
        });
        btnDeadpool.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgDeadSelect);

            }
        });
        btnWol.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgWolSelect);

            }
        });
        btnPunish.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgPunishSelect);

            }
        });
        btnCapi.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgCapSelect);

            }
        });
        btnLoki.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgLokiSelect);

            }
        });
        btnHulk.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgHulkSelect);

            }
        });
        btnCapMar.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgCapMarSelect);

            }
        });
        btnPanther.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                imgPlayerOne.setImage(imgPantherSelect);

            }
        });


    }

    private void accion() {
        btnDoc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                equipo1.añadirSuperheroe(doctor_strange);
                btnDoc.setDisable(true);
            }
        });

        btnSpider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                equipo1.añadirSuperheroe(spiderman);
                btnSpider.setDisable(true);
            }
        });

        btnThor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                equipo1.añadirSuperheroe(thor);
                btnThor.setDisable(true);
            }
        });
    }*/
    public void setearDatos(Escenario escenario, EscenarioController controller) {
        System.out.println(escenario.getNombreEscenario());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btEmpezar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/com/example/demo/partida-view.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = btEmpezar.getScene();
                root.translateXProperty().set(scene.getHeight());
                stackPane.getChildren().add(root);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(0.60), kv);
                timeline.getKeyFrames().add(kf);
                timeline.setOnFinished(t -> {
                    stackPane.getChildren().remove(stackPane);
                    System.out.println("Llegue");
                    //button.setDisable(true);

                });
                timeline.play();
            }
        });
    }
}



