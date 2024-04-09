//<<<<<<< HEAD
// This class takes care of building all the receipts for the orders but also it saves the tips that customer choose to give
// The receipt child class of the menu because it needs the items of the menu with their specific price
// If the prices in the menu are changed or the items served are change, because this is a child class it will also change
// This class also has methods to read and write information with files

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class receipt extends menu {

// Instance Variables
private String finalReceipt;
private Map<String, Double> beveragesAndFood; //One map for everything
private double tax = 1.21;
private ArrayList<Double> tipsOfOrders = new ArrayList<Double>();

// Prints receipt, return a String which is the finished receipt
public String printReceipt(ArrayList<String> orderList,int orderNumber,double total)
{
finalReceipt ="";
for(int i =0;i<orderList.size();i++)
{
    if(i==0)
    {
        finalReceipt+=" ------------------"+"\n";
        finalReceipt+="|  Order Number:"+String.format("%-2d",orderNumber)+" |"+"\n";
        finalReceipt+="|------------------|"+"\n";
        finalReceipt+=String.format("|%-14s$%.1f|",orderList.get(i),beveragesAndFood.get(orderList.get(i)))+"\n";   
    }
    else
    {
        finalReceipt+=String.format("|%-14s$%.1f|",orderList.get(i),beveragesAndFood.get(orderList.get(i)))+"\n";
    }
                         
}
finalReceipt+="|------------------|"+"\n";
finalReceipt+=String.format("|Tip       : $ %4.2f|",tipsOfOrders.get(orderNumber-1))+"\n";
finalReceipt+=String.format("|Total tax : $ %4.2f|",(total)-total/tax)+"\n";
finalReceipt+=String.format("|Your Total: $%5.2f|",total+tipsOfOrders.get(orderNumber-1))+"\n";
finalReceipt+=" ------------------"+"\n";
return finalReceipt;
}

// Saves tips for use of the program
public double saveTip(String tip)

{
    if(tip.equals("no"))
    {
        tipsOfOrders.add(0.0);
        return 0.0;

    }
    else
    {
        tipsOfOrders.add(Double.parseDouble(tip));
        return Double.parseDouble(tip);
    }
}

// returns tips for use of the program
public double getTip(int orderNumber)
{
    Double tip = tipsOfOrders.get(orderNumber-1);
    return tip;
}

// Saves tips from the file that it was read before
public void saveTipFile(double numero)
{
    tipsOfOrders.add(numero);
}

// Returns tips so they can be saves in file
public ArrayList<Double> fileTips()
{
    return this.tipsOfOrders;
}

// Puts together all items so the class has a easier acces
public void alltogether()
{
    beveragesAndFood = new  HashMap<String,Double>();

    for(String entry : beverages.keySet())
    {
        if(!beveragesAndFood.containsKey(entry))
        {
            beveragesAndFood.put(entry,beverages.get(entry));
        }
    }

    for(String entry : foods.keySet())
    {
        if(!beveragesAndFood.containsKey(entry))
        {
            beveragesAndFood.put(entry,foods.get(entry));
        }
    }
}

// Clear tips from receipt
public void clearReceipt()
{
    tipsOfOrders.clear();
}

//>>>>>>> 5a50953f2f3b78fb08e492a67dfbc1b03983c66a
}
