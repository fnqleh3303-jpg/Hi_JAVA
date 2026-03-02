package swea;

import java.util.Scanner;

public class Swea5215_햄버거다이어트 {
	
	static int num;
	static int maxCal;
	static int[][]total;	
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	for(int tc=1;tc<=T;tc++) {
		num = sc.nextInt();
		maxCal = sc.nextInt();
		
		total = new int[num][2];
		for(int i=0;i<num;i++) {
			total[i][0] = sc.nextInt();//점수
			total[i][1] = sc.nextInt();		//칼로리	
		}//할당 끝
		int cal =0;
		
		int res = best(0, 0, 0);
		
		System.out.println("#"+ tc +" "+res);
		
	}//테케 끝
}//메인 끝
private static int best(int idxNum, int cal, int currentScore) {
	if(cal>maxCal) {//*넘으면 그냥 0 return해서 실패한걸 보여줘
		return 0;
	}
	
	if(idxNum==num) {//*마지막까지 돌았는데 안터지면 그게 최대 값이니까
		return currentScore;
	}
	int a= best(idxNum+1, cal, currentScore);
	int b = best(idxNum+1, cal+total[idxNum][1], currentScore+total[idxNum][0]);
	
	return Math.max(a, b);//*여기 return을 더 큰 값으로 해야지. 
}

}
//11시 11분
//재귀에서 컨트롤해야하는건
//칼로리가 max보다 위면 return해야한다.