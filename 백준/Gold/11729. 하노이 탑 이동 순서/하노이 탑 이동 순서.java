import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb);

    }

    public static void hanoi(int n, int from, int to, int via){
        if (n==1){
            count++;
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(n-1, from, via, to);
        sb.append(from + " " + to + "\n");
        count++;

        hanoi(n-1, via, to, from);

    }
}
