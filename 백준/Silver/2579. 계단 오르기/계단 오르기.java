import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 테이블 정의 : i번째 계단에 올라왔을 때의 최댓값 (목푯값 설정하자)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N+1];
        for (int i=1; i<=N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];

        if (dp.length == 2) {
            System.out.println(stairs[1]);
            return;
        } else if (dp.length == 3) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        }

        dp[0] = 0;
        dp[1] = stairs[1];
        dp[2] = Math.max(dp[0] + stairs[2], dp[1] + stairs[2]);

        for (int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
        }

        System.out.println(dp[N]);

    }
}
