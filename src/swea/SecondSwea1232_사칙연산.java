package swea;


import java.util.Scanner;

public class SecondSwea1232_사칙연산 {
	
    static class Node {
        String val; // 숫자 또는 연산자
        int left, right; // 자식 노드 번호 (없으면 0)

        Node(String val) {
            this.val = val;
        }
    }

    static Node[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            tree = new Node[n + 1]; // 노드 번호가 1부터 시작하므로 n+1

            for (int i = 0; i < n; i++) {
                int id = sc.nextInt();
                String input = sc.next();
                tree[id] = new Node(input);

                // 연산자인 경우 자식 노드 번호가 추가로 들어옴
                if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                    tree[id].left = sc.nextInt();
                    tree[id].right = sc.nextInt();
                }
            }

            // 루트(1번)부터 계산 시작
            double result = calculate(1);
            System.out.println("#" + t + " " + (int) result);
        }
    }

    // 재귀 함수: 각 노드에서 계산된 값을 반환함
    private static double calculate(int nodeIdx) {
        Node node = tree[nodeIdx];

        // 1. 종료 조건: 자식 노드가 없는 경우 (숫자 노드인 경우)
        if (node.left == 0 && node.right == 0) {
            return Double.parseDouble(node.val);//.parseouble()은 문자열(String)을 분석해서 실수(double)로 내어주는 메서드.
            //String에서 숫자만 가져오는 과정. 
        }

        // 2. 재귀 호출: 왼쪽과 오른쪽 서브트리의 결과를 먼저 가져옴 (후위 순회)
        double a = calculate(node.left);
        double b = calculate(node.right);

        // 3. 현재 노드의 연산자로 계산하여 결과 반환
        switch (node.val) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        
        return 0;
    }
}
