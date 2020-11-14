package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FishingVillage extends Application {
    static int next = 0;
    private StatsPanelController statController;
    @Override
    public void start(Stage primaryStage) {

    }

    //
    // /**
    //  * @param args the command line arguments
    //  */
    public Scene createScene(Stage x, Player hero) {
       // hero.setClass("wizard");
        System.out.println(("Current file: Fort 2"));

        BorderPane root = new BorderPane();

        StackPane Bot_UI = new StackPane();


        //BOTTOM RECTANGLE

        Rectangle Bot_Rec = new Rectangle(AppSettings.screenWidth, AppSettings.bottomUIHeight);
        Bot_Rec.setFill(Color.rgb(211, 211, 211));
        Bot_UI.getChildren().add(Bot_Rec);
        root.setBottom(Bot_UI);
        Bot_Rec.setStroke(Color.BLACK);

        //LEFT RECTANGLE

        StackPane Left_UI = new StackPane();
        Rectangle Left_Rec = new Rectangle(AppSettings.leftUIWidth,
                AppSettings.leftUIHeight, Color.rgb(211, 211, 211));
        //Left_Rec.setStroke(Color.BLACK);
        root.setLeft(Left_UI);

        Pane newLoadedPane = null;
        try {
            URL fxmlUrl = Tavern.class.getResource("./StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
            statController=new StatsPanelController();
            fxmlLoader.setController(statController);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);

        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/TEMPfishingVillage.png", AppSettings.centerUIWidth,
                AppSettings.centerUIWidth, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);


        //Story for talking to guards




        Group encont  = new Group();
        Group WhatDo = new Group();
        Group WHatDotext = new Group();
        Group WhatDobutt = new Group();

        Text Intro = new Text("OI Slag if you wanna wanna  pass yous gotta pay the toll");
        Button go = new Button("Continue");
        go.setOnAction(new EventHandler<ActionEvent>() {

                           @Override
                           public void handle(ActionEvent event) {
                               System.out.println("This Works");
                               WhatDo.setVisible(true);
                               WhatDo.setDisable(false);
                               encont.setVisible(false);
                               encont.setDisable(true);


                           }
                       });

        Text text1 = new Text("1) Attack");
        Text text2 = new Text("2) Pay the toll");
        Text text3 = new Text("3) Negotioate ");
        Text text4 = new Text("4) Run Past him");

        text1.setY(0);
        text2.setY(text1.getY()+20);
        text3.setY(text2.getY()+20);
        text4.setY(text3.getY()+20);
        Bot_UI.setAlignment(WHatDotext, Pos.TOP_CENTER);

        WHatDotext.getChildren().addAll(text1, text2, text3, text4);


        Button butt1 = new Button("1");
        Button butt2 = new Button("2");
        Button butt3 = new Button("3");
        Button butt4 = new Button("4");

        butt1.setLayoutY(text1.getY());
        butt2.setLayoutY(text2.getY());
        butt3.setLayoutY(text3.getY());
        butt4.setLayoutY(text4.getY());
        butt1.setLayoutX(100);
        butt2.setLayoutX(butt1.getLayoutX());
        butt3.setLayoutX(butt1.getLayoutX());
        butt4.setLayoutX(butt1.getLayoutX());
        WhatDobutt.getChildren().addAll(butt1,butt2,butt3,butt4);
        Bot_UI.setAlignment(WhatDobutt,Pos.TOP_RIGHT);


        WhatDo.getChildren().addAll(WHatDotext,WhatDobutt);







        encont.getChildren().addAll(Intro,go);
        Bot_UI.getChildren().addAll(encont,WhatDo);
        WhatDo.setVisible(false);
        WhatDo.setDisable(true);


        Scene S2 = new Scene(root, 750, 500);
        return S2;
    }
}
