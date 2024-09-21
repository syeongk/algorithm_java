
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int sum = 0;

        for (int i=0; i<k; i++){
            int num = Integer.parseInt(br.readLine());
            if (num==0) {
                s.pop();
            } else {
                s.push(num);
            }
        }

        int size = s.size();

        for (int i=0; i<size; i++){
            sum += s.pop();
        }

        System.out.println(sum);
    }
}
