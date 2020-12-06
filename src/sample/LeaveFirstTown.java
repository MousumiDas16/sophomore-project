package sample;

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
import javafx.scene.input.MouseEvent;
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

public class LeaveFirstTown {
    static int next = 0;
    private  StatsPanelController statController;

    public void start(Stage primaryStage) {


    }


    public Scene createScene(Stage x, Player hero) {

        System.out.println(("Current file: LeaveFirstTown"));
        hero.setScene("LeaveFirstTown");
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
            URL fxmlUrl = LeaveFirstTown.class.getResource("StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(fxmlUrl);
            statController=new StatsPanelController();
            fxmlLoader.setController(statController);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);

        //
        int y = 0;

        StackPane Root = new StackPane();



        //Jimmy Story
        ArrayList<String> words = new ArrayList<>();
        words.add("Our brave hero is spotted by the hooded woman the next morning");
        words.add("?: \"Wait, You!! Are you venturing to Dragon’s Claw? Really…\"");
        //words.add("The woman's robes fall away revealing a tiny ball of spirit beneath.");
        words.add("Lady Wisp: \"I am the Lady Wisp, the remaining soul of the Sage who once guided\"");
        words.add("\"the first King.I thought you had the makings of Monarch returned\"");
        words.add("\"and shared my tale in hopes of this very thing.\"");
        words.add("\"They left the town together...");
        Text Line1 = new Text();
        //positioning text

        Bot_UI.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.BLACK);

        Image imgNext = new Image("sample/Art/Background/arrow.png", 70, 70, true, true);
        ImageView nxtView = new ImageView(imgNext);
        nxtView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                next++;
                if(next <= words.size() -1){
                    Line1.setText(words.get(next));
                }else{
                    WalkingInForest forest =new WalkingInForest();
                    Scene s1 = forest.createScene(x, hero);

                    x.setScene(s1);
                }
                //need to have sprite transition when the story demands
                event.consume();
            }

        });

        nxtView.setTranslateX(Line1.getX()+280);

        Bot_UI.getChildren().addAll(nxtView);



        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img1 = new Image("sample/Art/Background/Donkey_Town.PNG", 650, 400, true, true);
        Image img2 = new Image("sample/Art/Characters/Willow_Sprite.gif", 200, 200, true, true);
        ImageView Center_ImageView = new ImageView(img1);
        ImageView Character = new ImageView(img2);
        Center_UI.getChildren().addAll(Center_ImageView,Character);
        Center_UI.setAlignment(Character, Pos.BOTTOM_CENTER);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);
        return S2;



    }
}
