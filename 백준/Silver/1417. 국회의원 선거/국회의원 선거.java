
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int first = 0;

        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
            if (i==0){
                first = num;
            }
        }

        if (pq.size()==1) {
            System.out.println(0);
            return;
        }

        int p1 = pq.poll();
        int p2 = pq.poll();

        if (first == p1 & count+first > p2){
            System.out.println(0);
            return;
        }

        pq.offer(p1);
        pq.offer(p2);

        while(first+count<=pq.peek()){
            int temp = pq.poll();
            temp -= 1;
            count += 1;
            pq.offer(temp);
        }

        System.out.println(count);

    }
}
