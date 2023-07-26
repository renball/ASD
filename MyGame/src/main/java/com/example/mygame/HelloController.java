package com.example.mygame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.*;
import javafx.scene.text.Text;

public class HelloController {
    double x,y;
    final int YDOWN=380;
    final int YTOP=20;

    final int WALL=700;
    int target1_speed=5;
    int target2_speed=10;
    int arrow_speed =10;
    boolean arrow_flying = false;

    int scores = 0;

    int way1=1;
    int way2=1;

   // Arrow arrow;

    @FXML
    private Text score;
    @FXML
    private Line shaft;

    @FXML
    private Polygon tip;
    //Arrow arrow =new Arrow(shaft.getLayoutX());
    double arrX=50;


    @FXML
    private Circle target1;
    @FXML
    private Circle target2;

    Thread thread_targerts,thread_arrow ;
    @FXML
    protected void targetsMove() {

    if(thread_targerts!=null) return;
    score.setText("Scores: 0");
        arrow_flying=false;
    thread_targerts = new Thread(
            ()->
            {
                while(true){
                    y=target1.getLayoutY();
                    y+=target1_speed*way1;
                    target1.setLayoutY(y);
                    if(target1.getLayoutY()>YDOWN)
                        way1=-1;
                    else if(target1.getLayoutY()<YTOP)
                        way1=1;


                    y=target2.getLayoutY();
                    y+=target2_speed*way2;
                    target2.setLayoutY(y);
                    if(target2.getLayoutY()>YDOWN)
                        way2=-1;

                    else if(target2.getLayoutY()<YTOP)
                        way2=1;

                    arrow_fly();

                    score.setText("Scores: " + String.valueOf(scores));
                    try {

                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
    );

    thread_targerts.start();

    }

    @FXML
    protected void fireArrow() {
        arrow_flying=true;
//        if(thread_arrow!=null) return;
//
//        thread_arrow = new Thread(
//                ()->
//                {
//
//                    while(arrow_flying){
//                        x=shaft.getLayoutX();
//                        x+=arrow_speed;
//                        shaft.setLayoutX(x);
//                        x=tip.getLayoutX();
//                        x+=arrow_speed;
//                        tip.setLayoutX(x);
//
//                        if (shaft.getLayoutX()>=target1.getLayoutX() && shaft.getLayoutY()>=target1.getLayoutY() && shaft.getLayoutY()<=target1.getLayoutY()+20){
//                            scores++;
//                            shaft.setLayoutX(arrX);
//                            tip.setLayoutX(arrX+10);
//                            arrow_flying=false;
//                            thread_arrow=null;
//                        }
//                        if (shaft.getLayoutX()>=target2.getLayoutX() && shaft.getLayoutY()>=target2.getLayoutY() && shaft.getLayoutY()<=target2.getLayoutY()+10){
//                            scores+=2;
//                            shaft.setLayoutX(arrX);
//                            tip.setLayoutX(arrX+10);
//                            arrow_flying=false;
//                            thread_arrow=null;
//                        }
//                        if(shaft.getLayoutX()>=WALL){
//                            shaft.setLayoutX(arrX);
//                            tip.setLayoutX(arrX+10);
//                            arrow_flying=false;
//                            thread_arrow=null;
//                        }
//
//                        try {
//                            Thread.sleep(20);
//                        } catch (InterruptedException e) {
//
//                        }
//                    }
//                }
//        );
//        thread_arrow.start();
    }

    public void arrow_fly(){

        if (arrow_flying){
                        x=shaft.getLayoutX();
                        x+=arrow_speed;
                        shaft.setLayoutX(x);
                        x=tip.getLayoutX();
                        x+=arrow_speed;
                        tip.setLayoutX(x);

                        if (shaft.getLayoutX()>=target1.getLayoutX() && shaft.getLayoutY()>=target1.getLayoutY() && shaft.getLayoutY()<=target1.getLayoutY()+20){
                            scores++;
                            shaft.setLayoutX(arrX);
                            tip.setLayoutX(arrX+10);
                            arrow_flying=false;

                        }
                        if (shaft.getLayoutX()>=target2.getLayoutX() && shaft.getLayoutY()>=target2.getLayoutY() && shaft.getLayoutY()<=target2.getLayoutY()+10){
                            scores+=2;
                            shaft.setLayoutX(arrX);
                            tip.setLayoutX(arrX+10);
                            arrow_flying=false;

                        }
                        if(shaft.getLayoutX()>=WALL){
                            shaft.setLayoutX(arrX);
                            tip.setLayoutX(arrX+10);
                            arrow_flying=false;

                        }
                    }

    }

    public void checker(){


    }
}