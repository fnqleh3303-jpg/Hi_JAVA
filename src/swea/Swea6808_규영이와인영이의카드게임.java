package swea;

import java.util.Scanner;

public class Swea6808_규영이와인영이의카드게임 {
	static int win;
	static int lose;
	static boolean[] visited;
	static int[] gyu;
	static int[] in;
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	
	for(int tc=1;tc<=T;tc++) {
		gyu = new int[9];
		boolean[]isTrue = new boolean[19];//1부터 채울거야
		in = new int[9];
		
		for(int i=0;i<9;i++) {
			gyu[i] = sc.nextInt();
			isTrue[gyu[i]] = true;
		}
		
		int idx=0;
		
		for(int i=1;i<19;i++) {
			if(!isTrue[i]) {
				in[idx++]=i;//*인덱스를 하나씩 더해줘야지 한칸 채우면 다음칸에 담지. 
			}
		}
		
		win=0;
		lose=0;
		visited = new boolean[9];//*추가
		
		dfs(0, 0, 0);
		System.out.println("#"+tc+" "+win+" "+lose);
		
	}//테케 끝
}//메인 끝
    static void dfs(int round, int gScore, int iScore) {
    	//종료
    	if(round==9) {
    		if(gScore>iScore) win++;//근데 재귀에서 말하는 win이랑 여기서 말하는 win이랑 다른건가? 여기서는 횟수만 더하는 것 같은데 밑에 재귀파트에서는 score를 더하는 느낌이라서. 
    		//밑에는 순열로 경우의 수를 모두 더해서 뭐가 나오든 이기고, 지는거기 때문에 그 값을 넣는거고, 여기 종료파트에서는 9라운드 까지 다 하고 나서 마지막 결과물을 더하는 거라서 다른거야. 
    		else if(gScore<iScore) lose++;    	
    		return;//*return 적는거 까먹지 말기
    	}
    	
    	//재귀
    	int remain = 9-round;
    	int maxPossible=remain*35;//왜 여기서 18+17을 두번의 가지 수를 놔두고 계산하는거지? 16까지 더할 수도 있는거 아닌가?
    	//지금 말하는건 두가지 라운드의 수를 더하는게 아니고 두명이니까 18과 17을 서로 냈을때를 가정하는거라서 35가 되는거다. 
    	
    	if(gScore>iScore+maxPossible) {//더해도 의미 없을때
    		win+=factorial(remain);//남은 가짓수를 모두 더한다//*win에다가
    		return;
    	}
    	if(iScore>gScore+maxPossible) {
    		lose+=factorial(remain);//*lose에다가 더한다.
    		return;
    	}
    	
    	for(int i=0;i<9;i++) {
    		if(visited[i]) continue;//*visited배열 새로 생성
    		visited[i] = true;
    		
    		int g = gScore;
    		int inS = iScore;
    		
    		if(gyu[round]>in[i]) g+=gyu[round]+in[i];
    		else inS+=gyu[round]+in[i];
    		
    		dfs(round+1, g, inS);
    		
    		visited[i] = false;//복구
    	}
    	
    }
    
   private static int factorial(int remain) {
	   int res=1;
	   for(int i=1;i<=remain;i++) res*=i;//1에서부터 돌아도 되지 않아?
	   return res;
   }
}//클래스 끝