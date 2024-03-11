import java.util.HashMap;
import java.util.Map;


//Even though we did not go over HashMap Data Structure
// After doing futher research a HashMap would make more sense for displaying the item name and price 
//The HashMap can store in a key and a value. 
//In this case the key would be the item name ex. Caffe Americano. And the value would be the price $2.5




public class menu {
//Create the map top store menu items with their prices

private Map<String, Double> beverages; //One map for beverages
private Map<String, Double> foods; // One map for foods


//Constructor to initialize menu items 

public void ListMenu() 
{
  beverages = new HashMap<>(); //Set the beverages to a HashMap
  foods = new HashMap<>(); //Set the foods to a HashMap

  //Populate Beverages

  beverages.put("Caffe Americano", 2.50); //Key Food/Item name. Value = Price
  beverages.put("Caffe Latte", 3.00);
  beverages.put("Cappuccino", 3.00);
  beverages.put("Espresso", 2.00);
  beverages.put("Green Tea", 3.50); 


  //Populate Foods

  foods.put("Croissant", 2.00);
  foods.put("Muffin", 2.50);
  foods.put("Sandwich", 4.0);
  foods.put("Salad", 5.00);
  foods.put("Cake", 3.50); 

}

//Here is the method used to display the Menu
public void displayMenu() 
{
System.out.println("==== Starbucks Menu ===="); //Using SOP to display the "Graphics" for the menu
System.out.println("Beverages: ");

//This for-each loop iterates over the keys of the 'beverages' map. This beverages map contains the names of the beverages set to keys and their prices set to values
for (String beverage : beverages.keySet())
{
System.out.printf("%-20s $%.2f%n", beverage, beverages.get(beverage));
}

//New Code Goes here


}

}