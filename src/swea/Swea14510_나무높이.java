package swea;

import java.util.Scanner;

public class Swea14510_나무높이 {
	static int n;
	static int[] namu;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			n = sc.nextInt();
			namu = new int[n];
			
			for(int i=0;i<n;i++) {
				namu[i] = sc.nextInt();
			}
			
			max=Integer.MIN_VALUE;
			
			for(int j=0;j<n;j++) {
				if(namu[j]>max) {
					max=namu[j];
				}
			}//이번테케의 max값찾기
			
			int res = day(0);
			System.out.println("#"+tc+" "+res);
		}//테케 끝

	}//메인 끝
	
	private static int day(int idx) {
		boolean[] done = new boolean[n];
		int days=0;
		
		//종료
		for(int i=0;i<n;i++) {//만약 다 돌고 인덱스 하나라도 false면
			if(done[i]==true) {
			}
			break;//break하고
		}
		return days;//모두 true라면 days를 return한다. 
		
		//재귀
				
		
	}

}//클래스 긑
