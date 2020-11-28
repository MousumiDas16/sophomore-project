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

public class Cave1 extends Application {
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
       hero.setScene("Cave1");
        System.out.println(("Current file: Cave1"));

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
        Image img = new Image("sample/Art/Background/TEMPbackgroud.png", 650, 400, true, true);
        Image img2 = new Image("sample/Art/Characters/Ogre.gif", 300, 300, true, true);
        ImageView Center_ImageView = new ImageView(img);
        ImageView Character = new ImageView(img2);
        Center_UI.getChildren().addAll(Center_ImageView,Character);
        Center_UI.setAlignment(Character, Pos.BOTTOM_CENTER);
        root.setCenter(Center_UI);



        //Story for talking to guards





        Group WhatDo = new Group();
        Group WHatDotext = new Group();
        Group WhatDobutt = new Group();



        Text text1 = new Text("1) Fight Him");
        Text text2 = new Text("2) Negotiate ");
        Text text3 = new Text("3) Run Past him ");


        text1.setY(0);
        text2.setY(text1.getY()+20);
        text3.setY(text2.getY()+20);

        Bot_UI.setAlignment(WHatDotext, Pos.TOP_CENTER);

        WHatDotext.getChildren().addAll(text1, text2, text3 );


        Button butt1 = new Button("1");
        Button butt2 = new Button("2");
        Button butt3 = new Button("3");

        butt1.setLayoutY(text1.getY()- 10);
        butt2.setLayoutY(text2.getY()- 10);
        butt3.setLayoutY(text3.getY()- 10);
        butt1.setLayoutX(100);

        butt2.setLayoutX(butt1.getLayoutX());
        butt3.setLayoutX(butt1.getLayoutX());

        butt1.setPadding(new Insets(0,20,0,20));

        butt2.setPadding(new Insets(0,20,0,20));
        butt3.setPadding(new Insets(0,20,0,20));

        WhatDobutt.getChildren().addAll(butt1,butt2,butt3);
        Bot_UI.setAlignment(WhatDobutt,Pos.TOP_RIGHT);


        WhatDo.getChildren().addAll(WHatDotext,WhatDobutt);


        //attack
        butt1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                RandomEncounter RE = new RandomEncounter();
                try {
                    Scene s1 = RE.createScene(x,hero,1);
                    x.setScene(s1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
        });



        //Negotioate
        butt2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if((hero.getCharisma() > 10)){
                    Text fight = new Text("Oh, ye make a good bargainses. Wes leaves");
                    Button butt = new Button("Continue");
                    butt.setPadding(new Insets(0,20,0,20));
                    Group temp = new Group();
                    temp.getChildren().addAll(fight,butt);
                    Bot_UI.getChildren().addAll(temp);
                    fight.setY(0);
                    butt.setLayoutY(fight.getY() +15);

                    butt.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            toFort2 RE = new toFort2();
                            Scene s1 = RE.createScene(x,hero);
                            x.setScene(s1);


                        }
                    });



                    WHatDotext.setDisable(true);
                    WHatDotext.setVisible(false);
                    WhatDobutt.setVisible(false);
                    WhatDobutt.setDisable(true);

                }else{
                    Text fight = new Text("Alls you had to do was sod off. Now yous gonna pay for wastin' my time!!");
                    Button butt = new Button("Fight");
                    butt.setPadding(new Insets(0,20,0,20));
                    Group temp = new Group();
                    temp.getChildren().addAll(fight,butt);
                    Bot_UI.getChildren().addAll(temp);
                    fight.setY(0);
                    butt.setLayoutY(fight.getY() +15);

                    butt.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            RandomEncounter RE = new RandomEncounter();
                            try {
                                Scene s1 = RE.createScene(x,hero,1);
                                x.setScene(s1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }



                        }
                    });



                    WHatDotext.setDisable(true);
                    WHatDotext.setVisible(false);
                    WhatDobutt.setVisible(false);
                    WhatDobutt.setDisable(true);




                }



            }
        });

        //run past them
        butt3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if ((hero.getSpeed() > 8)) {

                    Text fight = new Text("You run past the cave troll");
                    Button butt = new Button("Continue");
                    butt.setPadding(new Insets(0,20,0,20));
                    Group temp = new Group();
                    temp.getChildren().addAll(fight,butt);
                    Bot_UI.getChildren().addAll(temp);
                    fight.setY(0);
                    butt.setLayoutY(fight.getY() +15);

                    butt.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            toFort2 RE = new toFort2();
                            Scene s1 = RE.createScene(x,hero);
                            x.setScene(s1);


                        }
                    });



                    WHatDotext.setDisable(true);
                    WHatDotext.setVisible(false);
                    WhatDobutt.setVisible(false);
                    WhatDobutt.setDisable(true);




                } else {
                    Text fight = new Text("And Where do you think your going squirt.");
                    Button butt = new Button("Fight");
                    butt.setPadding(new Insets(0, 20, 0, 20));
                    Group temp = new Group();
                    temp.getChildren().addAll(fight, butt);
                    Bot_UI.getChildren().addAll(temp);
                    fight.setY(0);
                    butt.setLayoutY(fight.getY() + 15);

                    butt.setOnAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {

                            RandomEncounter RE = new RandomEncounter();
                            try {
                                Scene s1 = RE.createScene(x, hero, 1);
                                x.setScene(s1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        }
                    });


                    WHatDotext.setDisable(true);
                    WHatDotext.setVisible(false);
                    WhatDobutt.setVisible(false);
                    WhatDobutt.setDisable(true);


                }








            }
        });




        Bot_UI.getChildren().addAll(WhatDo);
        //WhatDo.setVisible(false);
        //WhatDo.setDisable(true);


        Scene S2 = new Scene(root, 750, 500);
        return S2;
    }
}
