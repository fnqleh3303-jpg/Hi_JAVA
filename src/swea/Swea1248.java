package swea;

import java.util.Scanner;

public class Swea1248 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            int nodeNum = sc.nextInt(); // V (정점 개수)
            int line = sc.nextInt();    // E (간선 개수)
            int targetA = sc.nextInt(); // 찾을 노드 1
            int targetB = sc.nextInt(); // 찾을 노드 2
            
            // 1. 트리 정보를 저장할 배열들
            int[][] children = new int[nodeNum + 1][2]; // 자식들 저장
            int[] parent = new int[nodeNum + 1];        // 부모 저장 (상향 탐색용)

            for (int j = 0; j < line; j++) {
                int p = sc.nextInt();
                int c = sc.nextInt();
                
                // 자식 저장 (왼쪽이 비었으면 0번, 아니면 1번에 저장)
                if (children[p][0] == 0) {
                    children[p][0] = c;
                } else {
                    children[p][1] = c;
                }
                parent[c] = p; // 부모 정보 업데이트. if문에서 children배열을 채우면서 parents배열도 세운셈. 
            }//일단 배열안에 할당은 모두 끝!

            // 2. 공통 조상 찾기
            // targetA의 조상들을 체크 (boolean 배열 활용)
            boolean[] ancestors = new boolean[nodeNum + 1];
            int curr = targetA;//targetA는 입력받아서 시작되는 곳인데, 그 변수를 가지고 while문을 돌리면 시작점이 이더라? 하는 문제가 생기니까 일단 현재의 위치cur로 설정해서 따로 관리.
            while (curr != 0) {//루트노드까지 도달하지 않을때까지 반복해라
                ancestors[curr] = true;//내가 지금 서있는 인덱스를 true로 변환.
                curr = parent[curr]; // 위로 올라감. curr을 parents에 넣으면서 부모 값으로 curr을 이동하고 있다. 
            }

            // targetB의 조상을 따라 올라가며 처음 겹치는 노드 찾기
            int commonAncestor = 0;//최종적으로 가장 가까운 공통 조상을 담을 바구니.
            curr = targetB;
            while (curr != 0) {
                if (ancestors[curr]) {//이미 ancestors 변수에 true라고 길을 표시해놨으니까 이 곳을 만나면 commonAncestor가 되는거지. 
                    commonAncestor = curr;
                    break;//가장 가까운 동일 부모를 찾느거니까 break로 끝내버려.
                }
                curr = parent[curr];//ancestor랑 동일하지 않으면 계속해서 위로 올라가야하니까 curr를 부모로 변경해줘야해.
            }

            // 3. 서브트리 크기 계산 (공통 조상부터 시작해서 자식들 개수 세기)
            int subtreeSize = countSubtree(commonAncestor, children);//따로 재귀함수 만들어서 사용. 

            System.out.println("#" + i + " " + commonAncestor + " " + subtreeSize);
        }
    }

    // 재귀적으로 서브트리 노드 개수를 세는 함수
    public static int countSubtree(int node, int[][] children) {
        if (node == 0) return 0;//node ==0이라는 뜻은 자식이 없다는 뜻. 
        
        // 1(자기자신) + 왼쪽 자식 트리 크기 + 오른쪽 자식 트리 크기
        return 1 + countSubtree(children[node][0], children) 
                 + countSubtree(children[node][1], children);
    }
}
