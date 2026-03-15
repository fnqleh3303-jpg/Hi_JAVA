package swea;

import java.util.Scanner;
 
public class Swea1952_수영장 {
     
    static int ans, d, m1, m3, y;
    static int[] month;
     
     
    public static void main(String[] args) {
         
    Scanner sc = new Scanner(System.in);
     
    int T= sc.nextInt();
    for(int tc=1;tc<=T;tc++) {
        d = sc.nextInt();
        m1 = sc.nextInt();
        m3 = sc.nextInt();
        y = sc.nextInt();
         
        month = new int[13];//한달에 하나씩 인덱스 1부터 채운다
         
        for(int m=1;m<13;m++) {
            month[m] = sc.nextInt();
        }//할당 끝
         
        ans=y;//ans 초기화 해줘야지(최소값을 찾는거니까 1년권으로)
        fee(1, 0);
 
        System.out.println("#"+tc+" "+ans);
         
    }//테케 끝
    }//메인 끝
     
    static void fee(int m, int fee) {
        //종료
        if(m>=13) {
            ans = Math.min(ans, fee);//ans가 계속 갱신되는거니까 ans랑 fee랑 비교.
        return;//아오 좀 익혀라
        }//*return도 if문 안에 넣어야지 */
         
        //재귀
        fee(m+1, fee + Math.min(month[m]*d, m1));
 
        fee(m+3, fee+m3);
         
    }//메인 끝
}//클래스 끝