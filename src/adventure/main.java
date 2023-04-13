package adventure;

import java.util.Scanner;


public class main {
	public static void main(String[] args) {
		System.out.println("안녕하세요. 직업을 생성해주세요.\n직업리스트\n마법사, 전사, 도적, 사냥꾼");
		
	}
}

class 플레이어 {
	String 직업;
	int 레벨;
	int 체력;
	int 공격력;
	int 방어력;
	int 공속;
	int 운;
	void 이동() {
		System.out.println("이동합니다.");
	}
	void 탐색() {
		System.out.println("확인합니다.");
	}
	void 공격() {
		System.out.println("공격합니다.");
	}
	void 방어() {
		System.out.println("방어합니다.");
	}
	void 도망() {
		System.out.println("도망갑니다.");
	}
	void 아이템() {
		System.out.println("아이템을 사용합니다.");
	}
}