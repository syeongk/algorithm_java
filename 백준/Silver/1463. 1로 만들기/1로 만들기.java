import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];

        dp[0] = -1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 3;

        int temp = 0;
        for (int i = 6; i <= N; i++){
            if(i % 3 != 0 && i % 2 != 0) // 2와 3 모두 나누어 떨어지지 않아서 2 또는 3으로 나눌 수 없음
                dp[i] = dp[i - 1] + 1;
            else if (i % 3 != 0) // 3으로 나누어 떨어지지 않아서 3으로 나눌 수 없음
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            else if (i % 2 != 0) // 2로 나누어 떨어지지 않아서 2로 나눌 수 없음
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            else {
                temp = Math.min(dp[i - 1], dp[i / 3]);
                dp[i] = Math.min(temp, dp[i / 2]) + 1;
            }
        }

        System.out.println(dp[N]);
    }
}
