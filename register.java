// Insted of using a transaction class, lets use a register one that collects num of items, total price and an arraylist with the String name of the items.
import java.util.ArrayList;

public class register {

    private double totalPrice;
    private ArrayList<String> itemsOrdered;



public void additem(double price, String item)
{
    totalPrice+= price;
    itemsOrdered.add(item);
}

public double getTotal()
{
    return totalPrice;
}

public int getItemCount() {

    return itemsOrdered.size();
}

}