package com.example.demo;
import com.example.demo.utils.Equipo;
import com.example.demo.utils.Escenario;
import com.example.demo.utils.Jugador;
import com.example.demo.utils.Superheroe;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PersonajeController implements Initializable {

    @FXML
    private Button eliminar,test, btEmpezar, btnDoc2, btnHulk2, btnCapMar2, btnPanther2, btnPunish2, btnLoki2, btnCapi2, btnDead2, btnIron2, btnSpider2, btnThor2, btnWol2, btnDoc, btnSpider, btnCapMar, btnCapi, btnDeadpool, btnHulk, btnIron, btnLoki, btnPanther, btnPunish, btnThor, btnWol;
    @FXML
    private Label afiliacion, aliasSuperheroe, afiliacion1, aliasSuperheroe1, monedasJ1, monedasJ2, coste, coste2;
    @FXML
    private VBox vboxPersonajes, vboxPersonajes1, vboxCoste, vboxCoste1;
    @FXML
    private Pane J1P2, J1P3, J2P2, J2P3;
    @FXML
    private HBox boxCoin1, boxCoin2, cajaDer, cajaIzq;
    @FXML
    private GridPane grid2;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView imgPlayerOne, J2P1, imgPers2J1, imgPers3J1, imgPers2J2, imgPers3J2;

    private Image imgDocSelect, imgSpidermanSelect, imgThorSelect, imgIronSelect, imgDeadSelect, imgWolSelect, imgPunishSelect, imgCapSelect, imgLokiSelect, imgHulkSelect, imgCapMarSelect, imgPantherSelect;
    private Image imgDocFace, imgSpidermanFace, imgThorFace, imgIronFace, imgDeadFace, imgWolFace, imgPunishFace, imgCapFace, imgLokiFace, imgHulkFace, imgCapMarFace, imgPantherFace;
    private Escenario escenario1;
    private List<Superheroe> superheroeList;
    private Jugador jugador1, jugador2;
    private Equipo equipo1, equipo2;
    private PartidaController partidaController;

    private ArrayList<Superheroe> superheroesSeleccionados, axuHeroesSeleccionados;
    private MongoDB mongoDB;
    private Glow glow;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instancia();
        crearLista();
        accionHover();
        accionAdd();
        nextScene();
    }

    private void instancia() {
        equipo1 = new Equipo();
        equipo2 = new Equipo();
        glow = new Glow();
        glow.setLevel(0.3);
        superheroesSeleccionados = new ArrayList<>();
        axuHeroesSeleccionados = new ArrayList<>();
        mongoDB = new MongoDB();
        mongoDB.conectionMongo();
    }

    private void crearLista() {
        superheroeList = mongoDB.allHeroes();
        imgHulkSelect = new Image(superheroeList.get(4).getImgCompleto());
        imgPunishSelect = new Image(superheroeList.get(1).getImgCompleto());
        imgDocSelect = new Image(superheroeList.get(10).getImgCompleto());
        imgSpidermanSelect = new Image(superheroeList.get(6).getImgCompleto());
        imgThorSelect = new Image(superheroeList.get(7).getImgCompleto());
        imgIronSelect = new Image(superheroeList.get(9).getImgCompleto());
        imgDeadSelect = new Image(superheroeList.get(11).getImgCompleto());
        imgWolSelect = new Image(superheroeList.get(8).getImgCompleto());
        imgCapSelect = new Image(superheroeList.get(5).getImgCompleto());
        imgLokiSelect = new Image(superheroeList.get(0).getImgCompleto());
        imgCapMarSelect = new Image(superheroeList.get(3).getImgCompleto());
        imgPantherSelect = new Image(superheroeList.get(2).getImgCompleto());


        imgDocFace = new Image(superheroeList.get(10).getImgFace());
        imgSpidermanFace = new Image(superheroeList.get(6).getImgFace());
        imgThorFace = new Image(superheroeList.get(7).getImgFace());
        imgIronFace = new Image(superheroeList.get(9).getImgFace());
        imgDeadFace = new Image(superheroeList.get(11).getImgFace());
        imgWolFace = new Image(superheroeList.get(8).getImgFace());
        imgPunishFace = new Image(superheroeList.get(1).getImgFace());
        imgCapFace = new Image(superheroeList.get(5).getImgFace());
        imgLokiFace = new Image(superheroeList.get(0).getImgFace());
        imgHulkFace = new Image(superheroeList.get(4).getImgFace());
        imgCapMarFace = new Image(superheroeList.get(3).getImgFace());
        imgPantherFace = new Image(superheroeList.get(2).getImgFace());
    }

    public void resetear() {
        coste = coste2;
        monedasJ1 = monedasJ2;
        superheroesSeleccionados = axuHeroesSeleccionados;
        imgPers2J1 = imgPers2J2;
        imgPers3J1 = imgPers3J2;
        btnPunish = btnPunish2;
        btnSpider = btnSpider2;
        btnThor = btnThor2;
        btnWol = btnWol2;
        btnHulk = btnHulk2;
        btnDoc = btnDoc2;
        btnLoki = btnLoki2;
        btnDeadpool = btnDead2;
        btnCapMar = btnCapMar2;
        btnCapi = btnCapi2;
        btnIron = btnIron2;
        btnPanther = btnPanther2;
        afiliacion = afiliacion1;
        aliasSuperheroe = aliasSuperheroe1;
        J1P2 = J2P2;
        J1P3 = J2P3;
        imgPlayerOne = J2P1;
        imgPlayerOne.setDisable(false);
        J1P2.setDisable(false);
        J1P3.setDisable(false);
        accionHover();
        accionAdd();
        superheroesSeleccionados.remove(0);
    }

    private void accionHover() {

        btnHulk.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgHulkSelect, superheroeList.get(4), imgHulkFace);
            }
        });
        btnPunish.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgPunishSelect, superheroeList.get(1), imgPunishFace);
            }
        });
        btnPanther.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgPantherSelect, superheroeList.get(2), imgPantherFace);
            }
        });
        btnCapi.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgCapSelect, superheroeList.get(5), imgCapFace);
            }
        });
        btnLoki.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgLokiSelect, superheroeList.get(0), imgLokiFace);
            }
        });
        btnCapMar.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgCapMarSelect, superheroeList.get(3), imgCapMarFace);
            }
        });
        btnDoc.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgDocSelect, superheroeList.get(10), imgDocFace);
            }
        });
        btnThor.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgThorSelect, superheroeList.get(7), imgThorFace);
            }
        });
        btnSpider.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgSpidermanSelect, superheroeList.get(6), imgSpidermanFace);
            }
        });
        btnDeadpool.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgDeadSelect, superheroeList.get(11), imgDeadFace);
            }
        });
        btnIron.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgIronSelect, superheroeList.get(9), imgIronFace);
            }
        });
        btnWol.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                hoverAux(imgWolSelect, superheroeList.get(8), imgWolFace);
            }
        });
    }
    private void hoverAux(Image imgCompleto, Superheroe superheroe, Image imgFace) {

        if (!imgPlayerOne.isDisable()) {
            imgPlayerOne.setImage(imgCompleto);
            aliasSuperheroe.setText(superheroe.getAliasSuperheroe());
            afiliacion.setText(superheroe.getAfiliacion());
            coste.setText(String.valueOf(superheroe.getCoste()));

        }

        if (!imgPers2J1.isDisable() && imgPlayerOne.getImage() != imgFace && imgPlayerOne.getImage() != imgCompleto) {
            imgPers2J1.setImage(imgFace);
            aliasSuperheroe.setText(superheroesSeleccionados.get(0).getAliasSuperheroe() + " | " + superheroe.getAliasSuperheroe());
            afiliacion.setText(superheroesSeleccionados.get(0).getAfiliacion() + " | " + superheroe.getAfiliacion());
            coste.setText(String.valueOf(superheroe.getCoste()));

        }
        if (!imgPers3J1.isDisable() && imgPers2J1.getImage() != imgFace && imgPlayerOne.getImage() != imgCompleto) {
            imgPers3J1.setImage(imgFace);
            aliasSuperheroe.setText(superheroesSeleccionados.get(0).getAliasSuperheroe() + " | " + superheroesSeleccionados.get(1).getAliasSuperheroe() + " | " + superheroe.getAliasSuperheroe());
            afiliacion.setText(superheroesSeleccionados.get(0).getAfiliacion() + " | " + superheroesSeleccionados.get(1).getAfiliacion() + " | " + superheroe.getAfiliacion());
            coste.setText(String.valueOf(superheroe.getCoste()));

        }
    }
    private void accionAdd() {
        test.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                jugador1 = new Jugador(escenario1, equipo1);
                jugador2 = new Jugador(escenario1, equipo2);
                monedasJ1.setText(String.valueOf(jugador1.getNum_monedas_jugador()));
                monedasJ2.setText(String.valueOf(jugador2.getNum_monedas_jugador()));
                boxCoin1.setVisible(true);
                boxCoin2.setVisible(true);
                cajaDer.setDisable(false);
                cajaIzq.setDisable(false);
                btEmpezar.setVisible(true);
                J1P2.setVisible(true);
                J1P3.setVisible(true);
                J2P2.setVisible(true);
                J2P3.setVisible(true);
                vboxCoste.setVisible(true);
                test.setVisible(false);
            }
        });

        btnLoki.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(0), btnLoki);
            }
        });
        btnPunish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(1), btnPunish);
            }
        });
        btnPanther.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(2), btnPanther);
            }
        });
        btnCapMar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(3), btnCapMar);
            }
        });
        btnHulk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {addAux(superheroeList.get(4), btnHulk);}
        });
        btnCapi.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(5), btnCapi);
            }
        });
        btnSpider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(6), btnSpider);
            }
        });
        btnThor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(7), btnThor);
            }
        });
        btnWol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(8), btnWol);
            }
        });
        btnIron.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(9), btnIron);
            }
        });

        btnDoc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(10), btnDoc);
            }
        });


        btnDeadpool.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addAux(superheroeList.get(11), btnDeadpool);
            }
        });


    }

    private void addAux(Superheroe superheroe, Button btn) {
        if (superheroesSeleccionados.size() <= 2 && jugador1.getNum_monedas_jugador() >= superheroe.getCoste() && grid2.isDisable()) {
            superheroesSeleccionados.add(superheroe);
            jugador1.setNum_monedas_jugador(jugador1.getNum_monedas_jugador() - superheroe.getCoste());
            System.out.println(jugador1.getNum_monedas_jugador());
            monedasJ1.setText(String.valueOf(jugador1.getNum_monedas_jugador()));

            if (superheroesSeleccionados.size() <= 1) {
                imgPlayerOne.setDisable(true);
                imgPlayerOne.setEffect(glow);
            } else if (superheroesSeleccionados.size() <= 2) {
                imgPers2J1.setDisable(true);
                J1P2.setStyle("-fx-background-color: #FFFFFF;");
            } else {
                imgPers3J1.setDisable(true);
                J1P3.setStyle("-fx-background-color: #FFFFFF;");
            }
            btn.setStyle("-fx-background-color: #FFFFFF;");
            btn.setDisable(true);
            if (superheroesSeleccionados.size() == 3 && equipo1.getListaSuperheroe().size() == 0) {
                vboxPersonajes.setDisable(true);
                vboxCoste.setVisible(false);
                equipo1.setListaSuperheroe(superheroesSeleccionados);
                vboxCoste1.setVisible(true);
                grid2.setDisable(false);
                resetear();
            }
            if (superheroesSeleccionados.size() == 3 && equipo1.getListaSuperheroe().size() == 3) {
                vboxPersonajes1.setDisable(true);
                vboxCoste1.setVisible(false);
                equipo2.setListaSuperheroe(superheroesSeleccionados);
                jugador2 = new Jugador(escenario1, equipo2);
            }
        }

        if (superheroesSeleccionados.size() <= 2 && jugador2.getNum_monedas_jugador() >= superheroe.getCoste() && !grid2.isDisable()) {
            superheroesSeleccionados.add(superheroe);
            jugador2.setNum_monedas_jugador(jugador2.getNum_monedas_jugador() - superheroe.getCoste());
            System.out.println(jugador2.getNum_monedas_jugador());
            monedasJ1.setText(String.valueOf(jugador2.getNum_monedas_jugador()));

            if (superheroesSeleccionados.size() <= 1) {
                imgPlayerOne.setDisable(true);
                imgPlayerOne.setEffect(glow);
            } else if (superheroesSeleccionados.size() <= 2) {
                imgPers2J1.setDisable(true);
                J1P2.setStyle("-fx-background-color: #FFFFFF;");
            } else {
                imgPers3J1.setDisable(true);
                J1P3.setStyle("-fx-background-color: #FFFFFF;");
            }
            btn.setStyle("-fx-background-color: #FFFFFF;");
            btn.setDisable(true);

            if (superheroesSeleccionados.size() == 3 && equipo2.getListaSuperheroe().size() == 0) {
                vboxPersonajes.setDisable(true);
                vboxCoste.setVisible(false);
                equipo2.setListaSuperheroe(superheroesSeleccionados);
                vboxCoste1.setVisible(true);
                jugador2.setEquipo(equipo2);
            }
            if (superheroesSeleccionados.size() == 3 && equipo1.getListaSuperheroe().size() == 3) {
                vboxPersonajes1.setDisable(true);
                vboxCoste1.setVisible(false);
                equipo2.setListaSuperheroe(superheroesSeleccionados);
                jugador2.setEquipo(equipo2);

            }
        }
    }

    private void nextScene() {
        btEmpezar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                for (Superheroe s : jugador1.getEquipo().getListaSuperheroe()) {
                    System.out.println();
                    System.out.println(s.getAliasSuperheroe());
                    System.out.println(s.getMediaPoder());
                    System.out.println();

                }

                System.out.println(jugador1.getNum_monedas_jugador());

                for (Superheroe s : jugador2.getEquipo().getListaSuperheroe()) {
                    System.out.println();
                    System.out.println(s.getAliasSuperheroe());
                    System.out.println(s.getMediaPoder());
                    System.out.println();
                }
                System.out.println(jugador2.getNum_monedas_jugador());
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                FXMLLoader fxmlLoader = new FXMLLoader(Escenario.class.getResource("/com/example/demo/partida-view.fxml"));

                                Parent root = null;
                                try {
                                    root = fxmlLoader.load();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Scene scene = btEmpezar.getScene();
                                root.translateYProperty().set(scene.getHeight());
                                stackPane.getChildren().add(root);
                                Timeline timeline = new Timeline();
                                KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
                                KeyFrame kf = new KeyFrame(Duration.seconds(0.60), kv);
                                timeline.getKeyFrames().add(kf);
                                PartidaController partidaController = fxmlLoader.getController();
                                partidaController.setearDatos(jugador1,jugador2,PersonajeController.this);
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



    public void setearDatos(Escenario escenario, EscenarioController controller) {
        escenario1 = escenario;
    }




}



