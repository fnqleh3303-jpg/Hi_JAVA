package September;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2001_파리퇴치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }//입력완료

            int max = 0;
            for (int x = 0; x <= map.length - m; x++) {
                for (int y = 0; y <= map[x].length; y++) {
                    int sum = 0;
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            sum += map[x + i][y + j];
                        }
                    }
                    if (max < sum) max = sum;
                }
            }
        }//tc 끝
        sb.append("#").append(tc).append(" ").append(max);
        System.out.println(sb);

    }

}
