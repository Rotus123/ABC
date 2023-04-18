package dto;

import java.util.ArrayList;

public class Inventory{
    private static ArrayList<Item> inventory = new ArrayList<Item>();

    public static void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println(inventory);
    }

    public static ArrayList<Item> getInventory() {
        return inventory;
    }
    
    public static void printInventory() {
        System.out.println("인벤토리:");
        for(Item item : inventory) {
            System.out.printf("%s(+%d)\n", item.getName(), item.getValue());
        }
    }
}