package Tapgorithm.DynamicProgramming;

import java.util.*;
import java.io.*;

public class Feb7 {

    public static int maxPathSum(int n, int[][] triangle) {
        // dp 배열 초기화
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        // 모든 위치에서 최대 합 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][0];  // 왼쪽 끝인 경우
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][i];  // 오른쪽 끝인 경우
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];  // 중간인 경우
                }
            }
        }

        // 마지막 행에서 최대값 찾기
        int maxSum = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            maxSum = Math.max(maxSum, dp[n - 1][j]);
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(maxPathSum(n, triangle));
    }
}
