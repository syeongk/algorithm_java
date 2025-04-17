import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

//1234
//234 (1번)
//342 (2번)
//42 (1번)
//24 (2번)
//4 (1번)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

        for (int i=1; i<=N; i++){
            q.offer(i);
        }

        while (q.size() > 1){
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}
