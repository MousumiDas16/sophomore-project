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

public class Ending3 {
    static int next = 0;
    public void start(Stage primaryStage) {


    }
    public static Scene main(Stage x, Player hero) {
        hero.setScene("Ending3");
        System.out.println(("Current file: EndingIntro"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(AppSettings.screenWidth, AppSettings.screenHeight);
        rec.setFill(Color.BLACK);
        root.getChildren().add(rec);



        ArrayList<String> words = new ArrayList<>();
        words.add("The sword came loose easily, as if it\nhad been wanting to be pulled from the stone.\nThe Protagonist felt no different.");
        words.add("Lady Wisp: “Congratulations, Your Grace.\nYou have been reunited with your true weapon,\nThe Sword of the King! Truly, the sword is not magical,");
        words.add("to pick it shows that you embody the virtues the\nFirst King held in high regard. That is nothing\nmore than an old steel sword, and it was his but has wasted away\nin these centuries since his last heir’s death.”");
        words.add("The True Monarch descended the Dragon’s Claw\nand sat their rightful throne, in the Old Castle.\nThey then began their work to unite the kingdom and return it to glory…");

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
