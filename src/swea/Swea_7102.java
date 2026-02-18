
package swea;
import java.util.Scanner;

public class Swea_7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {// tc 반복
			int n = sc.nextInt();
			int m = sc.nextInt();
			int res = 0;
			int[] row = new int[n + m + 1];// 빈도로 넣을 배열 준비//0부터 시작하니까 +1

			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < m + 1; k++) {

					int hap = j + k;
//					int count = 0;  //얘 굳이 필요 없네

					// 1. 만약 hap이 인덱스와 동일하다면 row 배열[hap]을 ++해줘라. 놉 이게 아니지.
//					if (row[hap] == hap) {// 배열 인덱스랑 동일하게 hap 넣기
//						row[hap] = count++;

					// hap과 동일한 인덱스 번호에 row 배열[hap]을 count++해줘라

					row[hap]++;// 한줄로 할 수 있네.
					// row[j+k]++;로도 가능.

//					}
				}
			}
			// 2. 값이 가장 큰 인덱스 번호를 출력해라.
			int max = 0;
			for (int idx = 0; idx < n + m + 1; idx++) {
				if (row[idx] > max) {// 여기서는 그냥 맥스 값을 찾는걸로 만족해
					max = row[idx];// 내가 지금 max에 넣고 싶은건 배열 안에 있는 값이야.
				}
			}

			System.out.print("#" + i + " ");
			for (int idx = 0; idx < n + m + 1; idx++) {// 인덱스가 작은거부터 도니까 작은숫자별로 해당 조건만 충족하면 출력될 예정.
				if (row[idx] == max) {
					res = idx;// 내가 출력하고 싶은건 인덱스 넘버.

					System.out.print(res +" ");
				}
			} // res에서는 max 해당하는거 다 뱉.
			
			System.out.println();
		} // tc케이스 반복
	}
}
