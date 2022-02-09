package com.example.demo;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Button button , btn2,btn3;;
    @FXML
    private BorderPane container;
    @FXML
    private ProgressBar progressBar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    private void loadThird(ActionEvent event) throws IOException {
      Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
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


                            Parent root = null;
                            try {
                                root = FXMLLoader.load(getClass().getResource("escenarios-view.fxml"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Scene scene = button.getScene();
                            root.translateXProperty().set(scene.getWidth());
                            StackPane parentContainer = (StackPane) button.getScene().getRoot();
                            parentContainer.getChildren().add(root);
                            Timeline timeline = new Timeline();
                            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
                            KeyFrame kf = new KeyFrame(Duration.seconds(0.60), kv);
                            timeline.getKeyFrames().add(kf);
                            timeline.setOnFinished(t -> {
                                parentContainer.getChildren().remove(container);
                                button.setDisable(true);
                            });
                            timeline.play();
                        }

                    });
                }
        });
        thread.start();

    }
}
