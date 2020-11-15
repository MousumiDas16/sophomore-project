package sample;


import javafx.application.Application;
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

        Main.mainStage = primaryStage;
        System.out.println(("Current file: Main"));
        hero = new Player();
        hero.setClass("wizard");
        MainMenu firstMenu=new MainMenu();
        Scene s1 = firstMenu.getScene(primaryStage,hero);

        //pyramid fv = new pyramid();
        //Scene s1 = fv.createScene(primaryStage , hero);




        //AbandondedCamp ruin = new AbandondedCamp();
        //Scene s1 = ruin.createScene(primaryStage, hero);



        primaryStage.setTitle("Excalibur's Quest");
        primaryStage.setScene(s1);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }


}

