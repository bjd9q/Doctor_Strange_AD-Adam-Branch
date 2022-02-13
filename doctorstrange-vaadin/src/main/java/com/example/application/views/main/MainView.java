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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
    Image img1,img2,img3;
    Image img4,img5,img6;
    VerticalLayout v1,v2;
    HorizontalLayout h1;
    HorizontalLayout h2;

    public MainView() {

     addClassName("m");
     instanciar();
     setSizeFull();
     setAlignItems(Alignment.CENTER);
    }

    private void instanciar() {
        v1 = new VerticalLayout();
        v2 = new VerticalLayout();

        h1 = new HorizontalLayout();
        h2 = new HorizontalLayout();

        img1 = new Image("images/logo.png","");
        img2 = new Image("images/logo.png","");
        img3 = new Image("images/logo.png","");



        img4 = new Image("images/coin.png","");
        img5 = new Image("images/coin.png","");
        img6 = new Image("images/coin.png","");

        img1.setWidth("200px");
        img2.setWidth("200px");
        img3.setWidth("200px");
        img4.setWidth("200px");
        img5.setWidth("200px");
        img6.setWidth("200px");

        v1.add(img1,img2,img3);
        v1.setAlignItems(Alignment.CENTER);
        v2.add(img4,img5,img6);
        v2.setAlignItems(Alignment.CENTER);


        h1.add(v1,v2);
        h1.setSizeFull();
        h1.setAlignItems(Alignment.CENTER);

        h1.addClassName("h1");
        add(h1);
    }

}
