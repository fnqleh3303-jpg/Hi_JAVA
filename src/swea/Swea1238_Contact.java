package swea;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Swea1238_Contact {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int num = sc.nextInt();
			int start = sc.nextInt();

			boolean[][] store = new boolean[101][101];// 최대 100명이라고 했으니까 일단 만들어놓기

			for (int i = 0; i < num / 2; i++) {

				int from = sc.nextInt();
				int to = sc.nextInt();

				// *행렬에 있는 숫자들이 from to 니까 지금 넣을건 없고 boolean 2차 배열로 true 확인해주면 된다.
				store[from][to] = true;// 여기 어떻게 넣더라
			} // 할당 끝

			Queue<Integer> que = new ArrayDeque<>();
			boolean[] visited = new boolean[101];
			int[] depth = new int[101];// 얼만큼 멀리 들어가는지 저장

			que.add(start);// 일단 시작은 해야하니까
			visited[start] = true;

			while (!que.isEmpty()) {
				
				int now = que.poll();
//				visited[now] = true; //*얘는 안해도 돼. 애초에 start는 boolean에서 true 하고 넣은거고, next를 넣을 때
				//visited true하니까 한번 더 해줄 필요가 없어.

				for (int i = 1; i <= 100; i++) {
					
					if (store[now][i]&&!visited[i]) {//여기서 boolean store로 검증할거면 visited 배열이 필요한 이유는?
						int next = i;
						visited[next] = true;
						depth[next] = depth[now] + 1;// 얼만큼 들어가는지 기록
						que.add(next);
					}

				}
			} // while문 끝
			
			//제일 깊게 들어가는데 숫자가 큰걸로 뽑아야 하니까. 
			int max = 0;//visited 배열에서 실제 true, false는 인덱스 0에서는 안써지니까 이렇게 해도 돼.
			//*그치만 의미를 생각해본다면 int max = start로 하는걸 추천해. 

			for (int i = 1; i <= 100; i++) {
				
				if(!visited[i]) continue;//*방문안한 곳은 빼고 생각해야지.
				
				if (depth[i] > depth[max]) {
					max = i;
				} else if (depth[i] == depth[max] && i > max) {
					max = i;
				}
			}

			System.out.println("#" + tc + " " + max);

		} // 테케 끝
	}// 메인 끝
}// 클래스 끝
//2시 26분
//store은 어디서 어디를 갈 수 있다는 map역할이고
//visited는 방문여부를 확인하는 배열이다. 역할 생각하면서 코드 작성하기!
