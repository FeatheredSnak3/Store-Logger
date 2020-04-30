/*
CSE 205: 11333 / Tuesday, Thursday 4:30pm
Assignment: 6 (Store Logger)
Author: Samuel Arenson (1216923513)
  Description: 
 				  This file (Main.java), contains high level code, aka the Main functioning code
          to run the 'Store Logger' program. It starts the program calling on methods from the 
          other java files to, upon running, import all previously saved items in the inventory,
          then display the program logo and main menu. This file contains two methods of its own,
          the 'userStringHandler' and 'userIntHandler'. These methods are used by the UserAction 
          handler when either a string or int input is required for a specific function. 

          ~~For a detailed explination of the program as a whole, please see the PDf~~
*/

import java.util.*;
public class Main
{
    private static boolean menuActive = true;
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args)
    {
      CSVActions.readFromCSV(); //Pulls any items previously saved the CSV file
      Inventory.prepLoad(); //Loads the items from the publicAccessArray to the inventoryArray
      UserInterface.displayProgramLogo(); //Displays the 'Store Logger' logo

        do
        {
          UserInterface.showMainMenu(); //Displays MainMenu

          menuActive = UserActionHandler.menuHandler(userIntHandler()); /* 
            Takes inputs, performs subsequent function, checks if the exit
              case has been triggered. */
        }
        while(menuActive);
    }

    public static int userIntHandler()
    { // Method to ensure that an integer is imputted by the user,
      // and if it is, sents said input back to where it was requested
      System.out.print("  > ");

      while(! input.hasNextInt())
      {
        input.next();
        System.out.print("Please input a Numeric Value for this field\n");
        System.out.print("  > ");
      }
      int value = input.nextInt();
      return value;
    }

    public static String userStringHandler()
    { // Method that takes a String from the user and sents the input
      // back to where it was requested
      System.out.print("  > ");
      String inputString = input.next();
      return inputString;
    }
    
}