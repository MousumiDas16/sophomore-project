package sample;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Thanks {
    static int next = 0;


    public void start(Stage primaryStage) {


    }


    public Scene createScene(Stage x, Player hero) {
        System.out.println(("Current file: Opening"));

        int y = 0;

        StackPane root = new StackPane();
        Rectangle rec = new Rectangle(AppSettings.screenWidth, AppSettings.screenHeight);
        rec.setFill(Color.BLACK);
        root.getChildren().add(rec);



        ArrayList<String> words = new ArrayList<>();
        words.add("   Thanks for Playing!\n" +
                "       We love you");

        Text Line1 = new Text();
        root.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setFill(Color.WHEAT);
        Line1.setFont( Font.font("Verdana", FontWeight.BOLD, 18));


        // Image img = new Image("sample/Art/Background/arrow.png", 100, 100, true, true);
        //ImageView nxtView = new ImageView(img);
        //nxtView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        //          @Override
        //        public void handle(MouseEvent event) {
        //          System.out.println("Next pressed ");
        //        next++;
        //      if(next <= words.size() -1){
        //      Line1.setText(words.get(next));
        //    }else{
        //    Tavern scene=new Tavern();
        //Scene s1 = scene.getScene(x, hero);// next town pic please
        //  x.setScene(s1);
        // }
        //event.consume();
        // }

        // });

        //nxtView.setTranslateX(Line1.getX()+120);
        //nxtView.setTranslateY(Line1.getY()+ 160);
        //root.getChildren().add(nxtView);

        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);

        return S2;



    }
}
