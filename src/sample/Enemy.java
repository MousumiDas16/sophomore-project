package sample;

import javafx.scene.image.Image;
import java.util.Random;

public class Enemy {
    private int Health;
    private int Attack;
    private int Armor;
    private int Speed;

    private String enemyType;

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        this.Health = health;
    }

    public int getAttack() {
        Attack = rand.nextInt(20);
        return Attack;
    }

    public void setAttack(int att) {
        this.Attack = att;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        this.Speed = speed;
    }
    public String getType(){
        return enemyType;
    }




    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        this.Armor = armor;
    }
    // random made for different monsters attacks
    Random rand = new Random();
    public void setType(String type) {
        switch (type.toLowerCase()) {
            case "goblin":
                enemyType = "Goblin";
                Health = 50;
                Attack = rand.nextInt(20);
                Armor = 0;
                Speed = 16;

                //   Pictures.add(0,(new Image("sample/Art/Characters/Profile/Wizard_profile (2).png"))); //add goblin pic

                break;
            case "bloodpuddle":
                enemyType = "BloodPuddle";
                Health = 65;
                Attack = rand.nextInt(35);
                Armor = 0;
                Speed = 8;

                //   Pictures.add(0,(new Image("sample/Art/Characters/Profile/Wizard_profile (2).png"))); //add goblin pic

                break;
            case "kobold":
                enemyType = "Kobold";
                Health = 75;
                Attack = rand.nextInt(40);
                Armor = 0;
                Speed = 11;

                //   Pictures.add(0,(new Image("sample/Art/Characters/Profile/Wizard_profile (2).png"))); //add goblin pic

                break;
            case "guard":
                enemyType = "guard";
                Health = 80;
                Attack = rand.nextInt(28);
                Armor = 0;
                Speed = 11;
                break;



            default:
                System.out.println("IF THIS PRINTS YOU SCREWED THE POOCH, GO CHECK ENEMY .JAVA");
                break;
        }


    }
}