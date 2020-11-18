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

public class AbandondedCamp extends Application {

    public Scene createScene(Stage x, Player hero) {

        System.out.println(("Current file: Abandoned Camp"));
        hero.setScene("AbandondedCamp");
        StackPane Center_UI = new StackPane();

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

        Text LOR = new Text("Fight or negotiate");
        Text text2 = new Text("");
        Button Fight = new Button("Fight");
        Button items = new Button("Negotiate");
        Fight.setLayoutX(items.getLayoutY()+200);
        items.setLayoutY(LOR.getY()+10);
        Fight.setLayoutY(items.getLayoutY());

        items.setPadding(new Insets(0, 20, 0, 20));
        Fight.setPadding(new Insets(0, 20, 0, 20));
        items.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                LOR.setVisible(false);
                Fight.setDisable(true);
                Fight.setVisible(false);
                items.setDisable(true);
                items.setVisible(false);
                text2.setText("The Wendigo screams ARGAGAFGERGA");
                Bot_UI.getChildren().add(text2);
                Button goback = new Button();
                Bot_UI.getChildren().add(goback);
                goback.setText("Go back");
                goback.setPadding(new Insets(0, 20, 0, 20));
                Bot_UI.setAlignment(goback, Pos.BOTTOM_RIGHT);
                goback.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        LOR.setVisible(true);
                        Fight.setDisable(false);
                        Fight.setVisible(true);
                        items.setDisable(false);
                        items.setVisible(true);
                        LOR.setVisible(true);
                        Bot_UI.getChildren().remove(text2);
                        goback.setVisible(false);
                        goback.setDisable(true);
                        Bot_UI.getChildren().remove(goback);


                    }
                });





            }


        });

        Fight.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                RandomEncounter encounter = new RandomEncounter();
                Scene s1 = null; //talk to a random person pic please
                try {
                    s1 = encounter.createScene(x, hero,3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x.setScene(s1);


            }


        });

        LORGroup.getChildren().addAll(LOR,Fight,items);
        Bot_UI.getChildren().addAll(LORGroup);





//        submit.setTranslateX(charClass.getLayoutX() + 100);


        //Adding the tavern image to the current UI

        Image nxtImage = new Image("sample/Art/Background/Tavern.png", AppSettings.centerUIWidth,
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
