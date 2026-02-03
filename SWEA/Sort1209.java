import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sort1209 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("1209.txt");
		Scanner sc = new Scanner(file);//다른 곳에서 돌릴때에는 파일 지우고 직접 입력 코드로 바꾸기
//		Scanner sc = new Scanner(System.in);
		for (int k = 0; k < 10; k++) {// k는 테스트 케이스 10번 반복
			int n = sc.nextInt();// 테스트 케이스 받는 변수 n
			int[][] box = new int[100][100];// 배열 새로 만들때는 new 자료형[]하기! //가로세로100인 배열 생성

			for (int i = 0; i < 100; i++) {// 가로 채우기
				for (int j = 0; j < 100; j++) {// 세로 채우기
					box[i][j] = sc.nextInt();//
				}
			} // 가로세로 100 배열 채우기 완료//이 블럭을 나가도 지역변수는 사라지지만 [100][100]배열은 아직 차 있다. ---> 이 부분 더
				// 생각해보기
			int max = 0;// 최대값 나오는 변수 선언 //얘는 max가 한번 초기화 되고 가로세로줄 합을 구하고 나서 또 초기화로 돌아오는게 아니니까 가로세로 합 중에 max가 담겨서 뒤에 그대로 사용할 수 있는거야.
			int rowSum = 0;// 선언은 여기서
			int colSum = 0;//선언은 여기서
			for (int i = 0; i < 100; i++) {// 가로줄 합 구하기
				rowSum = 0;// 행의 합 //가로 한줄하고 초기화를 하려고 하니까 여기 들어가야해.//얘는 for문 안에 있는 내용이라서 초기화를 다시 거쳐서 0이 되는거다. 
				colSum = 0;// 열의 합 //세로 한 줄하고 초기화를 하려고 하니까 여기 들어가야 해.
				for (int j = 0; j < 100; j++) {// i는 고정이고 j를 넣는 중
					rowSum = rowSum + box[i][j];// 이니까 여기서 넣으면 한 줄씩 들어가는거지.
					colSum = colSum + box[j][i];
				}
				if(max<rowSum || max<colSum) {//일단 행합, 열합 이랑 max비교
					max = Math.max(rowSum, colSum);
				}
			} // 가로줄 합 구하기 끝 // 세로줄 합 구하기 끝

			int rightDown = 0;// 우하향 대각선 합
			int rightUp = 0;// 우상향 대각선 합
			for (int i = 0; i < 100; i++) {
				rightDown = rightDown + box[i][i];
				rightUp = rightUp + box[99 - i][i];
			} // 우하향 대각선 합 구하기 끝 //우상향 대각선 합 구하기 끝
			
			if(max<rightDown || max<rightUp) {
				if (rightDown > rightUp) {
					max = rightDown;
				} else {
					max = rightUp;
				}
			}
			
			System.out.println("#"+n+" "+max);
		} // 테스트케이스 끝.
		sc.close(); //메인함수 안에서 스캐너 끄기!
	}// main함수 끝
}// 클래스 끝
//*인덱스는 0부터 시작하는거 까먹지 않기!  	*동일한 변수에 값을 연속해서 넣으면 마지막 수만 들어가게 되니까 math.max()같은거 사용하기.