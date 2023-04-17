package dto;

public class Player {
    String name;
    String role;
    public int level;
    public int health;
    public int attack;
    public int defense;
    public int speed;
    public int luck;
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
    public void useItem() { //아이템사용
        System.out.println("아이템을 사용합니다.");
    }
    public void showStatus() { //상태
        System.out.printf("%s (Lv.%d %s)\n체력 : %d\n공격력 : %d\n방어력 : %d\n공속 : %d\n운 : %d\n", name, level, role, health, attack, defense, speed, luck);
    }
}