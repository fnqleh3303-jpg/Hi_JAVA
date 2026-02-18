package swea;
import java.util.Scanner;

public class AppleTree {
	public static void main(String[] args) {
		String input = "5\r\n"
				+ "1 1 1 1 1\r\n"
				+ "1 1 1 2 2\r\n"
				+ "1 1 1 2 1\r\n"
				+ "1 9 1 1 1\r\n"
				+ "1 1 1 1 1"; //입력값 여기에 넣음. 공백으로 읽어들이니까 꼭 공백 넣어서 입력하기
		
		Scanner sc = new Scanner(input); //이미 String input에 넣어놨다는 의미로 input이라고 작성. 
		
		int N = sc.nextInt(); //배열 칸수 n받음.
		int[][] map = new int[N][N]; //배열 생성
		int max = 0;
		
		
		for (int i=0;i < map.length;i++) {
			for(int j=0;j<map.length;j++) {
				map[i][j] = sc.nextInt();
			}
		}//map에 입력값 배치완료
		
		int[]dr = {-1, 1, 0, 0};//상하좌우
		int[]dc = {0, 0, -1, 1};//상하좌우
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int sum = map[i][j];//현재위치 탐색
				
				for (int k=0; k<4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];//현재 위치+상하좌우
					
					if(nr<0||nc<0||nr>=N||nc >= N || map[nr][nc] == 0) {//
							continue;//인 경우에는 skip
					}
					sum = sum +map[nr][nc]; //현위치+상하좌우 합 구하기
				}
				if(max<sum) {
					max=sum;//기존 max보다 sum이 더 크다면 max에 할당.
				}
			}
		}
		System.out.println(max);//메인함수 끝나기 전에 max할당.
		sc.close();
	}
}
