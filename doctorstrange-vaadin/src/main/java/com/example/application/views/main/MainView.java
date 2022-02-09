package com.example.application.views.main;

import com.example.application.views.menu.MenuView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import scala.Array;

import java.util.ArrayList;

@PWA(name = "DoctorStrange", shortName = "DoctorStrange", enableInstallPrompt = false)
@Theme(themeFolder = "doctorstrange", variant = Lumo.DARK)
@PageTitle("Main")
@Route(value = "main")
@RouteAlias(value = "")
@CssImport("../frontend/themes/doctorstrange/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {

        addClassName("main");

        // Cambio de view al pulsar botón iniciar
        RouterLink menuLink = new RouterLink("Menu", MenuView.class);
        menuLink.addClassName("btnIniciar");
        add(menuLink);
        setSizeFull();
        setAlignItems(FlexComponent.Alignment.CENTER);


    }
}
