package sample;

public class Player extends Entity {

    //Variable Initialization
    private String name;
    private int Health;
    private double Money;
    private int Strength;
    private int Armor;
    private int Speed;
    private int Charisma;
    private String Class;
    private int Potions;
    private int Statboost;
    private int Clothes;
    private int Food;
  

    public Player() {
       
    }

    // Get and Set Elements
    
    public void AddPotion(){
        Potions++;
        
    }
    public void addFood(){
        Food++;
    }
    public void addStatboost(){
        Statboost++;
    }
    public void addClothes(){
        Clothes++;
    }

    public void SetName(String n){
        name = n;
    }
    public String GetName(){
        return name;
    }
    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public int getArmor() {
        return Armor;
    }

    public void setArmor(int armor) {
        Armor = armor;
    }

    public int getSpeed() {
        return Speed;
    }
    
    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getCharisma() {
        return Charisma;
    }

    public void setCharisma(int charisma) {
        Charisma = charisma;
    }

    public void setClass(String clss) {
        switch (clss.toLowerCase()) {
            case "wizard":
                Class = "Wizard";
                Health = 100;//BASELINE is 100
                Money = 500;//BASE LINE 300
                Strength = 15;//BASELINE 10
                Armor = 5;//BASELINE 10
                Speed = 10;//BASELINE 10
                Charisma = 5;//BASELINE 10
                Potions = 0; // start with 0
                Statboost = 0; // start with 0
                break;


            case "knight":
                Class = "Knight";
                Health = 100;
                Money = 400;
                Strength = 10;
                Armor = 15;
                Speed = 5;
                Charisma = 10;
                Potions = 0; 
                Statboost = 0;
                break;

            case "mercenary":
                Class = "Mercenary";
                Health = 100;
                Money = 800;
                Strength = 10;
                Armor = 10;
                Speed = 10;
                Charisma = 15;
                Potions = 0;
                Statboost = 0;
                break;

            case "peasant":
                Class = "peasant";
                Health = 90;
                Money = 300;
                Strength = 10;
                Armor = 5;
                Speed = 15;
                Charisma = 10;
                Potions = 0;
                Statboost = 0;
                break;

            default:
                System.out.println("IF THIS PRINTS YOU SCREWED THE POOCH, GO CHECK PLAYER.JAVA");
                break;
        }


    }


}

