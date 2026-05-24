import java.util.Scanner;

// Item Class
class Item {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    Item(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Calculate item total
    public double getTotal() {
        return price * quantity;
    }

    // Display item details
    public void displayItem() {
        System.out.println(itemName +
                " Price: " + price +
                " Quantity: " + quantity +
                " Total: " + getTotal());
    }
}

// Order Class (Composition)
class Order {
    private int orderId;
    private Item item1;
    private Item item2;

    // Constructor
    Order(int orderId, Item item1, Item item2) {
        this.orderId = orderId;
        this.item1 = item1;
        this.item2 = item2;
    }

    // Calculate total bill
    public double calculateBill() {
        return item1.getTotal() + item2.getTotal();
    }

    // Display order details
    public void displayOrder() {
        System.out.println("\nOrder ID: " + orderId);

        item1.displayItem();
        item2.displayItem();

        System.out.println("Total Bill: " + calculateBill());
    }
}

// Customer Class (Aggregation)
class Customer {
    private int customerId;
    private String customerName;
    private Order order;

    // Constructor
    Customer(int customerId, String customerName, Order order) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.order = order;
    }

    // Display customer details
    public void displayCustomer() {
        System.out.println("\nCustomer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);

        order.displayOrder();
    }
}

// Main Class
public class Assign3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Customer Input
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String cname = sc.nextLine();

        // Order Input
        System.out.print("Enter Order ID: ");
        int oid = sc.nextInt();
        sc.nextLine();

        // Item 1 Input
        System.out.println("\nEnter First Item Details");

        System.out.print("Item Name: ");
        String itemName1 = sc.nextLine();

        System.out.print("Price: ");
        double price1 = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity1 = sc.nextInt();
        sc.nextLine();

        Item item1 = new Item(itemName1, price1, quantity1);

        // Item 2 Input
        System.out.println("\nEnter Second Item Details");

        System.out.print("Item Name: ");
        String itemName2 = sc.nextLine();

        System.out.print("Price: ");
        double price2 = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity2 = sc.nextInt();

        Item item2 = new Item(itemName2, price2, quantity2);

        // Passing objects to constructor
        Order order = new Order(oid, item1, item2);

        Customer customer = new Customer(cid, cname, order);

        // Display details
        customer.displayCustomer();

        sc.close();
    }
}