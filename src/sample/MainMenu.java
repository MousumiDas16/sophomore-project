package sample;

import java.util.List;

import javafx.animation.PauseTransition;
import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * @author Tommy
 */
public class MainMenu extends Application {

    @Override
    public void start(Stage primaryStage) {


    }


    public static Scene main(Stage x, Player hero) {
        System.out.println(("Current file: MainMenu"));

        int y = 0;

        StackPane root = new StackPane();


        Image img = new Image("sample/Art/Background/Title_Screen.png", 750, 500, true, true);

        ImageView welcome = new ImageView(img);

        root.getChildren().add(welcome);
        Scene hello = new Scene(root,750,500);
        PauseTransition pause = new PauseTransition(Duration.seconds(4));
        pause.setOnFinished(event ->{
            root.getChildren().remove(welcome);
            Label q1 = new Label("What is your name?");
            TextField name = new TextField();
            EventHandler<ActionEvent> eevent = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent entername) {
                    hero.setName(name.getText());
                    Scene s1 = Opening.main(x, hero);
                    x.setScene(s1);
                    System.out.println(hero.getName());
                }
            };
            name.setOnAction(eevent);

            Group text = new Group();
            text.getChildren().addAll(q1, name);
            root.getChildren().add(text);

            name.setLayoutY(y + 20);
        });
        pause.play();








        return hello;
    }

}