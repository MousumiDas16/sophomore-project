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

public class IntroSphinxBattle {
    static int next = 0;
    private StatsPanelController statController;

    public void start(Stage primaryStage) {


    }


    public Scene createScene(Stage x, Player hero) {

        System.out.println(("Current file: IntroSphinxBattle"));

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
        words.add("The protagonist entered the pyramid. Weary of all the traveling they hoped no more conflict would come their way…");
        words.add("Sphinx: “WHO GOES THERE…There…there…there?”\n" + "A loud echoing voice booms of the walls. The sound was coming from deeper inside.");
        words.add("Sphinx: “Welcome unexpected visitor… I am known as the Sphinx! I had a name other than that\n" +
                "long ago but, in my solitude, I have since forgotten it. My head only swarms with riddles and\n" +
                "mysteries now. I have no need for names, so do not bother me with yours.");
        words.add("Lady Wisp: “Great beast can you not see? This is the true Monarch returned again.”\n");
        words.add("Sphinx: “Silence creature. I do not care about the bloodline anymore… I live only for games. I\n" + "now know why you dared to come here but know I will not let you pass…\"");
        words.add("\"unless you answer my riddles correctly. If you do not, I will be done with you and dispose of you as is my purpose.\"");

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

                    sphinx sphin = new sphinx();
                    Scene s1 = null;
                    //uncomment later
                    //s1 = sphin.createScene(x, hero);
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
        Image img = new Image("sample/Art/Background/TEMPfishingVillage.PNG", 650, 400, true, true);// need pyramid interior background
        Image img2 = new Image("sample/Art/Characters/Sphinx.PNG", 200, 100, true, true);
        ImageView Center_ImageView = new ImageView(img);
        ImageView Character = new ImageView(img2);
        Center_UI.getChildren().addAll(Center_ImageView,Character);
        Center_UI.setAlignment(Character, Pos.BOTTOM_CENTER);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);
        return S2;
    }
}