package baekJoon;

import java.util.Scanner;

public class baek14501_퇴사 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] pay = new int[n+1];

		int[] t = new int[n+1];
		int[] p = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			t[i] = sc.nextInt();//이렇게 되면 0번 인덱스부터 넣는건데 안 헷갈리나?
			p[i] = sc.nextInt();
			
		}//할당 끝
		
		for(int i=1;i<=n;i++) {
			//오늘 상담 안 할 때
			pay[i] = Math.max(pay[i-1], pay[i]);
			
			//오늘 상담 할 때
			int next = i+t[i]-1;
			
			if(next<n+2) {//for문에서 n까지 닿으니까 여기서도 n까지 도는거다. 
				pay[next] = Math.max(pay[next], pay[i]+p[i]);
			}
			
			
		}
		System.out.println(pay[n]);
		
	}//메인 끝
}//클래스 끝
//2시
