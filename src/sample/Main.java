package sample;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.*;
import javafx.stage.Stage;

//import javafx.scene.control.TextField;


public class Main extends Application {

    static public Player hero;
    private Label lblHealth, lblMoney, lblStrength, lblSpeed, lblCharisma, lblPotions, lblArmor, lblClass, lblName;
    private Text lblCharacterDescription;
    private Stage appStage;
    private ShopUI shop;
    public static Stage mainStage;


    @Override
    public void start(Stage primaryStage) throws InterruptedException {

        //this.appStage=primaryStage;
        //BorderPane root = new BorderPane();
//
//
        //primaryStage.setTitle("Swords of Origin");
        //primaryStage.setScene(new Scene(root, 750, 500));
        //primaryStage.show();
        //StackPane Bot_UI = new StackPane();
//
//
        ////BOTTOM RECTANGLE
//
        //Rectangle Bot_Rec = new Rectangle(750, 100);
        //Bot_Rec.setFill(Color.rgb(211, 211, 211));
        //Bot_UI.getChildren().add(Bot_Rec);
        //root.setBottom(Bot_UI);
        //Bot_Rec.setStroke(Color.BLACK);
//
        ////LEFT RECTANGLE
        //StackPane right_UI = new StackPane();
        //right_UI.setMinWidth(100);
        //right_UI.setAlignment(Pos.CENTER_LEFT);
        //// Rectangle Left_Rec = new Rectangle(200, 400, Color.rgb(211, 211, 211));
        ////  Left_Rec.setStroke(Color.BLACK);
//
        ////PLayer stats on left side
//
        //        Group stats_Group = new Group();
//
        //        Font font1 = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 16);
        //        Font font2 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 12);
        //        lblClass=new Label("Class");
        //        lblName=new Label("Name");
        //        lblHealth=new Label("Health");
        //        lblMoney=new Label("Money");
        //        lblStrength=new Label("Strength");
        //        lblSpeed=new Label("Speed");
        //        lblCharisma=new Label("Charisma");
        //        lblPotions=new Label("Potions");
        //        lblArmor=new Label("Armor");
        //        setStyle(lblClass,20, font1, Color.CRIMSON);
        //        setStyle(lblName,50, font1, Color.BLUE);
        //        setStyle(lblHealth, 80, font2, Color.TEAL);
        //        setStyle(lblMoney, 110, font2, Color.TEAL);
        //        setStyle(lblStrength, 140, font2, Color.TEAL);
        //        setStyle(lblSpeed, 170, font2, Color.TEAL);
        //        setStyle(lblCharisma, 200, font2, Color.TEAL);
        //        setStyle(lblPotions, 230, font2, Color.TEAL);
        //        setStyle(lblArmor, 260, font2, Color.TEAL);
//
        //        stats_Group.getChildren().addAll(lblClass, lblName,lblHealth,lblMoney,lblCharisma,
        //                lblArmor,lblStrength,lblSpeed,lblPotions);
        //        right_UI.getChildren().add(stats_Group);
//
        //        root.setRight(right_UI);
        //       // right_UI.getChildren().add(Left_Rec);
//
//
//
//
//
        //Group text_Group = new Group();
//
        //int Text_coorY = 10;
//
        //lblCharacterDescription = new Text("Character traits");
        //Font font3 = Font.font("Brush Script MT", FontWeight.NORMAL, FontPosture.ITALIC, 16);
        //lblCharacterDescription.setFont(font3);
        ////Text text2 = new Text("2) sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        ////Text text3 = new Text("3) Ut enim ad minim veniam");
        ////Text text4 = new Text("4) quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat");
        //text_Group.getChildren().addAll(lblCharacterDescription);
//
//
        //lblCharacterDescription.setY(Text_coorY);
        //lblCharacterDescription.setTextAlignment(TextAlignment.JUSTIFY);
        ////text1.set
        ////text2.setY(Text_coorY + 20);
        ////text3.setY(Text_coorY + 40);
        ////text4.setY(Text_coorY + 60);
        //Bot_UI.getChildren().add(text_Group);
//
        //Button butt1 = new Button();
        //Button butt2 = new Button();
        //Button butt3 = new Button();
        //Button butt4 = new Button();
//
//
        //butt1.setPadding(new Insets(0, 20, 0, 20));
        //butt2.setPadding(new Insets(0, 20, 0, 20));
        //butt3.setPadding(new Insets(0, 20, 0, 20));
        //butt4.setPadding(new Insets(0, 20, 0, 20));
//
//
        //Group butt_Group = new Group();
        //butt_Group.getChildren().addAll(butt1, butt2, butt3, butt4);
//
//
        //Bot_UI.getChildren().add(butt_Group);
        //StackPane.setAlignment(butt_Group, Pos.CENTER_RIGHT);
//
//
        //butt1.setLayoutY(Text_coorY);
        //butt2.setLayoutY(Text_coorY + 20);
        //butt3.setLayoutY(Text_coorY + 40);
        //butt4.setLayoutY(Text_coorY + 60);
//
//
        //butt1.setText("Visit Shop");
        //butt1.setOnAction(this::goToShop);
//
        //butt2.setText("Visit Town");
        ////butt2.setOnAction(actionEvent -> hero.setClass("knight"));
//
        //butt3.setText("Visit Tavern");
        ////butt3.setOnAction(actionEvent -> hero.setClass("mercenary"));
//
        //butt4.setText("Take Rest");
        ////butt4.setOnAction(actionEvent -> hero.setClass("peasant"));
//
        ////Adding the tavern image to the current UI
        //    StackPane Center_UI = new StackPane();
        //    //Image img = new Image("sample/Art/Background/Tavern.PNG", 650, 400, true, true);
        //    //ImageView Center_ImageView = new ImageView(img);
        //    //Center_UI.getChildren().add(Center_ImageView);
        //    //root.setCenter(Center_UI);
//
        ////getHeroName();
        ////selectCharacter();
        ////lblCharacterDescription.setText("Character traits: "+hero.getDescription());
        ////updateStats();
//
        ////charcheter chreations
        //Scene s1 = MainMenu.main(primaryStage,hero);
//
//
//
//
        //primaryStage.setTitle("Excalibur's Quest");
        //primaryStage.setScene(s1);
        //primaryStage.show();
        Main.mainStage = primaryStage;
        System.out.println(("Current file: Main"));
        hero = new Player();

        Scene s1 = forest.main(primaryStage, hero);

        primaryStage.setTitle("Excalibur's Quest");
        primaryStage.setScene(s1);
        primaryStage.show();


    }

