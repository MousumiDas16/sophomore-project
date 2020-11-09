package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class YouDiedIdiot extends Application {

    public static Scene main(Stage x, Player hero) {
        BorderPane root = new BorderPane();
        Image img = new Image("sample/Art/Background/Death_Screen.png", AppSettings.screenWidth,
                AppSettings.screenHeight, true, true);
        ImageView deadfool = new ImageView(img);
        root.getChildren().add(deadfool);
        Scene dead = new Scene(root,AppSettings.screenWidth,AppSettings.screenHeight);
        return dead;
    }

    @Override
    public void start(Stage primaryStage) {




    }
}
