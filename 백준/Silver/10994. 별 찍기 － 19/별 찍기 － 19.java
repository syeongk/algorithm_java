import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = 4*n-3;
        arr = new char[size][size];
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                arr[i][j] = ' ';
            }
        }
        draw(0, 0, size);

        StringBuilder sb = new StringBuilder();
        for(char[] r : arr){
            for(char c : r ) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void draw(int x, int y, int size){
        if (size < 1){
            return;
        }

        // 상 하
        for (int i=0; i<size; i++){
            arr[x][y+i] = '*';
            arr[x+size-1][y+i] = '*';
        }

        // 좌 우
        for (int i=1; i<size; i++){
            arr[x+i][y] = '*';
            arr[x+i][y+size-1] = '*';
        }

        // 재귀 (내부 별)
        draw(x+2, y+2, size-4);
    }
}
