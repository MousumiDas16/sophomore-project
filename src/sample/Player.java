package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Player extends Entity {

    //Variable Initialization

    private int Health=0;
    private int Money=0;
    private int Strength=0;
    private int Armor=0;
    private int Speed=0;
    private int Charisma=0;
    private String Class;
    private int Potions=0;
    private int Statboost=0;
    private int Clothes;
    private int Food=0;
    private String description;
    private ArrayList<Image> Pictures = new ArrayList<>();
    //this is for a loop in the forest dont touch pls
    private int loopcount = 0;
    private String scene;
    private int strengthboost;
    private int Charismaboost;
    private int Speedboost;
    private int Armorboost;

  

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
    public void addMoney(int cash){
        Money += cash;

    }

    public void deductMoney(int cash){
        Money -= cash;

    }

    public void SetName(String n){
        this.Name = n;

    }
    public String GetName(){
        return Name;
    }
    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
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
                Strength = 10;//BASELINE 10
                Armor = 5;//BASELINE 10
                Speed = 10;//BASELINE 10
                Charisma = 5;//BASELINE 10
                Potions = 0; // start with 0
                Food = 0;
                Pictures.add(0,(new Image("sample/Art/Characters/Profile/Wizard_profile (2).png", 100,100,true,true)));
                Pictures.add(1,(new Image("sample/Art/Characters/Wizard_gif.gif",200, 100, true, true)));
                Statboost = 0; // start with 0
                description=" Always an intelligent youth, you would read and reread all the books your mother could\n " +
                        "afford. After reading you studied your hometown and observed the other residents as well as\n" +
                        " listening to any traveler who came by the Brewery. You could not be satisfied with the mundane world of Donkey’s\n " +
                        "Town and traveled south to the Grand University of the Mage Guild. There you learned devastating spells but were\n " +
                        "expelled for your lack of intrigue in the academics and obsession with powerful destruction\n magic. You returned home, an outcast…";


                System.out.println("The players class is " + this.Class);
                break;


            case "knight":
                Class = "Knight";
                Health = 100;
                Money = 400;
                Strength = 7;
                Armor = 15;
                Speed = 5;
                Charisma = 7;
                Potions = 0;
                Food = 0;
                Statboost = 0;
                Pictures.add(0,(new Image("sample/Art/Characters/Profile/Knight_Profile (2).png")));
                Pictures.add(1,(new Image("sample/Art/Characters/Knight_gif.gif",200, 100, true, true)));
                description="Always a strong and energetic child, you spent your youth training your physical prowess\n " +
                        "and sharpening your skills with a sword, until you became a squire. After an upbringing as a \n" +
                        "squire where you accompanied your mentor, Sir Reginald Fellings, you traveled the land seeking\n" +
                        " renown. However, you could not build your reputation and you returned to your hometown, a failure...";

                System.out.println("The players class is " + this.Class);
                break;

            case "mercenary":
                Class = "Mercenary";
                Health = 100;
                Money = 800;
                Strength = 5;
                Armor = 8;
                Speed = 10;
                Charisma = 15;
                Potions = 0;
                Food = 0;
                Statboost = 0;
                Pictures.add(0,(new Image("sample/Art/Characters/Profile/BH_Profile.png", 100,100,true,true)));
                Pictures.add(1,(new Image("sample/Art/Characters/Merc_gif.gif",200, 100, true, true)));
                description="Growing up an orphan in the slums of Donkey’s Town, you became an expert pickpocket\n " +
                        "and thief. Being self-taught your confidence grew until one day you stole from the wrong man. \n" +
                        " Edward was another thief but far more experienced, He took you under his wing and you spent \n" +
                        " years travelling from town to town swindling and thieving along the way. " +
                        "Edward instructed \n you in the ways of the sword and the art of sweet talking. After Edward was " +
                        "killed in  \n a job gone wrong you travelled home to lick your wounds and find leads for a new job…";
                System.out.println("The players class is " + this.Class);
                break;

            case "peasant":
                Class = "peasant";
                Health = 90;
                Money = 300;
                Strength = 4;
                Armor = 5;
                Speed = 15;
                Charisma = 10;
                Potions = 0;
                Food = 0;
                Statboost = 0;
                Pictures.add(0,(new Image("sample/Art/Characters/Profile/Farmer_Profile.png",100,100,true,true)));
                Pictures.add(1,(new Image("sample/Art/Characters/Farmer2_gif.gif",200, 100, true, true)));
                description="You were born an unremarkable child of unremarkable parents. " +
                        "All your life you toiled\n away at your family's farm, learning the trade from your mother " +
                        "and father. You were faster and braver than most of your peers.\n After the passing of your " +
                        "parents you swore you would not die a lowly farmer but would leave Donkey’s Town\n" +
                        " and seek a grand adventure…";
                System.out.println("The players class is " + this.Class);
                break;

            default:
                System.out.println("IF THIS PRINTS YOU SCREWED THE POOCH, GO CHECK PLAYER.JAVA");
                break;
        }


    }

    public String getPClass(){
        return Class;
    }

    public Image getImage(int index){
        if(Pictures.isEmpty())
            return  null;
        return  Pictures.get(index);
    }

    public int getPotions() {
        return Potions;
    }
    public void setPotions(int pot){
        Potions = pot;

    }

    public String getScene(){
        return scene;

    }
    public void setScene(String s){
        scene=s;
    }
    public void setStatboost(int s){
        Statboost = s;
    }
    public int getStatboost(){
        return Statboost;
    }

    public int getFood() {
        return Food;
    }
    public void setFood(int f){
        Potions = f;
    }
    // this is for forest dont touch please
    public void setLoopcount(int loop){
        loopcount = loop;

    }
    public int getLoopcount(){
        return loopcount;
    }
    public String getDescription(){
        return description;
    }

    public  void  addPurchaseItem(Item toPurchase){
        deductMoney(toPurchase.getPrice());
        Potions+=toPurchase.getPotions();
        Health+=toPurchase.getHealth();
        Strength+=toPurchase.getStrength();
        Armor+=toPurchase.getArmor();
        Speed+=toPurchase.getSpeed();
        Charisma+=toPurchase.getCharisma();
        this.Food+=toPurchase.getFood();
        this.Statboost+=toPurchase.getStatboost();
        strengthboost += toPurchase.getStrengthboost();
        Charismaboost += toPurchase.getCharismaboost();
        Speedboost += toPurchase.getSpeedboost();
        Armorboost += toPurchase.getArmorboost();



    }

    public void setAll(){
        Potions = 0;
        Strength = 0;



    }


}

