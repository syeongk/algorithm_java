import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine()); // 동전 종류 수
            int[] nums = new int[N]; // 동전 종류 저장할 배열
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) { // 동전 종류 입력 받기
                nums[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine()); // 만들어야 할 금액

            int[] dp = new int[M+1]; // 동전 종류로 i원 만들 수 있는 경우의 수
            dp[0] = 1; // 동전 1개 사용하는 경우
            // 동전의 종류가 1,2 면 dp에 1원으로 만들 수 있는 경우의 수 먼저 더하고, 2원 더함
            for (int j=0; j<N; j++){ // 동전의 종류
                for (int k=1; k<=M; k++){ // 만들어야 하는 숫자
                    if (k-nums[j] < 0)
                        continue;

                    dp[k] += dp[k-nums[j]];
                }
            }
            sb.append(dp[M] + "\n");
        }
        System.out.println(sb);


    }
}
