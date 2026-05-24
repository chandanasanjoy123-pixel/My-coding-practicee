import java.util.ArrayList;
import java.util.Scanner;

// Item class (Composition)
class Item {

    // Encapsulation
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    Item(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate item total
    double getTotal() {
        return price * quantity;
    }

    // Display item details
    void displayItem() {
        System.out.println(itemName + " - Price: " + price +
                ", Quantity: " + quantity +
                ", Total: " + getTotal());
    }
}

// Order class (Contains Items -> Composition)
class Order {

    // Encapsulation
    private int orderId;

    // Composition: Order has Items
    private ArrayList<Item> items;

    // Constructor
    Order(int orderId) {
        this.orderId = orderId;
        items = new ArrayList<>();
    }

    // Add item to order
    void addItem(Item item) {
        items.add(item);
    }

    // Calculate bill by passing Order object
    double calculateBill(Order order) {

        double totalBill = 0;

        for (Item item : order.items) {
            totalBill += item.getTotal();
        }

        return totalBill;
    }

    // Display order details
    void displayOrder() {

        System.out.println("\nOrder ID: " + orderId);

        for (Item item : items) {
            item.displayItem();
        }

        System.out.println("Total Bill: " + calculateBill(this));
    }
}

// Customer class (Aggregation)
class Customer {

    // Encapsulation
    private int customerId;
    private String customerName;

    // Aggregation: Customer has Orders
    private ArrayList<Order> orders;

    // Constructor
    Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        orders = new ArrayList<>();
    }

    // Add order
    void addOrder(Order order) {
        orders.add(order);
    }

    // Display customer details
    void displayCustomer() {

        System.out.println("\nCustomer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);

        for (Order order : orders) {
            order.displayOrder();
        }
    }
}

// Main class
public class RestaurantManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Customer input
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String cname = sc.nextLine();

        Customer customer = new Customer(cid, cname);

        // Create Order
        System.out.print("Enter Order ID: ");
        int oid = sc.nextInt();

        Order order1 = new Order(oid);

        // Number of items
        System.out.print("Enter Number of Items: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input items
        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter Details for Item " + i);

            System.out.print("Item Name: ");
            String itemName = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            Item item = new Item(itemName, price, qty);

            order1.addItem(item);
        }

        // Add order to customer
        customer.addOrder(order1);

        // Display details
        customer.displayCustomer();

        sc.close();
    }
}