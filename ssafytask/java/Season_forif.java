package grammer;

import java.util.Scanner;

public class Season_forif {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int season = 0;
		for (int i = 0; i < 3; i++) {
			System.out.print("월 입력>>");
			season = sc.nextInt(); //for 밖에서 이미 int season을 해서 int선언 한번더 하면 안됨!
			
			if (season >= 3 && season <= 5) {
				System.out.printf("%d월은 %s입니다.", season, "봄");
				System.out.println();
				
			} else if (season >= 6 && season <= 8) {
				System.out.printf("%d월은 %s입니다.", season, "여름");
				System.out.println();
				
			} else if (season >= 9 && season <= 11) {
				System.out.printf("%d월은 %s입니다.", season, "가을");
				System.out.println();
				
			} else {
				System.out.printf("%d월은 %s입니다.", season, "겨울");
				System.out.println();
				
			} 

		}
		sc.close();
	}
}
