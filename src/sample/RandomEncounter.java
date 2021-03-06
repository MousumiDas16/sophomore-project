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
import javafx.scene.text.Font;
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


        switch (a) {
            case 0://FishingVillage Fight
                background = new Image("sample/Art/Background/Fishing_Village.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemy.setType("fish monster");
                enemypic = new Image("sample/Art/Characters/Arlong.gif", 200, 400, true, true);
                break;
            case 1://Cave 1
                background = new Image("sample/Art/Background/Cave.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);

                enemy.setType("troll");
                enemypic = new Image("sample/Art/Characters/Ogre.gif",300,300,true,true);

                break;



            case 2:
                //old ruins

                background = new Image("sample/Art/Background/Fort_Ruined.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemypic = new Image("sample/Art/Characters/Bandit2.png", 150, 250, true, true);
                enemy.setType("bandit");
                break;
            case 3:
                //abandonded camp
                background = new Image("sample/Art/Background/Forrest.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemy.setType("wendigo");
                enemypic = new Image("sample/Art/Characters/Wendigo.png", 300, 300, true, true);
                break;
            case 4://first
                if (hero.getScene().equalsIgnoreCase("firsttown")) {
                    background = new Image("sample/Art/Background/Donkey_Town.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);

                } else if (hero.getScene().equalsIgnoreCase("fort1")) {
                    background = new Image("sample/Art/Background/Fort.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);



                }else if (hero.getScene().equalsIgnoreCase("Fort2")) {
                    background = new Image("sample/Art/Background/Fort_2.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);

                }else if (hero.getScene().equalsIgnoreCase("Village2")) {
                    background = new Image("sample/Art/Background/Town_2.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);
                }
                else if (hero.getScene().equalsIgnoreCase("Village3")){
                    background = new Image("sample/Art/Background/Summerville.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);
                }
                else if(hero.getScene().equalsIgnoreCase("Village4")){
                    background = new Image("sample/Art/Background/Geistadt_.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);
                }
                else if(hero.getScene().equalsIgnoreCase("Village5")){
                    background = new Image("sample/Art/Background/Ye_Olde_Village.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);
                }
                //Travel mechanics
                else if (hero.getScene().equalsIgnoreCase("Castle")) {
                    background = new Image("sample/Art/Background/Castle_Courtyard.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);
                }
                else if (hero.getScene().equalsIgnoreCase("FishingVillage")) {
                    background = new Image("sample/Art/Background/Fishing_Village.png",
                            AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);
                }

                int k = rand.nextInt(3);


                System.out.println("Random number is" + k);
                switch (k) {
                    case 0:
                        enemy.setType("goblin");
                        enemypic = new Image("sample/Art/Characters/Goblin_gif.gif", 200, 150, true, true);

                        System.out.println("enemy goblin");
                        break;


                    case 1:
                        enemy.setType("kobold");
                        enemypic = new Image("sample/Art/Characters/Kobalt_Gif2.gif", 200, 200, true, true);
                        System.out.println("enemy kobold");
                        break;

                    case 2:
                        enemy.setType("bloodpuddle");
                        enemypic = new Image("sample/Art/Characters/BloodMimic2.gif", 200, 300, true, true);
                        System.out.println("enemy bloodpuddle");
                        break;

                    default:
                        System.out.println("something went wrong in encounter case 4");
                        break;
                }
                break;


            case 5:
                System.out.println("made to case 5");
                if (hero.getScene().equalsIgnoreCase("WalkingInForest") || hero.getScene().equalsIgnoreCase("tovillage2")
                        || hero.getScene().equalsIgnoreCase("tovillage3") || hero.getScene().equalsIgnoreCase("toVillage4")
                        ||hero.getScene().equalsIgnoreCase("tovillage5") || hero.getScene().equalsIgnoreCase("tocave1")
                        || hero.getScene().equalsIgnoreCase("tocave2") || hero.getScene().equalsIgnoreCase("tohydra")
                        || hero.getScene().equalsIgnoreCase("toAbandonedCamp") || hero.getScene().equalsIgnoreCase("tofort2")
                        || hero.getScene().equalsIgnoreCase("tocastlebattle") || hero.getScene().equalsIgnoreCase("ToFishingVillage")
                || hero.getScene().equalsIgnoreCase("tooldruins"))  {
                    background = new Image("sample/Art/Background/Forrest.png", AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);


                }else if(hero.getScene().equalsIgnoreCase("toOasis") || (hero.getScene().equalsIgnoreCase("toSphinx"))){
                background = new Image("sample/Art/Background/Desert.png", AppSettings.centerUIWidth, AppSettings.screenHeight, true, true);

                }


                k = rand.nextInt(3);


                System.out.println("Random number is " + k);
                switch (k) {
                    case 0:
                        enemy.setType("goblin");
                        enemypic = new Image("sample/Art/Characters/Goblin_gif.gif", 200, 150, true, true);
                        System.out.println("enemy goblin");
                        break;


                    case 1:
                        enemy.setType("kobold");
                        enemypic = new Image("sample/Art/Characters/Kobalt_Gif2.gif", 200, 200, true, true);
                        System.out.println("enemy kobold");
                        break;

                    case 2:
                        enemy.setType("bloodpuddle");
                        enemypic = new Image("sample/Art/Characters/BloodMimic2.gif", 200, 200, true, true);
                        break;


                }
                break;
            case 6:
                background = new Image("sample/Art/Background/Castle_Goblin.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemy.setType("boss gob");
                enemypic = new Image("sample/Art/Characters/GoblinKing3c.png", 300, 300, true, true);
                break;
            case 7:
                background = new Image("sample/Art/Background/Castle_Hydra.png", AppSettings.centerUIWidth,
                        AppSettings.screenHeight, true, true);
                enemy.setType("hydra");
                enemypic = new Image("sample/Art/Characters/Hydra.png", 400, 400, true, true);
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
            URL fxmlUrl = Tavern.class.getResource("StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlUrl);
            statController=new StatsPanelController();
            fxmlLoader.setController(statController);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);

        Group text_Group = new Group();

        int Text_coorY = 10;
        Font verdana= Font.font("Verdana",16);

       // Text text1 = new Text("1) Attack");
        //text1.setFont(verdana);
        //text1.setStroke(Color.BLACK);
        //Text text2 = new Text("2) Negotiate ");
        //text1.setFont(verdana);
        //text1.setStroke(Color.BLACK);
       // Text text3 = new Text("3) RUNNNN");
        //text1.setFont(verdana);
        //text1.setStroke(Color.BLACK);
        //Text text4 = new Text("4) Use Health Potion");
        //text1.setFont(verdana);
        //text1.setStroke(Color.BLACK);

        //text_Group.getChildren().addAll(text1, text2, text3, text4);


       // text1.setY(Text_coorY);
        //text2.setY(Text_coorY + 20);
        //text3.setY(Text_coorY + 40);
        //text4.setY(Text_coorY + 60);
        //Bot_UI.getChildren().add(text_Group);

        //Attack setup


        //pop up creation
        Font statFont=Font.font("Verdana",12);
        Text popup1 = new Text();
        Text popup2 = new Text();
        Text popup3 = new Text();
        Text popup4 = new Text();
        popup1.setFont(statFont);
        popup2.setFont(statFont);
        popup3.setFont(statFont);
        popup4.setFont(statFont);

        Group popupgroup = new Group();
        popupgroup.getChildren().addAll(popup1, popup2, popup3, popup4);
        popupgroup.setTranslateX(10);

        popup1.setY(Text_coorY);
        popup2.setY(Text_coorY + 20);
        popup3.setY(Text_coorY + 40);
        popup4.setY(Text_coorY + 60);
        Bot_UI.setAlignment(popupgroup, Pos.CENTER_LEFT);


        Bot_UI.getChildren().add(popupgroup);
        Font larger=Font.font(16);

        int Text_coorX=100;
        //button creation
        Button b1 = new Button();
        b1.setText("Attack");
        b1.setFont(larger);
        Image imgAttack = new Image("sample/Art/Background/attack.png", 40, 40, true, true);
        ImageView attackView = new ImageView(imgAttack);
        b1.setGraphic(attackView);
        b1.setTranslateY(Text_coorY);
        b1.setLayoutX(-200);
        //b1.setTranslateX(Text_coorX);
        b1.setPrefWidth(160);
        b1.setPrefHeight(50);


        Button b2 = new Button();
        b2.setText("Negotiate");
        b2.setFont(larger);
        Image imgNegotiate = new Image("sample/Art/Background/negotiate.png", 40, 40, true, true);
        ImageView negotiateView = new ImageView(imgNegotiate);
        b2.setGraphic(negotiateView);
        b2.setTranslateY(Text_coorY+50);
        b2.setLayoutX(-200);
        b2.setPrefWidth(160);
        b2.setPrefHeight(45);

        Button b3 = new Button();
        b3.setText("Run");
        b3.setFont(larger);
        Image imgRun = new Image("sample/Art/Background/run.png", 40, 40, true, true);
        ImageView runView = new ImageView(imgRun);
        b3.setGraphic(runView);
        b3.setTranslateY(Text_coorY);
        b3.setLayoutX(-30);
        b3.setPrefWidth(160);
        b3.setPrefHeight(50);

        Button b4 = new Button();
        b4.setText("Heal");
        b4.setFont(larger);
        Image imgHeal = new Image("sample/Art/Background/heal.png", 35, 35, true, true);
        ImageView healView = new ImageView(imgHeal);
        b4.setGraphic(healView);
        b4.setTranslateY(Text_coorY+50);
        b4.setLayoutX(b3.getLayoutX());
        b4.setPrefWidth(160);
        b4.setPrefHeight(45);
        //button setup

        b1.setPadding(new Insets(0, 20, 0, 20));
        //b1.set
        b2.setPadding(new Insets(0, 20, 0, 20));
        b3.setPadding(new Insets(0, 20, 0, 20));
        b4.setPadding(new Insets(0, 20, 0, 20));

        Group butt_Group = new Group();
        butt_Group.getChildren().addAll(b1, b2, b3, b4);



        Bot_UI.getChildren().add(butt_Group);
        butt_Group.setTranslateX(-30);
        StackPane.setAlignment(butt_Group, Pos.TOP_RIGHT);


        //b1.setLayoutY(text1.getY());
        //b2.setLayoutY(text2.getY());
        //b3.setLayoutY(text3.getY());
        //b4.setLayoutY(text4.getY());

        //buttons for before returning to the forest
        Button weturn = new Button();
        weturn.setText("Continue...");
        weturn.setFont(larger);
        weturn.setPrefWidth(160);
        weturn.setPrefHeight(45);
        //weturn.setGraphic(runView);
        weturn.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                if (hero.getScene().equals("WalkingInForest")) {
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
                }else if (hero.getScene().equalsIgnoreCase("fort2")) {
                    Fort2 firstFort = new Fort2();
                    Scene s1 = firstFort.createScene(x, hero);
                    x.setScene(s1);
                }else if (hero.getScene().equalsIgnoreCase("village2")) {
                    Village2 firstFort = new Village2();
                    Scene s1 = firstFort.createScene(x, hero);
                    x.setScene(s1);
                }else if (hero.getScene().equalsIgnoreCase("village3")) {
                    Village3 firstFort = new Village3();
                    Scene s1 = firstFort.createScene(x, hero);
                    x.setScene(s1);
                }else if (hero.getScene().equalsIgnoreCase("village4")) {
                    Village4 firstFort = new Village4();
                    Scene s1 = firstFort.createScene(x, hero);
                    x.setScene(s1);
                }else if (hero.getScene().equalsIgnoreCase("village5")) {
                    Village5 firstFort = new Village5();
                    Scene s1 = firstFort.createScene(x, hero);
                    x.setScene(s1);
                }else if (hero.getScene().equalsIgnoreCase("Castle")) {
                    Castle firstFort = new Castle();
                    Scene s1 = firstFort.createScene(x, hero);
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("fishingvillage")) {
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
                else if(hero.getScene().equalsIgnoreCase("AbandonedCamp")){
                    toVillage4 encounter = new toVillage4();
                    Scene s1 = encounter.createScene(x, hero); //talk to a random person pic please
                    x.setScene(s1);
                }
                else if(hero.getScene().equalsIgnoreCase("HydraBattle")){
                    EndingIntro encounter = new EndingIntro();
                    Scene s1 = encounter.getScene(x, hero); //talk to a random person pic please
                    x.setScene(s1);
                }else if(hero.getScene().equalsIgnoreCase("castleBattle")){
                    Castle encounter = new Castle();
                    Scene s1 = encounter.createScene(x, hero); //talk to a random person pic please
                    x.setScene(s1);
                }
                //Travel mechanics
                else if (hero.getScene().equalsIgnoreCase("toFishingVillage")) {
                    toFishingVillage mytown = new toFishingVillage();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toVillage2")) {
                    toVillage2 mytown=new toVillage2();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toCave1")) {
                    toCave1 mytown=new toCave1();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toCave2")) {
                    toCave2 mytown=new toCave2();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toVillage3")) {
                    toVillage3 mytown=new toVillage3();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toVillage4")) {
                    toVillage4 mytown=new toVillage4();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }///


                else if (hero.getScene().equalsIgnoreCase("toVillage5")) {
                    toVillage5 mytown=new toVillage5();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toAbandonedCamp")) {
                    toAbandonedCamp mytown=new toAbandonedCamp();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toCastleBattle")) {
                    toCastleBattle mytown=new toCastleBattle();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toFort2")) {
                    toFort2 mytown=new toFort2();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toHydra")) {
                    toHydra mytown=new toHydra();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toOasis")) {
                    toOasis mytown=new toOasis();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toOldRuins")) {
                    toOldRuins mytown=new toOldRuins();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                else if (hero.getScene().equalsIgnoreCase("toSphinx")) {
                    toSphinx mytown=new toSphinx();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
                
                else {

                    //for later use of other towns/paths
                }

            }


        });
        Button heal = new Button();
        heal.setText("Heal");
        heal.setFont(larger);
        heal.setPrefWidth(160);
        heal.setPrefHeight(45);

        heal.setGraphic(healView);
        //heal.setText("1");
        heal.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                if (hero.getPotions() > 0) {
                    int pot = hero.getPotions() - 1;
                    hero.setPotions(pot);
                    if ((hero.getHealth() > 75)) {
                        int healthboost = 100 - hero.getHealth();
                        int addhealth = hero.getHealth() + healthboost;
                        hero.setHealth(addhealth);
                        statController.updateStats();

                    } else {
                        int addhealth = hero.getHealth() + 25;
                        hero.setHealth(addhealth);
                        statController.updateStats();
                        popup1.setText("You used a potion and healed\n25 health points.");
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
        Map.setText("Map");
        Image imgMap = new Image("sample/Art/Background/map.png", 40, 40, true, true);
        ImageView mapView = new ImageView(imgMap);
        Map.setGraphic(mapView);
        Map.setPrefWidth(160);
        Map.setPrefHeight(45);

        Image imgArrow = new Image("sample/Art/Background/arrow.png", 40, 40, true, true);
        ImageView arrowView = new ImageView(imgArrow);
        weturn.setGraphic(arrowView);


        //secondary button groups
        weturn.setPadding(new Insets(0, 20, 0, 20));
        heal.setPadding(new Insets(0, 20, 0, 20));
        Map.setPadding(new Insets(0, 20, 0, 20));
        Group secondbuttons = new Group();

        heal.setLayoutY(10);
        heal.setLayoutX(-260);
        Map.setLayoutY(60);
        Map.setLayoutX(-260);
        //weturn.setLayoutX();
        weturn.setLayoutY(10);

        secondbuttons.getChildren().addAll(heal, Map, weturn);
        secondbuttons.setTranslateX(-30);
        StackPane.setAlignment(secondbuttons, Pos.TOP_RIGHT);


        //game buttons

        //fight button setup

        b1.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {

                int enemyAttack = enemy.getAttack() - hero.getArmor();
                int PlayerAttack = hero.getStrength() * rand.nextInt(5);

                if (hero.getSpeed() > enemy.getSpeed()) {
                    if (hero.getHealth() > 0 && enemy.getHealth() > 0) {
                        if (enemyAttack > 0 && PlayerAttack > 0) {
                            popup1.setText("You  did " + PlayerAttack + " damage.");
                            int health = enemy.getHealth() - PlayerAttack;
                            enemy.setHealth(health);
                            if (enemy.getHealth() <= 0) {
                                popup3.setText("You have killed the " + enemy.getType());
                                int gold = hero.getMoney();
                                int earned = rand.nextInt(200);
                                gold = earned + gold;
                                hero.setMoney(gold);
                                popup4.setText("You took " + earned + " gold from the " + enemy.getType());
                                statController.updateStats();


                                Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                //text1.setText("1) Would you like to heal before continuing?");
                                //text2.setText("2) would you like to look at the map?");
                                //text3.setText("3) Ready to continue?");
                                //text4.setText("");


                                Bot_UI.getChildren().add(secondbuttons);
                                statController.updateStats();
                            }

                            else if (enemy.getHealth() > 0) {
                                int health2 = hero.getHealth() - enemyAttack;
                                hero.setHealth(health2);
                                popup2.setText("The "+enemy.getType() +" did " + enemyAttack + " damage.");
                                statController.updateStats();
                                popup3.setText("");
                                popup4.setText("");


                            }
                            if (hero.getHealth() <= 0) {

                                Scene s3 = YouDiedIdiot.main(x, hero);
                                x.setScene(s3);

                            }

                        }
                        else if (PlayerAttack == 0) {
                            popup1.setText("You  attempt to attack but miss.");
                            if (enemyAttack > 0) {
                                int health = hero.getHealth() - enemyAttack;
                                popup2.setText("The "  +enemy.getType() + " did " + enemyAttack + " damage");
                                hero.setHealth(health);
                                statController.updateStats();
                                popup3.setText("");
                                popup4.setText("");
                                if (hero.getHealth() <= 0) {

                                    Scene s3 = YouDiedIdiot.main(x, hero);
                                    x.setScene(s3);

                                }
                            } else if(enemyAttack == 0) {
                                popup2.setText("You attempted to hit the " + enemy.getType() + " but missed");
                                popup3.setText("");
                                popup4.setText("");
                            }
                            else {
                                popup2.setText("Your armor deflects the" + enemy.getType() + "'s attack");
                                popup3.setText("");
                                popup4.setText("");
                            }




                        }
                    }


                } else {
                    if (hero.getHealth() > 0 && enemy.getHealth() > 0) {
                        if (enemyAttack > 0 && PlayerAttack > 0) {
                            popup1.setText("The " + enemy.getType()+" did " + enemyAttack + " damage.");
                            int health2 = hero.getHealth() - enemyAttack;
                            hero.setHealth(health2);
                            statController.updateStats();
                            if (hero.getHealth() > 0) {
                                int health = enemy.getHealth() - PlayerAttack;
                                enemy.setHealth(health);
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                popup3.setText("");
                                popup4.setText("");
                                if (enemy.getHealth() <= 0) {
                                    popup3.setText("You have killed the " + enemy.getType());
                                    int gold = hero.getMoney();
                                    int earned = rand.nextInt(200);
                                    gold = earned + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("You took " + earned + " gold from the " + enemy.getType());
                                    statController.updateStats();


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    //text1.setText("1) Would you like to heal before continuing?");
                                    //text2.setText("2) would you like to look at the map?");
                                    //text3.setText("3) Ready to continue?");
                                    //text4.setText("");


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
                                    int earned = rand.nextInt(200);
                                    gold = earned + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("You took " + earned + " gold from the " + enemy.getType());


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    //text1.setText("1) Would you like to heal before continuing?");
                                    //text2.setText("2) would you like to look at the map?");
                                    //text3.setText("3) Ready to continue?");
                                    //text4.setText("");

                                    Bot_UI.getChildren().add(secondbuttons);
                                }
                            } else {
                                popup2.setText("You attempted to hit the " + enemy.getType() + " but missed");
                                popup3.setText("");
                                popup4.setText("");
                            }


                        } else {
                            popup1.setText("Your armour stopped " + enemy.getType() + "'s strike");
                            if (PlayerAttack > 0) {
                                int health = enemy.getHealth() - PlayerAttack;
                                popup2.setText("You did " + PlayerAttack + " damage.");
                                popup3.setText("");
                                popup4.setText("");
                                enemy.setHealth(health);
                                if (enemy.getHealth() <= 0) {
                                    popup3.setText("You have killed the " + enemy.getType());
                                    int gold = hero.getMoney();
                                    int earned = rand.nextInt(200);
                                    gold = earned + gold;
                                    hero.setMoney(gold);
                                    popup4.setText("You took " + earned + " gold from the " + enemy.getType());
                                    statController.updateStats();


                                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                                    //text1.setText("1) Would you like to heal before continuing?");
                                    //text2.setText("2) would you like to look at the map?");
                                    //text3.setText("3) Ready to continue??");
                                    //text4.setText("");

                                    Bot_UI.getChildren().add(secondbuttons);

                                }
                            } else {
                                popup2.setText("You attack and missed");
                                popup3.setText("");
                                popup4.setText("");
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
                if (hero.getCharisma() >= enemy.getCharisma() && enemy.getHealth() > 0) {
                    popup1.setText("You have talked your way out of a fight");
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                    //text1.setText("1) Would you like to heal before traveling?");
                    //text2.setText("2) would you like to look at the map?");
                    //text3.setText("3) Would you like to continue traveling?");
                    //text4.setText("");
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
                    popup1.setText("You were fast enough to out run the\n" + enemy.getType());
                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                    Bot_UI.getChildren().removeAll(butt_Group, b1, b2, b3, b4);
                    //text1.setText("Would you like to heal before traveling?");
                    //text2.setText("would you like to look at the map?");
                    //text3.setText("Would you like to continue traveling?");
                    //text4.setText("");
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
                        popup1.setText("You used a potion and healed\n" + healthboost + " health points.");

                    } else {
                        int addhealth = hero.getHealth() + 25;
                        hero.setHealth(addhealth);
                        statController.updateStats();
                        popup1.setText("You used a potion and healed\n25 health points.");

                    }

                    popup2.setText("");
                    popup3.setText("");
                    popup4.setText("");
                } else {
                    if (enemy.getHealth() > 0) {
                        popup1.setText("You Do not have any potions");
                        popup2.setText("You stand there in confusion looking for your potion");
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

                Image img1 = new Image("sample/Art/Background/TempMap.png", 650, 400, true, true);
                ImageView Center_ImageView1 = new ImageView(img1);
                Center_UI.getChildren().removeAll((Center_ImageView));
                Center_UI.getChildren().add(Center_ImageView1);
                root.setCenter(Center_UI);

                Bot_UI.getChildren().removeAll(secondbuttons, Map, heal, weturn);
                Button GoBack = new Button();
                GoBack.setText("Go Back");
                GoBack.setPrefHeight(50);
                GoBack.setPrefWidth(200);
                Image imgArrow2 = new Image("sample/Art/Background/arrow.png", 40, 40, true, true);
                ImageView arrowView2 = new ImageView(imgArrow2);

                GoBack.setGraphic(arrowView2);
                GoBack.setTranslateX(-30);
                Bot_UI.getChildren().add(GoBack);
                GoBack.setPadding(new Insets(0, 20, 0, 20));
                Bot_UI.setAlignment(GoBack, Pos.CENTER_RIGHT);
                popup1.setText("");
                popup2.setText("");
                popup3.setText("");
                popup4.setText("");
                //text1.setText("");
                //text2.setText("");
                //text3.setText("");
                //text4.setText("");
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
                        //text1.setText("1)Would you like to heal before traveling?");
                        //text2.setText("2)would you like to look at the map?");
                        //text3.setText("3)Would you like to continue traveling?");
                        //text4.setText("");


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
