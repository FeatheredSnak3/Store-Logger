/*
CSE 205: 11333 / Tuesday, Thursday 4:30pm
Assignment: 6 (Store Logger)
Author: Samuel Arenson (1216923513)
    Description: 
   				This file (UserInterface.java), contains the text/visuals for the main and sub'Menus'
          within the program, as well as prompts when a specific method requires an input.

          ~~For a detailed explination of the program as a whole, please see the PDf~~
*/

public class UserInterface 
{

  public static void displayProgramLogo(){
    System.out.println("");
    System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
    System.out.println("|  _|_ _  _ _  | _  _  _  _ _ |");
    System.out.println("| _)|_(_)| (-  |(_)(_)(_)(-|  |");
    System.out.println("|                  _/ _/      |");
    System.out.println("|                 __          |");
    System.out.println("|   \\  /   /|    /  \\         |");
    System.out.println("|    \\/     |.   \\__/         |");
    System.out.println("|                             |");
    System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
    System.out.println("");
    
}

  // Menu Methods \\

  public static void showMainMenu(){
    final String _0mainMenu = "\n---Main Menu---\n\n";
    final String _1mainMenu = "1) Create Item\n";
    final String _2mainMenu = "2) Remove Item\n";
    final String _3mainMenu = "3) Update Item Quantity\n";
    final String _4mainMenu = "4) View Items Out of Stock\n\n";
    final String _5mainMenu = "5) Search...\n";
    final String _6mainMenu = "6) File...\n";
    final String _7mainMenu = "9) Exit...\n";
    final String _8mainMenu = "---------------\n";
    final String mainMenu = (_0mainMenu +_1mainMenu+_2mainMenu+_3mainMenu+_4mainMenu+_5mainMenu+_6mainMenu+_7mainMenu+_8mainMenu);
    System.out.print(mainMenu);
  }

  public static void removeItemMenu()
  {
    final String _0RIM = "\n---Remove Item---\n";
    final String _1RIM = "1) By Name\n";
    final String _2RIM = "2) By UPC\n";
    final String _3RIM = "9) Cancel\n";
    final String _4RIM = "-----------------\n";
    final String rim = (_0RIM + _1RIM + _2RIM + _3RIM + _4RIM);
    System.out.print(rim + "\n");
  }

  public static void updateQuantityMenu()
  {
    final String _0UQM = "\n---Update Item Quantity---\n";
    final String _1UQM = "1) Increase Quantity\n";
    final String _2UQM = "2) Decrease Quantity\n";
    final String _3UQM = "9) Cancel\n";
    final String _4UQM = "--------------------------\n";
    final String uqm = (_0UQM + _1UQM + _2UQM + _3UQM + _4UQM);
    System.out.print(uqm + "\n");
  }

  public static void showSearchMenu()
  {
    final String _0searchMenu = "\n---Search Options---\n\n";
    final String _1searchMenu = "1) Search by Name\n";
    final String _2searchMenu = "2) Search by UPC\n";
    final String _3searchMenu = "3) Display all Items\n";
    final String _4searchMenu = "9) Return to Main Menu\n";
    final String _5searchMenu = "--------------------\n";
    final String searchMenu = (_0searchMenu+_1searchMenu+_2searchMenu+_3searchMenu+_4searchMenu+ _5searchMenu);
    System.out.print(searchMenu);
  }

  public static void showFileMenu()
  {
    final String _0fileMenu = "\n---File Actions---\n\n";
    final String _1fileMenu = "1) Manual File Load\n";
    final String _2fileMenu = "2) Manual File Save\n";
    final String _3fileMenu = "9) Return to Main Menu\n";
    final String _4fileMenu = "------------------\n";
    final String fileMenu = (_0fileMenu+_1fileMenu+_2fileMenu+_3fileMenu+_4fileMenu);
    System.out.print(fileMenu);
  }

  public static void showExitMenu()
  {
    final String _0exitMenu = "\n---Exit---\n";
    final String _1exitMenu = "1) Save Changed and Exit\n";
    final String _2exitMenu = "2) Don't Save Changes and Exit\n";
    final String _3exitMenu = "0) Cancel\n";
    final String _4exitMenu = "----------";
    final String exitMenu = (_0exitMenu+_1exitMenu+_2exitMenu+_3exitMenu+_4exitMenu);
    System.out.print(exitMenu);
  }  

  //Headers and Footers\\
  
  public static void ItemsOutOfStockHeader()
  {
    System.out.print("---The Following Items are Out of Stock---\n\n");
  }

  public static void ItemsOutOfStockFooter()
  {
    
    System.out.print("------------------------------------------\n");
  }

    //Prompts\\

  public static void ItemNamePrompt()
  {
    System.out.print("\nPlease Input the Item's Name\n");
  }

  public static void ItemUPCPrompt()
  {
    System.out.print("\nPlease Input the Item's UPC\n");
  }

  public static void ItemQuantityPrompt()
  {
    System.out.print("\nPlease Input the Item's Quantity\n");
  }

  public static void addQuantityPrompt()
  {
    System.out.print("\nPlease Input the Quantity to Add\n");
  }

  public static void removeQuantityPrompt()
  {
    System.out.print("\nPlease Input the Quantity to Remove\n");
  }

  public static void itemCreatedMSG()
  {
    System.out.print("\nThe Item has Successfully Been Created!\n");
  }
  public static void itemQuantityUpdatedMSG(){
    System.out.print("\n Item Quantity has Been Successfully Updated!\n");
  }
  
}