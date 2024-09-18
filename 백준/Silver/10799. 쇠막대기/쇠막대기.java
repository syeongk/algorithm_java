import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int result = 0;
        String s = br.readLine();

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else {
                stack.pop();

                if (s.charAt(i-1) == '('){
                    result += stack.size();
                }
                else {
                    result += 1;
                }
            }

        }

        System.out.println(result);


    }
}
