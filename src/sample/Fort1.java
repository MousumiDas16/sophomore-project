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

public class Fort1 extends Application {
    static int next = 0;
    StatsPanelController statController;
    @Override
    public void start(Stage primaryStage) {

    }

    //
    // /**
    //  * @param args the command line arguments
    //  */
    public Scene createScene(Stage x, Player hero) {
        System.out.println(("Current file: Fort1"));
        hero.setScene("fort1");

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

//tempFort1

        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Fort.png", AppSettings.centerUIWidth,
                AppSettings.centerUIHeight, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);

        //Player STATS ON Side Bar


        //Story for talking to guards
        ArrayList<String> words = new ArrayList<>();
        words.add("\"There are two paths ahead, both equally treacherous.\"");
        words.add("\"Talk to the fort’s quartermaster, he sells all sorts of goods \nto aid you on your journey!\"");

        Text Line1 = new Text();
        root.getChildren().add(Line1);
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

                    FirstTown mytown=new FirstTown();
                    Scene s1 = mytown.createScene(x, hero);// next town pic please
                    x.setScene(s1);
                }
            };
        });

        //TEXT AND BUTTON's

        Group text_Group = new Group();

        int Text_coorY = 10;

        Text text1 = new Text("1) Go to the Shop");
        Text text2 = new Text("2)Check Map");
        Text text3 = new Text("3) Interact with town");
        Text text4 = new Text("4) Leave Town");
        text_Group.getChildren().addAll(text1, text2, text3, text4);
        //solo text
        Text text5 = new Text("");
        Bot_UI.getChildren().add(text5);


        text1.setY(Text_coorY);
        text2.setY(Text_coorY + 20);
        text3.setY(Text_coorY + 40);
        text4.setY(Text_coorY + 60);
        Bot_UI.getChildren().add(text_Group);

        //shop button
        Group butt_Group = new Group();
        Button b1 = new Button();
        b1.setText("1");
        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene s1  = ShopUI.main(x, hero);

                x.setScene(s1);


            }


        });
        //check map
        Button b2 = new Button();
        b2.setText("2");
        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                butt_Group.setDisable(true);
                butt_Group.setVisible(false);

                text_Group.setDisable(true);
                text_Group.setVisible(false);
                Image Map = new Image("sample/Art/Background/TempMap.png");
                ImageView viewMap = new ImageView(Map);
                root.setCenter(viewMap);
                Button GoBack = new Button("Stop looking at Map");
                Bot_UI.getChildren().add(GoBack);

                GoBack.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        root.setCenter(Center_UI);
                        butt_Group.setDisable(false);
                        butt_Group.setVisible(true);
                        text_Group.setDisable(false);
                        text_Group.setVisible(true);
                        GoBack.setVisible(false);
                        GoBack.setDisable(true);


                    }
                });

            }


        });

        Button b3 = new Button();
        b3.setText("3");

        b3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                text1.setText("1) Interact with town.");
                text2.setText("2) Go looking for trouble");
                text3.setText("3) return to town");
                text4.setVisible(false);
                Button towntalk = new Button();

                butt_Group.setDisable(true);
                butt_Group.setVisible(false);

                Button findFight = new Button();

                Button BackToTown = new Button();

                Group secondgroup = new Group();
                secondgroup.getChildren().addAll(findFight,towntalk,BackToTown);
                Bot_UI.getChildren().add(secondgroup);
                StackPane.setAlignment(secondgroup, Pos.CENTER_RIGHT);


                towntalk.setLayoutY(Text_coorY);
                findFight.setLayoutY(Text_coorY + 20);
                BackToTown.setLayoutY(Text_coorY + 40);
                towntalk.setText("1");
                towntalk.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        text_Group.setDisable(true);
                        text_Group.setVisible(false);
                        butt_Group.setDisable(true);
                        butt_Group.setVisible(false);
                        secondgroup.setDisable(true);
                        secondgroup.setVisible(false);
                        Random rand = new Random();
                        int random = rand.nextInt(3);
                        switch(random){
                            case 0:
                                text5.setText(words.get(0));
                                break;



                            case 1:
                                text5.setText(words.get(1));
                                break;

                            case 2:
                                text5.setText(words.get(2));
                                break;
                            default:
                                System.out.println("something broke fam peep first town");
                                break;
                        }
                        Image img = new Image("sample/Art/Background/Fort.PNG", AppSettings.centerUIWidth,
                                AppSettings.centerUIHeight, true, true);
                        Image img2 = new Image("sample/Art/Characters/Guard#2.png", 200, 100, true, true);
                        ImageView Center_ImageView = new ImageView(img);
                        ImageView Character = new ImageView(img2);
                        Center_UI.getChildren().addAll(Center_ImageView,Character);
                        root.setCenter(Center_UI);
                        Button GoBack = new Button("Go back");
                        GoBack.setPadding(new Insets(0, 20, 0, 20));
                        Bot_UI.getChildren().add(GoBack);
                        Bot_UI.setAlignment(GoBack, Pos.CENTER_RIGHT);


                        GoBack.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                text5.setText("");
                                text_Group.setDisable(false);
                                text_Group.setVisible(true);
                                butt_Group.setDisable(true);
                                butt_Group.setVisible(false);
                                secondgroup.setDisable(false);
                                secondgroup.setVisible(true);
                                GoBack.setVisible(false);
                                GoBack.setDisable(true);



                            }
                        });


                    }







                });

                findFight.setText("2");
                Random rand = new Random(2);
                findFight.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        Scene s1 = null;
                        try {
                            RandomEncounter encounter=new RandomEncounter();
                            s1 = encounter.createScene(x, hero,4);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        x.setScene(s1);





                    }


                });
                BackToTown.setText("3");
                BackToTown.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        secondgroup.setDisable(true);
                        secondgroup.setVisible(false);
                        butt_Group.setDisable(false);
                        butt_Group.setVisible(true);

                        text1.setText("1) Go to the Shop");
                        text2.setText("2) Check Map");
                        text3.setText("3) Interact with town.");
                        text4.setText("4) Leave Town");
                        text4.setVisible(true);

                    }
                });

                towntalk.setPadding(new Insets(0, 20, 0, 20));
                findFight.setPadding(new Insets(0, 20, 0, 20));
                BackToTown.setPadding(new Insets(0, 20, 0, 20));



            }


        });
        //leave town
        Button b4 = new Button();
        b4.setText("4");
        b4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                butt_Group.setDisable(true);
                butt_Group.setVisible(false);

                text_Group.setDisable(true);
                text_Group.setVisible(false);

                Group LORGroup = new Group();

                Text LOR = new Text("Head to the Left for the Fishing Village or Right towards Cave 1");
                Button Right = new Button("Right");
                Button Left = new Button("Left");
                Right.setLayoutX(Left.getLayoutY()+200);
                Left.setLayoutY(LOR.getY()+10);
                Right.setLayoutY(Left.getLayoutY());

                Left.setPadding(new Insets(0, 20, 0, 20));
                Right.setPadding(new Insets(0, 20, 0, 20));
                Left.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        toFishingVillage village=new toFishingVillage();
                        Scene s1 = village.createScene(x, hero); //talk to a random person pic please
                        x.setScene(s1);


                    }


                });

                Right.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        toCave1 myfort=new toCave1();
                        Scene s1 = myfort.createScene(x, hero);// next town pic please
                        x.setScene(s1);


                    }


                });

                LORGroup.getChildren().addAll(LOR,Right,Left);
                Bot_UI.getChildren().addAll(LORGroup);



            }


        });

        b1.setPadding(new Insets(0, 20, 0, 20));
        b2.setPadding(new Insets(0, 20, 0, 20));
        b3.setPadding(new Insets(0, 20, 0, 20));
        b4.setPadding(new Insets(0, 20, 0, 20));


        butt_Group.getChildren().addAll(b1, b2, b3, b4);


        Bot_UI.getChildren().add(butt_Group);
        StackPane.setAlignment(butt_Group, Pos.CENTER_RIGHT);


        b1.setLayoutY(Text_coorY);
        b2.setLayoutY(Text_coorY + 20);
        b3.setLayoutY(Text_coorY + 40);
        b4.setLayoutY(Text_coorY + 60);


        Scene S2 = new Scene(root, 750, 500);
        return S2;
    }
}