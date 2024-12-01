import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 입력 받기
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 물건의 수
        int K = Integer.parseInt(firstLine[1]); // 배낭의 최대 무게

        // DP 배열 초기화
        int[] dp = new int[K + 1]; //dp[7]: 배낭의 용량이 7일 때 얻을 수 있는 최대 가치.

        // 물건 정보 입력 및 DP 배열 업데이트
        for (int i = 0; i < N; i++) {
            String[] item = br.readLine().split(" ");
            int W = Integer.parseInt(item[0]); // 물건의 무게
            int V = Integer.parseInt(item[1]); // 물건의 가치

            // DP 업데이트
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        // 결과 출력
        System.out.println(dp[K]);
    }
}
