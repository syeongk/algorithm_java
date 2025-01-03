import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //도시 개수
        int[] distances = new int[n-1];
        int[] cities = new int[n];

        //거리
        long dSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            distances[i] = Integer.parseInt(st.nextToken());
            dSum += distances[i];
        }

        //주유소 리터당 가격
        int cMin = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cities[i] = Integer.parseInt(st.nextToken());
            if (i==0)
                cMin = cities[i];
            else if (i<n-1 && cities[i] < cMin)
                cMin = cities[i];
        }

        long output = 0;
        for (int i=0; i<n-1; i++){
            if (cities[i] == cMin) {
                output += cities[i] * dSum;
                break;
            }
            output += cities[i] * distances[i];
            dSum -= distances[i];
        }
        System.out.println(output);


    }
}
