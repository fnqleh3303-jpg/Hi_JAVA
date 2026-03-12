package swea;

import java.util.Scanner;

public class Swea1952_수영장 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	for(int tc=1;tc<=T;tc++) {
		int d=sc.nextInt();
		int m1=sc.nextInt();
		int m3=sc.nextInt();
		int y=sc.nextInt();
		
		int[] month = new int[13];
		
		for(int i=1;i<=12;i++) {
			month[i] = sc.nextInt();
		}
	}//테케끝
	}//메인 끝
	
	private static void fee(int[] month, int sum) {
		fee(month[m+1], Math.min(d*month[m], m1));
		fee(month[m+3], m3);
	}
}//클래스 끝
