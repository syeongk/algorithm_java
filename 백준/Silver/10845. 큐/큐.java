

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main (String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0){
            String command = br.readLine();
            switch (command) {
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(q.pollFirst()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if (q.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (!q.isEmpty()){
                        sb.append(q.peekFirst()).append("\n");
                    }
                    else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if (!q.isEmpty()){
                        sb.append(q.peekLast()).append("\n");
                    }
                    else{
                        sb.append(-1).append("\n");
                    }
                    break;
                default:
                    q.offer(Integer.parseInt(command.substring(5)));
                    break;
            }
        }
        System.out.print(sb);
    }

}
