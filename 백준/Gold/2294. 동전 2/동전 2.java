import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 동전 종류수
        int k = Integer.parseInt(input[1]); // 목표 금액

        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1]; // dp[0] ~ dp[15] 까지 존재
        dp[0] = 0;

        for (int i=1; i<=k; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<=k; i++){ // dp[k] 채우기. k는 1~15
            for (int num: nums){
                if (i-num < 0) continue;
                if (dp[i-num] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-num]); // dp 에 저장된 값과, 현재 사용한 동전 비교 (동전 사용 최소가 되도록 하기 위해)
            }
        }

        if (dp[k] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
