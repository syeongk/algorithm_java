import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int l = answers.length;
        
        int[] cnt = new int[3];
        int[][] p = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        
        for (int i=0; i<3; i++){ // 수포자
            int idx = 0;
            for (int j=0; j<l; j++){ // 문제들
                if (p[i][idx % p[i].length] == answers[j]){
                    cnt[i] += 1;
                }
                idx++;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i=0; i<3; i++){
            if (cnt[i] >= max){
                max = cnt[i];
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i=0; i<3; i++){
            if (cnt[i] == max){
                arr.add(i+1);
            }
        }
        
        int[] answer = new int[arr.size()];
        for (int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
    
        return answer;
    }
}