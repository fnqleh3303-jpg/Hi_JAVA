package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Swea1219_길찾기 {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	static boolean check;
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	for(int tc=0;tc<10;tc++) {
		
		int T = sc.nextInt();
		int line = sc.nextInt();
		graph = new ArrayList[100];
		
		for(int i=0;i<100;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<line;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			graph[from].add(to);
		}//할당 끝
		
		dfs(0);
		System.out.println(graph[0].get(0));
//		System.out.println("#"+ T + " "+ dap);
	}
}

private static void dfs(int start) {
	//종료
	if() {
		
		
	}
	
}
}
