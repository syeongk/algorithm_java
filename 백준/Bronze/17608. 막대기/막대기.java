

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<n; i++){
            int h = Integer.parseInt(br.readLine());
            s.push(h);
        }
        int temp = s.pop();

        for (int i=0; i<(n-1); i++){
            int p = s.pop();
            if (p > temp){
                temp = p;
                count++;
            }
        }
        System.out.println(count);

    }
}
