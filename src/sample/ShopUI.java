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


    @FXML
    private StackPane leftUI;
    @FXML
    private Label lblPurchaseStatus;
    StatsPanelController sController;

    @FXML
    Button btnFood,btnMed, btnPotion, btnJewellery,  btnSword,btnHorse, btnArmor, btnCloth, btnMap,btnBoost;

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
        if(event.getSource().equals(btnFood)){
            toPurchase=Item.getItem("food");
        }
        else if(event.getSource().equals(btnMed)){
            toPurchase=Item.getItem("medicine");
        }
        else if(event.getSource().equals(btnPotion)){
            toPurchase=Item.getItem("potion");
        }
        else if(event.getSource().equals(btnArmor)){
            toPurchase=Item.getItem("armor");
        }
        else if(event.getSource().equals(btnJewellery)){
            toPurchase=Item.getItem("jewellery");
        }
        else if(event.getSource().equals(btnSword)){
            toPurchase=Item.getItem("sword");
        }
        else if(event.getSource().equals(btnHorse)){
            toPurchase=Item.getItem("horse");
        }
        else if(event.getSource().equals(btnCloth)){
            toPurchase=Item.getItem("cloth");
        }
        else if(event.getSource().equals(btnMap)){
            toPurchase=Item.getItem("map");
        }
        else if(event.getSource().equals(btnBoost)){
            toPurchase=Item.getItem("boost");
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
        FirstTown tavern= new FirstTown();
        Scene s1 = tavern.createScene(Main.mainStage  ,Main.hero);// next town pic please
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