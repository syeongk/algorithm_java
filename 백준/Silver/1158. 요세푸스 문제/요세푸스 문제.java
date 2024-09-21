
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        for (int i=1; i<n+1; i++){
            q.offer(i);
        }

        sb.append('<');
        while (!q.isEmpty()){
            for (int i=0; i<k-1; i++){
                q.offer(q.poll());
            }
            if (q.size()==1){
                sb.append(q.poll());
            } else {
                sb.append(q.poll()).append(',').append(" ");
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}
