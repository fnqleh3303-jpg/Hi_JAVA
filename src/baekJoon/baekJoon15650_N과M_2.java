package baekJoon;

import java.util.Scanner;

public class baekJoon15650_N과M_2 {
	
	static int n, m;
	static int[] ans;
//	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		ans = new int[m];
//		visited = new boolean[n+1];
		
		round(0, 1);
	}//main함수 끝

	private static void round(int idx, int start) {//*함수에서 파라미터 많이 쓰는거 무서워하지 않기!
		//종료
		if(idx == m) {//여기 boolean 없는데 무슨 말이지 *if문 조건에는 boolean이 들어가야하는데 idx=m은 할당이라서 컴파일에러.
			//*m까지 배열 다 채우고 m+1까지 되어야지 출력해야 답이 나오지 
//				
//					for(int j=0;j<m-1;j++) {//이렇게 하면 비효율
//						if(ans[j]>=ans[j+1])return;
//					}
				
					for (int i = 0; i < m; i++) {//*for문안에 또 for문을 작성할때는 사용하는 알파벳 확인하기, 그리고 디버깅할때 읽기 쉽게 중첩 안할 수 있으면 안하기
				
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		//재귀
		for(int i=start;i<=n;i++) {//start부터 넣는건데 start가 하나씩 커지는 거니까
			ans[idx] = i;
//			visited[i] = true;
			round(idx+1, i+1);//실제 재귀에 영향을 주는건 i이다. 
//			visited[i] = false;
		}
		
	}//round 함수 끝
}//클래스 끝
//11시 15분 오름차순만 뱉으려면 흠

