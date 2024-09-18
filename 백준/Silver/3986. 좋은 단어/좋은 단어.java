
import java.util.Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            String S = br.readLine();

            for (int j=0; j<S.length(); j++){

                // 스택이 비어있거나 top과 문자가 다를 때
                if (stack.isEmpty() || stack.peek() != S.charAt(j)){
                    stack.push(S.charAt(j));
                }
                 // 스택 top과 문자가 같을 때
                else if (stack.peek() == S.charAt(j)){
                    stack.pop();
                }
            }

            if(stack.isEmpty() ){
                result += 1;
            }


        }
        System.out.println(result);
    }
}
