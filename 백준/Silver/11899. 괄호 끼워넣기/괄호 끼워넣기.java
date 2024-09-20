

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> s = new Stack<>();

        int count = 0;

        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == ')'){
                if (s.isEmpty()){
                     count += 1;
                } else {
                    s.pop();
                }
            } else {
                s.push(str.charAt(i));
            }
        }

        if (!s.isEmpty()){
            count += s.size();
        }
        System.out.println(count);
    }
}
