package com.example.application.views.menu;

import com.example.application.views.escenario.EscenarioView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;

import java.util.Arrays;

@PageTitle("Menu")
@Route(value = "menu")
public class MenuView extends VerticalLayout {

    public MenuView() {

        addClassName("menu");
        RouterLink iniciarLink = new RouterLink("Iniciar", EscenarioView.class);
        RouterLink opcionesLink = new RouterLink("Opciones", MenuView.class);
        RouterLink salirLink = new RouterLink("Salir", MenuView.class);

        iniciarLink.addClassName("btnMenu1");
        opcionesLink.addClassName("btnMenu2");
        salirLink.addClassName("btnMenu3");

        add(iniciarLink,opcionesLink,salirLink);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");


        }




}
