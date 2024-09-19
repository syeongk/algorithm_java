

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] s = str.split(" ");

            switch (s[0]) {
                case "push":
                    q.offer(Integer.parseInt(s[1]));
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        System.out.println(q.poll());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peek());
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peekLast());
                    }
                    break;


            }

        }
    }
}
