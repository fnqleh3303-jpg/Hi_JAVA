package swea;

import java.util.Scanner;

public class Swea_2105_디저트카페 {
	
	static Cafe start;
	static boolean[] eat;
	static int ans;
	static int[] dr = {-1, 1, 1, -1};//방향 어떻게 할지 다시 보기
	static int[] dc = {1, 1, -1, -1};
	static int[][] map;
	
	
	
	private static class Cafe{
		int r,c;

		public Cafe(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			map = new int[n+2][n+2];//여기서 왜 굳이 n+2로 크기를 잡는거지?
			//int의 기본형은 0이잖아. 그래서 입력을 하지 않으면 자동으로 0이라는 벽이 생기는 거지. 
			
			for(int i=1;i<=n;i++) {//*n까지만 입력해야지
				for(int j=1;j<=n;j++) {//*여기도
					map[i][j] = sc.nextInt();
				}
			}//할당 끝
			ans=0;//*초기화 해놔야지
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					start = new Cafe(i, j);//스타트 지점 확정. //*클래스 만들어놓은 자료형으로 넣어야지!
					eat = new boolean[101];//디저트 종류가 1에서 100가지니까.
					eat[0] = true;//입력으로 값이 안들어간 0부분은 다 true라고 생각해보리기. 
					eat[map[i][j]] = true;//첫 위치에서도 디저트를 먹고 시작한거니까 표시 하기. 
					move(start, start, eat, 0);
					
				}
			}
			System.out.println("#"+tc+" "+(ans==0?-1:ans));//*ans 출력값 처리
		}//테케 끝
		
	}//메인 끝
	
	private static void move(Cafe start, Cafe curr, boolean[] eat, int dir) {//*Cafe타입으로 여기도 적어야지
		//종료 
		if(start.r==curr.r&&start.c==curr.c&&dir==3) {//*start타입이 Cafe니까 그 안에 내용 꺼내려면 Cafe클래스 인자를 꺼내야지. 
			int cnt=0;
			for(int i=1;i<=100;i++) {
				if(eat[i]) {
					cnt++;
				}
			}
			ans = Math.max(ans, cnt);//근데 이렇게 배교할 필요가 있나? 무조건 cnt로 들어가는거 아냐? 
			//놉 투어는 몇번이나 계속 되는거라서 그 투어들 사이에 갱신이 되는거야. 
			return;
		}
		
		//재귀
		for(int i=dir;i<dir+2&&i<4;i++) {
			int nr = curr.r + dr[i];
			int nc = curr.c + dc[i];
			
			//*시작점으로 돌아오는 경우 허용
			if(nr == start.r && nc == start.c && i == 3) {
		        move(start, new Cafe(nr, nc), eat, i);
		        continue;
		    }
			
			int dessert = map[nr][nc];
			
			if(!eat[dessert]) {
				eat[dessert] = true;
				move(start, new Cafe(nr, nc), eat, i);//여기서 어떻게 현재 위치가 바뀐다고 볼 수 있는거지? 
				//dir이 변화하고 있으니까 for문안에서 결국 nr, nc도 변하는거다. 
				eat[dessert] = false;
			}
		}
	}
}//클래스 끝

