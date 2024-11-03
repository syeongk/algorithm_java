import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //그래프 생성
        
        int[][] g = new int[n][m];
        
        for (int i=0; i<n; i++){
            String line = br.readLine();
            for (int j=0; j<m; j++){
                g[i][j] = line.charAt(j) - '0';
            }
        }

        //상하좌우
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();

            for (int[] d : dir){
                int x = now[0] + d[0];
                int y = now[1] + d[1];

                if (x >= 0 && y >= 0 && x <= n-1 && y <= m-1){
                    if(g[x][y] == 1){
                        q.offer(new int[] {x,y});
                        g[x][y] = g[now[0]][now[1]] + 1;
                    }
                }
            }
        }
        System.out.println(g[n-1][m-1]);
        

    }
}