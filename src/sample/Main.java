package sample;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.stage.Stage;

//import javafx.scene.control.TextField;


public class Main extends Application {

    static public Player hero;
    private Label lblHealth, lblMoney, lblStrength, lblSpeed, lblCharisma, lblPotions, lblArmor, lblClass, lblName;
    private Text lblCharacterDescription;
    private Stage appStage;
    private ShopUI shop;
    public static Stage mainStage;


    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        primaryStage.fullScreenProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> prop, Boolean wasIconified, Boolean isIconified) {
                System.out.println("ignore fullscreen");
            }
        });

        Main.mainStage = primaryStage;
        System.out.println(("Current file: Main"));
        hero = new Player();
        hero.setClass("mercenary");
        Fort2 fort = new Fort2();
        MainMenu firstMenu=new MainMenu();
        HydraIntro hy = new HydraIntro();
        CastleBattle camp = new CastleBattle();

        Scene s1 = fort.createScene(primaryStage, hero);





        //FishingVillage fv = new FishingVillage();
        //Scene s1 = fv.createScene(primaryStage , hero);







        primaryStage.setTitle("Swords of Origin");
        primaryStage.setScene(s1);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


}

