package sample;

import javafx.scene.image.Image;
import javafx.scene.text.Font;

import  javafx.scene.control.TextField;
import  javafx.scene.control.Label;

import javafx.scene.image.ImageView;

public class CommonInitializer {
    private Label lblHeroName;
    private TextField txtMoney,txtHealth,txtSpeed, txtArmor, txtPotion,txtCharisma, txtStrength;
    private ImageView profileIcon;
    final Font f = Font.loadFont("file:./Art/digital.ttf", 12);
    public  CommonInitializer(Label lblHeroName, TextField txtMoney, TextField txtHealth,TextField txtSpeed,TextField txtArmor,
                              TextField txtPotion,TextField txtCharisma, TextField txtStrength,  ImageView profileIcon){

        this.txtMoney=txtMoney;
        this.txtHealth=txtHealth;
        this.txtSpeed=txtSpeed;
        this.txtArmor=txtArmor;
        this.txtPotion=txtPotion;
        this.txtCharisma=txtCharisma;
        this.txtStrength=txtStrength;
        this.lblHeroName=lblHeroName;
        //this.txtFood=txtFood;
        this.profileIcon=profileIcon;



    }

    public void  updateStats(){
        lblHeroName.setText("Hello "+ Main.hero.getName());

        txtMoney.setFont(f);
        txtMoney.setText(String.valueOf(Main.hero.getMoney()));

        txtHealth.setFont(f);
        txtHealth.setText(String.valueOf(Main.hero.getHealth()));

        txtSpeed.setFont(f);
        txtSpeed.setText(String.valueOf(Main.hero.getSpeed()));

        txtArmor.setFont(f);
        txtArmor.setText(String.valueOf(Main.hero.getArmor()));

        txtPotion.setFont(f);
        txtPotion.setText(String.valueOf(Main.hero.getPotions()));

        txtCharisma.setFont(f);
        txtCharisma.setText(String.valueOf(Main.hero.getCharisma()));

        txtStrength.setFont(f);
        txtStrength.setText(String.valueOf(Main.hero.getStrength()));

       // txtFood.setFont(f);
        //txtFood.setText(String.valueOf(Main.hero.getFood()));
        Image profileImage=Main.hero.getImage(0);
        if(profileImage!=null)
            profileIcon.setImage(profileImage);



    }



}
