package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SecondSwea1225_퍼펙트셔플 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	for(int tc=1;tc<=T;tc++) {
		int n = sc.nextInt();
		
		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();
		Queue<String> res = new LinkedList<>();
		
		if(n%2==1) {//홀수라면
			for(int i=0;i<n/2+1;i++) {
				q1.offer(sc.next());
			}
			for(int i=0;i<n/2;i++) {
				q2.offer(sc.next());
			}
		} else {//n이 짝수라면
			for(int i=0;i<n/2;i++) {
				q1.offer(sc.next());
			}
			for(int i=0;i<n/2;i++) {
				q2.offer(sc.next());
			}
		}//일단은 LinkedList 두개에 할당 끝
//		System.out.println(q1);
//		System.out.println(q2);
		for(int k=0;k<n/2;k++) {
			res.offer(q1.poll());
			res.offer(q2.poll());
		}
		if(!q1.isEmpty()) {
			res.offer(q1.poll());
		}//res linkedList에 다시 순서대로 넣기 끝
//		System.out.println(res);//여기까지 좋아. 
//		System.out.println(res.size());
		
		System.out.print("#"+tc);
//		for(int i=0;i<res.size();i++) {
		//*for문에서 특히나 배열이 아니라 크기가 달라지는 linkedList나 queue의 경우에는 
		//size가 달라지기 때문에 내가 원하는 만큼 출력되지 않을 수도 있으니 주의 할것!
		//처음에 사이즈를 받아서 변수에 저장해두거나 while(!res.isEmpty())로 할수도 있음. 
		//for(String s: res){
		//sysout(" " +s);
		//}로 해도 된다. 
		while(!res.isEmpty()) {
			System.out.print(" "+res.poll());
		}
		System.out.println();
		
	}//tc 끝
}
}
//1시 35분 시작
//1, 2, 3, 4, 5, 6, 7이라면 딱 반 잘라서 각각 linkedList에 넣어.
//그리고 for문을 돌면서 isEnpty면 break;하고, 아니면 for문에 있는 i를 /2하는데 ==0이면 
//첫번째linkedlist에서 빼서 offer 답 queue에 넣고, 1이면 두번째 linkedList에서 넣는다. 
//4, 1, 5, 2, 6, 3, 7
//7이 홀수라면 n/2+1번 반복해서 넣어. 
