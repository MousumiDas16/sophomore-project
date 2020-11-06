package sample;

import java.util.ArrayList;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * @author Tommy
 */
public class Opening extends Application {
    static int next = 0;

    @Override
    public void start(Stage primaryStage) {


    }


    public static Scene main(Stage x, Player hero) {
        System.out.println(("Current file: Opening"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(750, 500);
        rec.setFill(Color.BLACK);
        root.getChildren().add(rec);



        ArrayList<String> words = new ArrayList<>();
        words.add("Hi i am Jimmy cool codey guy");
        words.add("Jimmy is now big sad boy.");
        Text Line1 = new Text();
        root.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.WHEAT);
        Button submit = new Button("NEXT");
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                next++;
                if(next <= words.size() -1){
                    Line1.setText(words.get(next));
                }else{

                    Scene s1 = Tavern.main(x, hero);// next town pic please
                    x.setScene(s1);
                }



            }

            ;

        });
        submit.setTranslateX(Line1.getX()+ 200);
        root.getChildren().add(submit);

        Scene S2 = new Scene(root, 750, 500);

        return S2;



    }

}