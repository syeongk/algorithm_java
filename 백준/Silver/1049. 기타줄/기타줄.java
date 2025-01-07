import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] price = new int[m][2];
        int sixMin = 1001;
        int oneMin = 1001;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            price[0][0] = Integer.parseInt(st.nextToken());
            price[0][1] = Integer.parseInt(st.nextToken());
            if (price[0][0] < sixMin)
                sixMin = price[0][0];
            if (price[0][1] < oneMin)
                oneMin = price[0][1];
        }

        int case1 = oneMin * n;
        int case2 = (n % 6 == 0) ? sixMin * n / 6 : sixMin * (n / 6 + 1);
        int case3 = (sixMin * (n / 6)) + (oneMin * (n % 6));

        int result = Math.min(case1, case2);
        result = Math.min(result, case3);
        System.out.println(result);
    }
}
