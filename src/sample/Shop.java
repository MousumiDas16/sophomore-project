package  sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tommy
 */
public class Shop extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    ///**
    // * @param args the command line arguments
    // */
    public static Scene main(Stage x, Player hero) {
        BorderPane root = new BorderPane();

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




        //TEXT AND BUTTON's

        Group text_Group = new Group();

        int Text_coorY = 10;

        Text text1 = new Text("1) Buy health potion");
        Text text2 = new Text("2) buy stat boost.");
        Text text3 = new Text("3) buy food");
        Text text4 = new Text("4) buy clothes");
        Text text5 = new Text("5) leave shop");
        text_Group.getChildren().addAll(text1, text2, text3, text4 , text5);


        text1.setY(Text_coorY);
        text2.setY(Text_coorY + 20);
        text3.setY(Text_coorY + 40);
        text4.setY(Text_coorY + 60);
        text4.setY(Text_coorY + 80);
        Bot_UI.getChildren().add(text_Group);

        //get character money for shop
        double money = hero.getMoney();
        //health potion

        Button b1 = new Button();
        b1.setText("1");
        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (money > 5){
                    hero.AddPotion();
                    hero.setMoney(money - 7);
                }







            }



        });
        //stat booster
        Button b2 = new Button();
        b2.setText("2");
        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (money > 15){
                    hero.addStatboost();
                    hero.setMoney(money - 15);
                }

            }



        });
        //food
        Button b3 = new Button();
        b3.setText("3");
        b3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (money > 5){
                    hero.addStatboost();
                    hero.setMoney(money - 5);
                }


            }



        });
        //clothes
        Button b4 = new Button();
        b4.setText("4");
        b4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (money > 8){
                    hero.addStatboost();
                    hero.setMoney(money - 8);
                }
            }





        });
        //leave the shop
        Button b5 = new Button();
        b5.setText("5");
        b5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Scene s1 = Tavern.main(x,hero); // get a diff image if u want
                x.setScene(s1);


            }





        });


        b1.setPadding(new Insets(0, 20, 0, 20));
        b2.setPadding(new Insets(0, 20, 0, 20));
        b3.setPadding(new Insets(0, 20, 0, 20));
        b4.setPadding(new Insets(0, 20, 0, 20));
        b5.setPadding(new Insets(0, 20, 0, 20));

        Group butt_Group = new Group();
        butt_Group.getChildren().addAll(b1,b2,b3,b4,b5);



        Bot_UI.getChildren().add(butt_Group);
        StackPane.setAlignment(butt_Group, Pos.CENTER_RIGHT);



        b1.setLayoutY(Text_coorY);
        b2.setLayoutY(Text_coorY + 20);
        b3.setLayoutY(Text_coorY + 40);
        b4.setLayoutY(Text_coorY + 60);
        b5.setLayoutY(Text_coorY + 80);

        //add shop image when we get it
        StackPane Center_UI = new StackPane();
        Image img = new Image("sample/Art/Background/Tavern.PNG", 650, 400, true, true);
        ImageView Center_ImageView = new ImageView(img);
        Center_UI.getChildren().add(Center_ImageView);
        root.setCenter(Center_UI);
        Scene S2 = new Scene(root,750,500);
        return S2;

    }
}
