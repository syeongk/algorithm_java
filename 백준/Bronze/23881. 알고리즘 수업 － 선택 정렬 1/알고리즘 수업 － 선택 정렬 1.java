import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int i=N-1; i>0; i--){
            int max = 1;
            int maxIdx = -1;
            for (int j=i; j>=0; j--){
                if (arr[j] > max){
                    max = arr[j];
                    maxIdx = j;
                }
            }
            if (arr[i] != max){
                cnt += 1;
                if (cnt == K){
                    sb.append(arr[i] + " " + max);
                }
            }
            arr[maxIdx] = arr[i];
            arr[i] = max;
        }

        if (cnt < K) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
