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
import java.util.Random;

public class RandomEncounter extends Application {
    private  StatsPanelController statController;

    public Scene createScene(Stage x, Player hero, int a) throws InterruptedException {
        System.out.println("Current File: Random Encounter");
        Image background = null;
        Image enemypic = null;
        Random rand = new Random();
        Enemy enemy = new Enemy();
        int k;

        switch (a) {
            case 0://FishingVillage Fight
                background = new Image("sample/Art/Background/TEMPfishingVillage.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemy.setType("fish monster");
                enemypic = new Image("sample/Art/Characters/Project_gifs/Arlong.gif",200,100,true,true);
                break;
            case 1://Cave 1
                background = new Image("sample/Art/Background/TEMPbackgroud.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);

                enemy.setType("troll");
                enemypic = new Image("sample/Art/Characters/TEMPtroll.png",200,100,true,true);

                break;



            case 2:
                //old ruins

                background = new Image("sample/Art/Background/Forrest_Walking.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemypic = new Image("sample/Art/Characters/Kobalt_Gif2.gif", 200, 100, true, true);
                enemy.setType("bandit");
                break;
            case 3:
                //abandonded camp
                background = new Image("sample/Art/Background/Forrest_Walking.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemy.setType("wendigo");
                enemypic = new Image("sample/Art/Characters/Wendigo.png", 200, 100, true, true);
                break;
            case 4://Fitst
                if (hero.getScene().equalsIgnoreCase("firsttown")) {
                    background = new Image("sample/Art/Background/Donkey_Town.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);

                } else if (hero.getScene().equalsIgnoreCase("fort1")) {
                    background = new Image("sample/Art/Background/tempFort1.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);

                }
                k = rand.nextInt(3);


                System.out.println("Random number is" + k);
                switch (k) {
                    case 0:
                        enemy.setType("goblin");
                        enemypic = new Image("sample/Art/Characters/Goblin_gif.gif", 200, 100, true, true);

                        System.out.println("enemy goblin");
                        break;


                    case 1:
                        enemy.setType("kobold");
                        enemypic = new Image("sample/Art/Characters/Kobalt_Gif2.gif", 200, 100, true, true);
                        System.out.println("enemy kobold");
                        break;

                    case 2:
                        enemy.setType("bloodpuddle");
                        enemypic = new Image("sample/Art/Characters/Kobalt_Gif2.gif", 200, 100, true, true);
                        break;

                    default:
                        System.out.println("something went wrong in encounter case 4");
                        break;
                }

                break;
            case 5:
                if (hero.getScene().equalsIgnoreCase("forest")) {
                    background = new Image("sample/Art/Background/Forrest.png", AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);

                }


                k = rand.nextInt(4);


                System.out.println("Random number is" + k);
                switch (k) {
                    case 0:
                        enemy.setType("goblin");
                        enemypic = new Image("sample/Art/Characters/Goblin_gif.gif", 200, 100, true, true);
                        System.out.println("enemy goblin");
                        break;


                    case 1:
                        enemy.setType("kobold");
                        enemypic = new Image("sample/Art/Characters/Kobalt_Gif2.gif", 200, 100, true, true);
                        System.out.println("enemy kobold");
                        break;

                    case 2:
                        enemy.setType("bloodpuddle");
                        enemypic = new Image("sample/Art/Characters/Kobalt_Gif2.gif", 200, 100, true, true);
                        break;

                    case 3:
                        WalkingInForest forest=new WalkingInForest();
                        Scene s1 = forest.createScene(x, hero);
                        x.setScene(s1);
                        break;
                }


                break;
            default:
                background = new Image("sample/Art/Background/Forrest_Walking.png", AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);
                break;
        }
        System.out.println("made it here");

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
        Rectangle Left_Rec = new Rectangle(100, 400, Color.rgb(211, 211, 211));
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


        //pop up creation

        Text popup1 = new Text();
        Text popup2 = new Text();
        Text popup3 = new Text();
        Text popup4 = new Text();

        Group popupgroup = new Group();
        popupgroup.getChildren().addAll(popup1, popup2, popup3, popup4);

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


        b1.setLayoutY(text1.getY());
        b2.setLayoutY(text2.getY());
        b3.setLayoutY(text3.getY());
        b4.setLayoutY(text4.getY());

        //buttons for before returning to the forest
        Button weturn = new Button();
        weturn.setText("3");
        weturn.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                if (hero.getScene().equals("forest")) {
                    WalkingInForest forest=new WalkingInForest();
                    Scene s1 = forest.createScene(x, hero);
                    x.setScene(s1);

                } else if (hero.getScene().equalsIgnoreCase("firsttown")) {
                    FirstTown mytown=new FirstTown();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                } else if (hero.getScene().equalsIgnoreCase("fort1")) {
                    Fort1 firstFort=new Fort1();
                    Scene s1 = firstFort.createScene(x, hero);
                    x.setScene(s1);

                }else if (hero.getScene().equalsIgnoreCase("fishingvillage")) {
                    toVillage2 v2 = new toVillage2();
                    Scene s1 = v2.createScene(x, hero);
                    x.setScene(s1);
                }else if (hero.getScene().equalsIgnoreCase("Cave1")) {
                    toFort2 v2 = new toFort2();
                    Scene s1 = v2.createScene(x, hero);
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("OldRuins")){
                    toVillage5 encounter = new toVillage5();
                    Scene s1 = encounter.createScene(x, hero); //talk to a random person pic please
                    x.setScene(s1);
                }
                else if(hero.getScene().equalsIgnoreCase("AbandondedCamp")){
                    toVillage4 encounter = new toVillage4();
                    Scene s1 = encounter.createScene(x, hero); //talk to a random person pic please
                    x.setScene(s1);
                }

                else {

                    //for later use of other towns/paths
                }

            }


        });
        Button heal = new Button();
        heal.setText("1");
        heal.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                if (hero.getPotions() > 0) {
                    int pot = hero.getPotions() - 1;
                    hero.setPotions(pot);
                    if ((hero.getHealth() > 75)) {
                        int healthboost = 100 - hero.getHealth();
                        int addhealth = hero.getHealth() + healthboost;
                        statController.updateStats();

                    } else {
                        int addhealth = hero.getHealth() + 25;
                        hero.setHealth(addhealth);
                        statController.updateStats();
                        popup1.setText("You used a potion and healed 25 health points.");
                        popup2.setText("");
                        popup3.setText("");
                        popup4.setText("");

                    }

                } else {
                    popup1.setText("You do not have any potions. ");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");


                }


            }


        });
        Button Map = new Button();
        Map.setText("2");

        //secondary button groups
        weturn.setPadding(new Insets(0, 20, 0, 20));
        heal.setPadding(new Insets(0, 20, 0, 20));
        Map.setPadding(new Insets(0, 20, 0, 20));
        Group secondbuttons = new Group();

        heal.setLayoutY(text1.getY());
        Map.setLayoutY(text2.getY());
        weturn.setLayoutY(text3.getY());
        secondbuttons.getChildren().addAll(heal, Map, weturn);
        StackPane.setAlignment(secondbuttons, Pos.CENTER_RIGHT);


        //game buttons

        //fight button setup

        b1.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {

                int enemyAttack = enemy.getAttack() - hero.getArmor();
                int PlayerAttack = hero.getStrength() * rand.nextInt(5);

                if (hero.getSpeed() > enemy.getSpeed()) {
                    if (hero.getHealth() > 0 && enemy.getHealth() > 0) {
                        if(enemyAttack > 0 && PlayerAttack > 0){
                            popup1.setText("You did " + PlayerAttack + " damage.");
                            int health = enemy.getHealth() - PlayerAttack;
                            enemy.setHealth(health);
                            if (enemy.getHealth()>0){
                                int health2 = hero.getHealth() - enemyAttack;
                                hero.setHealth(health2);
                                popup2.setText("The enemy did " + enemyAttack + " damage.");
                                statController.updateStats();

                            }
                        }

                            else if (PlayerAttack > 0) {
                            int health = enemy.getHealth() - PlayerAttack;
                            popup2.setText("You did " + PlayerAttack + " damage.");
                            enemy.setHealth(health);


                            if (enemyAttack == 0) {
                                popup2.setText("The " + enemy.getType() + " attempts to strike you but misses");
                                if (enemy.getHealth() <= 0) {
                                    popup3.setText("You have killed the " + enemy.getType());
                                    int gold = hero.getMoney();
                                    gold = rand.nextInt(200) + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took" + gold + " from the " + enemy.getType());


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    text1.setText("1) Would you like to heal before continuing?");
                                    text2.setText("2) would you like to look at the map?");
                                    text3.setText("3) Ready to go back?");
                                    text4.setText("");

                                    Bot_UI.getChildren().add(secondbuttons);
                                }
                            } else {
                                popup2.setText("You attempted to hit the " + enemy.getType() + " but missed");
                            }


                        } else {
                            popup1.setText("Your armour stopped " + enemy.getType() + "'s strike");
                            if (PlayerAttack > 0) {
                                int health = enemy.getHealth() - PlayerAttack;
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                enemy.setHealth(health);
                                if (enemy.getHealth() <= 0) {
                                    popup3.setText("You have killed the " + enemy.getType());
                                    int gold = hero.getMoney();
                                    int earned = rand.nextInt(200);
                                    gold = earned + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took gold" + gold + " from the " + enemy.getType());
                                    statController.updateStats();


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    text1.setText("1) Would you like to heal before continuing?");
                                    text2.setText("2) would you like to look at the map?");
                                    text3.setText("3) Ready to continue??");
                                    text4.setText("");

                                    Bot_UI.getChildren().add(secondbuttons);

                                }
                            } else {
                                popup2.setText("you attack and missed");
                            }

                        }
                    }


                } else {
                    if (hero.getHealth() > 0 && enemy.getHealth() > 0) {
                        if (enemyAttack > 0 && PlayerAttack > 0) {
                            popup1.setText("The enemy did " + enemyAttack + " damage.");
                            int health2 = hero.getHealth() - enemyAttack;
                            hero.setHealth(health2);
                            statController.updateStats();
                            if (hero.getHealth() > 0) {
                                int health = enemy.getHealth() - PlayerAttack;
                                enemy.setHealth(health);
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                if (enemy.getHealth() <= 0) {
                                    popup3.setText("You have killed the " + enemy.getType());
                                    int gold = hero.getMoney();
                                    int earned = rand.nextInt(200);
                                    gold = earned + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took gold " + earned + " from the " + enemy.getType());
                                    statController.updateStats();


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    text1.setText("1) Would you like to heal before continuing?");
                                    text2.setText("2) would you like to look at the map?");
                                    text3.setText("3) Ready to continue?");
                                    text4.setText("");


                                    Bot_UI.getChildren().add(secondbuttons);
                                }

                            }
                            if (hero.getHealth() <= 0) {

                                Scene s3 = YouDiedIdiot.main(x, hero);
                                x.setScene(s3);

                            }

                        } else if (enemyAttack == 0) {
                            popup1.setText("The " + enemy.getType() + " attempts to strike you but misses");
                            if (PlayerAttack > 0) {
                                int health = enemy.getHealth() - PlayerAttack;
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                enemy.setHealth(health);
                                if (enemy.getHealth() <= 0) {
                                    popup3.setText("You have killed the " + enemy.getType());
                                    int gold = hero.getMoney();
                                    gold = rand.nextInt(200) + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took" + gold + " from the " + enemy.getType());


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    text1.setText("1) Would you like to heal before continuing?");
                                    text2.setText("2) would you like to look at the map?");
                                    text3.setText("3) Ready to continue?");
                                    text4.setText("");

                                    Bot_UI.getChildren().add(secondbuttons);
                                }
                            } else {
                                popup2.setText("You attempted to hit the " + enemy.getType() + " but missed");
                            }


                        } else {
                            popup1.setText("Your armour stopped " + enemy.getType() + "'s strike");
                            if (PlayerAttack > 0) {
                                int health = enemy.getHealth() - PlayerAttack;
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                enemy.setHealth(health);
                                if (enemy.getHealth() <= 0) {
                                    popup3.setText("You have killed the " + enemy.getType());
                                    int gold = hero.getMoney();
                                    int earned = rand.nextInt(200);
                                    gold = earned + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("you took gold" + gold + " from the " + enemy.getType());
                                    statController.updateStats();


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    text1.setText("1) Would you like to heal before continuing?");
                                    text2.setText("2) would you like to look at the map?");
                                    text3.setText("3) Ready to continue??");
                                    text4.setText("");

                                    Bot_UI.getChildren().add(secondbuttons);

                                }
                            } else {
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
                if (hero.getCharisma() >= 10 && enemy.getHealth() > 0) {
                    popup1.setText("You have talked your way out of a fight");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                    text1.setText("Would you like to heal before traveling?");
                    text2.setText("would you like to look at the map?");
                    text3.setText("Would you like to continue traveling?");
                    text4.setText("");
                    Bot_UI.setAlignment(secondbuttons, Pos.CENTER_RIGHT);
                    Bot_UI.getChildren().add(secondbuttons);
                } else {
                    if (enemy.getHealth() > 0) {
                        popup1.setText("You angered the enemy.");
                        int SneakAttack = enemy.getAttack() - hero.getArmor();

                        int health2 = hero.getHealth() - SneakAttack;
                        hero.setHealth(health2);
                        if (SneakAttack > 0) {
                            popup2.setText("The " + enemy.getType() + " smacks you and does " + SneakAttack + " damage.");
                            statController.updateStats();
                            if (hero.getHealth() <= 0) {
                                Scene s3 = YouDiedIdiot.main(x, hero);
                                x.setScene(s3);
                            }
                            if (hero.getHealth() < 25) {
                                popup3.setText("Your health is low!");
                                popup4.setText("");
                            } else {
                                popup3.setText("");
                                popup4.setText("");
                            }

                        } else if (SneakAttack == 0) {
                            popup2.setText("The " + enemy.getType() + " attempts to smack you");
                            popup3.setText("He Misses!");
                            popup4.setText("");
                        } else {
                            popup2.setText("The " + enemy.getType() + " attempts to smack you");
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
                if (hero.getSpeed() > enemy.getSpeed() && enemy.getHealth() > 0) {
                    popup1.setText("you were fast enough to out run the " + enemy.getType());
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                    text1.setText("Would you like to heal before traveling?");
                    text2.setText("would you like to look at the map?");
                    text3.setText("Would you like to continue traveling?");
                    text4.setText("");
                    Bot_UI.setAlignment(secondbuttons, Pos.CENTER_RIGHT);
                    Bot_UI.getChildren().add(secondbuttons);
                } else {
                    if (enemy.getHealth() > 0) {
                        popup1.setText("The " + enemy.getType() + " caught you");
                        int SneakAttack = enemy.getAttack() - hero.getArmor();
                        if (SneakAttack > 0) {
                            int health2 = hero.getHealth() - SneakAttack;
                            hero.setHealth(health2);
                            popup2.setText("The " + enemy.getType() + " smacks you and does " + SneakAttack + " damage.");
                            if (hero.getHealth() < 25) {
                                popup3.setText("Your health is low!");
                                popup4.setText("");
                            } else {
                                popup3.setText("");
                                popup4.setText("");
                            }
                        } else if (SneakAttack == 0) {
                            popup2.setText("The " + enemy.getType() + " tried to smack you but misses.");
                            popup3.setText("");
                            popup4.setText("");
                        } else {
                            popup2.setText("He attempts to hit you.");
                            popup3.setText("Your armour blocked the attack.");
                            popup4.setText("");

                        }

                        statController.updateStats();
                        if (hero.getHealth() <= 0) {
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                            ;
                        }


                    }

                }


            }


        });
        //use potion action handler

        b4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (hero.getPotions() > 0 && enemy.getHealth() > 0) {
                    int pot = hero.getPotions() - 1;
                    hero.setPotions(pot);
                    if ((hero.getHealth() > 75)) {
                        int healthboost = 100 - hero.getHealth();
                        int addhealth = hero.getHealth() + healthboost;
                        hero.setHealth(addhealth);
                        statController.updateStats();
                        popup1.setText("You used a potion and healed " + healthboost + " health points.");

                    } else {
                        int addhealth = hero.getHealth() + 25;
                        hero.setHealth(addhealth);
                        statController.updateStats();
                        popup1.setText("You used a potion and healed 25 health points.");

                    }

                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                } else {
                    if (enemy.getHealth() > 0) {
                        popup1.setText("You Do not have any potions");
                        popup2.setText("you stand there in confusion looking for your potion");
                        int SneakAttack = enemy.getAttack() - hero.getArmor();

                        if (SneakAttack > 0) {
                            int health2 = hero.getHealth() - SneakAttack;
                            hero.setHealth(health2);
                            popup3.setText("The " + enemy.getType() + " smacks you and does " + SneakAttack + " damage.");
                            if (hero.getHealth() < 25) {
                                popup4.setText("Your health is low!");
                            } else {
                                popup4.setText("");
                            }
                        } else if (SneakAttack == 0) {
                            popup3.setText("The " + enemy.getType() + " tried to smack you but misses.");
                        } else {
                            popup3.setText("Your armour stopped" + enemy.getType() + " 's attack.");

                        }
                        statController.updateStats();
                        if (hero.getHealth() <= 0) {
                            Scene s3 = YouDiedIdiot.main(x, hero);
                            x.setScene(s3);
                        }


                    }


                }

            }

            ;
        });
        //popup button setup



        StackPane Center_UI = new StackPane();


        ImageView Center_ImageView = new ImageView(background);
        ImageView Character = new ImageView(enemypic);
        //Text enemyhealth = new Text();
       // enemyhealth.setText("Health: " + enemy.getHealth());

        Center_UI.getChildren().addAll(Center_ImageView, Character);
        Center_UI.setAlignment(Character, Pos.BOTTOM_CENTER);



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

                Bot_UI.getChildren().removeAll(secondbuttons, Map, heal, weturn);
                Button GoBack = new Button();
                GoBack.setText("Go Back");
                Bot_UI.getChildren().add(GoBack);
                GoBack.setPadding(new Insets(0, 20, 0, 20));
                Bot_UI.setAlignment(GoBack, Pos.CENTER_RIGHT);
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
                        Bot_UI.setAlignment(secondbuttons, Pos.CENTER_RIGHT);

                        Bot_UI.getChildren().add(secondbuttons);
                        Image img1 = new Image("sample/Art/Background/Forrest_Walking.png", 650, 400, true, true);
                        ImageView Center_ImageView1 = new ImageView(img1);
                        Center_UI.getChildren().removeAll((Center_ImageView));
                        Center_UI.getChildren().add(Center_ImageView1);
                        root.setCenter(Center_UI);
                        text1.setText("1)Would you like to heal before traveling?");
                        text2.setText("2)would you like to look at the map?");
                        text3.setText("3)Would you like to continue traveling?");
                        text4.setText("");


                    }

                });


            }

        });


        return S2;

    }


    @Override
    public void start(Stage primaryStage) {


    }
}
