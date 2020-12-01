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
import javafx.scene.input.MouseEvent;
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

public class IntroCave1 {
    static int next = 0;
    private StatsPanelController statController;

    public void start(Stage primaryStage) {


    }


    public Scene createScene(Stage x, Player hero) {

        System.out.println(("Current file: IntroCave1"));


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
        words.add("The protagonist arrives at the cave and finds a troll. They are approached by the massive creature.\n" +
                "Boss: “Aye ye, what is the likes of yous doing here? We were just minding ours own businesses.\nYou DIEEEEEE!!!!!!” He seems to believe there is more than one of him...");

        Text Line1 = new Text();
        //positioning text

        Bot_UI.getChildren().add(Line1);
        Line1.setText(words.get(next));
        Line1.setStroke(Color.BLACK);

        Image imgNext = new Image("sample/Art/Background/arrow.png", 100, 100, true, true);
        ImageView nxtView = new ImageView(imgNext);
        nxtView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                next++;
                if(next <= words.size() -1){
                    Line1.setText(words.get(next));
                }else{
                    Cave1 fishingVillage = new Cave1();
                    Scene s1 = null;
                    s1 = fishingVillage.createScene(x, hero);
                    x.setScene(s1);
                }
                //need to have sprite transition when the story demands
                event.consume();
            }

        });

        nxtView.setTranslateX(Line1.getX()+280);

        Bot_UI.getChildren().addAll(nxtView);



        //add town 1 image whenever we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/TEMPbackgroud.png", 650, 400, true, true);
        Image img2 = new Image("sample/Art/Characters/Ogre.gif", 300, 300, true, true);
        ImageView Center_ImageView = new ImageView(img);
        ImageView Character = new ImageView(img2);
        Center_UI.getChildren().addAll(Center_ImageView,Character);
        Center_UI.setAlignment(Character, Pos.BOTTOM_CENTER);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);
        return S2;
    }
}
