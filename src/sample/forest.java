package sample;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Duration;

import java.util.Random;

public class forest extends Application {
    @Override
    public void start(Stage primaryStage) {

    }


    public static Scene main(Stage x, Player hero) throws InterruptedException {
        System.out.println("Current file: forest");
        hero.setScene("forest");
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
        Group text_Group = new Group();

        int Text_coorY = 10;

        Text text1 = new Text("1) Attack");
        Text text2 = new Text("2) Negotiate ");
        Text text3 = new Text("3) RUNNNN");
        Text text4 = new Text("4) Use Health Potion");
        text_Group.getChildren().addAll(text1, text2, text3, text4);


        text1.setY(Text_coorY);
        text2.setY(Text_coorY + 20);
        text3.setY(Text_coorY + 40);
        text4.setY(Text_coorY + 60);
        Bot_UI.getChildren().add(text_Group);
        Left_UI.setAlignment(Player_Stats, Pos.TOP_CENTER);
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Forrest_Walking.png", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S1 = new Scene(root, 750, 500);







        Random rand = new Random();
        // loop count from hero

        int loop = hero.getLoopcount();


        while (loop < 3) {







           //int k = rand.nextInt(4);
            int k = 0;


            System.out.println("Random number is" + k);
            switch (k) {
                case 0:
                    loop= loop +1;
                    hero.setLoopcount(loop);
                    System.out.println("loop number is now" + hero.getLoopcount());
                    System.out.println("made it to case 0");
                    Scene s3 = RandomEncounterOne.main(x, hero);
                    x.setScene(s3);
                    return s3;
                case 1:
                    loop= loop +1;
                    hero.setLoopcount(loop);
                    System.out.println("loop number is now" + hero.getLoopcount());
                    System.out.println("made it to case 1");
                    Scene s4 = RandomEncounterTwo.main(x, hero);
                    x.setScene(s4);
                    return s4;
                case 2:
                    loop= loop +1;
                    hero.setLoopcount(loop);
                    System.out.println("loop number is now" + hero.getLoopcount());
                    System.out.println("made it to case 2");
                    Scene s5 = RandomEncounterThree.main(x, hero);
                    x.setScene(s5);
                    return s5;
                case 3:
                    loop= loop +1;
                    hero.setLoopcount(loop);
                    System.out.println("loop number is now" + hero.getLoopcount());
                    break;
            }


        }
        if(hero.getLoopcount()==3){
            text1.setText("you made it to the town!!");
            text2.setText("Press continue to enter!");
            text3.setText("");
            text4.setText("");
            Button cont = new Button();
            cont.setText("continue");
            cont.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {
                    Scene s1 = Fort1.main(x, hero);
                    x.setScene(s1);



                }



            }  )  ;

            Bot_UI.setAlignment(cont, Pos.BOTTOM_RIGHT);
            Bot_UI.getChildren().add(cont);
        }







            hero.setLoopcount(0);
        return S1;

        }











    }



