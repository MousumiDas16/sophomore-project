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
import javafx.stage.Window;

/**
 * @author Tommy, Mousumi
 */
public class Opening extends Application {
    static int next = 0;

    @Override
    public void start(Stage primaryStage) {


    }


    public Scene getScene(Stage x, Player hero) {
        System.out.println(("Current file: Opening"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(AppSettings.screenWidth, AppSettings.screenHeight);
        rec.setFill(Color.BLACK);
        root.getChildren().add(rec);



        ArrayList<String> words = new ArrayList<>();
        words.add("In the Elderbrew tavern, \na mysterious traveling woman \ninforms a young villager about \n an ancient legend….");
        words.add("In a cave atop Dragon’s Claw, an old \nand malformed mountain formation,\nthere rests a blade of unparalleled power.\n"+
                "The one who finds such a weapon will be\nrenowned across the land and will\n be made KING!!!\n" +
                "\nThe sword is the rightful relic of the Old \n King and his reincarnates…");
        Text Line1 = new Text();
        root.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.WHEAT);
        Line1.setFont( Font.font("Verdana", FontWeight.BOLD, 18));


        Image img = new Image("sample/Art/Background/arrow.png", 100, 100, true, true);
        ImageView nxtView = new ImageView(img);
        nxtView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.println("Next pressed ");
                        next++;
                        if(next <= words.size() -1){
                            Line1.setText(words.get(next));
                        }else{
                            Tavern scene=new Tavern();
                            Scene s1 = scene.getScene(x, hero);// next town pic please
                            x.setScene(s1);
                        }
                        event.consume();
                    }

                });

        nxtView.setTranslateX(Line1.getX()+120);
        nxtView.setTranslateY(Line1.getY()+ 160);
        root.getChildren().add(nxtView);

        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);

        return S2;



    }

}