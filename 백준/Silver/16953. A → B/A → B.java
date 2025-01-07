import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new ArrayDeque<>();
        q.offer(new long[]{a,1});

        long ans = -1;
        while(!q.isEmpty()){
            long[] num = q.poll();
            if (num[0] < b) {
                q.offer(new long[]{num[0] * 2, num[1]+1});
                q.offer(new long[]{(num[0] * 10) + 1, num[1]+1});
            } else if (num[0] == b) {
                ans = num[1];
                break;
            }
        }
        System.out.println(ans);

    }
}
