import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    String number = "";
    boolean check = false;
    int sum;

    public void solution() throws IOException {
        input = br.readLine();

        for (int i=0; i<input.length(); i++){
            if (input.charAt(i) == '+') {
                performSum();
                number = "";
            } else if (input.charAt(i) == '-') {
                performSum();
                check = true;
                number = "";
            } else {
                number += input.charAt(i);
            }
        }
        performSum();
        System.out.println(sum);
    }

    public void performSum(){
        if (check)
            sum -= Integer.parseInt(number);
        else {
            sum += Integer.parseInt(number);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
