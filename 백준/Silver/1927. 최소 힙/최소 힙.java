

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        for (int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if (num==0) {
                if (!minHeap.isEmpty()) {
                    sb.append(minHeap.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
            else {
                minHeap.add(num);
            }
        }
        System.out.println(sb);
    }
}