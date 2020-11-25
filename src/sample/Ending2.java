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

public class Ending2 {
    static int next = 0;
    public void start(Stage primaryStage) {


    }
    public  Scene getScene(Stage x, Player hero) {
        hero.setScene("Ending2");
        System.out.println(("Current file: EndingIntro"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(AppSettings.screenWidth, AppSettings.screenHeight);
        rec.setFill(Color.BLACK);
        root.getChildren().add(rec);



        ArrayList<String> words = new ArrayList<>();
        words.add("The sword gleamed with the crimson color of fire.\nThe Protagonist felt uneasy. Soon the\nfeeling came, the desire for everything!");
        words.add("Lady Wisp: That was not the correct choice,\nI am sorry my friend, but you picked the sword\nof greed and gluttony.\nYou have left me no choice but to seal you within\nthis place so your hunger will not tarnish this world!”");
        words.add("The wisp recited an ancient curse and the stone changed\nfrom walls to arms and surrounded The Protagonist.\nThey felt nothing but want and did not even\nnotice the bindings of stone. They clutched\ntheir sword so tightly their hands bled.");
        words.add("The wisp left them there to waste away.\nShe would search for them again when they had reincarnated.\nMaybe one day the True Monarch would return…");

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
