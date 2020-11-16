package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ShopUI extends Application implements Initializable {
   // private static Player hero;
    private  Stage x;
    static int armorboost= 0;
    static int speedboost= 0;
    static int chraismaboost = 0;
    static int strengthboost= 0;

    @FXML
    private StackPane leftUI;
    @FXML
    private Label lblPurchaseStatus;
    StatsPanelController sController;

    @FXML
    Button btnchaboost,btnpotion, spdboost, btnArmor,  btnStrength,donate;

    //Text purchaseStatus = new Text("1) Go to the Shop");

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Pane newLoadedPane = null;
        try {
            URL fxmlUrl = Tavern.class.getResource("./StatsPane.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
            sController=new StatsPanelController();
            fxmlLoader.setController(sController);
            newLoadedPane = fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }


        leftUI.getChildren().add(newLoadedPane);



        System.out.println("Init tavern");
    }


    @FXML
    private void handPurchaseItem(ActionEvent event) {
        Item toPurchase=null;
        if(event.getSource().equals(btnchaboost)){
            if (chraismaboost==0){
                toPurchase=Item.getItem("chaboost");
                ++chraismaboost;

            }
            else
                lblPurchaseStatus.setText("You already bought this.");

        }
        else if(event.getSource().equals(btnpotion)){
            toPurchase=Item.getItem("potion");
        }
        else if(event.getSource().equals(spdboost)){
            if(speedboost!=1){
                toPurchase=Item.getItem("speedboost");
                speedboost++;

            }
            else
                lblPurchaseStatus.setText("You already bought this.");


        }
        else if(event.getSource().equals(btnArmor)){
            if (armorboost != 1){
                toPurchase=Item.getItem("armor");
                armorboost++;

            }
            else
                lblPurchaseStatus.setText("You already bought this.");

        }
        else if(event.getSource().equals(donate)){
            toPurchase=Item.getItem("donate");
        }
        else if(event.getSource().equals(btnStrength)){
            if(strengthboost != 1){
                toPurchase=Item.getItem("strength");
                strengthboost++;

            }
            else
                lblPurchaseStatus.setText("You already bought this.");

        }

        if (toPurchase==null)
            return;
        int itemPrice=toPurchase.getPrice();
        if(itemPrice>Main.hero.getMoney()){
            lblPurchaseStatus.setText("Inadequate balance! Failed to purchase");
            return;
        }

        Main.hero.addPurchaseItem(toPurchase);
        lblPurchaseStatus.setText("Purchase successful!");
        sController.updateStats();




    }
    public void handleButtonReturntoTavern(ActionEvent event){
        if(Main.hero.getScene().equalsIgnoreCase("tavern")){
            FirstTown tavern= new FirstTown();
            Scene s1 = tavern.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);

        }
        else if (Main.hero.getScene().equalsIgnoreCase("fort1")){
            Fort1 fort= new Fort1();
            Scene s1 = fort.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);
        }
        else if (Main.hero.getScene().equalsIgnoreCase("fort2")){
            Fort2 fort= new Fort2();
            Scene s1 = fort.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);
        }
        else if (Main.hero.getScene().equalsIgnoreCase("firsttown")){
            FirstTown town= new FirstTown();
            Scene s1 = town.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);
        }
        else if (Main.hero.getScene().equalsIgnoreCase("village2")){
            Village2 town= new Village2();
            Scene s1 = town.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);
        }
        else if (Main.hero.getScene().equalsIgnoreCase("village3")){
            Village3 town= new Village3();
            Scene s1 = town.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);
        }
        else if (Main.hero.getScene().equalsIgnoreCase("village4")){
            Village4 town= new Village4();
            Scene s1 = town.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);
        }
        else if (Main.hero.getScene().equalsIgnoreCase("village5")){
            Village5 town= new Village5();
            Scene s1 = town.createScene(Main.mainStage  ,Main.hero);// next town pic please
            Main.mainStage.setScene(s1);
        }




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



    public static Scene main(Stage primaryStage, Player hero) {
        Parent root = null;
        try {
            root = FXMLLoader.load(ShopUI.class.getResource("./ShopUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ShopUI.hero=Main.hero;



        Scene shopScene=new Scene(root);
        primaryStage.setScene(shopScene);
        primaryStage.show();
        return shopScene;



    }

}