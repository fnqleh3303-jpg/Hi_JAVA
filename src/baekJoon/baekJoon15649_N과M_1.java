package baekJoon;

import java.util.Scanner;

public class baekJoon15649_N과M_1 {
    static int N, M;
    static int[] result;   // 선택한 숫자를 저장할 배열
    static boolean[] visited; // 숫자 사용 여부를 체크할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt(); // 1부터 N까지의 자연수
        M = sc.nextInt(); // 중복 없이 M개를 고른 수열

        result = new int[M];    // M개를 담을 그릇 준비
        visited = new boolean[N + 1]; // 1번 숫자부터 N번 숫자까지 사용 체크

        // 0번째 위치부터 숫자를 채우기 시작
        dfs(0);
    }

    private static void dfs(int depth) {
        // [Base Case] M개를 모두 골랐다면 출력하고 재귀 종료
        if (depth == M) {
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            return; // 이전 호출 스택으로 돌아감
        }

        // [Recursive Step] 1부터 N까지 숫자를 하나씩 시도
        for (int i = 1; i <= N; i++) {
            // 아직 사용하지 않은 숫자인 경우에만 진행
            if (!visited[i]) {
                visited[i] = true;      // 1. 숫자 사용 표시 (방문 체크)
                result[depth] = i;      // 2. 현재 자리에 숫자 저장
                
                dfs(depth + 1);         // 3. 다음 자리(depth + 1)를 채우러 떠남
                
                // 4. ★백트래킹의 핵심: 돌아온 후에는 다시 사용 가능한 상태로 복구
                visited[i] = false;     
            }
        }
    }
}