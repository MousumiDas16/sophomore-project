/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tommy
 */
public class Tavern extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    ////**
    /// * @param args the command line arguments
    /// */
    public static Scene main(Stage x, Player hero) {
        System.out.println(("Current file: Tavern"));

        BorderPane root = new BorderPane();

        StackPane Bot_UI = new StackPane();


        //BOTTOM RECTANGLE

        Rectangle Bot_Rec = new Rectangle(750, 100);
        Bot_Rec.setFill(Color.rgb(211, 211, 211));
        Bot_UI.getChildren().add(Bot_Rec);
        root.setBottom(Bot_UI);
        Bot_Rec.setStroke(Color.BLACK);

        //LEFT RECTANGLE
        StackPane Left_UI = new StackPane();
        Rectangle Left_Rec = new Rectangle(100, 400, Color.rgb(211, 211, 211));
        Left_Rec.setStroke(Color.BLACK);
        root.setLeft(Left_UI);
        Left_UI.getChildren().add(Left_Rec);




        //TEXT AND BUTTON's
        ComboBox<String> charClass = new ComboBox<>();
        charClass.getItems().addAll("Wizard","Peasant","Knight","Mercenary");
        Button submit = new Button("SET CLASS");
        submit.setOnAction(new EventHandler<ActionEvent>() {

                               @Override
                               public void handle(ActionEvent event) {
                                   hero.setClass(charClass.getValue());
                                   Scene s1 = FirstTown.main(x,hero);// next town pic please
                                   x.setScene(s1);





                               }
                           });


        Bot_UI.getChildren().addAll(submit,charClass);
        Bot_UI.setAlignment(submit,Pos.CENTER_RIGHT);
        submit.setPadding(new Insets(0, 200, 0, 20));











        //Adding the tavern image to the current UI
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Tavern.PNG", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root,750,500);




        return S2;

    }
}
    

