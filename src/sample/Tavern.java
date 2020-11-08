/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Tommy, Mousumi
 */
public class Tavern extends Application implements Initializable {

    @FXML
    private Label lblHeroName;

    @Override
    public void start(Stage primaryStage) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblHeroName.setText("Hello "+ Main.hero.getName());
    }

    ////**
    /// * @param args the command line arguments
    /// */
    static int next = 0;

    public Scene getScene(Stage x, Player hero) {
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
        Rectangle Left_Rec = new Rectangle(120, 400, Color.rgb(211, 211, 211));
        Left_Rec.setStroke(Color.BLACK);
        root.setLeft(Left_UI);
        Left_UI.getChildren().add(Left_Rec);
        Left_UI.setAlignment(Left_Rec, Pos.TOP_LEFT);

        Pane newLoadedPane = null;
        try {
            newLoadedPane = FXMLLoader.load(Tavern.class.getResource("./StatsPane.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);

        //enter story here
        ArrayList<String> words = new ArrayList<>();
        words.add("Only the King returned can take the weapon.");
        words.add("Many have tried and many have died in their quest for glory");
        Text Line1 = new Text();
        //positioning text

        Bot_UI.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.BLACK);
        Line1.setFont( Font.font("Verdana", FontWeight.BOLD, 13));


        //TEXT AND BUTTON's

        Image img = new Image("sample/Art/Background/arrow.png", 80, 80, true, true);
        ImageView nxtView = new ImageView(img);
        nxtView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Next pressed ");
                next++;
                if (next <= words.size() - 1) {
                    Line1.setText(words.get(next));
                } else {
                    Scene s1 = CharacterHouseIntro.main(x, hero);
                    x.setScene(s1);
                }
                event.consume();
            }

        });
        nxtView.setTranslateX(Line1.getX()+280);
        //nxtView.setTranslateY(Line1.getY()+ 160);

        Bot_UI.getChildren().addAll(nxtView);

//        submit.setTranslateX(charClass.getLayoutX() + 100);


        //Adding the tavern image to the current UI
        StackPane Center_UI = new StackPane();
        Image nxtImage = new Image("sample/Art/Background/Tavern.png", 630, 400, true, true);
        ImageView Center_ImageView = new ImageView(nxtImage);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, 750, 500);


        return S2;

    }
}
    

