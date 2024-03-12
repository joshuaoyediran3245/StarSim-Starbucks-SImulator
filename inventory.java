public class inventory {
    
//First we want to know how many indgredients is used for the order

private int quantityIngredients; 
private String ingredients; 

//Constructor
public inventory(int quantityIngredients, String ingredients)
{
this.quantityIngredients = quantityIngredients;
this.ingredients = ingredients;
}

//This method is used to update the inventory level
public void updateInventoryLevel(int quantityToAdd)
{
    quantityIngredients += quantityToAdd;
    System.out.println("Inventory level updated. New quanitity: " + quantityIngredients);
}

// Method to order more ingredients

//...


   
}
