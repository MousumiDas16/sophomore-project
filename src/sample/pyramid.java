/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.Random;

/**

 */
public class pyramid extends Application {
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
        hero.setScene("pyramid");

        System.out.println(("Current file: pyramid"));

        BorderPane root = new BorderPane();

        StackPane Bot_UI = new StackPane();




        //BOTTOM RECTANGLE

        Rectangle Bot_Rec = new Rectangle(AppSettings.screenWidth, AppSettings.bottomUIHeight);
        Bot_Rec.setFill(Color.rgb(211, 211, 211));
        Bot_UI.getChildren().add(Bot_Rec);
        root.setBottom(Bot_UI);
        Bot_Rec.setStroke(Color.BLACK);

        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Pyramid.PNG", AppSettings.centerUIWidth,
                AppSettings.centerUIHeight, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);

        //LEFT RECTANGLE

        StackPane Left_UI = new StackPane();
        Rectangle Left_Rec = new Rectangle(AppSettings.leftUIWidth, AppSettings.leftUIHeight,
                Color.rgb(211, 211, 211));
        Left_Rec.setStroke(Color.BLACK);
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

        //Character Pictures
        Image sphinx = new Image("sample/Art/Characters/Sphinx.png",450,450,true,true);
        Image wisp = new Image("sample/Art/Characters/Willow_Sprite.gif",150,150,true,true);
        ImageView view = new ImageView(sphinx);

        Center_UI.getChildren().add(view);
        Center_UI.setAlignment(view,Pos.BOTTOM_CENTER);



        //EXPOSITION
        Group talking = new Group();
        Group RiddleAns = new Group();
        RiddleAns.setVisible(false);
        RiddleAns.setDisable(true);
        Group fail = new Group();
        fail.setDisable(true);
        fail.setVisible(false);


        ArrayList<String> words = new ArrayList<>();
        words.add("\"Welcome unexpected visitor… I am known as the Sphinx!\n I had a name other than that long ago!\"");
        words.add("\" but, in my solitude, I have since forgotten it. \nMy head only swarms with riddles and mysteries now\"");
        words.add("\"I have no need for names, so do not bother me with yours\"");
        words.add("\"Great beast can you not see? This is the true Monarch returned again\"");
        words.add("\"Silence creature. I do not care about the bloodline anymore… I live only for games\"");
        words.add("\"I now know why you dared to come here but know I will not let you pass… unless you answer my riddles correctly\"");
        words.add("\"If you do not, I will be done with you and dispose of you as is my purpose \"");
        words.add("\"Riddle 1: “I have six faces yet wear no makeup, I have twenty-one eyes but cannot see.\nWhat am I?” \"");
        words.add("\"Correct \"");
        words.add("\"Riddle 2: “I am not alive, but I grow. I do not have lungs, but I must have air.\nI do not have a mouth, but I can drown. What am I \"");
        words.add("\"Correct! Very good. \"");
        words.add("\"I am one color, but not one size. I am here when it is sunny, but not when it rains. \nI do no harm and feel no pain. I am always on the bottom, but I can fly. What am I? \"");
        words.add("\"Correct. Excellent, HAHAHA! \"");
        words.add("\"Well done… perhaps you are the true Monarch. I  am pleased. As promised the way is clear, congratulations visitor. \"");
        words.add("\" End of String\"");

        Text Line1 = new Text();
        root.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.BLACK);
        Button submit = new Button("NEXT");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                next++;
                if(next <=2 ){
                    Line1.setText(words.get(next));

                }else if (next == 3){
                    Line1.setText(words.get(next));
                    view.setImage(wisp);

                }else if (next > 3 && next <= 7){
                    Line1.setText(words.get(next));
                    view.setImage(sphinx);

                } else if ((next == 8) | (next == 10)|(next ==12) ){
                    RiddleAns.setVisible(true);
                    RiddleAns.setDisable(false);
                    talking.setVisible(false);
                    talking.setDisable(true);

                } else if(next <= words.size() - 2 ){
                    Line1.setText(words.get(next));

                }else{
                    EndingIntro end = new EndingIntro();
                    Scene s1 = end.getScene(x,hero);
                    x.setScene(s1);
                }
            };
        });

        submit.setLayoutY(Line1.getY()+ 20);
        talking.getChildren().addAll(Line1,submit);



        //TEXT AND BUTTON's

        Group text_Group = new Group();
        Group butt_Group = new Group();



        RiddleAns.getChildren().addAll(text_Group,butt_Group);



        int Text_coorY = 10;

        Text text1 = new Text("1) The sun");
        Text text2 = new Text("2) A hydra");
        Text text3 = new Text("3) A die");
        Text text4 = new Text("4) A fly");
        Text failtext = new Text("YOU HAVE INSULSTED ME, MY PURPOSE AND MY ENTIRE WAY OF LIVING. FOR THIS YOU SHALL DIE.");
        text_Group.getChildren().addAll(text1, text2, text3, text4);


        text1.setY(Text_coorY);
        text2.setY(Text_coorY + 20);
        text3.setY(Text_coorY + 40);
        text4.setY(Text_coorY + 60);


        //solo text
        Button b1 = new Button();
        b1.setText("1");
        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(next == 12){
                    talking.setDisable(false);
                    talking.setVisible(true);
                    Line1.setText(words.get(next));
                    RiddleAns.setVisible(false);
                    RiddleAns.setDisable(true);

                }else{
                    fail.setVisible(true);
                    fail.setDisable(false);
                    RiddleAns.setVisible(false);
                    RiddleAns.setDisable((true));

                }


            }


        });
        //
        Button b2 = new Button();
        b2.setText("2");
        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (next == 10) {
                    text1.setText("A shadow");
                    text2.setText("A shirt");
                    text3.setText("A bird");
                    text4.setText("The sun");

                    talking.setDisable(false);
                    talking.setVisible(true);
                    Line1.setText(words.get(next));
                    RiddleAns.setVisible(false);
                    RiddleAns.setDisable(true);

                } else {
                    fail.setVisible(true);
                    fail.setDisable(false);
                    RiddleAns.setVisible(false);
                    RiddleAns.setDisable((true));

                }

            }
        });


        Button b3 = new Button();
        b3.setText("3");
        b3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (next == 8) {

                    text1.setText("A corpse");
                    text2.setText("A fire");
                    text3.setText("A plant");
                    text4.setText("A sword");

                    talking.setDisable(false);
                    talking.setVisible(true);
                    Line1.setText(words.get(next));
                    RiddleAns.setVisible(false);
                    RiddleAns.setDisable(true);

                } else {
                    fail.setVisible(true);
                    fail.setDisable(false);
                    RiddleAns.setVisible(false);
                    RiddleAns.setDisable((true));

                }


                            }
                        });

        Button b4 = new Button();
        b4.setText("4");
        b4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("SENDS PLAYER TO YOU DIED");
                fail.setVisible(true);
                fail.setDisable(false);
                RiddleAns.setVisible(false);
                RiddleAns.setDisable((true));



            }
        });

        Button failbutt = new Button();
        failbutt.setText("Continue");
        failbutt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("SENDS PLAYER TO YOU DIED");
                Scene s3 = YouDiedIdiot.main(x, hero);
                x.setScene(s3);


            }
        });


        b1.setPadding(new Insets(0, 20, 0, 20));
        b2.setPadding(new Insets(0, 20, 0, 20));
        b3.setPadding(new Insets(0, 20, 0, 20));
        b4.setPadding(new Insets(0, 20, 0, 20));
        failbutt.setPadding(new Insets(0, 20, 0, 20));


        butt_Group.getChildren().addAll(b1, b2, b3, b4);
        fail.getChildren().addAll(failbutt,failtext);


        Bot_UI.getChildren().addAll(RiddleAns,talking,fail);
        StackPane.setAlignment(butt_Group, Pos.CENTER_RIGHT);


        b1.setLayoutY(Text_coorY- 10);
        b2.setLayoutY(Text_coorY- 10 + 20);
        b3.setLayoutY(Text_coorY- 10 + 40);
        b4.setLayoutY(Text_coorY- 10 + 60);
        failbutt.setLayoutY(failtext.getY() + 20);

        b1.setLayoutX(text1.getX() + 150);
        b2.setLayoutX(text1.getX() + 150);
        b3.setLayoutX(text1.getX() + 150);
        b4.setLayoutX(text1.getX() + 150);



        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);
        return S2;



}
}
    

        
        
    
    

