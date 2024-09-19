

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n*2];

        int front = 0;
        int back = n-1;

        for (int i=0; i<n; i++){
            arr[i] = i+1;
        }

        while (back!=front) {
            front++;
            arr[back+1] = arr[front];
            back += 1;
            front += 1;
        }

        System.out.println(arr[back]);

    }
}