package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ShopUI extends Application {
    private  Player hero;

    @FXML
    private Label lblMoney, lblHealth, lblPotions, lblSpeed, lblCharisma, lblArmor, lblStrength;



    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        //updateStats();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./ShopUI.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //updateStats();
    }
     public   ShopUI( ){

        hero.setClass("knight");

     }

    public static void main(String[] args) {
        launch(args);
    }


   // public  void updateStats(){
//
   //     lblHealth.setText("Health: "+ hero.getHealth());
   //     lblArmor.setText("Armor: "+ hero.getArmor());
   //     lblPotions.setText("Potions: "+ hero.getPotions());
   //     lblMoney.setText("Money: "+ hero.getMoney());
   //     lblSpeed.setText("Speed: "+ hero.getSpeed());
   //     lblCharisma.setText("Charisma: "+ hero.getCharisma());
   //     lblStrength.setText("Strength: "+ hero.getStrength());
//
   // }

}