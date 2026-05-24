import java.util.Scanner;
class Item
{
    String name;
    int price;
    float quantity;
    double amount;
    void calculate()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a name:");
        name=sc.next();
        System.out.println("Enter the price:");
        price=sc.nextInt();
        System.out.println("Enter any quantity:");
        quantity=sc.nextFloat();
    }
     double calcualateAmount()
     {
        return price*quantity;
     }    
    void display()
    {
        System.out.println("Item name= ", name);
        System.out.println("Price= ", price);
        System.out.println("Quantity= ", quantity);
        System.out.println("Amount= ", amount);
    }
}
public class Retail Store{
    public static void main(String[]args){
    Item obj=new Item();
    System.out.println("\n-----BILL-----");
    obj.display();
    }

    
}


