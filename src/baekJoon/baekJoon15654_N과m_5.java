package baekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class baekJoon15654_N과m_5 {

	static int n, m;
	static int[] ans, given;
	static StringBuilder sb = new StringBuilder();// 여기서 초기화
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		given = new int[n];
		ans = new int[m];
		visited = new boolean[n];//딱 지금 이미 쓴 것만 제외하고 쓰고 싶을때는 true인건 제외하자는 의미에서 boolean배열 필요. 

		for (int i = 0; i < n; i++) {
			given[i] = sc.nextInt();
		}
		Arrays.sort(given);// 오름차순으로 정렬하는 함수 //*있고 없고의 차이

		ham(0);

		System.out.println(sb);
	}

	private static void ham(int idx) {//*인자 start여부에 따른 차이/ boolean으로 방문체크
		// 종료
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 재귀근데 
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;//*true면 continue해라.//얘가 있어야 boolean배열이 의미가 있는거니까!
			
				ans[idx] = given[i];
				visited[i] = true;
				ham(idx + 1);
				visited[i] = false;
			
		}

	}
}
//출력되는 수열이 오름차순으로 되어야 해. 
//중복되는 글자를 사용할 수 는없어야 해. 

