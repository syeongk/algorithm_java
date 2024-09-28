import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long n = Long.parseLong(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            pq.offer(Long.parseLong(st.nextToken()));
        }

        while (m-- > 0){
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.offer(sum);
            pq.offer(sum);
        }

        long ans = 0;
        for (int i=0; i<n; i++){
            ans += pq.poll();
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
