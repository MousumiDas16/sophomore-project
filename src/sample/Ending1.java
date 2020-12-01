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

public class Ending1 {
    static int next = 0;
    public void start(Stage primaryStage) {


    }
    public  Scene getScene(Stage x, Player hero) {
        hero.setScene("Ending1");
        System.out.println(("Current file: EndingIntro"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(AppSettings.screenWidth, AppSettings.screenHeight);
        rec.setFill(Color.BLACK);
        root.getChildren().add(rec);



        ArrayList<String> words = new ArrayList<>();
        words.add("The Protagonist drew the beautiful blade from the ground…\nThen! A terrible shaking began to occur, and\nthe side of the mountain crumbled away…");
        words.add("Then sun was rising on a new day.\nThe Protagonist looked out over the lands they now ruled…\n and hated.");
        words.add("Lady Wisp: “No you fool, how could you not\nsee that it was not the true sword. A worthy\nmonarch would have seen the correct choice. You have picked\nthe sword of malice, you must pu…!?”");
        words.add("The Protagonist slashed the wisp to pieces to silence its scolding.\nThe New Monarch would conquer these lands and\ndestroy all its inhabitants, monsters, and people alike.\nThey hated them all…");

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
                    Thanks house=new Thanks();
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
