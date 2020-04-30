/*
CSE 205: 11333 / Tuesday, Thursday 4:30pm
Assignment: 6 (Store Logger)
Author: Samuel Arenson (1216923513)
	Description: 
         This file (UserActionHandler.java), contains the methods that make the 'menus'
         from the UserInterface.java file actually function. It consists of the main menu,
         method (reffered to as MenuHandler) in addition to the code for all the sub menus.
         Almost all of the code in this file (beyond the switch statements) acts as a 'hub' 
         or referance to other java files. The called methods from their respective java 
         files which actually perform the action chosen by the user.
				 
          ~~For a detailed explination of the program as a whole, please see the PDf~~
*/

public class UserActionHandler {
  public static boolean menuHandler(int input)// Main Menu Function
  {
    switch(input)
    {
      case 1: //Creates an Item and adds it to the inventory
        UserInterface.ItemNamePrompt();
        String name = Main.userStringHandler();
        UserInterface.ItemUPCPrompt();
        int upc = Main.userIntHandler();
        UserInterface.ItemQuantityPrompt();
        int quantity = Main.userIntHandler();

        Item newItem = new Item(name,upc,quantity);
        Inventory.addItemToInventory(newItem); 
        
        break;

      case 2: //Remove Item(Menu)
              //Allows User to Remove an item from the inventory
          UserInterface.removeItemMenu();
          int rchoice = Main.userIntHandler();
          while (rchoice !=9){
              switch(rchoice)
              {
                  case 1: //Remove Item using name
                      UserInterface.ItemNamePrompt();
                      Inventory.removeItemByName(Main.userStringHandler());
                      rchoice = 9;
                  break;

                  case 2: //Remove Item using UPC
                    UserInterface.ItemUPCPrompt();
                    Inventory.removeItembyUPC(Main.userIntHandler());
                    rchoice = 9;
                  break;
                  
                  case 9: //Return to main menu
                    rchoice = 9;
                  break;

                  default: 
                      System.out.println(" ~Error: Invalid Input~ \n");
                      UserInterface.removeItemMenu();
                  break;
              }
          }
      break;
      
      case 3: //Update quantity
            //Taking the UPC number, an item's quantity can be increased or decreased
        UserInterface.updateQuantityMenu();
        int uChoice = Main.userIntHandler();
        while(uChoice != 9){
          int inputtedUPC;
          int inputtedQuantity;
          switch(uChoice)
          {
            case 1: //Increase Quantity
              UserInterface.ItemUPCPrompt();
              inputtedUPC = Main.userIntHandler();
              UserInterface.addQuantityPrompt();
              inputtedQuantity = Main.userIntHandler();
              Inventory.addQuantity(inputtedUPC, inputtedQuantity);
              UserInterface.itemQuantityUpdatedMSG();
              uChoice = 9;
            break;

            case 2://Decrease Quantity
            UserInterface.ItemUPCPrompt();
            inputtedUPC = Main.userIntHandler();
            UserInterface.removeQuantityPrompt();
            inputtedQuantity = Main.userIntHandler();
            Inventory.removeQuantity(inputtedUPC, inputtedQuantity);
            UserInterface.itemQuantityUpdatedMSG();//Displays the old and updated quantity values
            uChoice = 9;
            break;

            case 9://Exit
            uChoice = 9;
            break;

            default: 
              System.out.println(" ~Error: Invalid Input~ \n");
              UserInterface.updateQuantityMenu();
            break;
          }
        }
       
      break;
  
      case 4: //View items that are out of stock
        UserInterface.ItemsOutOfStockHeader();
        Inventory.displayOutofStockItems();
        UserInterface.ItemsOutOfStockFooter();
      break;

      case 5: //Search Menu
            //Allows the user to search for an item using its name or UPC
            //Also allows user to display all items within the inventory

        UserInterface.showSearchMenu();
        int sChoice = Main.userIntHandler();
        while (sChoice != 9)
        {
          switch(sChoice)
          {
            case 1: //Search by Name
              UserInterface.ItemNamePrompt();
              String inputName =Main.userStringHandler();
              Inventory.SearchItemByName(inputName);
              sChoice = 9;
            break;

            case 2: //Search by UPC
              UserInterface.ItemUPCPrompt();
              int inputUPC = Main.userIntHandler();
              Inventory.SearchItemByUPC(inputUPC);
              sChoice = 9;
            break;

            case 3: //Show all Items
              Inventory.displayAllItems();
              sChoice = 9;
            break;

            case 9: //return to main menu
              sChoice = 9;
              break;

            default: 
              System.out.println(" ~Error: Invalid Input~ \n");
              UserInterface.showSearchMenu();
            break;
          }
        }

      break;

      case 6: //File (Menu)
          //Allows the user to save and load the inventory from the
          //CSV file at any time while the program is running

        UserInterface.showFileMenu();
        int fChoice = Main.userIntHandler();
        while(fChoice != 9)
        {
          switch(fChoice){
            case 1: //Manual File Load
            
              CSVActions.readFromCSV();
              Inventory.prepLoad();
              fChoice = 9;
            break;

            case 2: // Manual File Save
              Inventory.prepSave();
              CSVActions.saveToCSV();
              fChoice = 9;
            break;
            
            case 9:
            break;

            default: 
              System.out.println(" ~Error: Invalid Input~ \n");
              UserInterface.showFileMenu();
            break; 
          }
        }
      break;

      case 9: //Exit(Menu)...
          //Before quitting the program, allows user to save or delete changes
        UserInterface.showExitMenu();
        int echoice = Main.userIntHandler();
        while(echoice != 0)
        {
            switch(echoice)
            {
              case 1: //Exit and save changes
                Inventory.prepSave();
                CSVActions.saveToCSV();
                  return false;
              case 2: //Exit without saving changes
                  return false;
              case 0:
              break;
              default:
                  break;
            }
        }
      break;
        
      default:
        System.out.println("Error: Invalid Input");
      break;
       
    }
    return true; //Upon breaking from the while loop (after the user saved 
                //or did not save changes) the Program quits
  }  

}