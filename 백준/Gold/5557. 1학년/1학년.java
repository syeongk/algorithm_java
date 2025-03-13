import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // nums : 0~n-1까지 각각의 숫자가 저장됨 nums[0] = 8, nums[n-1] = 8
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // dp : 0~n-1 까지 (dp[10][8] 출력해야 함)
        long[][] dp = new long[n][21]; // i번째 숫자에서 j가 되는 경우의 수
        dp[0][nums[0]] = 1;
        for (int i=1; i<n; i++){
            for (int j=0; j<=20; j++){
                if (dp[i-1][j] > 0){ // 이전 반복문에서 나온 숫자 11, 5
                    if (j+nums[i] >= 0 && j+nums[i] <= 20) // 11에서 2를 더했을 때 20보다 작은 경우
                        dp[i][j+nums[i]] += dp[i-1][j]; // 11에서 2를 더함
                    if (j-nums[i] >= 0 && j-nums[i] <= 20) // 11에서 2를 뺐을 때 20보다 작은 경우
                        dp[i][j-nums[i]] += dp[i-1][j]; // 11에서 2를 뺌
                }
            }
        }
        System.out.println(dp[n-2][nums[n-1]]);

    }
}
