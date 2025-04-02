import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n==1){
            System.out.println(1 % 10007);
            return;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007; // dp[i-1]은 2x1타일 1개 놓은 경우, dp[i-1]은 1x2타일 2개 놓은 경우이다.
        }

        System.out.println(dp[n]);
    }
}
