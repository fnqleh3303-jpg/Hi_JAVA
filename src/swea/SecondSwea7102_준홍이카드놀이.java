package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SecondSwea7102_준홍이카드놀이 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T=sc.nextInt();
	for(int tc=1;tc<=T;tc++) {
		int n=sc.nextInt();
		int m=sc.nextInt();
	
	int[] counting = new int[n+m+1];//일단은 할 수 있는 최대한의 칸을 모두 만들어줘
	
	for(int i=1;i<=n;i++) {//*덱의 숫자는 1~n까지 
		for(int j=1;j<=m;j++) {//*덱의 숫자는 1~m까지
			counting[i+j]++;//*바뀌는 값으로 넣는거 주의하기! 인덱스에서는 0부터 시작이니까 1을 더하는게 맞지
			
		}
	}
	
//	System.out.println(Arrays.toString(counting));
	
	int max=0;
	for(int s:counting) {//*counting배열에 있는 걸 하나씩 꺼내서 s에 담아줘 라는 뜻
		if(s>max) {
			max=s;
		}
	}//max인 값 찾기 완. 
	
//	System.out.println(max);
	
	System.out.print("#"+tc);
	for(int i=0;i<counting.length;i++) {
		if(counting[i]==max) {
			System.out.print(" "+i);
		}
	}
	System.out.println();
	
	}//테케 끝
}
}
//2시 40분 시작
//일단 테케 받고 for문 돌려
//N, M받고 
//1~N까지 1~M까지 각각 더해. 그리고 그걸 카운팅 정렬에 넣어
//가장 MAX값을 구하고, for문으로 카운팅 정렬 배열을 돌면서 max값이면 출력. 
//빈도수니까 카운팅 정렬 사용
//등장확률이 가장 높은 더하기 답은? 이 문제다.