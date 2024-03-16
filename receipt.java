//<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class receipt {



private String finalReceipt;
private HashMap<String, Double> beveragesAndFood = new HashMap<String,Double>(); //One map for everything
private double tax = 1.21;
private ArrayList<Double> tipsOfOrders = new ArrayList<Double>();

public String printReceipt(ArrayList<String> orderList,int orderNumber,double total)
{

finalReceipt ="";
for(int i =0;i<orderList.size();i++)
{
    if(i==0)
    {
        finalReceipt+=" ------------------"+"\n";
        finalReceipt+="|  Order Number: "+orderNumber+" |"+"\n";
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

public void MapReciverFood(Map<String,Double> list)
{
    for(Map.Entry<String,Double> entry : list.entrySet())
    {
        if(!beveragesAndFood.containsKey(entry.getKey()))
        {
            beveragesAndFood.put(entry.getKey(),entry.getValue());
        }
    }
}
public void MapReciverDrinks(Map<String,Double> list)
{
    for(Map.Entry<String,Double> entry : list.entrySet())
    {
        if(!beveragesAndFood.containsKey(entry.getKey()))
        {
            beveragesAndFood.put(entry.getKey(),entry.getValue());
        }
    }
}


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

public double getTip(int orderNumber)
{
    Double tip = tipsOfOrders.get(orderNumber-1);
    return tip;

}
//>>>>>>> 5a50953f2f3b78fb08e492a67dfbc1b03983c66a
}
