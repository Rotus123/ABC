package dto;

import java.util.ArrayList;

public class Inventory{
	
    private static ArrayList<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<Item>();
    }

    public static void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}