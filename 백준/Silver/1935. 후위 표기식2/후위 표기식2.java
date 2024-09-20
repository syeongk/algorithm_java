
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> s = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' & c <= 'Z') {
                s.push(arr[c - 'A']);
            } else {
                if (!s.isEmpty()) {
                    double num1 = s.pop();
                    double num2 = s.pop();
                    switch (c) {
                        case '+':
                            s.push(num2 + num1);
                            break;
                        case '-':
                            s.push(num2 - num1);
                            break;
                        case '*':
                            s.push(num2 * num1);
                            break;
                        case '/':
                            s.push(num2 / num1);
                            break;
                    }
                }
            }
        }

        System.out.printf("%.2f",s.pop());
    }
}

