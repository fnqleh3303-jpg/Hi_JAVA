package swea;

import java.util.Scanner;

public class SecondSwea1248_공통조상 {
	static int V, E, targetA, targetB;
	static int[][] children;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			targetA = sc.nextInt();
			targetB = sc.nextInt();

			children = new int[V + 1][2];
			parent = new int[V + 1];
			visited = new boolean[V + 1];

			for (int i = 0; i < E; i++) {//왜 노드는 v개 인데 넣는 행위는 e만 해도 다 차는건가?//*응 왜냐면 하나의 간선에 부모자식 두가지 정보가 있으니까
				int p = sc.nextInt();
				int c = sc.nextInt();

				if (children[p][0] == 0)
					children[p][0] = c;
				else
					children[p][1] = c;

				parent[c] = p;//할당 넣으면서 parent 배열도 한번에 채우기. 얘의 목적은 바로 parents 알아내기 위함. 
			}

			findAncestors(targetA);
			int commonAncestor = findCommon(targetB);
			int subtreeSize = countNodes(commonAncestor);
			
			System.out.println("#"+tc+" "+ commonAncestor + " "+ subtreeSize);
			
		} // 테케 끝
	}// 메인 끝
	
	private static void findAncestors(int node) {//여기 들어가는 node는 무슨 뜻이야?
		if(node==0) return;//0일때는 어떤 경우가 되는거야?
		visited[node] = true;
		findAncestors(parent[node]);
	}
	
	private static int findCommon(int node) {
		if(visited[node]) return node;
		return findCommon(parent[node]);
	}
	
	private static int countNodes(int node) {
		if(node ==0) return 0;//왜 노드가 없는 상황을 가정해서 return해주는 거야?
		return 1 + countNodes(children[node][0]) + countNodes(children[node][1]);
	}

}// 클래스 끝
