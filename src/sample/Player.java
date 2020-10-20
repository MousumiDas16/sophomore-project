package sample;



public class Player extends Entity {



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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private  String description;



    public String getPlayerClass() {
        return Class;
    }


    public Player(String name) {
        this.Name = name;
    }


    public String getPlayerName() {
        return Name;
    }


    public void setPlayerName(String name) {
        this.Name = name;
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
                Potions=0;
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
                Strength = 10;
                Armor = 15;
                Speed = 5;
                Charisma = 10;
                Potions=0;
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
                Strength = 10;
                Armor = 10;
                Speed = 10;
                Charisma = 15;
                Potions=0;
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
                Strength = 10;
                Armor = 5;
                Speed = 15;
                Charisma = 10;
                Potions=0;
                description="ou were born an unremarkable child of unremarkable parents. " +
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


    public int getPotions() {
        return  this.Potions;
    }
}
