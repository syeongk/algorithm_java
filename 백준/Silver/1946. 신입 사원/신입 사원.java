import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken());
                score[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(score, (a,b) -> Integer.compare(a[0], b[0]));

            int cnt = 1;
            int min = score[0][1];
            for (int j = 1; j < N; j++){
                if (score[j][1] < min){
                    min = score[j][1];
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
