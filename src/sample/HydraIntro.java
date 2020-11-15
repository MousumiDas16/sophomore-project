package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class HydraIntro {
    static int next = 0;
    private StatsPanelController statController;

    public void start(Stage primaryStage) {


    }


    public Scene createScene(Stage x, Player hero) {

        System.out.println(("Current file: HydraIntro"));

        BorderPane root = new BorderPane();

        StackPane Bot_UI = new StackPane();


        //BOTTOM RECTANGLE

        Rectangle Bot_Rec = new Rectangle(AppSettings.screenWidth, AppSettings.bottomUIHeight);
        Bot_Rec.setFill(Color.rgb(211, 211, 211));
        Bot_UI.getChildren().add(Bot_Rec);
        root.setBottom(Bot_UI);
        Bot_Rec.setStroke(Color.BLACK);

        //LEFT RECTANGLE

        StackPane Left_UI = new StackPane();
        Rectangle Left_Rec = new Rectangle(AppSettings.leftUIWidth, AppSettings.leftUIHeight,
                Color.rgb(211, 211, 211));
        //Left_Rec.setStroke(Color.BLACK);
        root.setLeft(Left_UI);
        Pane newLoadedPane = null;
        try {
            URL fxmlUrl = Tavern.class.getResource("./StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
            statController = new StatsPanelController();
            fxmlLoader.setController(statController);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);

        //
        int y = 0;

        StackPane Root = new StackPane();


        //Jimmy Story
        ArrayList<String> words = new ArrayList<>();
        words.add("Outside the old castle the Protagonist found the Hydra waiting in the moat that protects the bridge.\n");
        words.add("Hydra: “Welcomeeee, I can smell the oooold blood in youuuu. You must seek the mountain\nI protecttttt, and its secret…. Yesssss?”\n");
        words.add("The Hydra is immense, far to great to slay it all, the Protagonist must here the creature out or\n" +
                "surely face demise.\n");
        words.add("Hydra: “By my respect for your lineageeeee, I will give youuuuu a choice. If you can cut one of \n" +
                "my heads off, I’lllll let you passssss. A true Monarch would be able to vanquish one head of \n" +
                "mine surely. But, a true Monarch would also know to sacrifice their wealth for their kingdom, for\n");
        words.add("their peoplllllle. Everyone has a price, even one as great as I. I’ll accept everything you own but \n" +
                "your horse and weapons as they serve me no purpossssssee. I cannot guarantee you won’t \n" +
                "need these items at the Dragon’s Claw but that is my offer. Tempting….yessssss?”\n");

        Text Line1 = new Text();
        //positioning text

        Bot_UI.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.BLACK);
        Button submit = new Button("NEXT");
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                next++;
                if (next <= words.size() - 1) {
                    Line1.setText(words.get(next));
                } else {

                    FishingVillage fishingVillage = new FishingVillage();//goes to hydra battle
                    Scene s1 = null;
                    s1 = fishingVillage.createScene(x, hero);
                    x.setScene(s1);
                }
                //need to have sprite transition when the story demands


            }

            ;

        });
        Bot_UI.getChildren().addAll(submit);

        Bot_UI.setAlignment(submit, Pos.CENTER_RIGHT);
        submit.setPadding(new Insets(0, 20, 0, 20));

        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/TEMPfishingVillage.PNG", 650, 400, true, true);// need castle exterior
        Image img2 = new Image("sample/Art/Characters/", 200, 100, true, true);//need hydra
        ImageView Center_ImageView = new ImageView(img);
        ImageView Character = new ImageView(img2);
        Center_UI.getChildren().addAll(Center_ImageView,Character);
        Center_UI.setAlignment(Character, Pos.BOTTOM_CENTER);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);
        return S2;
    }
}