package com.example.application.views.partida;

import com.example.application.utils.Jugador;
import com.example.application.utils.Superheroe;
import com.example.application.views.personaje.PersonajeView;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import scala.Array;

import java.util.*;

@PageTitle("Partida")
@Route(value = "partida")
public class PartidaView extends VerticalLayout  {

    private VerticalLayout containerJ1, containerJ2,verticalVidaEnergiaJ1,verticalVidaEnergiaJ2,verticalBotonesJ1,verticalBotonesJ2;
    private HorizontalLayout personajesJ1, personajesJ2, base,horizontalVidaJ1,horizontalVidaJ2,horizontalEnergiaJ1,horizontalEnergiaJ2,filaUnoBtnJ1,filaDosBtnJ1,filaUnoBtnJ2,filaDosBtnJ2;
    private Image j1p1img, j1p2img, j1p3img, j2p1img, j2p2img, j2p3img, heartImg, heartImg2,enerImg, enerImg2;
    private Button btnAtaqueUnoJ1, btnAtaqueDosJ1, btnAtaqueUnoJ2, btnAtaqueDosJ2,btnDefensaUnoJ1, btnDefensaDosJ1, btnDefensaUnoJ2, btnDefensaDosJ2;

    public PartidaView() {
     inicializarYinstanciar();
    }

    public void inicializarYinstanciar(){
        containerJ1 = new VerticalLayout();
        containerJ2 = new VerticalLayout();

        verticalVidaEnergiaJ1 = new VerticalLayout();
        verticalVidaEnergiaJ2 = new VerticalLayout();

        horizontalVidaJ1 = new HorizontalLayout();
        horizontalVidaJ2 = new HorizontalLayout();

        heartImg = new Image("/images/heart.png", "");
        heartImg.setWidth("60px");
        heartImg2 = new Image("/images/heart.png", "");
        heartImg2.setWidth("60px");

        enerImg = new Image("https://cdn-icons-png.flaticon.com/512/2983/2983973.png", "");
        enerImg.setWidth("60px");
        enerImg2 = new Image("https://cdn-icons-png.flaticon.com/512/2983/2983973.png", "");
        enerImg2.setWidth("60px");



        horizontalVidaJ1.add(heartImg);
        horizontalVidaJ2.add(heartImg2);

        horizontalEnergiaJ1 = new HorizontalLayout();
        horizontalEnergiaJ2 = new HorizontalLayout();

        horizontalEnergiaJ1.add(enerImg);
        horizontalEnergiaJ2.add(enerImg2);

        verticalVidaEnergiaJ1.add(horizontalVidaJ1);
        verticalVidaEnergiaJ1.add(horizontalEnergiaJ1);

        verticalVidaEnergiaJ2.add(horizontalVidaJ2);
        verticalVidaEnergiaJ2.add(horizontalEnergiaJ2);

        base = new HorizontalLayout();
        personajesJ1 = new HorizontalLayout();
        personajesJ2 = new HorizontalLayout();

        j1p1img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "");
        j1p2img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "");
        j1p3img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "");

        j2p1img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "");
        j2p2img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "");
        j2p3img = new Image("https://i.ibb.co/WybhkLD/loki-Select.png", "");



        j2p1img.setWidth("262px");
        j2p2img.setWidth("262px");
        j2p3img.setWidth("262px");

        j1p1img.setWidth("262px");
        j1p2img.setWidth("262px");
        j1p3img.setWidth("262px");

        verticalBotonesJ1 = new VerticalLayout();
        verticalBotonesJ2 = new VerticalLayout();

        filaUnoBtnJ1 = new HorizontalLayout();
        filaDosBtnJ1 = new HorizontalLayout();

        filaUnoBtnJ2 = new HorizontalLayout();
        filaDosBtnJ2 = new HorizontalLayout();

        btnAtaqueUnoJ1 = new Button("Ataque 1");
        btnAtaqueUnoJ2 = new Button("Ataque 2");
        btnAtaqueDosJ1 = new Button("Ataque 1");
        btnAtaqueDosJ2 = new Button("Ataque 2");

        btnDefensaUnoJ1 = new Button("Defensa 1");
        btnDefensaUnoJ2 = new Button("Defensa 2");
        btnDefensaDosJ2 = new Button("Defensa 2");
        btnDefensaDosJ1 = new Button("Defensa 1");

        filaUnoBtnJ1.add(btnAtaqueUnoJ1,btnAtaqueDosJ1);
        filaUnoBtnJ2.add(btnAtaqueUnoJ2,btnAtaqueDosJ2);

        filaDosBtnJ1.add(btnDefensaUnoJ1,btnDefensaDosJ1);
        filaDosBtnJ2.add(btnDefensaUnoJ2,btnDefensaDosJ2);

        HorizontalLayout horizontalBtn = new HorizontalLayout();
        verticalBotonesJ1.add(filaUnoBtnJ1,filaDosBtnJ1);
        verticalBotonesJ1.addClassName("btnJ1");
        verticalBotonesJ2.add(filaUnoBtnJ2,filaDosBtnJ2);
        verticalBotonesJ2.addClassName("btnJ2");
        horizontalBtn.add(verticalBotonesJ1,verticalBotonesJ2);

        btnAtaqueUnoJ1.addClassName("botones");
        btnAtaqueUnoJ2.addClassName("botones");
        btnAtaqueDosJ1.addClassName("botones");
        btnAtaqueDosJ2.addClassName("botones");

        btnDefensaUnoJ1.addClassName("botones");
        btnDefensaUnoJ2.addClassName("botones");
        btnDefensaDosJ2.addClassName("botones");
        btnDefensaDosJ1.addClassName("botones");


        personajesJ1.add(j1p1img, j1p2img, j1p3img);
        personajesJ2.add(j2p1img, j2p2img, j2p3img);


        Text text = new Text("Loki ha recibido 30 de daño!");
        Div div = new Div();
        div.add(text);
        div.addClassName("div");

        containerJ1.add(verticalVidaEnergiaJ1,personajesJ1);
        containerJ2.add(verticalVidaEnergiaJ2,personajesJ2);
        containerJ2.addClassName("heartImg2");
        base.add(containerJ1, containerJ2);
        add(div,base,horizontalBtn);
        getStyle().set("text-align","center");
        setAlignItems(Alignment.CENTER);

    }



}
