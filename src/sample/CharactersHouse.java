package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Tommy, Mousumi
 */
public class CharactersHouse extends Application {

    private StatsPanelController statConroller;

    @Override
    public void start(Stage primaryStage) {

    }


    ////**
    /// * @param args the command line arguments
    /// */
    public Scene createScene(Stage x, Player hero) {
        System.out.println(("Current file: CharactersHouse"));

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
        Left_Rec.setStroke(Color.BLACK);
        root.setLeft(Left_UI);
        Left_UI.getChildren().add(Left_Rec);
        Left_UI.setAlignment(Left_Rec, Pos.TOP_LEFT);

        Pane newLoadedPane = null;
        try {
            URL fxmlUrl = Tavern.class.getResource("./StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
            statConroller=new StatsPanelController();
            fxmlLoader.setController(statConroller);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);




        //TEXT AND BUTTON's
        ComboBox<String> charClass = new ComboBox<>();


        charClass.getItems().addAll("Wizard", "Peasant", "Knight", "Mercenary");
        charClass.getSelectionModel().selectFirst();

        Button submit = new Button("SET CLASS");
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hero.setClass(charClass.getValue());
                FirstTown town=new FirstTown();
                WalkingInForest forest = new WalkingInForest();
                Scene s1 = forest.createScene(x, hero);// next town pic please
                x.setScene(s1);


            }
        });


        Bot_UI.getChildren().addAll(submit, charClass);
        //Bot_UI.setAlignment(submit,Pos.CENTER_RIGHT);
        submit.setTranslateX(charClass.getLayoutX() + 100);
        submit.setPadding(new Insets(0, 20, 0, 20));


        //Adding the tavern image to the current UI
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Character_Select.png", AppSettings.centerUIWidth,
                AppSettings.centerUIHeight, true, true);

        BackgroundImage myBI= new BackgroundImage(img,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //ImageView Center_ImageView = new ImageView(img);
        Center_UI.setBackground(new Background(myBI));
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);

        return S2;

    }


}