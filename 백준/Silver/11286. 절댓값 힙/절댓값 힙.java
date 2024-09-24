
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> {
                    if (Math.abs(a) != Math.abs(b)){
                        return Integer.compare(Math.abs(a), Math.abs(b));
                    }

                    return Integer.compare(a, b);
                }
        );

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if (num==0){
                if (!pq.isEmpty()){
                    sb.append(pq.poll()).append('\n');
                }
                else {
                    sb.append(0).append('\n');
                }
            }
            else {
                pq.offer(num);
            }
        }

        System.out.println(sb);

    }
}
