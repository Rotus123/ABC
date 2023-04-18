package adventure;

import dto.Monster;
import dto.Player;
import dto.Inventory;
import dto.Item;
import java.util.ArrayList;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
    	ArrayList<Inventory> inventory = new ArrayList<>();
        ArrayList<String> jobs = new ArrayList<>();
        jobs.add("마법사");
        jobs.add("전사");
        jobs.add("도적");
        jobs.add("사제");
        jobs.add("사냥꾼");
        
        Scanner scanner = new Scanner(System.in);
        System.out.printf("안녕하세요. 모험가님을 환영합니다. 당신의 닉네임을 입력하세요.\n닉네임 : ");
        String name = scanner.nextLine().trim();
        System.out.println("안녕하세요." + name + "님 반갑습니다.");
        Player player = null; 

        while (true) {
            System.out.printf("직업을 선택해 주세요.\n마법사, 전사, 도적, 사제, 사냥꾼\n직업 : ");
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
    	            double random = Math.random();
    	            if (random < 0.1) { // 70% 확률로 몬스터를 만남
    	                System.out.println("몬스터를 만났습니다!");
    	                Monster monster = new Monster("고블린", 1, 8, 5, 1, 1, 1);
    	                System.out.printf("[%s 전투 시작]\n", monster.getName());
    	                battle(player, monster);
    	            } else if (random < 0.9){ // 20% 확률로 아이템을 발견
    	                System.out.println("아이템을 발견했습니다!");
    	                Item item = new Item("체력 포션", 10);
    	                System.out.printf("아이템 \"%s(+%d)\"을 발견했습니다.", item.name, item.value);
    	                Inventory.addItemToInventory(item);
    	            } else { // 10% 확률로 아무것도 없음
    	                System.out.println("이동하였으나, 그곳엔 아무것도 없었습니다.");
    	            }
    	        } else if (command.equals("탐색")) {
    	            player.search();
    	        } else if (command.equals("인벤")) {
    	            Inventory.printInventory();
    	        } else if (command.equals("공격")) {
    	            player.attack();
    	        } else if (command.equals("방어")) {
    	            player.defense();
    	        } else if (command.equals("도망")) {
    	            player.escape();
    	        } else if (command.equals("아이템")) {
    	            player.useItem();
    	        } else if (command.equals("상태")) {
    	            player.showStatus();
    	        }
    }
    		
    private static void battle(Player player, Monster monster) {
        Scanner scanner = new Scanner(System.in);
        
   	        while (player.health > 0 && monster.health > 0) {
   	            player.showStatus();
   	            monster.showStatus();
   	            System.out.print("명령어를 입력하세요. (도움말-도움)\n");
   	            String command = scanner.nextLine().trim();
   	            if (command.equals("도움")) {
   	                System.out.println("도움: 도움말을 호출합니다.");
   	                System.out.println("공격: 몬스터를 공격합니다.");
   	                System.out.println("아이템: 아이템을 사용합니다.");
  	            } else if (command.equals("공격")) {
   	                player.attack(monster);
   	                if (monster.health > 0) {
   	                    monster.attack(player);
    	                }
  	            } else if (command.equals("아이템")) {
  	        	ArrayList<Item> inventory = player.getInventory();
  	        	if (inventory.size() == 0) {
  	        	System.out.println("소지한 아이템이 없습니다.");
  	        	} else {
  	        	System.out.println("사용할 아이템을 선택하세요.");
  	        	for (int i = 0; i < inventory.size(); i++) {
  	        	System.out.printf("%d. %s\n", i + 1, inventory.get(i).getName());
  	        	}
  	        	int index = scanner.nextInt();
  	        	scanner.nextLine(); // 버퍼 비우기
  	        	if (index < 1 || index > inventory.size()) {
  	        	System.out.println("잘못된 입력입니다.");
  	        	} else {
  	        	player.useItem(inventory.get(index - 1));
  	        	inventory.remove(index - 1);
  	        	}
  	        	}
    	            } else {
    	                System.out.println("잘못된 명령어입니다.");
    	            }
    	        }
    	        if (player.health > 0) {
    	            System.out.printf("%s를 물리쳤습니다!\n", monster.getName());
    	      /*    int exp = monster.getLevel() * 10;
    	            System.out.printf("%d의 경험치를 얻습니다.\n", exp);
    	            player.gainExp(exp); */
    	        } else {
    	            System.out.println("당신은 사망했습니다...");
    	        }
    }
}
