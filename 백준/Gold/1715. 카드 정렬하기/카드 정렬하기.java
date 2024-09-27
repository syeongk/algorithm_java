import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int ans;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if (pq.size()==1){
            System.out.println(0);
            return;
        }

        while (pq.size()!=1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int result = num1 + num2;
            ans += result;
            pq.offer(result);
        }
        System.out.println(ans);


    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
