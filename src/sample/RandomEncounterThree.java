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

import java.util.Random;

public class RandomEncounterThree extends Application {

    public static Scene main(Stage x, Player hero) {
        System.out.println(("Current file: EncounterOne"));
        hero.setClass("wizard");

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

        //Attack setup

        Random rand = new Random();
        Enemy kobold = new Enemy();
        kobold.setType("kobold");
        //pop up creation

        Text popup1 = new Text();
        Text popup2 = new Text();
        Text popup3 = new Text();
        Text popup4 = new Text();

        Group popupgroup = new Group();
        popupgroup.getChildren().addAll(popup1,popup2,popup3,popup4);

        popup1.setY(Text_coorY);
        popup2.setY(Text_coorY + 20);
        popup3.setY(Text_coorY + 40);
        popup4.setY(Text_coorY + 60);
        Bot_UI.setAlignment(popupgroup, Pos.CENTER_LEFT);


        Bot_UI.getChildren().add(popupgroup);
        //button creation
        Button b1 = new Button();
        b1.setText("1");
        Button b2 = new Button();
        b2.setText("2");
        Button b3 = new Button();
        b3.setText("3");
        Button b4 = new Button();
        b4.setText("4");
        //button setup

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

        //buttons for before returning to the forest
        Button weturn = new Button();
        weturn.setText("3");
        weturn.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                if(hero.getScene().equals("forest")){
                    Scene s1 = WalkingInForest.main(x, hero);
                    x.setScene(s1);

                }

                else{
                    //for later use of other towns/paths
                }

            }


        }  )  ;
        Button heal = new Button();
        heal.setText("1");
        heal.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                if (hero.getPotions()>0){
                    int pot = hero.getPotions() - 1;
                    hero.setPotions(pot);
                    if ((hero.getHealth()>75)){
                        int healthboost = 100 - hero.getHealth() ;
                        int addhealth = hero.getHealth()+healthboost;
                        hero.setHealth(addhealth);
                        HealthTXT.setText("Health:"+hero.getHealth());
                        popup1.setText("You used a potion and healed " + healthboost +" health points.");

                    }
                    else{
                        int addhealth = hero.getHealth() + 25;
                        hero.setHealth(addhealth);
                        HealthTXT.setText("Health:"+hero.getHealth());
                        popup1.setText("You used a potion and healed 25 health points.");
                        popup2.setText("");
                        popup3.setText("");
                        popup4.setText("");

                    }

                }



                else{
                    popup1.setText("You do not have any potions. ");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");


                }


            }



        }  )  ;
        Button Map = new Button();
        Map.setText("2");

        //secondary button groups
        weturn.setPadding(new Insets(0, 20, 0, 20));
        heal.setPadding(new Insets(0, 20, 0, 20));
        Map.setPadding(new Insets(0, 20, 0, 20));
        Group secondbuttons = new Group();
        secondbuttons.getChildren().addAll(heal,Map,weturn);
        heal.setLayoutY(Text_coorY);
        Map.setLayoutY(Text_coorY + 20);
        weturn.setLayoutY(Text_coorY + 40);






        //game buttons

        //fight button setup

        b1.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                Random rand = new Random();
                int enemyAttack = kobold.getAttack()  - hero.getArmor();
                int PlayerAttack = hero.getStrength()  * rand.nextInt(5);

                if(hero.getSpeed()>kobold.getSpeed()) {
                    if (hero.getHealth() > 0 && kobold.getHealth() > 0) {
                        int health = kobold.getHealth() - PlayerAttack;
                        kobold.setHealth(health);
                        int health2 = hero.getHealth() - enemyAttack;
                        hero.setHealth(health2);
                        popup1.setText("You did " + PlayerAttack + " damage.");
                        popup2.setText("The kobold did " + enemyAttack + " damage." );
                        HealthTXT.setText("Health:"+hero.getHealth());

                        if (kobold.getHealth() <= 0){
                            popup3.setText("You have killed The kobold");
                            double gold = hero.getMoney();
                            int earned = rand.nextInt(200) ;
                            gold = earned + gold;
                            hero.setMoney(gold);
                            popup4.setText("you took" + earned + " from the kobold.");
                            MoneyTxt.setText(""+ hero.getMoney());

                            Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                            text1.setText("Would you like to heal before traveling?");
                            text2.setText("would you like to look at the map?");
                            text3.setText("Would you like to continue traveling?");
                            text4.setText("");
                            Bot_UI.setAlignment(secondbuttons, Pos.BOTTOM_RIGHT);

                            Bot_UI.getChildren().add(secondbuttons);



                        };
                        if (hero.getHealth() <= 0) {
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }


                    }



                }
                else{
                    if (hero.getHealth() > 0 && kobold.getHealth() >0){
                        if (enemyAttack>0 && PlayerAttack>0){
                            popup1.setText("The kobold did " + enemyAttack + " damage." );
                            int health2 = hero.getHealth() - enemyAttack;
                            hero.setHealth(health2);
                            HealthTXT.setText("Health:"+hero.getHealth());
                            if (hero.getHealth()>0){
                                int health = kobold.getHealth() - PlayerAttack;
                                kobold.setHealth(0);
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                if (kobold.getHealth() <= 0){
                                    popup3.setText("You have killed The v");
                                    double gold = hero.getMoney();
                                    int earned = rand.nextInt(200) ;
                                    gold = earned + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took" + earned + " from the kobold.");
                                    MoneyTxt.setText("Money:"+ hero.getMoney());



                                    Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                                    text1.setText("Would you like to heal before traveling?");
                                    text2.setText("would you like to look at the map?");
                                    text3.setText("Would you like to continue traveling?");
                                    text4.setText("");

                                    Bot_UI.setAlignment(secondbuttons, Pos.BOTTOM_RIGHT);
                                    Bot_UI.getChildren().add(secondbuttons);
                                }

                            }
                            if (hero.getHealth()<=0){

                                Scene s3 = YouDiedIdiot.main(x, hero);
                                x.setScene(s3);

                            }

                        }
                        else if (enemyAttack==0){
                            popup1.setText("The kobold attempts to strike you but misses");
                            if(PlayerAttack> 0){
                                int health = kobold.getHealth() - PlayerAttack;
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                kobold.setHealth(health);
                                if (kobold.getHealth() <= 0){
                                    popup3.setText("You have killed The kobold");
                                    double gold = hero.getMoney();
                                    gold = rand.nextInt(200) + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took" + gold + " from the kobold.");



                                    Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                                    text1.setText("Would you like to heal before traveling?");
                                    text2.setText("would you like to look at the map?");
                                    text3.setText("Would you like to continue traveling?");
                                    text4.setText("");
                                    Bot_UI.setAlignment(secondbuttons, Pos.BOTTOM_RIGHT);
                                    Bot_UI.getChildren().add(secondbuttons);
                                }
                            }
                            else{
                                popup2.setText("You attempted to hit the kobold but missed");
                            }


                        }
                        else{
                            popup1.setText("Your armour defended you from the kobold strike");
                            if(PlayerAttack> 0){
                                int health = kobold.getHealth() - PlayerAttack;
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                kobold.setHealth(health);
                                if (kobold.getHealth() <= 0){
                                    popup3.setText("You have killed The kobold");
                                    double gold = hero.getMoney();
                                    gold = rand.nextInt(200) + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took" + gold + " from the kobold.");
                                    MoneyTxt.setText(""+hero.getMoney());


                                    Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                                    text1.setText("Would you like to heal before traveling?");
                                    text2.setText("would you like to look at the map?");
                                    text3.setText("Would you like to continue traveling?");
                                    text4.setText("");
                                    Bot_UI.setAlignment(secondbuttons, Pos.BOTTOM_RIGHT);
                                    Bot_UI.getChildren().add(secondbuttons);

                                }
                            }
                            else{
                                popup2.setText("you attack and missed");
                            }

                        }
                    }

                }





            }


        });
        //Negotiate button event

        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (hero.getCharisma()>=10 && kobold.getHealth()>0){
                    popup1.setText("You have talked your way out of a fight");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                    Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                    text1.setText("Would you like to heal before traveling?");
                    text2.setText("would you like to look at the map?");
                    text3.setText("Would you like to continue traveling?");
                    text4.setText("");
                    Bot_UI.setAlignment(secondbuttons, Pos.BOTTOM_RIGHT);
                    Bot_UI.getChildren().add(secondbuttons);
                }
                else{
                    if (kobold.getHealth()> 0){
                        popup1.setText("You angered the kobold.");
                        int SneakAttack = kobold.getAttack()  - hero.getArmor();

                        int health2 = hero.getHealth() - SneakAttack;
                        hero.setHealth(health2);
                        if (SneakAttack>0){
                            popup2.setText("The kobold smacks you and does " + SneakAttack + " damage.");
                            HealthTXT.setText("Health:"+hero.getHealth());
                            if (hero.getHealth()<= 0){
                                Scene s3 = YouDiedIdiot.main(x, hero);
                                x.setScene(s3);
                            }
                            popup3.setText("");
                            popup4.setText("");

                        }
                        else if(SneakAttack ==0){
                            popup2.setText("The kobold attempts to smack you");
                            popup3.setText("He Misses!");
                            popup4.setText("");
                        }
                        else{
                            popup2.setText("The kobold attempts to smack you");
                            popup3.setText("Your armour protects you!");
                            popup4.setText("");
                        }
                    }

                }

            }

        });

        //Run AWAYYYYYYYYYYYYYYYYYY button event

        b3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if( hero.getSpeed()>kobold.getSpeed() && kobold.getHealth()>0){
                    popup1.setText("you were fast enough to out run the kobold.");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                    Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                    text1.setText("Would you like to heal before traveling?");
                    text2.setText("would you like to look at the map?");
                    text3.setText("Would you like to continue traveling?");
                    text4.setText("");
                    Bot_UI.setAlignment(secondbuttons, Pos.BOTTOM_RIGHT);
                    Bot_UI.getChildren().add(secondbuttons);
                }
                else{
                    if(kobold.getHealth()>0){
                        popup1.setText("The kobold caught you");
                        int SneakAttack = kobold.getAttack()  - hero.getArmor();
                        if (SneakAttack>0){
                            int health2 = hero.getHealth() - SneakAttack;
                            hero.setHealth(health2);
                            popup2.setText("The kobold smacks you and does " + SneakAttack + " damage.");
                            popup3.setText("");
                            popup4.setText("");
                        }
                        else if(SneakAttack== 0) {
                            popup2.setText("The kobold tried to smack you but misses.");
                            popup3.setText("");
                            popup4.setText("");
                        }
                        else{
                            popup2.setText("He attempts to hit you.");
                            popup3.setText("Your armour blocked the attack.");
                            popup4.setText("");

                        }

                        HealthTXT.setText("Health:"+hero.getHealth());
                        if (hero.getHealth()<= 0){
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);;
                        }



                    }

                }


            }


        });
        //use potion action handler

        b4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (hero.getPotions()>0 && kobold.getHealth()>0){
                    int pot = hero.getPotions() - 1;
                    hero.setPotions(pot);
                    if ((hero.getHealth()>75)){
                        int healthboost = 100 - hero.getHealth() ;
                        int addhealth = hero.getHealth()+healthboost;
                        hero.setHealth(addhealth);
                        HealthTXT.setText("Health:"+hero.getHealth());
                        popup1.setText("You used a potion and healed " + healthboost +" health points.");

                    }
                    else{
                        int addhealth = hero.getHealth() + 25;
                        hero.setHealth(addhealth);
                        HealthTXT.setText("Health:"+hero.getHealth());
                        popup1.setText("You used a potion and healed 25 health points.");

                    }

                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                }
                else{
                    if(kobold.getHealth()>0){
                        popup1.setText("You Do not have any potions");
                        popup2.setText("you stand there in confusion looking for your potion");
                        int SneakAttack = kobold.getAttack()  - hero.getArmor();

                        if (SneakAttack>0){
                            int health2 = hero.getHealth() - SneakAttack;
                            hero.setHealth(health2);
                            popup3.setText("The kobold smacks you and does " + SneakAttack + " damage.");
                        }
                        else if(SneakAttack== 0) {
                            popup3.setText("The kobold tried to smack you but misses.");
                        }
                        else{
                            popup3.setText("Your armour defended you from the kobold's attack.");

                        }
                        HealthTXT.setText("Health:"+hero.getHealth());
                        if (hero.getHealth()<= 0){
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }


                    }


                }

            };
        });
        //popup button setup


        Left_UI.setAlignment(Player_Stats, Pos.TOP_CENTER);
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Forrest_Walking.png", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, 750, 500);


        Map.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Image img1 = new Image("sample/Art/Background/Death_Screen.png", 650, 400, true, true);
                ImageView Center_ImageView1 = new ImageView(img1);
                Center_UI.getChildren().removeAll((Center_ImageView));
                Center_UI.getChildren().add(Center_ImageView1);
                root.setCenter(Center_UI);

                Bot_UI.getChildren().removeAll(secondbuttons,Map , heal ,weturn);
                Button GoBack = new Button();
                GoBack.setText("Go Back");
                Bot_UI.getChildren().add(GoBack);
                GoBack.setPadding(new Insets(0, 20, 0, 20));
                Bot_UI.setAlignment(GoBack, Pos.BOTTOM_RIGHT);
                popup1.setText("");
                popup2.setText("");
                popup3.setText("");
                popup4.setText("");
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                GoBack.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Bot_UI.getChildren().remove(GoBack);
                        Bot_UI.setAlignment(secondbuttons, Pos.BOTTOM_RIGHT);

                        Bot_UI.getChildren().add(secondbuttons);
                        Image img1 = new Image("sample/Art/Background/Forrest_Walking.png", 650, 400, true, true);
                        ImageView Center_ImageView1 = new ImageView(img1);
                        Center_UI.getChildren().removeAll((Center_ImageView));
                        Center_UI.getChildren().add(Center_ImageView1);
                        root.setCenter(Center_UI);
                        text1.setText("Would you like to heal before traveling?");
                        text2.setText("would you like to look at the map?");
                        text3.setText("Would you like to continue traveling?");
                        text4.setText("");


                    }

                }  )  ;


            }

        }  )  ;

        return S2;

    }

    @Override
    public void start(Stage primaryStage) {

    }
}
