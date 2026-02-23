package swea;
//문제있음. 20케이스 중 1개만 맞음. 다시 해볼 것
import java.util.Scanner;

public class Swea7087_문제제목붙이기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc < T; tc++) {
			int n = sc.nextInt();
			char[] original = new char[n];
			int[] alphabat = new int[26];

			for (int i = 0; i < n; i++) {
				String string = sc.next();
				original[i] = string.charAt(0);// 첫글자를 original 배열에 넣
				alphabat[original[i] - 'A']++;//*뭘 어떻게 할건지를 알려주지 않아도 에러가 난다. 더할거면 []++붙이기//알파벳이 존재한다면 값은 1이상일거다.
				// 오리지날 배열에 있는 char 형태를 -'A'를 통해 0부터 25까지 26크기의 배열에 집어넣을거야.
			}

			int res = 0;
			int firstIdx = -1;// *만약 아직 값이 존재하는 인덱스를 찾지 못했다면 -1일거다.

			for (int j = 0; j < 26; j++) {// 일단 알파벳 배열을 돌면서 null이 있는지 없는지 알아야하니까 탐색시작
				if (firstIdx == -1 && alphabat[j] != 0) {// 만약 값이 존재한다면 그건 첫 인덱스.//*char 자료형의 기본형은 '\u0000'이다!//근데 알파벳 베열은 int형이니까 0이 기본.
					// *값만 존재한다고 첫번째 인덱스가 아니라 지금까지 firstIdx가 갱신되지 않았으면서 값이 존재해야지.
					firstIdx = j;
				}
				if (firstIdx != -1) { // *firstIdx를 구한상태에서
					//*재용추천 while문 새로 안에 만들기. 읽기도 더 쉽고, 디버깅하기도 굿.//그리고 첫 글자가 아니라 a부터 존재만 하면 되니까 count++만 할것.


					if (alphabat[j+1] == 0) {// 이미 연속된 count는 시작됐고, 만약 그 인덱스의 값이 존재한다면
						res = j - firstIdx;
						break;

					} else if(j==25){ //*alphabat 배열을 다 돌았다면// '\u0000'인 칸을 만나면 return [지금 인덱스]-[처음 시작인덱스]
						res = 26 - firstIdx;//*break뒷줄은 작동하지 않는다.
						break;
					}
				}
//				firstIdx++;
			}

			System.out.println("#" + tc + " " + res);

		} // 테케끝

	}
}

/*문제제목붙이기 (8:13) ~ 9:10;

테케 받고
몇개 문자 받을지 배열로 char [N]
for 문으로 탐색하면서 문자의 첫 글자들만 배열에 넣는다. -'A' (배열의 0부터 넣는다) 
	그리고 얘를 26개 알파벳 대문자 배열에 넣는다. (카운팅 정렬)
	그리고  if(처음 값이 있는 곳으로 가서 시작한다.)  '\u0000'인 칸을 만나면 return [지금 인덱스]-[처음 시작인덱스]

조건1. 처음 값이 있는곳에서 시작
2. 그 [인덱스+1]에 값이 존재하면 탐색 계속. 
만약 [인덱스+1]에 값이 존재하지 않으면 return [지금 인]-[처음 시작[인]

for(알파벳 배열 26개 탐색
while(알파벳 탐색해서 값이 있으면){
count++
if(alphabat[지금 인덱스+1]이 기본값이 아니라면
continue;
else
break;
return 지금 인덱스-처음 카운트 인덱스;

6탐색중 7이 없네
근데 4부터 있어서 456 총 3개 야. 
*/