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
import java.util.ArrayList;
import java.util.Random;

public class Village2 extends Application {
    static int next = 0;
    private StatsPanelController statController;
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
    public  Scene createScene(Stage x, Player hero) {
        System.out.println(("Current file: Village 2"));
        hero.setScene("village2");

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
        Rectangle Left_Rec = new Rectangle(AppSettings.leftUIWidth, AppSettings.leftUIHeight,
                Color.rgb(211, 211, 211));
        //Left_Rec.setStroke(Color.BLACK);
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


        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Town_2.png", AppSettings.centerUIWidth,
                AppSettings.centerUIHeight, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);

        //Player STATS ON Side Bar



        //Story for talking to townspeople
        ArrayList<String> words = new ArrayList<>();
        words.add("\"Our local shopkeeper has lots of good supplies for ya.\"");
        words.add("\"That castle sometimes is attacked by monsters, make sure\nyou’re ready to face any that might block your\npath\"");



        //TEXT AND BUTTON's

        Group text_Group = new Group();

        int Text_coorY = 10;

        Text text1 = new Text("1) Go to the Shop");
        Text text2 = new Text("2) Check Map");
        Text text3 = new Text("3) Converse With Locals");
        Text text4 = new Text("4) Leave Town");
        Text text5 = new Text("");
        Bot_UI.getChildren().add(text5);
        text_Group.getChildren().addAll(text1, text2, text3, text4);


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
                Scene s1 = ShopUI.main(x, hero);

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
                text1.setText("1) Talk To Towns person.");
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
                        int random = rand.nextInt(2);
                        switch(random){
                            case 0:
                                text5.setText(words.get(0));

                                break;



                            case 1:
                                text5.setText(words.get(1));

                                break;


                            default:
                                System.out.println("something broke fam peep first town");
                                break;
                        }
                        Image img = new Image("sample/Art/Background/Town_2.PNG", 650, 400, true, true);
                        Image img2 = new Image("sample/Art/Characters/Townsperson.png", 200, 200, true, true);
                        ImageView Center_ImageView = new ImageView(img);
                        ImageView Character = new ImageView(img2);
                        Center_UI.getChildren().addAll(Center_ImageView,Character);
                        Center_UI.setAlignment(Character, Pos.BOTTOM_CENTER);
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
                                Center_UI.getChildren().remove(Character);



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
                toCastleBattle myCastle=new toCastleBattle();
                Scene s1 = myCastle.createScene(x, hero);// next town pic please
                x.setScene(s1);


            }


        });

        b1.setPadding(new Insets(0, 20, 0, 20));
        b2.setPadding(new Insets(0, 20, 0, 20));
        b3.setPadding(new Insets(0, 20, 0, 20));
        b4.setPadding(new Insets(0, 20, 0, 20));


        butt_Group.getChildren().addAll(b1, b2, b3, b4);

        butt_Group.setTranslateX(-20);

        Font txtFont= Font.font("Verdana",16);
        text1.setFont(txtFont);
        text2.setFont(txtFont);
        text3.setFont(txtFont);
        text4.setFont(txtFont);


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
