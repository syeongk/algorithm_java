import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int five = n / 5; // 5의 최대 개수
        int two = 0;

        while (true) {
            if (five == 0){
                if ((n % 2) != 0) {
                    break;
                }
                two = n / 2;
            }

            if ((n - 5 * five) % 2 != 0) { //5로 나누었을 때 나머지가 2로 나누어 떨어지지 않으면
                five -= 1; // 5의 최대 개수 - 1
            } else {
                two = (n - 5 * five) / 2; //5로 나누었을 때 나머지가 2로 나누어 떨어지면, 나머지를 2로 나눈 몫이 2의 개수
                break;
            }
        }

        if (two + five == 0){
            System.out.println(-1);
        } else {
            System.out.println(two + five);
        }


    }
}
