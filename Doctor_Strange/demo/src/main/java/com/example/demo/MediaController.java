package com.example.demo;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaController implements Initializable{

    @FXML
    private MediaView video;
    @FXML
    private BorderPane borderV;
    @FXML
    private StackPane parentContainer;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cargarVideo();
    }

    public void loadScene1() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.60), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(borderV);
            mediaPlayer.stop();
        });
        timeline.play();
    }

    public void cargarVideo() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() - 20;
        int height = gd.getDisplayMode().getHeight() - 20;
        file = new File("src/main/resources/assets/Video/bgInicio.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        video.setFitHeight(height);
        video.setFitWidth(width);
        video.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(video.translateXProperty(), 11, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(10), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            borderV.getChildren().remove(video);
            try {
                loadScene1();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        timeline.play();
    }
}

