package September;
/*
입력으로 들어오는 것: tc, 예시
저장해야 하는 값: 예시, 회문여부 숫자
반복해서 할 일: 회문검사
사용할 자료구조: String
회문이 아니라는 판단 기준: charAt해서 앞뒤 비교해서 동일할 ㅒ
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea1989_초심자의_회문검사 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            String word = br.readLine();

            int left=0;
            int right = word.length() -1;
            int answer =1;

            while (left<right){
                if(word.charAt(left) != word.charAt(right)){
                    answer=0;
                    break;
                }
                left++;
                right--;
            }//회문 끝
            output.append("#").append(tc).append(" ").append(answer).append("\n");
        }//tc
        System.out.println(output);
    }//메인
}//클래스
