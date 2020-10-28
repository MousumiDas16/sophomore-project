package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopUI extends Application {
   // private static Player hero;
    private  Stage x;

    @FXML
    private Label lblMoney, lblHealth, lblPotions, lblSpeed, lblCharisma, lblArmor, lblStrength;



    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        updateStats();
    }
    public void handleButtonReturntoTarvern(ActionEvent event){
        Scene s1 = FirstTown.main(Main.mainStage  ,Main.hero);// next town pic please
        Main.mainStage.setScene(s1);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./ShopUI.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //updateStats();
    }
     public   ShopUI( ){


     }



    public static Scene main(Stage primaryStage, Player hero) throws IOException {
        Parent root = FXMLLoader.load(ShopUI.class.getResource("./ShopUI.fxml"));
        //ShopUI.hero=Main.hero;



        Scene shopScene=new Scene(root);
        primaryStage.setScene(shopScene);
        primaryStage.show();
        return shopScene;



    }
    public  void updateStats(){

        lblHealth.setText("Health: "+ Main.hero.getHealth());
        lblArmor.setText("Armor: "+ Main.hero.getArmor());
        lblPotions.setText("Potions: "+ Main.hero.getPotions());
        lblMoney.setText("Money: "+ Main.hero.getMoney());
        lblSpeed.setText("Speed: "+ Main.hero.getSpeed());
        lblCharisma.setText("Charisma: "+ Main.hero.getCharisma());
        lblStrength.setText("Strength: "+ Main.hero.getStrength());

    }

}