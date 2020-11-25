package sample;

import javafx.event.EventHandler;
import javafx.scene.Scene;
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

public class EndingIntro {
    static int next = 0;

    public void start(Stage primaryStage) {


    }


    public static Scene getScene(Stage x, Player hero) {
        hero.setScene("EndingIntro");
        System.out.println(("Current file: EndingIntro"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(AppSettings.screenWidth, AppSettings.screenHeight);
        rec.setFill(Color.BLACK);
        root.getChildren().add(rec);



        ArrayList<String> words = new ArrayList<>();
        words.add("The Protagonist finds the drawbridge down and\nnot a soul around. They enter the castle now a\nderelict colossus of an ancient age. The Old Castle\nwas once the seat of the kings of the Old");
        words.add("Lineage. Descendants of the True King, they\nwould be born, live, have families and grow old\nhere in this place. Now the only residents were spiders and mice.");
        words.add("A sort of sadness fell over The Protagonist as\nthey entered this oddly familiar place.");
        words.add("They quickly made their way to the entrance to the Dragon’s Claw.");
        words.add("The climb to the top was long and arduous.\nHowever, The Protagonist endured and reached\nthe top of Dragon’s Claw.");

        Text Line1 = new Text();
        root.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setFill(Color.WHEAT);
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
                    EndingIntro2 house=new EndingIntro2();
                    Scene s1 = house.createScene(x, hero);
                    x.setScene(s1);
                }
                event.consume();
            }

        });
        nxtView.setTranslateX(Line1.getX()+250);
        nxtView.setTranslateY(Line1.getY()+ 150);

        root.getChildren().add(nxtView);

        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);

        return S2;



    }
}
