import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10^11 % 12
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(power(A,B,C));
    }

    public static long power(long A, long B, long C){
        if (B==0) return 1; // A^0 = 1

        long half = power(A, B/2, C); // 절반 나눠서 계산
        long result = (half * half) % C;

        if (B%2 == 1){ // B가 홀수면 A를 한번 더 곱해준다.
            result = (result * A) % C;
        }
        return result;
    }
}
