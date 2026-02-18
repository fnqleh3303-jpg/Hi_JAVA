package swea;

import java.util.Scanner;

public class Season_whileswitch {
	public static void main(String[] args) {
			
	Scanner sc = new Scanner(System.in);
	int i=0;
	while(i<3){
		System.out.print("월 입력>>");
		int num = sc.nextInt(); //nextInt하고 뒤에 () 꼭 붙이기!
		
		switch(num){ //자바 명령어는 모두 소문자.
			case 3 : case 4: case 5:
			System.out.println(num+"월은 봄입니다.");
			break;
			case 6: case 7: case 8:
			System.out.println(num+"월은 여름입니다.");
			break;
			case 9: case 10: case 11:
			System.out.println(num+"월은 가을입니다.");
			break;
			default:
			System.out.println(num+"월은 겨울입니다.");
			break;
		}
		i++;
	}
	sc.close();
	}
}
