// 16:50

// 3 + 6 + 9 + 12 = 30
// (3 * 1) + (3 * 2) + (3 * 3) + (3 * 4) = 30 (sum)
// sum - money = result

class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for (int i=1; i<=count; i++){
            sum += price * i;
        }
        
        long result = sum - money; 
        
        if (result <= 0) return 0;
        return sum - money;
    }
}