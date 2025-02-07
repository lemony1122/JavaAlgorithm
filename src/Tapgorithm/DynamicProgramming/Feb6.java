package Tapgorithm.DynamicProgramming;
import java.io.*;
import java.util.*;

public class Feb6 {
    public static int countCoinCases(int n, int k, int[] coins) {
        int[] dp = new int[k + 1];
        dp[0] = 1;  // 초기값 설정

        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j-coin];  // 현재 동전을 사용하는 경우의 수 추가
            }
        }

        return dp[k];  // 최종 결과 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(countCoinCases(n, k, coins));
    }
}
