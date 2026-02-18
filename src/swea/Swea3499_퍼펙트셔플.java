package swea;

import java.util.Scanner;

public class Swea3499_퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();//테케 몇개
		for(int tc = 1;tc<=T;tc++) {//테케만큼 반복할거야
			int n = sc.nextInt();//몇개 받을건데?
			String[] deck = new String[n+1];//1번인덱스부터 넣을 배열 만들어
			
			int half = (n%2==0) ? n/2: n/2+1;//*딱 반의 기준을 명확히 하기. 홀 수 있때는 반에 1더한 곳. 
			
			for(int i=1;i<=n;i++) {
				if(i<=half) {//반보다 전에 들어온 입력값은 
					deck[2*i-1] = sc.next();//홀수 인덱스에 넣고
				} else {
					deck[2*(i-half)] = sc.next();//아니고는 짝수 인덱스에 넣어라
				}
			}
			
			System.out.print("#" +tc);
			for(int i=1;i<=n;i++) {
				String res = deck[i];
				System.out.print(" "+res);
				
			}
			System.out.println();
			}//tc 끝
		sc.close();
	}//메인 끝

}//클래스 끝
