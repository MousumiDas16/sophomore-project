package sample;

import java.util.List;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

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
        Label q1 = new Label("What is your name?");
        TextField name = new TextField();
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent entername) {
                hero.setName(name.getText());
                Scene s1 = Tavern.main(x, hero);
                x.setScene(s1);
                System.out.println(hero.getName());
            }
        };
        name.setOnAction(event);

        Group text = new Group();
        text.getChildren().addAll(q1, name);
        root.getChildren().add(text);

        name.setLayoutY(y + 20);


        Scene scene = new Scene(root, 750, 500);
        return scene;
    }

}