/*
CSE 205: 11333 / Tuesday, Thursday 4:30pm
Assignment: 6 (Store Logger)
Author: Samuel Arenson (1216923513)
	Description: 
        This file (Inventory.java), contains the methods performing actions related
        to the inventory. This includes: adding an item (to the inventoryArray ArrayList),
        removing an item (From the inventoryArray ArrayList), searching for a created item 
        (which includes displaying all info related to said item or displaying all items),
        and more. It also contains an additional ArrayList, named 
        publicAccessInventoryArray, and methods to copy all items between the inventory
        Arraylist or publicAccessInventoryArray. These copying methods are used when 
        saving or importing items, to protect the integrity of the privatly declared 
        inventoryArray Arraylist.
				 
          ~~For a detailed explination of the program as a whole, please see the PDf~~
*/

import java.util.*;

public class Inventory 
{
    private static ArrayList <Item> inventoryArray = new ArrayList <Item>();
    private static String storeItemName = "";
    private static int storeUPC = 0;
    private static int storeItemQuantity = 0;
    private static int updatedItemQuantity = 0;
    public static ArrayList <Item> publicAccessInventoryArray = new ArrayList <Item>();

    public static void addItemToInventory(Item i) //Adds a new item to the Inventory Array
    {
        inventoryArray.add(i);

    }

    public static void removeItemByName(String Name) //removes item, identifed by name
    {
        int targetItem = getItemIndex(Name); 
        if(targetItem == -1)
        {
            System.out.print("Error, unable to locate: \""+ Name +"\" within inventory");
            return;
        }
        else
        {
            inventoryArray.remove(targetItem);
            System.out.println("The Item "+ storeItemName +" has been removed!");
            return;
        }
    }

    public static void removeItembyUPC(int UPC) //Removes item, identified by UPC
    {
        int targetItem = getItemIndex(UPC);
            if (targetItem == -1)
            {
                System.out.print("Error, unable to locate: \""+ UPC +"\" within inventory");
                return;
            }
            else
            {
                inventoryArray.remove(targetItem);
                System.out.println("The Item: "+ storeItemName +"has been removed!");
            }
    }
    
    public static void addQuantity(int UPC, int itemsToAdd) //Increase quantity of an item
    {   
        if (itemsToAdd <1)
        {
            System.out.print("Error, Please input a value greater than 0");
        }
        else
        {
            boolean Success = updateItemQuantity(UPC,itemsToAdd);
                if (Success== true)
                {
                    System.out.print("\nThe item: " + storeItemName + " had a quantity of: " + storeItemQuantity + " and now has: " + updatedItemQuantity + "\n");
                }
                else
                {
                
                System.out.print("Error, unable to locate: \""+ UPC +"\" within inventory");
                } 
        }
    }
    public static void removeQuantity(int UPC, int itemsToRemove) //Decrease the quantity of an item
    {
        if (itemsToRemove <1)
        {
            System.out.print("Error, Please input a value greater than 0");
        }
        else
        {
            int removenumb = itemsToRemove * -1; //Subtracting the inputted number from total.
            boolean Success = updateItemQuantity(UPC,removenumb);
            if (Success== true)
                {
                    System.out.print("\nThe item: " + storeItemName + " had a quantity of: " + storeItemQuantity + " and now has: " + updatedItemQuantity + "\n");
                }
                else
                {
                
                System.out.print("Error, unable to locate: \""+ UPC +"\" within inventory");
                } 

        }
    }

    public static void displayOutofStockItems() //Displays all items with a quantity of 0
    {
        int itemCount = 1;
        for(Item i : inventoryArray)
        {
            if(i.getQuantity() == 0){
                System.out.print("Item "+itemCount+ " Name: "+i.getName()+"\n");
                System.out.print("Item "+itemCount + " UPC: " +i.getUPC()+"\n\n");
                
                itemCount++;
            }
            
        }
        System.out.println("");
    }


    public static void SearchItemByName(String Name) //Searches using an item's name, returns all information about item
    {
        int targetItem = getItemIndex(Name);
        if(targetItem == -1)
        {
            System.out.print("\nError, unable to locate: \""+ Name +"\" within inventory\n");
            return;
        }
        else
        {
            System.out.println("\nThe Item: "+ storeItemName +" with the UPC: "+storeUPC+" has a Quantity of: "+storeItemQuantity);
            return;
        }
    }

    public static void SearchItemByUPC(int UPC) //Searches using an item's UPC, returns all information about item
    {
        int targetItem = getItemIndex(UPC);
        if(targetItem == -1)
        {
            System.out.print("Error, unable to locate: \""+ UPC +"\" within inventory");
            return;
        }
        else
        {
            System.out.println("\nThe Item: "+ storeItemName +" with the UPC: "+storeUPC+" has a Quantity of: "+storeItemQuantity);
            return;
        }
    }

    public static void displayAllItems() //Displays all added items and respective information
    {   
        for(Item i : inventoryArray)
        {
            System.out.print("Item "+" Name: "+i.getName()+"\n");
            System.out.print("Item "+" UPC: "+i.getUPC()+"\n");
            System.out.print("Item "+" Quantity: "+i.getQuantity()+"\n\n");
        
        } 
    }

    public static void prepSave() //Public method to clone Inventory Arraylist to an Arraylist with public access
    {
        cloneInventoryArray();
    }

    public static void prepLoad()  //Public method to clone public access Arraylist to Inventory
    {
        importInventoryArray();
    }

    //Internal Inventory Methods
    private static boolean updateItemQuantity(int UPC, int quantity) 
    { //Private method to find and update the quantity of an item, given UPC
        for(Item i : inventoryArray)
        {
            if(i.getUPC() == UPC)
            {
                storeItemQuantity = i.getQuantity();
                storeItemName =i.getName();
                i.setQuantity(quantity+storeItemQuantity); 
                    //Intentionally does not safeguard quantity being set to negative,
                    //as stores use negtive quantities to know when to recount inventory
                updatedItemQuantity= i.getQuantity();
                return true;
            }   
        }
        return false;
    }
    
    private static int getItemIndex(String Name) //Index search for item given name
    {
        for(Item i : inventoryArray)
        {
            if (i.getName() == null)
            {
                return -1;
            }
            else if(i.getName().equals(Name))
            {
                storeItemName =i.getName();
                storeUPC = i.getUPC();
                return inventoryArray.indexOf(i);
            } 
        }
        return -1;
    }

    private static int getItemIndex(int UPC) //Index search for item given UPC
    {
        for(Item i : inventoryArray)
        {
            if(i.getUPC() == UPC)
            {
                storeItemQuantity = i.getQuantity();
                storeItemName =i.getName();
                storeUPC = i.getUPC();
                return inventoryArray.indexOf(i);
            }
            
        }
        return -1;
    }

    private static void cloneInventoryArray() // Private method copying all items from Inventory to PublicAccess
    {
        for(Item i : inventoryArray)
        {
            publicAccessInventoryArray.add(i);
        }
    }

    private static void importInventoryArray() // Private method for coping all items from PublicAccess to Inventory
    {
        for (Item i :publicAccessInventoryArray)
        {
            inventoryArray.add(i);
        } 
    }

}
