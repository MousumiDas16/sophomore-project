package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CharacterHouseIntro {
    static int next = 0;

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
        words.add("The protagonist leaves the brewery drunk on\nideas of adventure and excitement.\nLater, after further contemplating the\nstory of the sword, they conclude \nthat they are the King reborn…");
        words.add("Whether or not our protagonist is\nthe King returned is not important yet, \nwhat is important is that they were \nleaving their tired old village and \nsetting forth to the Dragon’s Claw.");
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

                    Scene s1 = CharactersHouse.main(x, hero);// next town pic please
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
