package swea;

import java.util.Scanner;

public class Swea1970_쉬운거스름돈 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	for(int tc=1;tc<=T;tc++) {
		System.out.print("#"+tc);
		System.out.println();
		
		int money = sc.nextInt();
		
		int[] picks = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		for(int pick :picks) {
			int ans = money/pick;//int니까 기본으로 0을 출력해주겠지?
			System.out.print(ans+" ");
			money %= pick;
		}
		System.out.println();
	}//테케 끝
}
}
//2시 40분
//3시 1분

//*출력형식 한번 더 확인하고 제출하기!!!