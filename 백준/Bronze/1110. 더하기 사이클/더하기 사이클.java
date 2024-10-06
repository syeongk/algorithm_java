import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String targetNum = br.readLine();
        if (targetNum.length()==1){
            targetNum = '0' + targetNum;
        }

        String cycleNum = null;

        int ans = 0;
        while (!targetNum.equals(cycleNum)) {
            int sum = 0;
            String strSum = null;

            if (ans == 0)
                cycleNum = targetNum;
            
            sum = cycleNum.charAt(0) - '0' + cycleNum.charAt(1) - '0';
            strSum = Integer.toString(sum);
            if (strSum.length() == 1)
                cycleNum = Character.toString(cycleNum.charAt(1)) + strSum;
            else
                cycleNum = Character.toString(cycleNum.charAt(1)) + Character.toString(strSum.charAt(1));
            
            ans += 1;
        }

        System.out.println(ans);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
