import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List<Integer>> g = new ArrayList<>();
        
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

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[V+1];
        int count = 0;
        
        q.offer(1);
        visited[1] = true;
        
        while (!q.isEmpty()){
            for (int v : g.get(q.poll())){
                if (visited[v] == false){
                    q.offer(v);
                    visited[v] = true;
                    count += 1;
                }
            }
        }

        System.out.println(count);
        
    }
}