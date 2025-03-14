import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 동전 종류 갯수
        int k = Integer.parseInt(input[1]); // 목표

        int[] coins = new int[n];
        for (int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1]; // dp 0~10 까지 저장
        dp[0] = 1;
        for (int coin : coins){
            for (int i=1; i<=k; i++){
                if (i - coin < 0) continue;
                dp[i] += dp[i-coin];
            }
        }

        System.out.println(dp[k]);
    }
}
