// Insted of using a transaction class, lets use a register one that collects num of items, total price and an arraylist with the String name of the items.
import java.util.ArrayList;

public class register {
// For now this are the private variables, we can add more, im still figuring out how to do it better
    private double totalPrice;
    private ArrayList<String> itemsOrdered = new ArrayList<String>();


// add item with price and name
public void additem(double price, String item)
{
    totalPrice+= price;
    itemsOrdered.add(item);
}
// Gives total value of order
public double getTotal()
{
    return totalPrice;
}
// Count item, we did not use it, we can use it in the future
public int getItemCount() 
{

    return itemsOrdered.size();
}
// Display if there is a past order, it wont if there is nothing
public void displayPastOrders()
{
    //Strings all the name of the items in the order toghether
    String orden="";
    System.out.println("The order has the next items: ");
    for(int i =0; i<itemsOrdered.size();i++)
    {
    if(i==0)
    {
    orden=orden+itemsOrdered.get(i);
    }
    else
    {
    orden= orden+","+itemsOrdered.get(i);
    }
    }
    System.out.println(orden);
}
}