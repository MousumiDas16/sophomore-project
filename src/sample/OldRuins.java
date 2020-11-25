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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class OldRuins extends Application {

    public Scene getScene(Stage x, Player hero) {
        hero.setScene("OldRuins");
        System.out.println(("Current file: OldRuins"));

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
        Left_UI.getChildren().add(Left_Rec);
        Left_UI.setAlignment(Left_Rec, Pos.TOP_LEFT);

        Pane newLoadedPane = null;
        try {
            URL fxmlUrl = Tavern.class.getResource("./StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
            StatsPanelController statController=new StatsPanelController();
            fxmlLoader.setController(statController);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);



        //TEXT AND BUTTON's
        Group LORGroup = new Group();

        Text LOR = new Text("Fight or give all your belongings!");
        Button Fight = new Button("Fight");
        Button items = new Button("Give all your items");
        Fight.setLayoutX(items.getLayoutY()+200);
        items.setLayoutY(LOR.getY()+10);
        Fight.setLayoutY(items.getLayoutY());

        items.setPadding(new Insets(0, 20, 0, 20));
        Fight.setPadding(new Insets(0, 20, 0, 20));
        items.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hero.setAll();
                Village5 encounter = new Village5();
                Scene s1 = encounter.createScene(x, hero); //talk to a random person pic please
                x.setScene(s1);


            }


        });

        Fight.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                RandomEncounter encounter = new RandomEncounter();
                Scene s1 = null; //talk to a random person pic please
                try {
                    s1 = encounter.createScene(x, hero,2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x.setScene(s1);


            }


        });

        LORGroup.getChildren().addAll(LOR,Fight,items);
        Bot_UI.getChildren().addAll(LORGroup);





//        submit.setTranslateX(charClass.getLayoutX() + 100);



        StackPane Center_UI = new StackPane();
        Image nxtImage = new Image("sample/Art/Background/Fort_Ruined.PNG", AppSettings.centerUIWidth,
                AppSettings.centerUIHeight, true, true);
        ImageView Center_ImageView = new ImageView(nxtImage);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);


        return S2;

    }



    @Override
    public void start(Stage primaryStage) {

    }
}
