package sample;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Tommy, Mousumi
 */
public class MainMenu extends Application {

    @Override
    public void start(Stage primaryStage) {


    }


    public  Scene getScene(Stage x, Player hero) {
        System.out.println(("Current file: MainMenu"));

        int y = 0;

        StackPane root = new StackPane();


        Image img = new Image("sample/Art/Background/Title_Screen.png",
                AppSettings.screenWidth, AppSettings.screenHeight, true, true);

        ImageView welcome = new ImageView(img);

        root.getChildren().add(welcome);
        Scene hello = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.2));
        pause.setOnFinished(event -> {
            root.getChildren().remove(welcome);
            Label q1 = new Label(" Howdy, Explorer! What should I call you?");
            Font myFont = Font.font("Verdana", FontWeight.BOLD, 16);
            q1.setFont(myFont);
            q1.setTextFill(Color.CRIMSON);
            TextField name = new TextField();
            name.setMinWidth(300.0);
            name.setMinHeight(30);
            name.setFont(myFont);
            EventHandler<ActionEvent> eevent = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent entername) {
                    String heroName=name.getText();
                    if(heroName==null ||heroName=="" ||heroName.length()==0)
                        return;
                    hero.setName(heroName.toUpperCase());
                    Opening intro=new Opening();
                    Scene s1 = intro.getScene(x, hero);
                    x.setScene(s1);
                    System.out.println(hero.getName());
                }
            };
            name.setOnAction(eevent);

            Group text = new Group();
            text.getChildren().addAll(q1, name);
            root.getChildren().add(text);
            root.setStyle("-fx-background-color:rgba(10, 10, 10, 1)");

            name.setLayoutY(y + 40);

        });
        pause.play();


        return hello;
    }

}