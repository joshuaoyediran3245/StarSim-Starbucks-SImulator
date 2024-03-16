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

  beverages.put("americano", 2.50); //Key Food/Item name. Value = Price // I changed some drinks, so its easier to use the key, if the key has space, is complicated
  beverages.put("latte", 3.00);
  beverages.put("cappuccino", 3.00);
  beverages.put("espresso", 2.00);
  beverages.put("frappuccino", 3.50); 


  //Populate Foods

  foods.put("croissant", 2.00);
  foods.put("muffin", 2.50);
  foods.put("sandwich", 4.0);
  foods.put("salad", 5.00);
  foods.put("cake", 3.50); 

}

//Here is the method used to display the Menu
public void displayMenuDrinks() 
{
  System.out.println("==== Starbucks Menu ===="); //Using SOP to display the "Graphics" for the menu
  System.out.println("Beverages: ");

  //This for-each loop iterates over the keys of the 'beverages' map. This beverages map contains the names of the beverages set to keys and their prices set to values
  for (String beverage : beverages.keySet())
  {
  System.out.printf("%-20s $%.2f%n", beverage, beverages.get(beverage));
  }




}


// Here we are going to get the price of an item when we want to place an order for Drinks
public double getPriceDrink(String drink)
{
  double priceOfDrink = beverages.get(drink);
  return priceOfDrink;
}

//Checks if we have the Drink in the menu
public boolean checkMenuDrink(String drink)
{
  boolean checking = beverages.containsKey(drink);
  return checking;
}

// display food items

public void displayFoodMenu() 
{
  System.out.println("Food Items: ");

  //This for-each loop iterates over the keys of the 'foods' map. This foods map contains the names of the foods set to keys and their prices set to values
  for (String food : foods.keySet())
  {
  System.out.printf("%-20s $%.2f%n", food, foods.get(food));
  }

}

//Checks if we have the Food in the menu
public boolean checkMenuFood(String food)
{
  boolean checking = foods.containsKey(food);
  return checking;
}


// Here we are going to get the price of an item when we want to place an order for Foods
public double getPriceFood(String food)
{
  double priceOfFood = foods.get(food);
  return priceOfFood;
}


public Map<String,Double> mapPassDrinks()
{

  return beverages ;
}
public Map<String,Double> mapPassFood()
{
  
  
  return foods;
}

}