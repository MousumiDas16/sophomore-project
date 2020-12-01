package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class StatsPanelController implements Initializable {

    @FXML
    private Label lblHeroName;
    @FXML
    private ImageView profileIcon;
    @FXML
    private TextField txtMoney,txtHealth,txtSpeed, txtArmor, txtPotion,txtCharisma, txtStrength;
    CommonInitializer initializer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializer=new CommonInitializer(lblHeroName,txtMoney,txtHealth,txtSpeed,txtArmor,
                txtPotion,txtCharisma,txtStrength,profileIcon);
        initializer.updateStats();

    }

    public  void updateStats(){
        initializer.updateStats();

    }

}
