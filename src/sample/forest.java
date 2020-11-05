package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Random;

public class forest extends Application {
    @Override
    public void start(Stage primaryStage) {

    }

    static int i;
    public static Scene main(Stage x, Player hero) throws InterruptedException {
        System.out.println(("Current file: Forest"));

        for (i =0; i>3;i++) {
            Thread.sleep(3000);

            Random rand = new Random();


            int k = rand.nextInt(4);
            System.out.println(k);
            switch (k) {
                case 0:
                    Scene s3 = RandomEncounterOne.main(x, hero);
                    x.setScene(s3);
                    break;
                case 1:
                    Scene s4 = RandomEncounterTwo.main(x, hero);
                    x.setScene(s4);
                    break;
                case 2:
                    Scene s5 = RandomEncounterThree.main(x, hero);
                    x.setScene(s5);
                    break;
                case 3:
                    break;
            }


        }






            Button Rest = new Button();
            Button Continue = new Button();
            Continue.setText("Continue");
            Rest.setText("Rest");
            Rest.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent event) {
                    int f = hero.getFood() - 15;
                    hero.setFood(f);
                    int h = hero.getHealth() + 20;
                    hero.setHealth(h);


                }

            });
        Scene s1 = CharactersHouse.main(x, hero); // next town pic please
        return s1;
        }











    }



