import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for (int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (start < N && end < N) {
            if (A[end] - A[start] >= M){ //최초의 M보다 같거나 큰 숫자 찾음
                if (min > Math.min(min, A[end]-A[start])){ //min 보다 작은 숫자라면
                    min = Math.min(min, A[end]-A[start]); //min 을 갱신함
                }
                start++; //start 증가시킴
            } else { //최초의 M보다 같거나 큰 숫자를 찾지 못 함 (M보다 작음)
                end++; //end 증가시킴
            }
        }

        System.out.println(min);
    }
}
