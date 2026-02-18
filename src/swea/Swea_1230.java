package swea;

import java.util.LinkedList;
import java.util.Scanner;


public class Swea_1230 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {//tc는 10번 진행
			LinkedList<Integer> linkedlist = new LinkedList<>();//collection framework에 있는거 확인해서 사용.

			int N =sc.nextInt();//첫번재 줄 완.
			for(int j=0;j<N;j++) {//N번만큼 받아들이기
				int old = sc.nextInt();//두번째 줄 완.
				linkedlist.add(old);
				
				
			}
			
			int M = sc.nextInt();//M 개 받아들이기. 세번재 줄 완. 
			
			for(int j=0;j<M;j++) {//명령문의 갯수
				String condition = sc.next();//첫번째 글자를 읽어오는거야. 
				
				
				if(condition.equals("I")) {//지금 문자열이랑 동일하다고 하고 싶은거니까 .equals 사용.
					///삽입의 경우
					int x = sc.nextInt();//x번째
					int y = sc.nextInt();//y개
					for(int k=0;k<y;k++) {
						int s = sc.nextInt();//s는 덧붙일 암호문들
						
						//linked로 붙이기
						
						linkedlist.add(x++, s);//이 자리부터 하나씩 삽입하는거니까 더해지려면 이렇게 적어야해. 
						
					}
					
					
				}else if(condition.equals("D")) {
					//삭제
					int x = sc.nextInt();//x번째 암호문 바로 다음부터 
					int y = sc.nextInt();//y개의 암호문을 삭제한다.
					
					for(int k=0;k<y;k++) {
						linkedlist.remove(x+1);//x+1인덱스부터 삭제한다. 근데 linkedList는 삭제하면 리스트의 인덱스가 당겨짐. 
					}
					
					
					
				}else if(condition.equals("A")) {
					//추가
					int y = sc.nextInt();//암호문 뭉치 맨 뒤에 y개의 암호문을 붙인다.
					for(int k=0;k<y;k++) {
						int s = sc.nextInt();//덕붙일 암호문들
						linkedlist.add(s);
					}
				}
				
			}
			System.out.print("#"+i);
			for(int k=0;k<10;k++) {//바로 linkedlist를 출력하면 배열처럼 출력된곳에도 [0, 0, 0, 0]이런형식으로 출력될건데 그걸 원하는건 아니라서.
				System.out.print(" "+ linkedlist.get(k));
			}
			System.out.println();
		}//tc도는거 끝
	}
}