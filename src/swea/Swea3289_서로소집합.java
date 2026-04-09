package swea;

import java.util.Scanner;

public class Swea3289_서로소집합 {
	static int[] p;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 테케 하나에 하나씩 sb를 생성해야지 초기화되는거지!
			StringBuilder sb = new StringBuilder();// 맞다맞다 sysout많이 하지말고 StringBuilder로 append해서 한번에 출력하기

			int n = sc.nextInt();
			int m = sc.nextInt();

			p = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				// 일단 처음에는 다 떨어져 있어서 자기자신이 부모니까.
				p[i] = i;
			} // 배열 p에 처음 부모들을 쫙 넣어놓기

			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < m; i++) {
				int doo = sc.nextInt();
				int from = sc.nextInt();
				int to = sc.nextInt();

				// 이 문제에서는 union, find-set만 하면 됨.

				// 만약 doo가 0이면 union하고, 1이라면 출력하라.
				if (doo == 0) {
					union(from, to);
				} else {
					if (findSet(from) == findSet(to)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}

			System.out.println(sb);
			
		}

	}// 메인 끝

	private static int findSet(int to) {// 누가 부모인가 물어보는건 인자 1개만 필요.
		// 여기서 필요로 하는 p의 역할은?
		// 원소가 어떤 그룹에 속하는지 부모를 적어놓기 위함.
		if (to != p[to])
			p[to] = findSet(p[to]);
		return p[to];

	}

	private static void union(int from, int to) {// 합치는건 인자가 2개 필요하지만
		p[findSet(to)] = findSet(from);

	}
}// 클래스 끝

