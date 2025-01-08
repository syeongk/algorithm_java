import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] room = new int[n][2];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            room[i][0] =  Integer.parseInt(st.nextToken());
            room[i][1] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room, (a, b)->{
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(room[0][1]);
        for (int i=1; i<n; i++){
            if (pq.peek() <= room[i][0]){
                pq.poll();
                pq.add(room[i][1]);
            } else {
                pq.add(room[i][1]);
            }
        }
        System.out.println(pq.size());

    }
}
