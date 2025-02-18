import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 1,2,3,4,5,5,7,8,9,10
 * 합이 s (15) 이상 중 길이가 가장 짧은 수열
 * 1+2+3+4+5 = 15
 * 2+3+4+5+5 = 19
 * 3+4+5+5 = 17
 * 4+5+5+7 = 21
 * 5+5+7 = 17
 * 결론 : 최초의 s 이상인 수열 발견 시 st 증가, s 미만일 때 en 증가
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열 길이
        int S = Integer.parseInt(st.nextToken()); // 합

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = arr[0];
        int ans = Integer.MAX_VALUE;
        while(start < N && end < N) {
            if (sum < S) {
                end++;
                if (end >= N)
                    break;
                sum += arr[end];
            } else {
                ans = Math.min(ans, end - start + 1);
                sum -= arr[start];
                start++;
                if (start >= N)
                    break;
            }
        }

        if (ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);

    }
}