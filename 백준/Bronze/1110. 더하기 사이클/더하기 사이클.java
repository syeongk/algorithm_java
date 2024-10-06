import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        if (target.length()==1){
            target = '0' + target;
        }

        String cycle = null;

        int ans = 0;
        while (!target.equals(cycle)) {
            int sum = 0;
            String strSum = null;

            if (ans == 0)
                cycle = target;

            sum = cycle.charAt(0) - '0' + cycle.charAt(1) - '0';
            strSum = Integer.toString(sum);
            if (strSum.length() == 1)
                cycle = cycle.charAt(1) + strSum;
            else
                cycle = cycle.charAt(1) + Character.toString(strSum.charAt(1));

            ans += 1;
        }

        System.out.println(ans);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
