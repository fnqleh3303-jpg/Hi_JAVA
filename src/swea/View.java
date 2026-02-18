package swea;

import java.util.Scanner;

public class View {
public static void main(Row[] args) {
	Scanner sc = new Scanner(System.in);
	for(int tc = 1;tc<11;tc++) {
		
		int bn = sc.nextInt();
		int [] array = new int[bn];
		
		for(int i=0;i<bn;i++) {
			array[i] = sc.nextInt();//빌딩들 높이 배열로 받기
					
		}
		
		int max = 0;
		
		for(int i=2;i<array.length-2;i++) {
			int around = Math.max(array[i-2], Math.max(array[i-1], Math.max(array[i+1], array[i+2])));
			
			if(around<array[i]) {//* 주변중 max랑 비교해야지! 비교대상 제대로 확인하고 적기
				max+=array[i]-around;//*테스트 케이스 별 총 세대수를 알아야하니까 누적해서 더해야지!
			}
		}
		System.out.println("#"+tc+" "+max);
	}
}
}
