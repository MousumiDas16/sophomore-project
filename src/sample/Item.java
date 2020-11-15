package sample;

public class Item {
    private int Health = 0;
    private int Price = 0;
    private int Strength = 0;
    private int Armor = 0;
    private int Speed = 0;
    private int Charisma = 0;
    private int Potions = 0;
    private int Statboost = 0;
    private int Food = 0;
    private int strengthboost;
    private int Charismaboost;
    private int Speedboost;
    private int Armorboost;

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
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

    public int getCharisma() {
        return Charisma;
    }

    public void setCharisma(int charisma) {
        Charisma = charisma;
    }

    public int getPotions() {
        return Potions;
    }

    public void setPotions(int potions) {
        Potions = potions;
    }
    public int getStrengthboost() {
        return strengthboost;
    }
    public void setCharismaboost(int s){
        Charismaboost = s;

    }
    public int getCharismaboost() {
        return Charismaboost;
    }
    public void setStrengthboost(int s){
        strengthboost = s;

    }
    public int getSpeedboost() {
        return Armorboost;
    }
    public void setSpeedboost(int s){
        Armorboost = s;

    }
    public int getArmorboost() {
        return Armorboost;
    }
    public void setArmorboost(int s){
        Armorboost = s;

    }

    public int getStatboost() {
        return Statboost;
    }

    public void setStatboost(int statboost) {
        Statboost = statboost;
    }

    public int getFood() {
        return Food;
    }

    public void setFood(int food) {
        Food = food;
    }


    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }


    public Item(int health, int price, int armor, int speed, int food, int potion, int charisma, int strength, int boost) {
        this.setHealth(health);
        this.setPrice(price);
        this.setArmor(armor);
        this.setSpeed(speed);
        this.setFood(food);
        this.setPotions(potion);
        this.setCharisma(charisma);
        this.setStrength(strength);
        this.setStatboost(boost);

    }

    public static Item getItem(String itemName) {

        if (itemName == "chaboost") {
            return new Item(0, 450, 0, 0, 0, 0, 5, 0, 0);

        } else if (itemName == "potion") {
            return new Item(0, 75, 0, 0, 0, 0, 0, 0, 0);

        } else if (itemName == "speedboost") {
            return new Item(0, 600, 0, 5, 0, 0, 0, 0, 0);

        } else if (itemName == "armor") {
            return new Item(0, 400, 5, 0, 0, 0, 0, 0, 0);

        } else if (itemName == "strength") {
            return new Item(0, 700, 0, 0, 0, 0, 0, 5, 0);

        } else if (itemName == "donate") {
            return new Item(0, 50, 0, 0, 0, 0, 0, 0, 0);





        }
        else
        return null;


    }
}