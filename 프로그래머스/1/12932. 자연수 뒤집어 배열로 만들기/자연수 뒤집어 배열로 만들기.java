// 일의 자리 수만 얻으려면 10으로 나눈 나머지
// 일의 자리 수를 없애려면 10으로 나눈 몫
// 12345%10 = 5
// 12345/10 = 1234, 1234%10 = 4

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int l = str.length();
        int[] answer = new int[l];
        
        for (int i=0; i<l; i++){
            long temp = n % 10;
            answer[i] = (int) temp;
            n /= 10;
        }
        
        return answer;
    }
}