package sample;


import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        primaryStage.setTitle("Excalibur's quest");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
        StackPane Bot_UI = new StackPane();


        //BOTTOM RECTANGLE

            Rectangle Bot_Rec = new Rectangle(750, 100);
            Bot_Rec.setFill(Color.rgb(211, 211, 211));
            Bot_UI.getChildren().add(Bot_Rec);
            root.setBottom(Bot_UI);
            Bot_Rec.setStroke(Color.BLACK);

        //LEFT RECTANGLE
        StackPane Left_UI = new StackPane();
        Rectangle Left_Rec = new Rectangle(100, 400, Color.rgb(211, 211, 211));
        Left_Rec.setStroke(Color.BLACK);
        root.setLeft(Left_UI);
        Left_UI.getChildren().add(Left_Rec);


        Scanner getInput = new Scanner(System.in);


        String heroName ;
        do{
            System.out.println("What is the name of your hero?");
            //heroName = "TEMPORARY_NAME";
            heroName = getInput.nextLine();

        }while(heroName.isEmpty());
        Player hero = new Player(heroName);
        System.out.println("The Player's name is " + hero.getName());

        //TEXT AND BUTTON's

            Group text_Group = new Group();

            int Text_coorY = 10;

            Text text1 = new Text("1) Lorem ipsum dolor sit amet, consectetur adipiscing elit");
            Text text2 = new Text("2) sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
            Text text3 = new Text("3) Ut enim ad minim veniam");
            Text text4 = new Text("4) quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat");
            text_Group.getChildren().addAll(text1, text2, text3, text4);


            text1.setY(Text_coorY);
            text2.setY(Text_coorY + 20);
            text3.setY(Text_coorY + 40);
            text4.setY(Text_coorY + 60);
            Bot_UI.getChildren().add(text_Group);

            Button butt1 = new Button();
            Button butt2 = new Button();
            Button butt3 = new Button();
            Button butt4 = new Button();


            butt1.setPadding(new Insets(0, 20, 0, 20));
            butt2.setPadding(new Insets(0, 20, 0, 20));
            butt3.setPadding(new Insets(0, 20, 0, 20));
            butt4.setPadding(new Insets(0, 20, 0, 20));


            Group butt_Group = new Group();
            butt_Group.getChildren().addAll(butt1,butt2,butt3,butt4);



            Bot_UI.getChildren().add(butt_Group);
            StackPane.setAlignment(butt_Group, Pos.CENTER_RIGHT);



            butt1.setLayoutY(Text_coorY);
            butt2.setLayoutY(Text_coorY + 20);
            butt3.setLayoutY(Text_coorY + 40);
            butt4.setLayoutY(Text_coorY + 60);


        butt1.setText("Wizard");
        butt1.setOnAction(actionEvent -> hero.setClass("wizard"));

        butt2.setText("Knight");
        butt2.setOnAction(actionEvent -> hero.setClass("knight"));

        butt3.setText("mercenary");
        butt3.setOnAction(actionEvent -> hero.setClass("mercenary"));

        butt4.setText("peasant");
        butt4.setOnAction(actionEvent -> hero.setClass("peasant"));

        //Adding the tavern image to the current UI
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Tavern.PNG", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);









    }


    public static void main(String[] args) {
        launch(args);
    }


}

