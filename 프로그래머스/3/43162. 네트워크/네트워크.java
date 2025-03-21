// 자기 자신은 1
// 방문배열 만들기
// 나를 제외한 다른 곳이 1이면 거기로 이동할 수 있음. 근데 이미 방문했는지 확인해야 함
// n 만큼 반복

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i=0; i<n; i++){
            if (!visited[i]){
                visited[i] = true; // 방문 처리
                q.offer(computers[i]);
                
                while (!q.isEmpty()){
                    int[] now = q.poll();
                    
                    for (int j=0; j<n; j++){
                        if (i!=j && now[j] != 0 && !visited[j]){
                            visited[j] = true;
                            q.offer(computers[j]);
                        }
                    }
                }
                answer++;
            }
            
        }
        
        return answer;
    }
}