package baekJoon;
import java.util.Arrays;
import java.util.Scanner;

public class baekJoon15655_N과M_6 {

	static int n, m;
	static int[] given, ans;
	static StringBuilder sb = new StringBuilder();
//	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		given = new int[n];
		ans = new int[m];//ans 배열 초기화 아예 안해서 nullpointException이 나온거야!
//		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			given[i] = sc.nextInt();
		}

		Arrays.sort(given);//사전 순으로 증가하는 순서로 정렬

		ham(0, 0);//왜냐면 어쨌든 이건 인덱스 번호로 관리되어야하는거기 때문에 start도 0부터 시작. 

		System.out.println(sb);//여기 축적되는거니까 한번만 출력하기
	}

	private static void ham(int idx, int start) {
		
		// 종료
		if (idx == m) {
			
//			for(int i=0;i<m-1;i++) {//종료 조건에 조건 하나 달기
//				if(ans[i]>=ans[i+1]) return;
//			}
			
			for (int i = 0; i < m; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 재귀
		for (int i = start; i < n; i++) {
//			if(visited[i]) continue;
			
			ans[idx] = given[i];
//			visited[i] = true;
			ham(idx + 1, start+1);//여기 i+1을 하는 이유는 for문에 돌때 나보다 큰 수를 다음 idx에 넣기 위해서다. 
//			visited[i] = false;
		}

	}

}
//4시 31분//4시 56분
//ham(idx+1, start+1)을 한다면?
//4 2    9 8 7 1 을 예로 들었을때, 첫번재 stack이 한칸 쌓이고, 첫칸이 쌓일 때, 처음 들어가는 값이 두번째 순서인 7부터 들어가게 된다. 
//그래서 start+1을하게 되면 오름차순이 아니고 두번째 칸은 7부터 들어가는 거다!