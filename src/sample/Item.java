package sample;

public class Item {
    private int Health=0;
    private int Price=0;
    private int Strength=0;
    private int Armor=0;
    private int Speed=0;
    private int Charisma=0;
    private int Potions=0;
    private int Statboost=0;
    private  int Food=0;

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




    public  Item(int health, int price, int armor, int speed, int food, int potion, int charisma, int strength, int boost){
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

    public  static Item getItem(String itemName){

        if(itemName=="sword"){
            return  new Item(0,20, 0,0,0,0,0, 40,0);

        }
        else if(itemName=="medicine"){
            return  new Item(40,30, 0,0,0,0,0, 40,0);

        }
        else if(itemName=="potion"){
            return  new Item(0,50, 0,0,0,1,0, 40,0);

        }
        else if(itemName=="jewellery"){
            return  new Item(0,60, 0,0,0,0,100, 0,0);

        }
        else if(itemName=="horse"){
            return  new Item(0,100, 0,50,0,0,0, 0,0);

        }
        else if(itemName=="armor"){
            return  new Item(0,30, 30,0,0,0,0, 10,0);

        }
        else if(itemName=="cloth"){
            return  new Item(0,15, 5,0,0,0,10, 0,0);

        }
        else if(itemName=="map"){
            return  new Item(0,50, 0,50,0,0,0, 0,0);

        }
        else if(itemName=="food"){
            return  new Item(0,10, 0,0,20,0,0, 0,0);

        }
        else if(itemName=="boost"){
            return  new Item(0,25, 0,0,20,0,0, 0,25);

        }
        return  null;


    }




}
