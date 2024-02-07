package CIS2206.Unit_17;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InventorySystem {
    Map<String, Order> inventory = new HashMap();

//    public InventorySystem(Map<String, Order> inventory) {
//        this.inventory = inventory;
//    }

    //store order

    public void storeOrder (String key, Order order) {
        if (!inventory.containsKey(key)) {
            inventory.put(key, order);
        }
    }

    //update order
    public void updateOrder (String key, Order neworder) {
        if (inventory.containsKey(key)) {
            inventory.replace(key, neworder);
        }
    }
    //cancel order
    public void cancelOrder (String key, Order order) {
        if (inventory.containsKey(key)) {
            inventory.remove(key, order);
        }
    }
    //track order
    public void trackOrder (String key) {
        if (inventory.containsKey(key)) {
            for(Order order : inventory.values()) {
                if (Objects.equals(order.orderID, key)) {
                    System.out.println("Order ID " + order.orderID +" "+ order.status);
                }
            }
        }
    }

    //print list of orders
    public void listOrders () {
        for (Map.Entry<String, Order> entry : inventory.entrySet()) {
            System.out.println("EntrySet (key,value): " + entry.getKey() + ", " + entry.getValue());
        }
    }

    public void printOrdersByStatus(String status) {
        System.out.println("Orders with status " + status + ":");
        for (Order order : inventory.values()) {
            if (order.getStatus().equalsIgnoreCase(status)) {
                System.out.println(order);
            }
        }
    }

    // Calculate total revenue generated by the inventory system
    public void calculateRevenue() {
        double totalRevenue = 0.0;
        for (Order order : inventory.values()) {
            totalRevenue += order.getProductPrice() * order.getQuantity();
        }
        System.out.println( "Total revenue generated: £" + totalRevenue);
    }
}