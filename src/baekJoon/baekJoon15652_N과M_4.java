package baekJoon;

import java.util.Scanner;

public class baekJoon15652_N과M_4 {
	
	static int n, m;
	static int[] ans;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		ans = new int[m];
		sb = new StringBuilder();
		
		ham(0, 1);
		
		System.out.println(sb);
	}

	private static void ham(int idx, int start) {
		
		//종료
		if(idx==m) {
			for(int i=0;i<m;i++) {
				sb.append(ans[i]).append(' ');
			}
			sb.append("\n");
			return;
		}
		
		//재귀
		for(int i=start;i<=n;i++) {
			ans[idx] =i;
			ham(idx+1, i);//같은 수를 골라도 된다. 
//			ham(idx+1, i+1);  이렇게 두번 호출하면 중복이 있을 수 밖에 없다. 
		}
		
	}

}

//3번 문제 // 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//1부터 N까지 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도 된다.

//4번 문제 
//*자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//1부터 N까지 자연수 중에서 M개를 고른 수열
//같은 수를 여러 번 골라도 된다.
//고른 수열은 비내림차순이어야 한다.
//길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

