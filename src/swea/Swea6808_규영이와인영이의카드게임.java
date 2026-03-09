package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea6808_규영이와인영이의카드게임 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	
	for(int tc=1;tc<=T;tc++) {
		
		
		int[] card = new int[9];
		int[] other = new int[9];
		boolean[] isTrue = new boolean[19];//왜냐면 카드는 1에서 18번까지 있으니까
		int win=0;
		int lose=0;
		int same=0;
		
		for(int i=0;i<9;i++) {
			card[i] = sc.nextInt();
			isTrue[card[i]] = true;//card에 있는 숫자라면 true로 넣겠다. 
		}
		
		int idx =0;
		
		for(int i=1;i<=18;i++) {//isTrue돌면서 true인것만 담을거다.
			if(!isTrue[i]) {//값이 false라면
				other[idx++] = i;//인덱스를 담을거야.
			}
		}
		
		//other을 순열로 순서 바꾸는 함수 작성하기
		
		for(int i=0;i<9;i++) {
			if(card[i]>other[i]) {
				win+=card[i]+other[i];//이긴걸 보여주는게 아니라 그 이긴게 누적으로 몇개 인지를 
			} else if(card[i]<other[i]) {
				lose+=card[i]+other[i];
			} else {//얘를 빼고 적는 코드는?
				same++;
			}
		}
		
		
		System.out.println("#"+tc+" "+win+" "+lose);
	}//테케
}//메인 끝
}//테케끝 
