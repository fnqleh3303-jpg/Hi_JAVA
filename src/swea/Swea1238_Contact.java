package swea;

import java.util.Queue;
import java.util.Scanner;

public class Swea1238_Contact {
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	for(int tc=1;tc<=10;tc++) {
		
		int num =sc.nextInt();
		int start = sc.nextInt();
		
		int[] store = new int[num+1];
		
		for(int i=0;i<num/2;i++) {
			int from =sc.nextInt();
			int to = sc.nextInt();
			
			store[from] = to;
		}//할당 끝
		
		Queue<Integer> queue = new //큐로 일단 첫 start넣고 poll해서 push하고 반복하다가 queue가 빈다면 
				//그 직전에 빠진 것들 중에 가장 큰 값을 답으로 해야해. 
		
	}//테케 끝
}//메인 끝
}//클래스 끝
//10시 52분
