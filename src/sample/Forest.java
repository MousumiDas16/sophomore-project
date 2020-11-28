package sample;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Forest extends Application {

    StatsPanelController statController;
    @Override
    public void start(Stage primaryStage) {

    }


    public Scene createScene(Stage x, Player hero) throws InterruptedException {

        System.out.println("Current file: forest");

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
        Rectangle Left_Rec = new Rectangle(AppSettings.leftUIWidth,
                AppSettings.leftUIHeight, Color.rgb(211, 211, 211));
        //Left_Rec.setStroke(Color.BLACK);
        root.setLeft(Left_UI);

        Pane newLoadedPane = null;
        try {
            URL fxmlUrl = Tavern.class.getResource("./StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
            statController=new StatsPanelController();
            fxmlLoader.setController(statController);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        Left_UI.getChildren().add(newLoadedPane);



        Group text_Group = new Group();

        int Text_coorY = 10;

        Text text1 = new Text("1) Attack");
        Text text2 = new Text("2) Negotiate ");
        Text text3 = new Text("3) RUNNNN");
        Text text4 = new Text("4) Use Health Potion");
        text_Group.getChildren().addAll(text1, text2, text3, text4);


        text1.setY(Text_coorY);
        text2.setY(Text_coorY + 20);
        text3.setY(Text_coorY + 40);
        text4.setY(Text_coorY + 60);
        Bot_UI.getChildren().add(text_Group);

        StackPane Center_UI = new StackPane();









        // loop count from hero

        int loop = hero.getLoopcount();


        if (hero.getLoopcount() < 3) {
            loop= loop +1;
            hero.setLoopcount(loop);
            RandomEncounter encounter =new RandomEncounter();
            Scene s1 = encounter.createScene(x, hero,5);// next town pic please
            x.setScene(s1);
            System.out.println("the loop number is" +hero.getLoopcount());
            return s1;






        }
        else if(hero.getLoopcount()==3){
            text1.setText("you made it to the next location!");
            text2.setText("Press continue to enter!");
            text3.setText("");
            text4.setText("");
            Button cont = new Button();
            cont.setText("continue");
            cont.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {
                    if(hero.getScene().equalsIgnoreCase("WalkingInForest")){
                        Fort1 firstFort=new Fort1();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("ToVillage3")){
                        Village3 firstFort=new Village3();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("ToVillage4")){
                        Village4 firstFort=new Village4();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("ToVillage5")){
                        Village5 firstFort=new Village5();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("tocave1")){
                        Cave1 firstFort=new Cave1();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("tocave2")){
                        Cave2Cutscene firstFort=new Cave2Cutscene();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("toFishingVillage")){
                        FishingVillage firstFort=new FishingVillage();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("tofort2")){
                        Fort2 firstFort=new Fort2();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("tohydra")){
                        HydraIntro firstFort=new HydraIntro();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("tooasis")){
                        Oasis firstFort=new Oasis();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("tooldruins")){
                        OldRuins firstFort=new OldRuins();
                        Scene s1 = firstFort.getScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("tosphinx")){
                        IntroSphinxBattle firstFort=new IntroSphinxBattle();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }else if(hero.getScene().equalsIgnoreCase("ToVillage2")){
                        Village2 firstFort=new Village2();
                        Scene s1 = firstFort.createScene(x, hero);
                        x.setScene(s1);

                    }




                }



            }  )  ;

            Bot_UI.setAlignment(cont, Pos.BOTTOM_RIGHT);
            Bot_UI.getChildren().add(cont);
        }

        if(hero.getScene().equalsIgnoreCase("WalkingInforest") || hero.getScene().equalsIgnoreCase("tovillage2")
        || hero.getScene().equalsIgnoreCase("tovillage3") || hero.getScene().equalsIgnoreCase("toVillage4")
        ||hero.getScene().equalsIgnoreCase("tovillage5") || hero.getScene().equalsIgnoreCase("tocave1")
        || hero.getScene().equalsIgnoreCase("tocave2") || hero.getScene().equalsIgnoreCase("tohydra")
        || hero.getScene().equalsIgnoreCase("toabandonedcamp") || hero.getScene().equalsIgnoreCase("tofort2")
        || hero.getScene().equalsIgnoreCase("tocastlebattle") || hero.getScene().equalsIgnoreCase("ToFishingVillage"))  {
             Image img = new Image("sample/Art/Background/Forrest_Walking.png", AppSettings.centerUIWidth,
                    AppSettings.centerUIHeight, true, true);

            Image img2 = hero.getImage(1);
            ImageView Center_ImageView = new ImageView(img);
            ImageView Character = new ImageView(img2);
            Center_UI.getChildren().addAll(Center_ImageView,Character);

            root.setCenter(Center_UI);
        }else if(hero.getScene().equalsIgnoreCase("toOasis") || (hero.getScene().equalsIgnoreCase("toSphinx")) ){
            Image img = new Image("sample/Art/Background/Desert_Walking.png", AppSettings.centerUIWidth,
                    AppSettings.centerUIHeight, true, true);

            Image img2 = hero.getImage(1);
            ImageView Center_ImageView = new ImageView(img);
            ImageView Character = new ImageView(img2);
            Center_UI.getChildren().addAll(Center_ImageView,Character);

            root.setCenter(Center_UI);

        }







        hero.setLoopcount(0);
        System.out.println(hero.getLoopcount());


        Scene S1 = new Scene(root, AppSettings.screenWidth, AppSettings.screenHeight);
        return S1;

        }











    }



