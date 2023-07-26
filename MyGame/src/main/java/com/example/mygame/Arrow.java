package com.example.mygame;

import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class Arrow {
    double x;
    @FXML
    private Line shaft;

    @FXML
    private Polygon tip;

    public Arrow(Line _shaft, Polygon _tip){
        this.shaft = _shaft;
        this.tip = _tip;
    }

    public void move(int arrow_speed){
        x=shaft.getLayoutX();
        x+=arrow_speed;
        shaft.setLayoutX(x);
        x=tip.getLayoutX();
        x+=arrow_speed;
        tip.setLayoutX(x);
    }

}
