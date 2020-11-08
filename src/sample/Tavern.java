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
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author Tommy
 */
public class Tavern extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    ////**
    /// * @param args the command line arguments
    /// */
    static int next = 0;
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
        Left_UI.setAlignment(Left_Rec, Pos.TOP_LEFT);

        //Player STATS
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


        Player_Stats.getChildren().addAll(
                NameTXT, heroName, ClassTXT, HealthTXT, MoneyTxt, PotionsTXT,
                StrengthTXT, CharismaTXT, ArmorTXT, SpeedTXT);

        Left_UI.getChildren().add(Player_Stats);

        Left_UI.setAlignment(Player_Stats, Pos.TOP_CENTER);
        //enter story here
        ArrayList<String> words = new ArrayList<>();
        words.add("Only the King returned can take the weapon.");
        words.add("Many have tried and many have died in their quest for glory");
        Text Line1 = new Text();
        //positioning text

        Bot_UI.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.BLACK);


        //TEXT AND BUTTON's


        Button submit = new Button("NEXT");
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                next++;
                if(next <= words.size() -1){
                    Line1.setText(words.get(next));
                }else{

                    Scene s1 = CharacterHouseIntro.main(x, hero);
                    x.setScene(s1);
                }



            }

            ;

        });


        Bot_UI.getChildren().addAll(submit);
        Bot_UI.setAlignment(submit,Pos.CENTER_RIGHT);
//        submit.setTranslateX(charClass.getLayoutX() + 100);
        submit.setPadding(new Insets(0, 20, 0, 20));


        //Adding the tavern image to the current UI
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Tavern.png", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, 750, 500);





        return S2;

    }
}
    

