import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cons = new int[n][2];
        StringTokenizer st;

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            cons[i][0] = Integer.parseInt(st.nextToken());
            cons[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cons, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); // 시작 시간을 기준으로 정렬
            }
            return Integer.compare(a[1], b[1]); // 종료 시간 기준 정렬
        });

        int check = 0;
        int cnt = 0;
        for (int i=0; i<n; i++){
            if (check <= cons[i][0]) {
                check = cons[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