    //  private void goToShop(ActionEvent event) {
    //      //if (shop==null)
    //         // shop=new ShopUI(hero);
    //      //try {
    //          //this.appStage.setScene(shop.initialize());
    //      //} catch (IOException e) {
    //        //  e.printStackTrace();
    //      //}
//
    //  }
//
    //  private void setStyle(Label label, int y, Font font, Color c) {
//
    //      label.setFont(font);
    //      //Filling color to the label
    //      label.setTextFill(c);
    //      //Setting the position
    //      label.setTranslateX(10);
    //      label.setTranslateY(y);
    //  }
//
    //  private void getHeroName() {
    //      String heroName;
//
    //      TextInputDialog dialog = new TextInputDialog("Excalibur");
    //      dialog.setTitle("Welcome");
    //      dialog.setHeaderText("Welcome to to the quest!");
    //      dialog.setContentText("What is the name of your hero:");
//
//
    //      do{
    //          Optional<String> result = dialog.showAndWait();
    //          if (result.isPresent()) {
    //              String chosenName=result.get();
    //              if(chosenName!=null && chosenName.length()>0){
    //                  hero = new Player(chosenName);
    //                  System.out.println("The Player's name is: " + chosenName);
    //              }
    //          }
    //      }while(hero==null);
    //  }
//
    //  public  void updateStats(){
    //      lblClass.setText("Class: "+ hero.getPlayerClass());
    //      lblName.setText("Name: "+ hero.getPlayerName());
    //      lblHealth.setText("Health: "+ hero.getHealth());
    //      lblArmor.setText("Armor: "+ hero.getArmor());
    //      lblPotions.setText("Potions: "+ hero.getPotions());
    //      lblMoney.setText("Money: "+ hero.getMoney());
    //      lblSpeed.setText("Speed: "+ hero.getSpeed());
    //      lblCharisma.setText("Charisma: "+ hero.getCharisma());
    //      lblStrength.setText("Strength: "+ hero.getStrength());
//
    //  }
    //  private  void selectCharacter(){
    //      ArrayList<String> choices = new ArrayList<String>();
    //      choices.add("Knight");
    //      choices.add("Wizard");
    //      choices.add("Mercenary");
    //      choices.add("Peasant");
//
    //      ChoiceDialog<String> dialog = new ChoiceDialog<String>("Knight", choices);
    //      dialog.setTitle("Character selection");
    //      dialog.setHeaderText("Which character do you want to be?");
    //      dialog.setContentText("Choose your character:");
//
    //      do{
    //          Optional<String> result = dialog.showAndWait();
    //          if (result.isPresent()){
    //              String chosenClass=result.get();
    //              System.out.println("Your choice: " + chosenClass);
    //              this.hero.setClass(chosenClass);
//
    //          }
    //      }while (hero.getPlayerClass()==null);
//
//
    //  }
//

    public static void main(String[] args) {
        launch(args);
    }


}

