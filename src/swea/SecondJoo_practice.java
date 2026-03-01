package swea;

import java.util.LinkedList;
import java.util.Queue;

public class SecondJoo_practice {
public static void main(String[] args) {
	int n = 20;
	int pNum =1;
	
	Queue<int[]> queue = new LinkedList<>();
	int lastPerson =1;
	
	queue.offer(new int [] {pNum, 1});//*배열 안에 내용을 넣을때에는 {}로 
	
	while(n>0) {
		int person[] = queue.poll();//*지금 queue에 아무도 없는데 빼려고 해서 NullPointerException발생. 
		int id = person[0];
		int pCount = person[1];
		
		n -= pCount;
		
		if(n<=0) {
			lastPerson = id;
			break;
		}
		
		queue.offer(new int[] {id, pCount++});
		
		queue.offer(new int[] {pNum++, 1});
	}
	System.out.println("마지막 마이쮸를 가져간 사람: "+ lastPerson + "번");
	
}
}
//큐를 만드는데 우리가 계산해야하는게 사람 번호, 마이쮸 갯수(배열을 넣어)
//while문으로 계속 돌리는데 n<=0이면 break;
//n -= count
//지금 만든 배열을 다시 offer로 뒤에 넣어. count++
//그러고 뒤에 pNum++한 거를 넣어서 사람을 한명씩 더하기

