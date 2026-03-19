package baekJoon;

import java.util.Scanner;

public class baekJoon15651_N과M_3 {
	
	static int n, m;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();//출력 량이 너무 많아지면 for문안에서 sysout하지 말고 sb로 모아서 한번에 출력하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		ans  = new int[m];
		
		ham(0);
		
		System.out.println(sb);

	}

	private static void ham(int idx) {
		//종료
		if(idx == m) {
			for(int i=0;i<m;i++) {
//				System.out.print(ans[i]+" ");//여기 반복문 안에서 sysout함수를 너무 많이 호출하면 시간초과 문제 발생. 
				sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
//			System.out.println();
			return; //재귀에서는 return까먹지 말기!
		}
		
		//재귀
		for(int i=1;i<=n;i++) {
			ans[idx] = i;
			ham(idx+1);
		}
		
	}

}
