package swea;

import java.util.Scanner;

public class Swea14510_나무높이 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//테케 받기

        for (int tc = 1; tc <= T; tc++) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            int max = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                max = Math.max(max, arr[i]);
            }//여기서 max 알아내기

            int one = 0;
            int two = 0;

            for (int i = 0; i < n; i++) {

                int diff = max - arr[i];

                two += diff / 2;
                one += diff % 2;
            }

            while (two > one) {
                two--;
                one += 2;
            }

            int days;

            if (one > two) {
                days = one * 2 - 1;
            } else {
                days = one * 2;
            }

            System.out.println("#" + tc + " " + days);
        }
    }
}