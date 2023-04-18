package dto;
import dto.Inventory;
import dto.Item;
import java.util.ArrayList;


public class Player {
    String name;
    String role;
    public int level;
    public int health;
    public int attack;
    public int defense;
    public int speed;
    public int luck;
    private Item[] items;
    public Player(String name, String role, int level, int health, int attack, int defense, int speed, int luck) {
	        this.name = name;
	        this.role = role;
	        this.level = level;
	        this.health = health;
	        this.attack = attack;
	        this.defense = defense;
	        this.speed = speed;
	        this.luck = luck;
	        }
    public ArrayList<Item> getInventory() {
        return Inventory.getInventory();
    }
    public void move() { //이동
        System.out.println("이동합니다.");
    }
    public void search() { //탐색
        System.out.println("탐색합니다.");
    }
    
    public void attack(Monster monster) {
        System.out.printf("%s(이)가 %s(을)를 공격합니다.\n", name, monster.name);
        int damage = attack - monster.defense;
        if (damage < 0) {
            damage = 0;
        }
        monster.health -= damage;
        System.out.printf("%s(은)는 %s(으)로부터 %d의 피해를 입었습니다.\n", monster.name, name, damage);
    }
    public void attack() { //공격
        System.out.println("공격합니다.");
    }
    public void defense() { //방어
        System.out.println("방어합니다.");
    }
    public void escape() { //도망
        System.out.println("도망갑니다.");
    }
    public void useItem(Item item) {
        boolean isInInventory = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) {
                isInInventory = true;
                items[i] = null;
                health += item.getValue();
                System.out.printf("%s 아이템을 사용하여 체력이 %d 증가했습니다.\n", item.getName(), item.getValue());
                break;
            }
        }
        if (!isInInventory) {
            System.out.printf("%s 아이템이 인벤토리에 없습니다.\n", item.getName());
        }
    }
    public void showStatus() { //상태
        System.out.printf("%s (Lv.%d %s)\n체력 : %d\n공격력 : %d\n방어력 : %d\n공속 : %d\n운 : %d\n", name, level, role, health, attack, defense, speed, luck);
    }
}