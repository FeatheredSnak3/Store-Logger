/*
CSE 205: 11333 / Tuesday, Thursday 4:30pm
Assignment: 6 (Store Logger)
Author: Samuel Arenson (1216923513)
	Description: 
 				This file (CSVActions.java), contains the methods used for both loading
				and saving all items added into the inventory (ArrayList) by the users. 
				This allows for any items and subsuquent data to be available after
				the program is quit.

          ~~For a detailed explination of the program as a whole, please see the PDf~~
*/

import java.util.*;
import java.io.*;

public class CSVActions 
{
  private static final String comma_DELIM = ",";
  private static final String new_Line = "\n";
  private static final String file_Header = "Name,UPC,Quantity";
  private static final String fileName = "inventorySave.csv";
  private static ArrayList <Item> importedLocalArray = Inventory.publicAccessInventoryArray;
  private static ArrayList <Item> importedExternalArray = new ArrayList<Item>();

	public static void saveToCSV() // This method, using a BufferedWriter takes all objects saved 
  	//to the InventoryArray (and transfered to the importedLocalArray), and saves the data for 
  	//each into the 'inventorySave.csv' file.
	{
    	BufferedWriter bw = null; //initializng the BufferedWriter
    	try
      {
        	bw = new BufferedWriter (new FileWriter(fileName));  
        	bw.write(file_Header); //Writes the file header to the CSV
        	bw.write(new_Line); //Sets the Writer to write future data below the header
        	for (Item i : importedLocalArray)//Iterates through array for all items
          {
            	bw.write(i.getName()); //writes name of item
            	bw.write(comma_DELIM); //Sets the Writer to 
            	bw.write(String.valueOf(i.getUPC()));//writes UPC of item
            	bw.write(comma_DELIM);
            	bw.write(String.valueOf(i.getQuantity())); //Writes quantity of item
            	bw.newLine(); //sets writer to write next item to the line below current item
          }
    	System.out.print("\n\n File Save Succeded\n\n"); //If compleated without errors, user is informed 
      	bw.flush(); //Flushes the BufferedWriter
    	bw.close(); //Closes the BufferedWriter
		}
    	catch (IOException e) //In the event of an IO Exception, notifies user of Unsuccessful save
    	{
        	System.out.print("\n File Save Unsuccessful\n");
    	}
	}
	
	public static void readFromCSV()// This method, using a BufferedReader reads all items saved to the 'inventorySave.csv' file, saving the data for each into the array 
  	{
		BufferedReader br = null; // initializes BufferedReader
		try
		{
			br = new BufferedReader(new FileReader("inventorySave.csv"));
			String line = " "; 
			br.readLine();//Skips reading the Header of the CSV File
			while((line = br.readLine()) != null) //Enters loop if 
			{
				String [ ] itemInfo = line.split(comma_DELIM); //String Array used to properly split up an item's data
				if(itemInfo.length > 0) 
				{//Takes data for imported item, sets to proper spot variable
					String itemName = itemInfo[0]; 
					int itemUPC = Integer.parseInt(itemInfo[1]);
					int itemQuantity = Integer.parseInt(itemInfo[2]);
					Item i = new Item(itemName,itemUPC,itemQuantity);
					importedExternalArray.add(i);//adds the imported item to array
				}
			}
			br.close();
			for (Item i :importedExternalArray) //Iterates through array for all items
        
			Inventory.publicAccessInventoryArray.add(i); //Copies Items from importedExternalArray to publicAccessInventoryArray
			
			System.out.print("\n\n File Load Succeded\n\n"); //Informs user of successful import
		}
		catch(IOException e) //In the event of an IO Exception, notifies user of Unsuccessful Load
		{
			System.out.print("\n\n File Load Unsuccessful\n"); 
      
		}
	}

}
