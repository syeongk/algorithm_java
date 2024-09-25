

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N ; i++){

            String[] input = br.readLine().split(" ");

            if (input.length==1) {
                if(pq.isEmpty()){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }

            for (int j = 0; j< Integer.parseInt(input[0]) ; j++){
                pq.offer(Integer.parseInt(input[j+1]));
            }
        }
        System.out.println(sb);
    }
}
