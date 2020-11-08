package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        Line1.setFont( Font.font("Verdana", FontWeight.BOLD, 18));


        Image img = new Image("sample/Art/Background/arrow.png", 80, 80, true, true);
        ImageView nxtView = new ImageView(img);
        nxtView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Next pressed ");
                next++;
                if (next <= words.size() - 1) {
                    Line1.setText(words.get(next));
                } else {
                    Scene s1 = CharactersHouse.main(x, hero);
                    x.setScene(s1);
                }
                event.consume();
            }

        });
        nxtView.setTranslateX(Line1.getX()+250);
        nxtView.setTranslateY(Line1.getY()+ 150);

        root.getChildren().add(nxtView);

        Scene S2 = new Scene(root, 750, 500);

        return S2;



    }
}
