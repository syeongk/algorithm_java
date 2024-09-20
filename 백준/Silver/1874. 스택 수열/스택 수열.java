

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> s = new ArrayDeque<>();

        int now = 1;

        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            while(now<=num){
                s.push(now);
                sb.append('+').append('\n');
                now += 1;
            }
            if (s.peek() == num) {
                s.pop();
                sb.append('-').append('\n');
            } else if (s.peek() > num) {
                sb.setLength(0);
                sb.append("NO");
                break;
            }

        }
        System.out.println(sb);
    }
}
