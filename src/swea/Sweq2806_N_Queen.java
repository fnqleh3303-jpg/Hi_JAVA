package swea;

import java.util.Scanner;

public class Sweq2806_N_Queen {
	static int n;
	static int ans;
	static int[] cal;
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	for(int tc=1;tc<=T;tc++) {
		n = sc.nextInt();
		cal = new int[n];
		
		ans =0;
		make(0);//인덱스 0부터 채우면서 탐색하려고.
		
		System.out.println("#"+tc+" "+ans);
		
	}//테케 끝
}//메인 끝

private static void make(int row) {
	//종료
	if(row==n) {//*종료조건이 먼저 있기때문에 row+1하고 인덱스에 넣기 전에 종료조건에 걸림. 
		ans++;
		return;
	}
	
	//재귀
	for(int i=0;i<n;i++) {//*n까지 탐색해야지 재귀가 돌고돌아서 꽉차는거지. 
		cal[row] = i;
		
		if(isPossible(row)) {
			make(row+1);//재귀니까 다시 돌아야지
		}
	}
}//make함수 끝

private static boolean isPossible(int row) {
	for(int i=0;i<row;i++) {//row까지 도는걸 체크하고 싶은거니까
		if(cal[i]==cal[row]) {
			return false;
		}
		
		if(Math.abs(row-i)==Math.abs(cal[row]-cal[i])) {
			return false;
		}
	}
	
	return true;
}//isPossible 함수끝

}//클래스 끝
