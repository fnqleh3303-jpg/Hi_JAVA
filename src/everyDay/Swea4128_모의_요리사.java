package everyDay;

import java.util.Scanner;

public class Swea4128_모의_요리사 {
	
	static int n, min;
	static int[][] sin;
	static boolean[] visited;
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int T = sc.nextInt();
	for(int tc=1;tc<=T;tc++) {
		n = sc.nextInt();
		
		sin = new int[n][n];//시너지 입력받을 2차 배열
		visited = new boolean[n];//재료 n개 중에 몇개를 foodA에 담을건지 dfs들어가면서 visited 체크 할 1차 배열
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sin[i][j] = sc.nextInt();
			}
		}//할당 완
		
		min=Integer.MAX_VALUE;//테케 돌때마다 min초기화
		
		dfs(0, 0);//처음엔 ids=0부터 시작해서 아직 아무도 선택 안했으니까 count 도 0.
		
		System.out.println("#"+tc+" "+min);
	}//테케 끝
}//메인 끝

private static void dfs(int idx, int count) {//지금 어디를 뽑을건지, 몇개를 뽑았는지 -> 두가지 묶음을 나누는 메서드
	
	if(count==n/2) {//두 묶음으로 모두 다 나눠졌다면 계산하라
		calculate();
			return;
		}
	
	if(idx==n) return;//n개수만큼 다 돌았는데 n/2만큼 선택 못했으면 이건 두가지 묶음의 갯수가 다른거다. 못쓰는거. 
	
	visited[idx]=true;
	dfs(idx+1, count+1);
	
	visited[idx]=false;
	dfs(idx+1, count);
	
	}


private static void calculate() {//두가지 묶음에서 시너지 계산을 하는 메서드 *맞다 메서드 작성할 때 파라미터는 없어도 되는거였어. 
	
	int foodA = 0;
	int foodB = 0;
	
	for(int i=0;i<n;i++) {//*계산 할 때 이미 visited로 t, f구분을 해놨으니까 visited 배열의 끝인 n까지 둘다 돌아야 해. 근데 중복되지 않으려면
		//*i부터 첫 for문은 시작하돼, j는 i이후부터 시작해야지. 
		for(int j=i+1;j<n;j++) {
			
			if(visited[i]&&visited[j]) {
				foodA+=sin[i][j]+sin[j][i];
			} else if(!visited[i]&& !visited[j]) {
				foodB+=sin[i][j]+sin[j][i];
			}
			
			
		}
	}
	min = Math.min(min, Math.abs(foodA - foodB));//*이렇게 하면 min은 갱신되지 않아서 결국에 ans는 마지막 계산된 조합의 차가 된다. 
	
}
}//클래스 끝
//답은 나오는데 숫자가 이상하다. 그러면 일단 초기화, for문범위 확인하기, 생각보다 너무 크거나 작으면 갱신이 잘 되고 있는지도 확인 필요. 
