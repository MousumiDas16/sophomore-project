/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Tommy
 */
public class FirstTown extends Application {
    static int next = 0;
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //
    // /**
    //  * @param args the command line arguments
    //  */
    public static Scene main(Stage x, Player hero) {
        System.out.println(("Current file: FirstTown"));

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

        //Player STATS ON Side Bar

        Group Player_Stats = new Group();
        Text NameTXT = new Text("Hero's Name");
        Text heroName = new Text(hero.getName());
        Text ClassTXT = new Text("Class: " + hero.getPClass());
        Text HealthTXT = new Text("Health: " + hero.getHealth());
        Text MoneyTxt = new Text("Money: " + hero.getMoney());
        Text PotionsTXT = new Text("Potions: " + hero.getPotions());
        Text StrengthTXT = new Text("Strength: " + hero.getStrength());
        Text CharismaTXT = new Text("Charisma: " + hero.getCharisma());
        Text ArmorTXT = new Text("Armor: " + hero.getArmor());
        Text SpeedTXT = new Text("Speed: " + hero.getSpeed());


        //Adding the Player Image to the Left Rectangle

        ImageView heroProfile = new ImageView(hero.getImage(0));
        heroProfile.setFitWidth(100);
        heroProfile.setFitHeight(100);


        //Formating the Text
        NameTXT.setUnderline(true);
        NameTXT.setY(10);
        heroName.setY(NameTXT.getY() + 15);
        ClassTXT.setY(heroName.getY() + 20);

        HealthTXT.setY(ClassTXT.getY() + 40);
        MoneyTxt.setY(HealthTXT.getY() + 10);
        PotionsTXT.setY(MoneyTxt.getY() + 10);

        StrengthTXT.setY(PotionsTXT.getY() + 40);
        CharismaTXT.setY(StrengthTXT.getY() + 10);
        ArmorTXT.setY(CharismaTXT.getY() + 10);
        SpeedTXT.setY(ArmorTXT.getY() + 10);
        //heroProfile.setY(SpeedTXT.getY() + 40);

        //ADDs the Player Stats to the Scene
        Player_Stats.getChildren().addAll(
                NameTXT, heroName, ClassTXT, HealthTXT, MoneyTxt, PotionsTXT,
                StrengthTXT, CharismaTXT, ArmorTXT, SpeedTXT);

        Left_UI.getChildren().addAll(Player_Stats, heroProfile);

        Left_UI.setAlignment(Player_Stats, Pos.TOP_CENTER);
        Left_UI.setAlignment(heroProfile, Pos.BOTTOM_CENTER);

        //Jimmy's story for taking to townspeople
        ArrayList<String> words = new ArrayList<>();
        words.add("");
        words.add("");
        Text Line1 = new Text();
        root.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.WHEAT);
        Button submit = new Button("NEXT");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                next++;
                if(next <= words.size() -1){
                    Line1.setText(words.get(next));
                }else{

                    Scene s1 = FirstTown.main(x, hero);// next town pic please
                    x.setScene(s1);
                }
            };
        });
        //TEXT AND BUTTON's

        Group text_Group = new Group();

        int Text_coorY = 10;

        Text text1 = new Text("1) Go to the Shop");
        Text text2 = new Text("2)Check Map");
        Text text3 = new Text("3) Converse With Locals");
        Text text4 = new Text("4) Leave Town");
        text_Group.getChildren().addAll(text1, text2, text3, text4);


        text1.setY(Text_coorY);
        text2.setY(Text_coorY + 20);
        text3.setY(Text_coorY + 40);
        text4.setY(Text_coorY + 60);
        Bot_UI.getChildren().add(text_Group);

        //shop button
        Button b1 = new Button();
        b1.setText("1");
        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene s1 = null;
                try {
                    s1 = ShopUI.main(x, hero);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                x.setScene(s1);


            }


        });
        //check map
        Button b2 = new Button();
        b2.setText("2");
        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene s1 = Shop.main(x, hero); //get a map picture pls
                x.setScene(s1);


            }


        });

        Button b3 = new Button();
        b3.setText("3");
        b3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene s1 = WalkingInForest.main(x, hero); //talk to a random person pic please
                x.setScene(s1);


            }


        });
        //leave town
        Button b4 = new Button();
        b4.setText("4");
        b4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene s1 = LeaveFirstTown.main(x, hero);// next town pic please
                x.setScene(s1);


            }


        });

        b1.setPadding(new Insets(0, 20, 0, 20));
        b2.setPadding(new Insets(0, 20, 0, 20));
        b3.setPadding(new Insets(0, 20, 0, 20));
        b4.setPadding(new Insets(0, 20, 0, 20));

        Group butt_Group = new Group();
        butt_Group.getChildren().addAll(b1, b2, b3, b4);


        Bot_UI.getChildren().add(butt_Group);
        StackPane.setAlignment(butt_Group, Pos.CENTER_RIGHT);


        b1.setLayoutY(Text_coorY);
        b2.setLayoutY(Text_coorY + 20);
        b3.setLayoutY(Text_coorY + 40);
        b4.setLayoutY(Text_coorY + 60);

        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Donkey_Town.PNG", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, 750, 500);
        return S2;



}
}
    

        
        
    
    

