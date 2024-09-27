import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<M; i++){
            int peek = (int) pq.peek();

            int num = Integer.parseInt(st.nextToken());
            if (peek == num){
                pq.poll();
            }
            else if (peek < num) {
                System.out.println(0);
                return;
            }
            else {
                int temp = (int) pq.poll();
                int result = temp-num;
                pq.offer(result);
            }
        }
        System.out.println(1);

    }
}
