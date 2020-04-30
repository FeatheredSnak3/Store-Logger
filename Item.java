/*
CSE 205: 11333 / Tuesday, Thursday 4:30pm
Assignment: 6 (Store Logger)
Author: Samuel Arenson (1216923513)
	Description: 
        This file (Item.java), contains the constructor for the 'Item' object.
        It also contains getter and setter methods for the "Name, UPC, and Quantity"
        values associated with a constructed Item object.
				 
          ~~For a detailed explination of the program as a whole, please see the PDf~~
*/
public class Item{
    private String name = "";
    private int UPC_Numb = 0;
    private int quantity = 0;
    
    public Item(String name, int UPC_Numb, int quantity)
    {
        this.name = name;
        this.UPC_Numb = UPC_Numb;
        this.quantity = quantity;
    }

    public void setName(String _name)
    {
      name = _name;
    }

    public String getName()
    {
      return name;
    }

    public void setUPC(int _UPC_Numb)
    {
      UPC_Numb = _UPC_Numb;
    }

    public int getUPC()
    {
      return UPC_Numb;
    }

    public void setQuantity(int _quantity)
    {
      quantity = _quantity;
    }
    
    public int getQuantity()
    {
      return quantity;
    }

}