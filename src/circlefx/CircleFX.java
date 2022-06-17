/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlefx;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author asli
 */
public class CircleFX extends Application {
    int row, column = 0;
    int x = 35, y = 25, r = 20;
    
  
    @Override
    public void start(Stage primaryStage) {
        
        BorderPane border = new BorderPane();
        HBox hb = new HBox(10);
        hb.setPadding(new Insets(20, 20, 10, 50));
        Spinner<Integer> rows = new Spinner<>(0, 5, 0);
        Spinner<Integer> columns = new Spinner<>(0, 5, 0);
        Spinner<Integer> x_scale = new Spinner<>(0, 10, 0);
        Spinner<Integer> y_scale = new Spinner<>(0, 10, 0);
        
        BorderPane root = new BorderPane();
        rows.setPrefWidth(50);
        columns.setPrefWidth(50);
        x_scale.setPrefWidth(50);
        y_scale.setPrefWidth(50);
        Label lbl1 = new Label("Rows", rows);
        lbl1.setContentDisplay(ContentDisplay.BOTTOM);
        Label lbl2 = new Label("Columns", columns);
        lbl2.setContentDisplay(ContentDisplay.BOTTOM);
        Slider slider = new Slider(0, 100, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        Label lbl3 = new Label("Cell Size", slider);
        lbl3.setContentDisplay(ContentDisplay.BOTTOM);
        Label lbl4 = new Label("X Scale", x_scale);
        lbl4.setContentDisplay(ContentDisplay.BOTTOM);
        Label lbl5 = new Label("Y Scale", y_scale);
        lbl5.setContentDisplay(ContentDisplay.BOTTOM);
        hb.getChildren().addAll(lbl1, lbl2, lbl3, lbl4, lbl5);
        ArrayList<Circle> Circles = new ArrayList<>();
        
        rows.valueProperty().addListener(ov -> {
            
            border.getChildren().clear();
            row = rows.getValue();
            column = columns.getValue();
            Circles.clear();
            y = 25;
            for(int i = 0; i<row; i++) {
                for (int j=0; j<column; j++) {
                    float red =(float)(Math.random());
                    float green =(float)(Math.random());
                    float blue =(float)(Math.random());
                    r = (int)(slider.getValue());
                    Circle circle = new Circle(x, y, r, Color.color(red, green, blue));
                    x += 50;
                    border.getChildren().add(circle);
                    Circles.add(circle);
                }
                    y += 50;
                    x = 35;
            }
            
        
        });
       
        columns.valueProperty().addListener(ov -> {
            border.getChildren().clear();
            row = rows.getValue();
            column = columns.getValue();
            Circles.clear();
            y = 25;
            for(int i = 0; i<row; i++) {
                for (int j=0; j<column; j++) {
                    float red =(float)(Math.random());
                    float green =(float)(Math.random());
                    float blue =(float)(Math.random());
                    r = (int)(slider.getValue());
                    Circle circle = new Circle(x, y, r, Color.color(red, green, blue));
                    x += 50;
                    border.getChildren().add(circle);
                    Circles.add(circle);
                    
                    
                }
                    y += 50;
                    x = 35;
            }
        });
        
        slider.valueProperty().addListener( ov -> {
            double radius = slider.getValue();
            for (Circle i: Circles) {
                i.setRadius(radius);
            }
        });
        
        x_scale.valueProperty().addListener( ov -> {
            double scaleX = x_scale.getValue() + 1;
            for (Circle i: Circles) {
                i.setScaleX(scaleX);
            }
        });
        
         y_scale.valueProperty().addListener( ov -> {
            double scaleY = y_scale.getValue() + 1;
            for (Circle i: Circles) {
                i.setScaleY(scaleY);
            }
        });
        
        
        
        Scene scene = new Scene(root, 500, 500);
        root.setBottom(hb);
        root.setTop(border);
        primaryStage.setTitle("Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
