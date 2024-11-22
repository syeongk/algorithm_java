import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];

        dp[0] = Integer.MAX_VALUE;
        dp[1] = Integer.MAX_VALUE;
        dp[2] = Integer.MAX_VALUE;
        dp[3] = 1;
        dp[4] = Integer.MAX_VALUE; //봉지 수 구할 수 없는 것
        dp[5] = 1;

        for (int i=6; i<=N; i++){
            if (dp[i-3] == Integer.MAX_VALUE && dp[i-5] == Integer.MAX_VALUE)
                dp[i] = Integer.MAX_VALUE;
            else
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        }

        if (dp[N] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[N]);
    }
}