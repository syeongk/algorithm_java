import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    private static int count;
    private static boolean[] visited;
    private static List<List<Integer>> g = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
  
        for (int i=0; i<V+1; i++){
            g.add(new ArrayList<>());
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());   
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }       

        visited = new boolean[V+1];
        DFS(1);
        
        System.out.println(count);
        
    }

    public void DFS(int vertex){
        visited[vertex] = true;
        
        for(int v: g.get(vertex)){
            if (visited[v] == false){
                count += 1;
                DFS(v);
            }
        }
    }
}