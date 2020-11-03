package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Opening extends Application {
    static int next = 0;
    public static Scene main(Stage x, Player hero) {
        System.out.println(("Current file: MainMenu"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(750,500);
        rec.setFill(Color.BLACK);

        Button submit = new Button("NEXT");
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                next++;


            };

        });
        ArrayList<String> words = new ArrayList<>();
        words.add("Hi i am Jimmy cool codey guy");
        words.add("Jimmy is now big sad boy.");
        Text Line1 = new Text();
        root.getChildren().add(Line1);
        while(next < 2) {
            Line1.setText(words.get(next));


        };




        Scene scene = new Scene(root, 750, 500);
        return scene;
    }



    @Override
    public void start(Stage primaryStage) {

    }
}
