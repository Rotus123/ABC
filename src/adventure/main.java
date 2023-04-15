package adventure;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        ArrayList<String> jobs = new ArrayList<>();
        jobs.add("마법사");
        jobs.add("전사");
        jobs.add("도적");
        jobs.add("사제");
        jobs.add("사냥꾼");

        Scanner scanner = new Scanner(System.in);
        System.out.print("안녕하세요. 모험가님을 환영합니다. 당신의 닉네임을 입력하세요.\n닉네임 : ");
        String name = scanner.nextLine().trim();
        System.out.println("안녕하세요." + name + "님 반갑습니다.");
        Player player = null; 

        while (true) {
            System.out.print("직업을 선택해 주세요.\n마법사, 전사, 도적, 사제, 사냥꾼\n직업 : ");
            String role = scanner.nextLine().trim();
            if (jobs.contains(role)) {
                System.out.printf("직업은 %s로 선택되었습니다.\n%s님은 레벨1 %s입니다.\n(도움말을 보고싶다면 언제든 \"도움\"를 입력하세요.)", role, name, role);
                player = new Player(name, role, 1, 10, 10, 10, 10, 10); // player 객체 생성
                break;
            }
            System.out.println("직업이 존재하지 않습니다.");
        }
        while (true) {
    		System.out.print("명령어를 입력하세요. (도움말-도움)\n");
    		String command = scanner.nextLine().trim();
    		executeCommand(command, player);
        }
    }		
    		private static void executeCommand(String command, Player player) {
    	        if(command.equals("도움")) {
    	            System.out.println("도움: 도움말을 호출합니다.");
    	            System.out.println("이동: 플레이어가 움직입니다.");
    	            System.out.println("탐색: 탐색합니다.");
    	            System.out.println("공격: 공격합니다.");
    	            System.out.println("방어: 방어합니다.");
    	            System.out.println("도망: 도망갑니다.");
    	            System.out.println("아이템: 아이템을 사용합니다");
    	            System.out.println("상태: 현재 상태를 확인합니다.");
    	        } else if (command.equals("이동")) {
    	            player.move();
    	        } else if (command.equals("탐색")) {
    	            player.search();
    	        } else if (command.equals("공격")) {
    	            player.attack();
    	        } else if (command.equals("방어")) {
    	            player.defense();
    	        } else if (command.equals("도망")) {
    	            player.escape();
    	        } else if (command.equals("아이템")) {
    	            player.useItem();
    	        }
    }
    }

class Player {
    String name;
    String role;
    int level;
    int health;
    int attack;
    int defense;
    int speed;
    int luck;
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
    void move() { //이동
        System.out.println("이동합니다.");
    }
    void search() { //탐색
        System.out.println("탐색합니다.");
    }
    void attack() { //공격
        System.out.println("공격합니다.");
    }
    void defense() { //방어
        System.out.println("방어합니다.");
    }
    void escape() { //도망
        System.out.println("도망갑니다.");
    }
    void useItem() { //아이템사용
        System.out.println("아이템을 사용합니다.");
    }
    void showStatus() { //상태
        System.out.printf("%s (Lv.%d %s)\n체력 : %d\n공격력 : %d\n방어력 : %d\n공속 : %d\n운 : %d\n", name, level, role, health, attack, defense, speed, luck);
    }
}