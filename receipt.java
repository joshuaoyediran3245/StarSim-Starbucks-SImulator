<<<<<<< HEAD
public class receipt {
    
=======
import java.util.ArrayList;

public class receipt {

private String finalReceipt;



public String printReceipt(ArrayList<String> orderList,int orderNumber)
{

finalReceipt ="";
for(int i =0;i<orderList.size();i++)
{
    if(i==0)
    {
        finalReceipt+=" ------------------"+"\n";
        finalReceipt+="|  Order Number: "+orderNumber+" |"+"\n";
        finalReceipt+=String.format("|%-18s|",orderList.get(i))+"\n";

    }
    else
    {
        finalReceipt+=String.format("|%-18s|",orderList.get(i))+"\n";
    
    }
                         
}
finalReceipt+=" ------------------"+"\n";
return finalReceipt;
}
>>>>>>> 5a50953f2f3b78fb08e492a67dfbc1b03983c66a
}
