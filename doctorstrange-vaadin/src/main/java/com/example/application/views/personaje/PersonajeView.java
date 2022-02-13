package com.example.application.views.personaje;

import com.example.application.utils.*;
import com.example.application.views.menu.MenuView;
import com.example.application.views.partida.PartidaView;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Personaje")
@Route(value = "personaje")
@CssImport("../frontend/themes/doctorstrange/styles.css")
public class PersonajeView extends VerticalLayout implements HasUrlParameter<String> {


    private ArrayList<Superheroe> superheroesSeleccionados, axuHeroesSeleccionados;
    private MongoDB mongoDB;
    private int screenWidth;


    private void instaciarInicializar() {

    }



    @Override
    public void setParameter(BeforeEvent beforeEvent, String s) {

    }
}
