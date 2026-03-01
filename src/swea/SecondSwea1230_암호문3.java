package swea;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SecondSwea1230_암호문3 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	for(int tc=1;tc<=10;tc++) {
		int originalNum = sc.nextInt();
		List<Integer> list = new LinkedList<>();//for문안에 있으니까 지역변수로 소멸할 수 밖에 없었네.
		
		for(int i=0;i<originalNum;i++) {
			list.add(sc.nextInt());
		}//일단 받은 original 할당 완. 
		
		int green = sc.nextInt();
		
		for(int i=0;i<green;i++) {
			String alf = sc.next();
			int x = sc.nextInt();//번째
			
			if(alf.equals("I")) {//*문자를 비교할 때에는 ==로 주소값이 아니라.equals()로 내용이 같은지 비교해야 함.
				//*그리고 삽입할 때에는 인덱스를 하나씩 더해가면서 넣어야 거꾸로 들어가지 않음. 기억하기!
				int y = sc.nextInt();//개를 
				
				for(int j=0;j<y;j++) {
				list.add(x+j, sc.nextInt());
				}//왜 이 메서드에서는 list인데도 인덱스로 접근이 가능한거지? list이니까 가능한거야.
				//왜냐면 list인터페이스를 LinkedList로 구현한거라서.
			}
			if(alf.equals("D")) {
				int y = sc.nextInt();//개를 
				for(int j=0;j<y;j++) {
					list.remove(x);
				}//
			}
			if(alf.equals("A")) {
				for(int j=0;j<x;j++) {
					list.add(list.size(), sc.nextInt());
				}//
			}
		}
		System.out.print("#"+ tc);
		for(int i=0;i<10;i++) {
			System.out.print(" "+ list.get(i));
		}
		System.out.println();
	}//테케 끝
}
}
//4시 52분

//테케는 10개래
//일단 원본을 linkedList로 받아. 
//초록색을 n으로 받
//n만큼 반복하는데
//if I이면, D이면, A 이면 나누기
//그리고 마지막 완성된 res는 <10까지만 출력하기