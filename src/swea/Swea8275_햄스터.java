package swea;

import java.util.Scanner;

public class Swea8275_햄스터 {

	static int[] l, r, s, cage, ans;
	static int n, x, m;
	static int maxsum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			x = sc.nextInt();
			m = sc.nextInt();

			l = new int[m];
			r = new int[m];
			s = new int[m];

			for (int i = 0; i < m; i++) {
				l[i] = sc.nextInt();
				r[i] = sc.nextInt();
				s[i] = sc.nextInt();

			}

			cage = new int[n + 1];// 답 넣을 케이지 생성
			ans = new int[n + 1];
			maxsum= -1;

			dfs(1);

			System.out.print("#"+tc+" ");
			if(maxsum ==-1) {
				System.out.println(-1);
			} else {
				for(int i=1;i<=n;i++) {
					System.out.print(ans[i] + " ");
				}
				System.out.println();
			}
		} // 테케 끝
	}// 메인 끝

	static private void dfs(int idx) {
//		if (found)// 여기서 check할 수는 없다. 왜냐면 아직 배열을 채우지도 못했으니까
//			return; //찾으면 무조건 return이라서 배치인지 확인 할 수 없음. 
		if (idx == n + 1) {// cage 배열 다 채웠다면

			if (check()) {
				int sum=0;
				for (int i = 1; i <= n; i++) {
					sum += cage[i];
				}
				if(sum> maxsum) {
					maxsum=sum;
					for(int i=1;i<=n;i++) {
						ans[i] = cage[i];
					}
				} else if(sum ==maxsum) {
					if(compare()) {
						for(int i=1;i<=n;i++) {
							ans[i] = cage[i];
						}
					}
				}
			}
			return;
		}

		for(int i=0;i<=x;i++) {
			cage[idx] = i;
			dfs(idx+1);
//			if (found) return;//..? 다시. check는 한번만 체크해도 되고 왜 found는 곳곳에 있는거야?
		}
	}

	static boolean check() {//근데 함수에 이렇게 인자가 없어도 되나? 필요한 인자들은 모두 static에 이미 존재함. 
		for (int i = 0; i < m; i++) {

			int sum = 0;

			for (int j = l[i]; j <= r[i]; j++) {//*r케이지도 포함해야함. 
				sum += cage[j];
			}
			if (sum != s[i]) {//왜 동일하면 true를 먼저 적는게 아니고 false를 먼저 적는거지?
				//다 더한 값이 s가 아니면 false로 어서 쳐내려고
				return false;
			}
		}
		return true;//for문으로 m번 메모까지 다 돌았는데도 숫자가 맞다 하면 true 뱉기
	}
static boolean compare() {
	for(int i=1;i<=n;i++) {
		if(cage[i]<ans[i]) return true;
		if(cage[i]>ans[i]) return false;
	}
	return false;
}
}// 클래스 끝
//8시 3분
