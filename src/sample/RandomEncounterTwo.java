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

public class RandomEncounterTwo extends Application {

    public static Scene main(Stage x, Player hero) {
        System.out.println("current file: RandomEncounterTwo");
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
        Enemy BloodPuddle = new Enemy();
        BloodPuddle.setType("bloodyboi");

        //popup buttons
        Text popup1 = new Text();
        Text popup2 = new Text();
        Text popup3 = new Text();
        Text popup4 = new Text();
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


        //button to use to return to forest
        Button weturn = new Button();
        weturn.setText("Return to forest");
        weturn.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                Scene s1 = null;// next town pic please
                try {
                    s1 = forest.main(x, hero);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x.setScene(s1);


            }


        }  )  ;
        //game buttons

        //fight button setup

        b1.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                Random rand = new Random();
                int enemyAttack = BloodPuddle.getAttack()  - hero.getArmor();
                int PlayerAttack = hero.getStrength()  * rand.nextInt(5);
                if(hero.getSpeed()>BloodPuddle.getSpeed()) {
                    if (hero.getHealth() > 0 && BloodPuddle.getHealth() > 0) {
                        int health = BloodPuddle.getHealth() - PlayerAttack;
                        BloodPuddle.setHealth(health);
                        int health2 = hero.getHealth() - enemyAttack;
                        hero.setHealth(health2);
                        popup1.setText("You did " + PlayerAttack + " damage.");
                        popup2.setText("The BloodPuddle did " + enemyAttack + " damage." );
                        if (BloodPuddle.getHealth() <= 0){
                            popup3.setText("You have killed The BloodPuddle");
                            double gold = hero.getMoney();
                            gold = rand.nextInt(200) + gold;
                            hero.setMoney(gold);
                            popup4.setText("you took" + gold + " from the BloodPuddle.");


                            Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                            Bot_UI.setAlignment(weturn, Pos.BOTTOM_RIGHT);
                            Bot_UI.getChildren().add(weturn);

                        };
                        if (hero.getHealth() <= 0) {
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }


                    }



                }
                else{
                    if (hero.getHealth() > 0 && BloodPuddle.getHealth() >0){
                        int health2 = hero.getHealth() - enemyAttack;
                        hero.setHealth(health2);
                        int health = BloodPuddle.getHealth() - PlayerAttack;
                        BloodPuddle.setHealth(health);
                        popup1.setText("You did " + PlayerAttack + " damage.");
                        popup2.setText("The BloodPuddle did " + enemyAttack + " damage." );
                        if (BloodPuddle.getHealth() <= 0){
                            popup3.setText("You have killed The BloodPuddle");
                            double gold = hero.getMoney();
                            gold = rand.nextInt(200) + gold;
                            hero.setMoney(gold);
                            popup4.setText("you took" + gold + " from the BloodPuddle.");




                            Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                            Bot_UI.setAlignment(weturn, Pos.BOTTOM_RIGHT);
                            Bot_UI.getChildren().add(weturn);
                        }
                        if (hero.getHealth() <= 0) {
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }
                    }




                }








            }


        });
        //Negotiate

        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (hero.getCharisma()>=10 && BloodPuddle.getHealth()>0){
                    popup1.setText("You have talked your way out of a fight");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");

                    Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                    Bot_UI.setAlignment(weturn, Pos.BOTTOM_RIGHT);
                    Bot_UI.getChildren().add(weturn);
                }
                else{
                    if (BloodPuddle.getHealth()> 0){
                        popup1.setText("You angered the BloodPuddle.");
                        int SneakAttack = BloodPuddle.getAttack()  - hero.getArmor();

                        int health2 = hero.getHealth() - SneakAttack;
                        hero.setHealth(health2);
                        popup2.setText("The BloodPuddle smacks you and does " + SneakAttack + " damage.");
                        if (hero.getHealth()<= 0){
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }
                        popup4.setText("");
                    }


                }





            }


        });

        //Run AWAYYYYYYYYYYYYYYYYYY

        b3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if( hero.getSpeed()>BloodPuddle.getSpeed() && BloodPuddle.getHealth()>0){
                    popup1.setText("you were fast enough to out run the BloodPuddle.");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                    Bot_UI.getChildren().removeAll(butt_Group,b1 , b2 ,b3,b4);
                    Bot_UI.setAlignment(weturn, Pos.BOTTOM_RIGHT);
                    Bot_UI.getChildren().add(weturn);
                }
                else{
                    if(BloodPuddle.getHealth()>0){
                        popup1.setText("The monster caught you");
                        int SneakAttack = BloodPuddle.getAttack()  - hero.getArmor();

                        int health2 = hero.getHealth() - SneakAttack;
                        hero.setHealth(health2);
                        popup2.setText("The BloodPuddle smacks you and does " + SneakAttack + " damage.");
                        if (hero.getHealth()<= 0){
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }
                        popup4.setText("");

                    }

                }


            }


        });
        //use potion

        b4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (hero.getPotions()>0 && BloodPuddle.getHealth()>0){
                    popup1.setText("You used a potion and healed 25 health points.");
                    int pot = hero.getPotions() - 1;
                    int phealth = hero.getHealth() + 25;
                    hero.setPotions(pot);
                    hero.setHealth(phealth);
                }
                else{
                    if(BloodPuddle.getHealth()>0){
                        popup1.setText("You Do not have any potions");
                        popup2.setText("you stand there in confusion looking for your potion");
                        int SneakAttack = BloodPuddle.getAttack()  - hero.getArmor();

                        int health2 = hero.getHealth() - SneakAttack;
                        hero.setHealth(health2);
                        popup3.setText("The BloodPuddle smacks you  and does " + SneakAttack + " damage.");
                        if (hero.getHealth()<= 0){
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }

                    }


                }




            };


        });
        //popup button setup



        Group popupgroup = new Group();
        popupgroup.getChildren().addAll(popup1,popup2,popup3,popup4);

        popup1.setY(Text_coorY);
        popup2.setY(Text_coorY + 20);
        popup3.setY(Text_coorY + 40);
        popup4.setY(Text_coorY + 60);
        Bot_UI.setAlignment(popupgroup, Pos.CENTER_LEFT);


        Bot_UI.getChildren().add(popupgroup);




        Left_UI.setAlignment(Player_Stats, Pos.TOP_CENTER);
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Forrest_Walking.png", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, 750, 500);





        return S2;



    }

    @Override
    public void start(Stage primaryStage) {

    }
}
