package sample;

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

import java.util.ArrayList;

public class LeaveFirstTown {
    static int next = 0;

    public void start(Stage primaryStage) {


    }


    public static Scene main(Stage x, Player hero) {
        hero.setClass("wizard");
        System.out.println(("Current file: LeaveFirstTown"));

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

        //
        int y = 0;

        StackPane Root = new StackPane();



        //Jimmy Story
        ArrayList<String> words = new ArrayList<>();
        words.add("Our brave hero is spotted by the hooded woman the next morning as they setting out.");
        words.add("?: \"Wait, You!! Are you venturing to Dragon’s Claw? Really…\"");
        words.add("The woman's robes fall away revealing a tiny ball of spirit beneath.");
        words.add("Lady Wisp: \"I am the Lady Wisp, the remaining soul of the Sage who once guided\"");
        words.add("\"the first King.I thought you had the makings of Monarch returned\"");
        words.add("\"and shared my tale in hopes of this very thing.\"");
        words.add("\"They left the town together...");
        Text Line1 = new Text();
        //positioning text

        Bot_UI.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.BLACK);
        Button submit = new Button("NEXT");
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                next++;
                if(next <= words.size() -1){
                    Line1.setText(words.get(next));
                }else{

                    Scene s1 = WalkingInForest.main(x, hero);// next town pic please
                    x.setScene(s1);
                }
        //need to have sprite transition when the story demands


            }

            ;

        });
        Bot_UI.getChildren().addAll(submit);

        Bot_UI.setAlignment(submit,Pos.CENTER_RIGHT);
        submit.setPadding(new Insets(0, 20, 0, 20));


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
