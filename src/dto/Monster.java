package dto;

public class Monster {

    String name;
    public int level;
    public int health;
    public int attack;
    public int defense;
    public int speed;
    public int luck;
    public Monster(String name, int level, int health, int attack, int defense, int speed, int luck) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getSpeed() {
        return speed;
    }
    public int getLuck() {
        return luck;
    }
    public void showStatus() { //상태
        System.out.printf("%s (Lv.%d)\n체력 : %d\n공격력 : %d\n방어력 : %d\n공속 : %d\n운 : %d\n", name, level, health, attack, defense, speed, luck);
    }
    public void attack(Player player) {
        System.out.printf("%s(이)가 %s(을)를 공격합니다.\n", name, player.name);
        int damage = attack - player.defense;
        if (damage < 0) {
            damage = 0;
        }
        player.health -= damage;
        System.out.printf("%s(은)는 %s(으)로부터 %d의 피해를 입었습니다.\n", player.name, name, damage);
    }
}